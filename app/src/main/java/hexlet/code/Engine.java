package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static int numberOfRounds = 3;
    public static Scanner scanner = new Scanner(System.in);

    public static void runGame() {
        // Welcome message
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println(gameDiscription);

        for (int i = 0; i < numberOfRounds; i++) {
            System.out.println("Question: " + gameQuestion);
            System.out.println("Answer: ");
            String userAnswer = scanner.next();

            if (!userAnswer.equals(correctAnswer)) {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
                System.out.println("Let's try again, " + userName);
                App.main(null);
            }
        }
        System.out.println("Congratulations, " + userName);

    }

    public static int getRandomNumber(int min, int max) {
        int randomNumber = min + (int) (Math.random() * max);
        return randomNumber;
    }

    public static int getGcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGcd(b, a % b);
    }

}
