package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import hexlet.code.core.Difficulty;
import hexlet.code.core.GameData;
import hexlet.code.menu.Menu;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static hexlet.code.Main.SCANNER;
import static hexlet.code.Main.player;


public class Engine {
    public static Difficulty difficulty = Difficulty.EASY;

    public static void runGame(String gameDescription, List<GameData> gameData) {
        String playerName = player.getName();

        System.out.println("Hello, " + playerName + "!");
        System.out.println(gameDescription);

        for (int i = 0; i < difficulty.getNumberOfRounds(); i++) {
            GameData roundData = gameData.get(i);

            System.out.println("Question: " + roundData.getQuestion());
            System.out.println("Answer: ");
            String userAnswer = SCANNER.next();

            if (userAnswer.equals(roundData.getAnswer())) {
                System.out.println("Correct!");
                updateScore(difficulty.getScoreValue(), true);
            } else {
                System.out.println("'" + userAnswer
                        + "' is wrong answer ;(. Correct answer was '"
                        + roundData.getAnswer() + "'.");
                updateScore(difficulty.getScoreValue(), false);
            }
        }
        System.out.println("Congratulations, " + playerName + "!\n");
        getTotalScore();
        Menu.getMainMenu();
    }

    public static void selectDifficulty() {
        System.out.println("Select difficulty: Easy, Normal, or Hard");
        String input = SCANNER.next().toUpperCase();
        switch (input) {
            case "EASY":
                Engine.difficulty = Difficulty.EASY;
                break;
            case "NORMAL":
                Engine.difficulty = Difficulty.NORMAL;
                break;
            case "HARD":
                Engine.difficulty = Difficulty.HARD;
                break;
            default:
                System.out.println("Invalid input, defaulting to EASY");
                Engine.difficulty = Difficulty.EASY;
        }

    }

    public static void getTotalScore() {
        try {
            File file = GameData.gameDataFile;

            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            Map<String, Integer> stats = readStatsFromFile(file, mapper);

            System.out.println("Your current total score: " + stats.get(player.getName()));

        } catch (IOException e) {
            System.out.println("Error reading stats file: " + e.getMessage());
        }
    }

    public static void updateScore(int value, boolean isAdd) {
        String playerName = player.getName();
        int scoreChange = isAdd ? value : -value;

        try {
            File file = GameData.gameDataFile;

            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            Map<String, Integer> stats = readStatsFromFile(file, mapper);

            stats.merge(playerName, scoreChange, Integer::sum);

            writeStatsToFile(file, mapper, stats);

            String action = isAdd ? "get" : "lose";
            System.out.println(String.format("You %s %d score(s)", action, value));

        } catch (IOException e) {
            System.out.println("Error writing to stats file: " + e.getMessage());
        }
    }

    public static void getStatistics() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        File file = GameData.gameDataFile;

        if (isFileEmpty(file)) {
            System.out.println("Top players are not determined yet.");
            return;
        }

        Map<String, Integer> stats = readStatsFromFile(file, mapper);

        if (stats.isEmpty()) {
            System.out.println("Top players are not determined yet.");
            return;
        }

        System.out.println("Top 5 players:");
        AtomicInteger positionNumber = new AtomicInteger(1);
        stats.entrySet()
                .stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .limit(5)
                .forEach(entry -> System.out.println(String.format("%d. %s: %d",
                        positionNumber.getAndIncrement(), entry.getKey(), entry.getValue())));

    }

    public static Map<String, Integer> readStatsFromFile(File file, ObjectMapper mapper) throws IOException {
        if (file.length() == 0) {
            return new HashMap<>();
        }
        return mapper.readValue(file, new TypeReference<Map<String, Integer>>() {
        });
    }

    private static void writeStatsToFile(File file, ObjectMapper mapper,
                                         Map<String, Integer> stats) throws IOException {
        mapper.writeValue(file, stats);
    }

    private static boolean isFileEmpty(File file) {
        return !file.exists() || file.length() == 0;
    }
}
