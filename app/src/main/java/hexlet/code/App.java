package hexlet.code;

import hexlet.code.games.Prime;
import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.Gcd;
import hexlet.code.games.Progression;

public class App {
    private static final int exit = 0;
    private static final int great = 1;
    private static final int even = 2;
    private static final int calc = 3;
    private static final int gcd = 4;
    private static final int progression = 5;
    private static final int prime = 6;

    public static void main(String[] args) {
        // Greeting
        System.out.println("Please enter the game number and press Enter.");

        int x = 0;
        String s = "";

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
            s = Engine.scanner.next();

            try {
                x = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Incorrect value");
            }

            switch (x) {
                case great -> Cli.greeting();
                case even -> Even.startGame();
                case calc -> Calc.startGame();
                case gcd -> Gcd.startGame();
                case progression -> Progression.startGame();
                case prime -> Prime.startGame();
                case exit -> {
                    System.exit(0);
                }
                default -> System.out.println("Choose correct number");
            }
        }
    }
}
