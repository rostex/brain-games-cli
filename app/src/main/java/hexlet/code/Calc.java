package hexlet.code;

public class Calc {

    public static void calcGame() {
        Cli.greeting(); // Greeting
        System.out.println("What is the result of the expression?");

        askQuestion(); // First question
        askQuestion(); // Second question
        askQuestion(); // Third question

        System.out.println("Congratulations, Bill!");

    }

    // Calc question logic

    public static void askQuestion() {

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
        int answer = Integer.parseInt(App.scanner.next());

        if (result == answer) {
            System.out.println("Correct!");
        } else {
            System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + result + "'.");
            System.out.println("Let's try again,"); // добавить юзера
            App.main(null);
        }

    }
}
