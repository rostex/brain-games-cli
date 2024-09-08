package hexlet.code;

public class Prime {

    public static void primeGame() {
        Engine.putWelcomeMessage();
        Engine.getUserName();
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        putTask(); // First question
        putTask(); // Second question
        putTask(); // Third question

        Engine.putCongratulationMessage();

    }

    // Question logic
    public static void putTask() {
        int randomNumber = Engine.getRandomNumber(1, 20);
        System.out.println("Question: " + randomNumber);
        System.out.println("Your answer: ");
        String answer = Engine.scanner.next();

        if (randomNumber == 1 && "no".equals(answer)) {
            Engine.putCorrectMessage();
        } else if (randomNumber % 2 != 0 && "no".equals(answer)) {
            Engine.putCorrectMessage();
        } else {
            System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was 'no'."); // add var correct-number
            System.out.println("Let's try again,"); // add userName
            App.main(null);
        }
    }
}
