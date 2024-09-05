package hexlet.code;

public class Calc {

    public static void calcGame() {
        Engine.putWelcomeMessage();
        Engine.getUserName();
        System.out.println("What is the result of the expression?");

        putTask(); // First question
        putTask(); // Second question
        putTask(); // Third question

        Engine.putCongratulationMessage();

    }

    // Calc question logic

    public static void putTask() {

        String operatorSwitch = "null";

        int operator = Engine.getRandomNumber(1, 3);
        int result = 0;
        int number1 = Engine.getRandomNumber(1, 20);
        int number2 = Engine.getRandomNumber(1, 20);

        result = switch (operator) {
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
            default -> result;
        };

        System.out.println("Question: " + number1 + operatorSwitch + number2);
        System.out.println("Your answer: ");
        int answer = Integer.parseInt(Engine.scanner.next());

        if (result == answer) {
            Engine.putCorrectMessage();
        } else {
            System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + result + "'.");
            System.out.println("Let's try again,"); // добавить юзера
            App.main(null);
        }

    }
}
