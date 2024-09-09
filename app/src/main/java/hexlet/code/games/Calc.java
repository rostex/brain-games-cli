package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {
    private static final String gameDiscription = "What is the result of the expression?";
    private static final int min = 1;
    private static final int max = 20;
    private static final int minOperator = 1;
    private static final int maxOperator = 3;

    public static void startGame() {
        String[][] gameData = new String[Engine.numberOfRounds][2];

        for (int i = 0; i < Engine.numberOfRounds; i++) {
            int firstNumber = Engine.getRandomNumber(min, max);
            int secondNumber = Engine.getRandomNumber(min, max);
            int operator = Engine.getRandomNumber(minOperator, maxOperator);

            switch (operator) {

                case 1:
                    gameData[i][0] = String.valueOf(firstNumber) + " + " + String.valueOf(secondNumber);
                    gameData[i][1] = String.valueOf(firstNumber + secondNumber);
                    break;
                case 2:
                    gameData[i][0] = String.valueOf(firstNumber) + " - " + String.valueOf(secondNumber);
                    gameData[i][1] = String.valueOf(firstNumber - secondNumber);
                    break;
                case 3:
                    gameData[i][0] = String.valueOf(firstNumber) + " * " + String.valueOf(secondNumber);
                    gameData[i][1] = String.valueOf(firstNumber * secondNumber);
                    break;
                default:
                    return;
            }
        }
        Engine.runGame(gameDiscription, gameData);
    }
}
