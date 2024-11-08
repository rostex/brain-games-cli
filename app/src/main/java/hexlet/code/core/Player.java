package hexlet.code.core;

import static hexlet.code.Main.SCANNER;
import static hexlet.code.Main.player;

public class Player {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void selectName() {
        System.out.println("May I have your name?");
        player.setName(SCANNER.next());

    }
}
