package hexlet.code.games;

import hexlet.code.Engine;

public class Gcd {
    private static final String GAME_DISCRIPTION = "Find the greatest common divisor of given numbers.";
    private static final int MIN = 1;
    private static final int MAX = 20;

    public static void startGame() {
        String[][] gameData = new String[Engine.NUMBER_OF_ROUNDS][2];

        for (int i = 0; i < Engine.NUMBER_OF_ROUNDS; i++) {

            int firstNumber = Engine.getRandomNumber(MIN, MAX);
            int secondNumber = Engine.getRandomNumber(MIN, MAX);

            gameData[i][0] = firstNumber + " " + secondNumber; // Arrays with question
            gameData[i][1] = getGcd(firstNumber, secondNumber); // Arrays with answer
        }
        Engine.runGame(GAME_DISCRIPTION, gameData);
    }
    // Get GCD method of Euclid algorithm
    public static String getGcd(int a, int b) {
        if (b == 0) {
            return String.valueOf(a);
        }
        return getGcd(b, a % b);
    }
}
