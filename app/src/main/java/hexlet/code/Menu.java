package hexlet.code;

import hexlet.code.games.*;
import hexlet.code.games.Games;

public class Menu {
    public static void getGamesMenu() {
        System.out.println("Please enter the game number and press Enter.");

        for (Games game : Games.values()) {
            System.out.println(game.getNumber() + " - " + game);
        }

        System.out.println("Your choice:");

        while (true) {
            try {
                int choice = Integer.parseInt(Setup.SCANNER.next());
                Games game = Games.fromNumber(choice);

                switch (game) {
                    case EVEN -> Even.startGame();
                    case CALC -> Calc.startGame();
                    case GCD -> Gcd.startGame();
                    case PROGRESSION -> Progression.startGame();
                    case PRIME -> Prime.startGame();
                    case EXIT -> {
                        System.out.println("Exiting the game...");
                        return;
                    }
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Incorrect value. Please enter a valid number.");
            }

        }
    }
}
