package hexlet.code;

public class Calc {

    public static void calcGame() {
        Cli.greeting(); // Greeting
        System.out.println("What is the result of the expression?");

//        askQuestion(); // First question
//        askQuestion(); // Second question
//        askQuestion(); // Third question

        System.out.println("Congratulations, Bill!");

    }

    // Question logic
//    public static void askQuestion() {
//        System.out.println("Question: " + Engine.getRandomExpression());
//        System.out.println("Your answer: ");
//        int answer = Integer.parseInt(App.scanner.next());
//
//        if (Engine.getRandomExpression() == answer) {
//            System.out.println("Correct!");
//        } else {
//            System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + Engine.getRandomExpression() + "'."); // инверсия к ответу
//            System.out.println("Let's try again,"); // добавить юзера
//            App.main(null);
//        }
//    }

}
