package hexlet.code.games;

import hexlet.code.core.GameData;
import hexlet.code.utils.MathUtils;

import java.util.ArrayList;
import java.util.List;

public class Gcd extends Game {

    @Override
    protected String getGameDescription() {
        return "Find the greatest common divisor of given numbers.";
    }

    @Override
    protected List<GameData> getGeneratedGameData() {
        List<GameData> gameData = new ArrayList<>();

        int minNumber = difficultyValue.minNumber;
        int maxNumber = difficultyValue.maxNumber;
        for (int i = 0; i < difficultyValue.numberOfRounds; i++) {
            int firstNumber = MathUtils.getRandomNumber(minNumber, maxNumber);
            int secondNumber = MathUtils.getRandomNumber(minNumber, maxNumber);
            String question = firstNumber + " " + secondNumber;
            String rightAnswer = MathUtils.getGcd(firstNumber, secondNumber);
            gameData.add(new GameData(question, rightAnswer));
        }
        return gameData;
    }
}
