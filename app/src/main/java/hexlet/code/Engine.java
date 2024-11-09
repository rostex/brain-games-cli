package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import hexlet.code.core.Difficulty;
import hexlet.code.core.GameData;
import hexlet.code.menu.Menu;
import hexlet.code.utils.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static hexlet.code.Main.SCANNER;
import static hexlet.code.Main.player;


public class Engine {

    public static void runGame(String gameDescription, List<GameData> gameData) {
        String playerName = player.getName();

        System.out.println("Hello, " + playerName + "!");
        System.out.println(gameDescription);

        for (int i = 0; i < Difficulty.numberOfRounds; i++) {
            GameData roundData = gameData.get(i);

            System.out.println("Question: " + roundData.getQuestion());
            System.out.println("Answer: ");
            String userAnswer = SCANNER.next();

            if (userAnswer.equals(roundData.getAnswer())) {
                System.out.println("Correct!");
                updateScore(Difficulty.scoreValue, true);
            } else {
                System.out.println("'" + userAnswer
                        + "' is wrong answer ;(. Correct answer was '"
                        + roundData.getAnswer() + "'.");
                updateScore(Difficulty.scoreValue, false);
            }
        }
        System.out.println("Congratulations, " + playerName + "!\n");
        getTotalScore();
        Menu.getMainMenu();
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

            if (!stats.containsKey(playerName)) {
                stats.put(playerName, 0);
            }

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

        Map<String, Integer> stats = mapper.readValue(file,
                new TypeReference<Map<String, Integer>>() {
                });

        if (stats.isEmpty()) {
            System.out.println("Top players are not determined yet.");
            return;
        }

        System.out.println("Top 5 players:");
        List<Map.Entry<String, Integer>> sortedStats = stats.entrySet()
                .stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .collect(Collectors.toList());

        int positionNumber = 1;
        for (Map.Entry<String, Integer> stat : sortedStats) {
            if (positionNumber > 5) {
                break;
            }
            String statsTable = String.format("%d. %s: %d", positionNumber, stat.getKey(), stat.getValue());
            System.out.println(statsTable);
            positionNumber++;
        }
    }

    public static Map<String, Integer> readStatsFromFile(File file, ObjectMapper mapper) throws IOException {
        if (file.length() == 0) {
            return new HashMap<>();
        }
        return mapper.readValue(file, new TypeReference<Map<String, Integer>>() {});
    }

    private static void writeStatsToFile(File file, ObjectMapper mapper,
                                         Map<String, Integer> stats) throws IOException {
        mapper.writeValue(file, stats);
    }

    private static boolean isFileEmpty(File file) {
        return !file.exists() || file.length() == 0;
    }
}
