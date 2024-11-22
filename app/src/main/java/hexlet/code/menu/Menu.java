package hexlet.code.menu;

import hexlet.code.managers.DifficultyManager;
import hexlet.code.core.GlobalScanner;
import hexlet.code.core.Player;
import hexlet.code.games.*;
import hexlet.code.managers.StatisticsManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Menu {
    private static final Logger logger = LoggerFactory.getLogger(Menu.class);

    public void getMainMenu() {
        logger.info("{} difficulty level set", Game.difficultyValue.title);
        logger.info("Please enter the menu number and press Enter.");
        logger.debug("Displaying the main menu.");

        for (MenuItem game : MenuItem.values()) {
            System.out.println(game.getMenuNumber() + " - " + game);
        }

        logger.info("Your choice:");

        while (true) {
            try {
                int choice = Integer.parseInt(GlobalScanner.getInstance().next());
                logger.debug("Player enter the number {}", choice);
                MenuItem game = MenuItem.fromNumber(choice);

                switch (game) {
                    case EVEN -> new Even().startGame();
                    case CALC -> new Calc().startGame();
                    case GCD -> new Gcd().startGame();
                    case PROGRESSION -> new Progression().startGame();
                    case PRIME -> new Prime().startGame();
                    case SETTINGS -> getSettingsMenu();
                    case STATISTICS -> {
                        StatisticsManager.getStatistics();
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

    public void getSettingsMenu() {
        logger.info("Please enter the menu number and press Enter.");
        logger.info("1 - Change player name");
        logger.info("2 - Select game difficulty");
        logger.info("3 - Back");

        while (true) {
            try {
                int choice = Integer.parseInt(GlobalScanner.getInstance().next());
                logger.debug("Player enter the number {}", choice);

                switch (choice) {
                    case 1 -> {
                        Player.getInstance().selectName(GlobalScanner.getInstance());
                        getMainMenu();
                        return;
                    }
                    case 2 -> {
                        new DifficultyManager().selectDifficulty(GlobalScanner.getInstance().next());
                        getMainMenu();
                        return;
                    }
                    case 3 -> {
                        getMainMenu();
                        return;
                    }
                }
            } catch (IllegalArgumentException e) {
                logger.error("Incorrect value. Please enter a valid number.");
            }
        }
    }
}
