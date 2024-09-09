package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {
    static String gameDiscription = "What is the result of the expression?";

    public static void startGame() {
        String[][] gameData = new String[Engine.numberOfRounds][2];

        for (int i = 0; i < Engine.numberOfRounds; i++) {
            int firstNumber = Engine.getRandomNumber(1, 20);
            int secondNumber = Engine.getRandomNumber(1, 20);
            int operator = Engine.getRandomNumber(1, 3);

            switch (operator) {

                case 1:
                    gameData[i][0] = String.valueOf(firstNumber) + " + " + String.valueOf(secondNumber); //Arrays with question
                    gameData[i][1] = String.valueOf(firstNumber + secondNumber); // Arrays with answer
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
        System.exit(0);
    }
}
