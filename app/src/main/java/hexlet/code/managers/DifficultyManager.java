package hexlet.code.managers;

import hexlet.code.core.Difficulty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DifficultyManager {
    private static final Logger logger = LoggerFactory.getLogger(DifficultyManager.class);
    private static Difficulty difficulty = Difficulty.EASY;

    public static Difficulty getDifficulty() {
        return difficulty;
    }

    public void selectDifficulty(String input) {
        logger.info("Select difficulty level: Easy, Normal, or Hard");
        try {
            difficulty = Difficulty.valueOf(input.toUpperCase());
            logger.debug("Player selected difficulty: {}", input);
        } catch (IllegalArgumentException e) {
            logger.error("Invalid difficulty level. Defaulting to EASY.");
            difficulty = Difficulty.EASY;
        }
    }

}
