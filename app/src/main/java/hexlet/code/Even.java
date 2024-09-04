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

}
