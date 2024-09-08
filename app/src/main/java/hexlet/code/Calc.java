package hexlet.code;

public class Calc {
    static String gameDiscription = "What is the result of the expression?";


    public static void startGame() {

        String[][] gameData = new String[Engine.numberOfRounds][2];

        for (int i = 0; i < Engine.numberOfRounds; i++) {
            int firstNumber = Engine.getRandomNumber(1, 20);
            int secondNumber = Engine.getRandomNumber(1, 20);
            int operator = Engine.getRandomNumber(1, 3);
            String operatorSwitch = null;

            switch (operator) {

                case 1:
                    operatorSwitch = "+";
                    gameData[i][0] = String.valueOf(firstNumber) + " + " + String.valueOf(secondNumber);
                    gameData[i][1] = String.valueOf(firstNumber + secondNumber);
                    break;
                case 2:
                    operatorSwitch = "-";
                    gameData[i][0] = String.valueOf(firstNumber) + " - " + String.valueOf(secondNumber);
                    gameData[i][1] = String.valueOf(firstNumber - secondNumber);
                    break;
                case 3:
                    operatorSwitch = "*";
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
