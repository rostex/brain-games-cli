package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.core.GameData;
import hexlet.code.utils.MathUtils;
import hexlet.code.core.Difficulty;

import java.util.ArrayList;
import java.util.List;

public class Gcd {
    private static final String GAME_DESCRIPTION = "Find the greatest common divisor of given numbers.";

    public static void startGame() {
        Engine.runGame(GAME_DESCRIPTION, generateGameData(Difficulty.minNumber, Difficulty.maxNumber));
    }

    private static List<GameData> generateGameData(int min, int max) {
        List<GameData> gameData = new ArrayList<>();
        for (int i = 0; i < Difficulty.numberOfRounds; i++) {
            int firstNumber = MathUtils.getRandomNumber(min, max);
            int secondNumber = MathUtils.getRandomNumber(min, max);
            String question = firstNumber + " " + secondNumber;
            String rightAnswer = MathUtils.getGcd(firstNumber, secondNumber);
            gameData.add(new GameData(question, rightAnswer));
        }
        return gameData;
    }
}
