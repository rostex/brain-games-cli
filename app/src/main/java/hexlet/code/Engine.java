package hexlet.code;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Engine {

    public static void runGame(String gameDescription, String[][] gameData) {
        // Welcome message
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println(gameDescription);
        // Logic of question rounds
        for (int i = 0; i < Setup.NUMBER_OF_ROUNDS; i++) {
            System.out.println("Question: " + gameData[i][0]);
            System.out.println("Answer: ");
            String userAnswer = scanner.next();

            if (userAnswer.equals(gameData[i][1])) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer
                        + "' is wrong answer ;(. Correct answer was '"
                        + gameData[i][1] + "'.");
                System.out.println("Let's try again, " + userName + "!");
                System.exit(0);
            }
        }
        System.out.println("Congratulations, " + userName + "!");
        scanner.close();
        System.exit(0);
    }
    // Get random number method
    public static int getRandomNumber(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
