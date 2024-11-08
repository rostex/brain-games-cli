package hexlet.code.menu;

import hexlet.code.core.Difficulty;
import hexlet.code.Engine;
import hexlet.code.Main;
import hexlet.code.core.Player;
import hexlet.code.games.*;

import java.io.IOException;

public class Menu {
    public static void getMainMenu() {
        System.out.println(Difficulty.difficultyValue + " difficulty level set");
        System.out.println("Please enter the game number and press Enter.");

        for (MenuItem game : MenuItem.values()) {
            System.out.println(game.getNumber() + " - " + game);
        }

        System.out.println("Your choice:");

        while (true) {
            try {
                int choice = Integer.parseInt(Main.SCANNER.next());
                MenuItem game = MenuItem.fromNumber(choice);

                switch (game) {
                    case EVEN -> Even.startGame();
                    case CALC -> Calc.startGame();
                    case GCD -> Gcd.startGame();
                    case PROGRESSION -> Progression.startGame();
                    case PRIME -> Prime.startGame();
                    case SETTINGS -> getSettingsMenu();
                    case STATISTICS -> {
                        Engine.getStatistics();
                        getMainMenu();
                    }
                    case EXIT -> {
                        System.out.println("Exiting the game...");
                        return;
                    }
                }
                return;
            } catch (IllegalArgumentException e) {
                System.out.println("Incorrect value. Please enter a valid number.");
            } catch (IOException b) {
                System.out.println("Error reading statistics file. Please enter another number.");
            }

        }
    }

    public static void getSettingsMenu() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Change player name");
        System.out.println("2 - Select game difficulty");
        System.out.println("3 - Back");

        while (true) {
            try {
                int choice = Integer.parseInt(Main.SCANNER.next());

                switch (choice) {
                    case 1 -> {
                        Player.selectName();
                        Menu.getMainMenu();
                        return;
                    }
                    case 2 -> {
                        Difficulty.selectDifficulty();
                        Menu.getMainMenu();
                        return;
                    }
                    case 3 -> {
                        Menu.getMainMenu();
                        return;
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Incorrect value. Please enter a valid number.");
            }
        }
    }
}
