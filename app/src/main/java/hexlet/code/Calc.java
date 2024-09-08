package hexlet.code;

public class Calc {

    public static void startGame() {
        String gameDiscription = "What is the result of the expression?";

        String operatorSwitch = "null";
        int operator = Engine.getRandomNumber(1, 3);

        int number1 = Engine.getRandomNumber(1, 20);
        int number2 = Engine.getRandomNumber(1, 20);
        int result = 0;

        correctAnswer = switch (operator) {
            case 1 -> {
                operatorSwitch = "+";
                yield number1 + number2;
            }
            case 2 -> {
                operatorSwitch = "-";
                yield number1 - number2;
            }
            case 3 -> {
                operatorSwitch = "*";
                yield number1 * number2;
            }
            default -> correctAnswer;
        };

        String gameQuestion = "Question: " + number1 + operatorSwitch + number2;

        Engine.runGame();
    }
}
