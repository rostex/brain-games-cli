package hexlet.code;

public class Even {

    public static void evenGame() {
        Cli.greeting(); // Greeting
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        askQuestion(); // First question
        askQuestion(); // Second question
        askQuestion(); // Third question

        System.out.println("Congratulations, Bill!");

    }

    // Question logic
    public static void askQuestion() {
        int randomNumber = Engine.getRandomNumber(1, 20);
        System.out.println("Question: " + randomNumber);
        System.out.println("Your answer: ");
        String answer = App.scanner.next();

        if (randomNumber % 2 == 0 && "yes".equals(answer)) {
            System.out.println("Correct!");
        } else if (randomNumber % 2 != 0 && "no".equals(answer)) {
            System.out.println("Correct!");
        } else {
            System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was 'no'."); // инверсия к ответу
            System.out.println("Let's try again,"); // добавить юзера
            App.main(null);
        }
    }

//    public static void askQuestion1() {
//
//        String operatorSwitch = "null";
//
//        int operator = Engine.getRandomNumber(1, 2);
//        boolean result = false;
//        int number1 = Engine.getRandomNumber(1, 20);
//        int number2 = Engine.getRandomNumber(1, 20);
//
//        result = switch (operator) {
//            case 1 -> {
//                operatorSwitch = "yes";
//                yield number1 % 2 == 0;
//            }
//            case 2 -> {
//                operatorSwitch = "no";
//                yield number1 % 2 != 0;
//            }
//            default -> result;
//        };
//
//        System.out.println("Question: " + number1);
//        System.out.println("Your answer: ");
//        String answer = App.scanner.next();
//
//        if (operatorSwitch.equals(answer)) {
//            System.out.println("Correct!");
//        } else {
//            System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + operatorSwitch + "'.");
//            System.out.println("Let's try again,"); // добавить юзера
//            App.main(null);
//        }
//    }
}
