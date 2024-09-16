package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Setup;

public class Calc {
    private static final String GAME_DISCRIPTION = "What is the result of the expression?";
    private static final int MIN = 1;
    private static final int MAX = 20;
    private static final int MIN_OPERATOR = 1;
    private static final int MAX_OPERATOR = 3;
    private static final int PLUS = 1;
    private static final int MINUS = 2;
    private static final int MULTIPLY = 3;
    private static String[][] gameData = new String[Setup.NUMBER_OF_ROUNDS][2];

    public static void startGame() {
        setGameData();
        Engine.runGame(GAME_DISCRIPTION, gameData);
    }

    private static void setGameData() {
        for (int i = 0; i < Setup.NUMBER_OF_ROUNDS; i++) {
            int firstNumber = Engine.getRandomNumber(MIN, MAX);
            int secondNumber = Engine.getRandomNumber(MIN, MAX);
            int operator = Engine.getRandomNumber(MIN_OPERATOR, MAX_OPERATOR);
            String markOperator;

            switch (operator) {

                case PLUS:
                    markOperator = " + ";
                    gameData[i][1] = String.valueOf(firstNumber + secondNumber);
                    break;
                case MINUS:
                    markOperator = " - ";
                    gameData[i][1] = String.valueOf(firstNumber - secondNumber);
                    break;
                case MULTIPLY:
                    markOperator = " * ";
                    gameData[i][1] = String.valueOf(firstNumber * secondNumber);
                    break;
                default:
                    return;
            }
            gameData[i][0] = firstNumber + markOperator + secondNumber;
        }
    }
}
