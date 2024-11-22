package hexlet.code.games;

import hexlet.code.core.Difficulty;
import hexlet.code.core.GameData;
import hexlet.code.core.GlobalScanner;
import hexlet.code.core.Player;
import hexlet.code.managers.DifficultyManager;
import hexlet.code.managers.StatisticsManager;
import hexlet.code.menu.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public abstract class Game {
    public static Difficulty difficultyValue = DifficultyManager.getDifficulty();
    private static final Logger logger = LoggerFactory.getLogger(Game.class);

    public void startGame() {
        runGameLogic(getGameDescription(), getGeneratedGameData());
    }

    protected abstract String getGameDescription();
    protected abstract List<GameData> getGeneratedGameData();

    public void runGameLogic(String gameDescription, List<GameData> gameData) {
        String playerName = Player.getInstance().getName();

        logger.info("Hello, {}!", playerName);
        logger.info(gameDescription);

        for (int i = 0; i <= difficultyValue.numberOfRounds; i++) {
            GameData roundData = gameData.get(i);
            logger.info("Round {}/{}", i + 1, difficultyValue.numberOfRounds);
            logger.info("Question: {}", roundData.getQuestion());
            logger.info("Your answer: ");
            String userAnswer = GlobalScanner.getInstance().next();

            if (userAnswer.equals(roundData.getAnswer())) {
                logger.debug("Player answered correctly.");
                logger.info("Correct!");
                StatisticsManager.updateScore(difficultyValue.scoreValue, true);
                logger.debug("Player gained {} point(s).", difficultyValue.scoreValue);
            } else {
                logger.debug("Player answered incorrectly.");
                logger.info("'{}' is wrong answer ;(. Correct answer was '{}'.", userAnswer, roundData.getAnswer());
                StatisticsManager.updateScore(difficultyValue.scoreValue, false);
                logger.debug("Player lost {} point(s).", difficultyValue.scoreValue);
            }
        }
        logger.info("Congratulations, {}!\n", playerName);
        StatisticsManager.getTotalScore();
        new Menu().getMainMenu();
    }

}


