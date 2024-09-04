package hexlet.code;

import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        // Приветствие
        System.out.println("Please enter the game number and press Enter.");

        int x = 0;
        String s = "";

        // Контекстное меню
        while (!"2".equals(s)) {
            System.out.println("1 - Great");
            System.out.println("2 - Even");
            System.out.println("3 - Calc");
            System.out.println("0 - Exit");
            System.out.println("Your choice:");
            s = scanner.next();

            try {
                x = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Incorrect value");
            }

            switch (x) {
                case 1 -> Cli.greeting();
                case 2 -> Even.evenGame();
                case 3 -> Calc.calcGame();
                case 0 -> {
                    System.exit(0);
                }
                default -> System.out.println("Choose correct number");
            }
        }

    }
}
