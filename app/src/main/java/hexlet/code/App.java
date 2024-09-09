package hexlet.code;

import hexlet.code.games.*;

public class App {

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
                case 1 -> Cli.greeting();
                case 2 -> Even.startGame();
                case 3 -> Calc.startGame();
                case 4 -> Gcd.startGame();
                case 5 -> Progression.startGame();
                case 6 -> Prime.startGame();
                case 0 -> {
                    System.exit(0);
                }
                default -> System.out.println("Choose correct number");
            }
        }
    }
}
