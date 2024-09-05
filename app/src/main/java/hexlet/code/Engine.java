package hexlet.code;

import java.util.Scanner;

public class Engine {
    static Scanner scanner = new Scanner(System.in);

    public static void putWelcomeMessage() {
        System.out.println("Welcome to the Brain Games!");
    }

    // Need to fix: return userName throw methods
    public static void getUserName() {
        System.out.println("May I have your name?");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
    }

    // Need to fix: somewhere String, somewhere int
    public static void getAnswer() {
        System.out.println("Your answer: ");
        var answer = Integer.parseInt(scanner.next());
    }

    public static void putCorrectMessage() {
        System.out.println("Correct!");
    }

    public static void putCongratulationMessage() {
        System.out.println("Congratulations, Bill!");
    }

    /* Need to fix: var answer and result throw methods
    public static void putIncorrectMessage() {
        System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + result + "'.");
        System.out.println("Let's try again,"); // добавить юзера
    }

     */


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
