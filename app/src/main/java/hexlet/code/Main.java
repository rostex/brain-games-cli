package hexlet.code;

import hexlet.code.core.GlobalScanner;
import hexlet.code.core.Player;
import hexlet.code.menu.Menu;

public class Main {

    public static void main(String[] args) {
        Player.getInstance().selectName(GlobalScanner.getInstance());
        new Menu().getMainMenu();
    }
}
