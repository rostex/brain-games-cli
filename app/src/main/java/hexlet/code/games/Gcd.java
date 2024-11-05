package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.MathUtils;
import hexlet.code.Setup;

public class Gcd {
    private static final String GAME_DISCRIPTION = "Find the greatest common divisor of given numbers.";
    private static final int MIN = 1;
    private static final int MAX = 20;

    public static void startGame() {
        Engine.runGame(GAME_DISCRIPTION, generateGameData());
    }

    private static String[][] generateGameData() {
        String[][] gameData = new String[Setup.NUMBER_OF_ROUNDS][2];
        for (int i = 0; i < Setup.NUMBER_OF_ROUNDS; i++) {
            int firstNumber = MathUtils.getRandomNumber(MIN, MAX);
            int secondNumber = MathUtils.getRandomNumber(MIN, MAX);

            gameData[i][0] = firstNumber + " " + secondNumber; // Arrays with question
            gameData[i][1] = MathUtils.getGcd(firstNumber, secondNumber); // Arrays with answer
        }
        return gameData;
    }
}
