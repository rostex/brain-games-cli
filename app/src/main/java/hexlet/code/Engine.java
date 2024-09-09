package hexlet.code;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Engine {
    public static int numberOfRounds = 3;
    public static Scanner scanner = new Scanner(System.in);

    public static void runGame(String gameDescription, String[][] gameData) {
        // Welcome message
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println(gameDescription);
        // Logic of question rounds
        for (int i = 0; i < numberOfRounds; i++) {
            System.out.println("Question: " + gameData[i][0]);
            System.out.println("Answer: ");
            String userAnswer = scanner.next();

            if (userAnswer.equals(gameData[i][1])) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + gameData[i][1] + "'.");
                System.out.println("Let's try again, " + userName + "!");
                System.exit(0);
            }
        }
        System.out.println("Congratulations, " + userName + "!");
        System.exit(0);
    }
    // Get random number method
    public static int getRandomNumber(int min, int max) {
        int randomNumber = ThreadLocalRandom.current().nextInt(min, max + 1);
        return randomNumber;
    }
}
