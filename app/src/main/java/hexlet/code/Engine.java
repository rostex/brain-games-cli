package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import hexlet.code.core.Difficulty;
import hexlet.code.core.GameData;
import hexlet.code.core.Player;
import hexlet.code.menu.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static hexlet.code.Main.SCANNER;

public class Engine {
    private static final Logger logger = LoggerFactory.getLogger(Engine.class);
    public static Difficulty difficulty = Difficulty.EASY;

    public static void runGame(String gameDescription, List<GameData> gameData) {
        String playerName = Player.getInstance().getName();

        logger.info("Hello, {}!", playerName);
        logger.info(gameDescription);

        for (int i = 1; i <= difficulty.numberOfRounds; i++) {
            GameData roundData = gameData.get(i - 1);
            logger.info("Round {}/{}", i + 1, difficulty.numberOfRounds);
            logger.info("Question: {}", roundData.getQuestion());
            logger.info("Your answer: ");
            String userAnswer = SCANNER.next();

            if (userAnswer.equals(roundData.getAnswer())) {
                logger.debug("Player answered correctly.");
                logger.info("Correct!");
                updateScore(difficulty.scoreValue, true);
                logger.debug("Player gained {} point(s).", difficulty.scoreValue);
            } else {
                logger.debug("Player answered incorrectly.");
                logger.info("'{}' is wrong answer ;(. Correct answer was '{}'.", userAnswer, roundData.getAnswer());
                updateScore(difficulty.scoreValue, false);
                logger.debug("Player lost {} point(s).", difficulty.scoreValue);
            }
        }
        logger.info("Congratulations, {}!\n", playerName);
        getTotalScore();
        Menu.getMainMenu();
    }

    public static void selectDifficulty() {
        logger.info("Select difficulty level: Easy, Normal, or Hard");
        String input = SCANNER.next().toUpperCase();
        logger.debug("Player selected difficulty: {}", input);
        switch (input) {
            case "EASY":
                Engine.difficulty = Difficulty.EASY;
                logger.debug("Switched to Easy difficulty.");
                break;
            case "NORMAL":
                Engine.difficulty = Difficulty.NORMAL;
                logger.debug("Switched to Normal difficulty.");
                break;
            case "HARD":
                Engine.difficulty = Difficulty.HARD;
                logger.debug("Switched to Hard difficulty.");
                break;
            default:
                logger.error("Invalid input. Defaulting to Easy difficulty.");
                Engine.difficulty = Difficulty.EASY;
                logger.debug("Switched to Easy difficulty.");
        }

    }

    public static void getTotalScore() {
        String playerName = Player.getInstance().getName();
        try {
            File file = GameData.gameDataFile;

            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            Map<String, Integer> stats = readStatsFromFile(file, mapper);

            Integer totalScore = stats.get(playerName);
            if (totalScore == null) {
                logger.info("No score found for player {}.", playerName);
            } else {
                logger.info("Your current total score: {}", totalScore);
            }

        } catch (IOException e) {
            logger.error("Error reading stats file: {}", e.getMessage());
        }
    }

    public static void updateScore(int value, boolean isAdd) {
        String playerName = Player.getInstance().getName();
        int scoreChange = isAdd ? value : -value;

        try {
            File file = GameData.gameDataFile;

            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            Map<String, Integer> stats = readStatsFromFile(file, mapper);

            stats.merge(playerName, scoreChange, Integer::sum);

            writeStatsToFile(file, mapper, stats);

            String action = isAdd ? "gained" : "lost";
            logger.info("You {} {} score(s)", action, value);

        } catch (IOException e) {
            logger.error("Error writing to stats file: {}", e.getMessage());
        }
    }

    public static void getStatistics() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        File file = GameData.gameDataFile;

        if (!file.exists()) {
            logger.debug("Stats file does not exist.");
            logger.info("Top players are not determined yet.");
            return;
        }

        Map<String, Integer> stats = readStatsFromFile(file, mapper);

        if (stats.isEmpty()) {
            logger.debug("File with players status is empty.");
            logger.info("Top players are not determined yet.");
            return;
        }

        logger.info("Top 5 players:");
        AtomicInteger positionNumber = new AtomicInteger(1);
        stats.entrySet()
                .stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .limit(5)
                .forEach(entry -> logger.info("{}. {}: {}",
                        positionNumber.getAndIncrement(), entry.getKey(), entry.getValue()));

    }

    public static Map<String, Integer> readStatsFromFile(File file, ObjectMapper mapper) throws IOException {
        if (file.length() == 0) {
            logger.debug("Stats file is empty. Returning an empty map.");
            return new HashMap<>();
        }

        Map<String, Integer> stats = mapper.readValue(file, new TypeReference<Map<String, Integer>>() {
        });
        logger.debug("Successfully read player statistics: {}", stats);
        return stats;
    }

    private static void writeStatsToFile(File file, ObjectMapper mapper,
                                         Map<String, Integer> stats) throws IOException {
        mapper.writeValue(file, stats);
        logger.debug("Player statistics written to file.");
    }
}
