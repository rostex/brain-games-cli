package hexlet.code.managers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import hexlet.code.core.GameData;
import hexlet.code.core.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class StatisticsManager {
    private static final Logger logger = LoggerFactory.getLogger(StatisticsManager.class);

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
