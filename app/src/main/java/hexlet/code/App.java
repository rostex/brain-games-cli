package hexlet.code;

import hexlet.code.games.Prime;
import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.Gcd;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        // Greeting
        System.out.println("Please enter the game number and press Enter.");
        Scanner scanner = new Scanner(System.in);

        // Context menu
        System.out.println("1 - Great");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        System.out.println("Your choice:");

        while (true) {
            try {
                var choice = Integer.parseInt(scanner.next());

                switch (choice) {
                    case Setup.GREAT -> Cli.greeting();
                    case Setup.EVEN -> Even.startGame();
                    case Setup.CALC -> Calc.startGame();
                    case Setup.GCD -> Gcd.startGame();
                    case Setup.PROGRESSION -> Progression.startGame();
                    case Setup.PRIME -> Prime.startGame();
                    case Setup.EXIT -> System.exit(0);
                    default -> System.out.println("Choose correct number");
                }

            } catch (NumberFormatException e) {
                System.out.println("Incorrect value");
            }

        }
    }

}
