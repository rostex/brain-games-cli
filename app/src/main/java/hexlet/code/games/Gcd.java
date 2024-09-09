package hexlet.code.games;

import hexlet.code.Engine;

public class Gcd {
    static String gameDiscription = "Find the greatest common divisor of given numbers.";

    public static void startGame() {
        String[][] gameData = new String[Engine.numberOfRounds][2];

        for (int i = 0; i < Engine.numberOfRounds; i++) {

            int firstNumber = Engine.getRandomNumber(1, 20);
            int secondNumber = Engine.getRandomNumber(1, 20);

            gameData[i][0] = String.valueOf(firstNumber) + " " + String.valueOf(secondNumber); // Arrays with question
            gameData[i][1] = getGcd(firstNumber, secondNumber); // Arrays with answer
        }
        Engine.runGame(gameDiscription, gameData);
        System.exit(0);
    }
    // Get GCD method of Euclid algorithm
    public static String getGcd(int a, int b) {
        if (b == 0) {
            return String.valueOf(a);
        }
        return getGcd(b, a % b);
    }
}
