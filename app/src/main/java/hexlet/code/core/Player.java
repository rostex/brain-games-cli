package hexlet.code.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Player {
    private static final Logger logger = LoggerFactory.getLogger(Player.class);
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void selectName(Scanner scanner) {
        if (name == null) {
            logger.info("Welcome to the Brain Games!");
        }
        logger.info("May I have your name?");
        logger.debug("Prompting player to select a name.");
        this.setName(scanner.next());
        logger.debug("Player has selected a name: {}", name);

    }
}
