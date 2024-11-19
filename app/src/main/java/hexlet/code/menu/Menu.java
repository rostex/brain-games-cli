package hexlet.code.menu;

import hexlet.code.Engine;
import hexlet.code.Main;
import hexlet.code.core.Player;
import hexlet.code.games.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Menu {
    private static final Logger logger = LoggerFactory.getLogger(Player.class);

    public static void getMainMenu() {
        logger.info("{} difficulty level set", Engine.difficulty.title);
        logger.info("Please enter the menu number and press Enter.");
        logger.debug("Displaying the main menu.");

        for (MenuItem game : MenuItem.values()) {
            System.out.println(game.getMenuNumber() + " - " + game);
        }

        logger.info("Your choice:");

        while (true) {
            try {
                int choice = Integer.parseInt(Main.SCANNER.next());
                logger.debug("Player enter the number {}", choice);
                MenuItem game = MenuItem.fromNumber(choice);

                switch (game) {
                    case EVEN -> Even.getInstance().startGame();
                    case CALC -> Calc.getInstance().startGame();
                    case GCD -> Gcd.getInstance().startGame();
                    case PROGRESSION -> Progression.getInstance().startGame();
                    case PRIME -> Prime.getInstance().startGame();
                    case SETTINGS -> getSettingsMenu();
                    case STATISTICS -> {
                        Engine.getStatistics();
                        getMainMenu();
                    }
                    case EXIT -> {
                        logger.info("Exiting the game...");
                        return;
                    }
                }
                return;
            } catch (IllegalArgumentException e) {
                logger.error("Incorrect value. Please enter a valid number.");
            } catch (IOException b) {
                logger.error("Error reading statistics file. Please enter another number.");
            }

        }
    }

    public static void getSettingsMenu() {
        logger.info("Please enter the menu number and press Enter.");
        logger.info("1 - Change player name");
        logger.info("2 - Select game difficulty");
        logger.info("3 - Back");

        while (true) {
            try {
                int choice = Integer.parseInt(Main.SCANNER.next());
                logger.debug("Player enter the number {}", choice);

                switch (choice) {
                    case 1 -> {
                        Player.getInstance().selectName(Main.SCANNER);
                        Menu.getMainMenu();
                        return;
                    }
                    case 2 -> {
                        Engine.selectDifficulty();
                        Menu.getMainMenu();
                        return;
                    }
                    case 3 -> {
                        Menu.getMainMenu();
                        return;
                    }
                }
            } catch (IllegalArgumentException e) {
                logger.error("Incorrect value. Please enter a valid number.");
            }
        }
    }
}
