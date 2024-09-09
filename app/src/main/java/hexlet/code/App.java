package hexlet.code;

import hexlet.code.games.Prime;
import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.Gcd;
import hexlet.code.games.Progression;

public class App {
    private static final int EXIT = 0;
    private static final int GREAT = 1;
    private static final int EVEN = 2;
    private static final int CALC = 3;
    private static final int GCD = 4;
    private static final int PROGRESSION = 5;
    private static final int PRIME = 6;

    public static void main(String[] args) {
        // Greeting
        System.out.println("Please enter the game number and press Enter.");

        int menuNumber = 0;
        String input;

        // Context menu
        while (true) {
            System.out.println("1 - Great");
            System.out.println("2 - Even");
            System.out.println("3 - Calc");
            System.out.println("4 - GCD");
            System.out.println("5 - Progression");
            System.out.println("6 - Prime");
            System.out.println("0 - Exit");
            System.out.println("Your choice:");
            input = Engine.SCANNER.next();

            try {
                menuNumber = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Incorrect value");
            }

            switch (menuNumber) {
                case GREAT -> Cli.greeting();
                case EVEN -> Even.startGame();
                case CALC -> Calc.startGame();
                case GCD -> Gcd.startGame();
                case PROGRESSION -> Progression.startGame();
                case PRIME -> Prime.startGame();
                case EXIT -> System.exit(0);
                default -> System.out.println("Choose correct number");
            }
        }
    }
}
