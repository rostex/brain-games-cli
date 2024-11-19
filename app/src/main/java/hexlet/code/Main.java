package hexlet.code;

import hexlet.code.core.Player;

import java.util.Scanner;

import static hexlet.code.menu.Menu.getMainMenu;

public class Main {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        Player.getInstance().selectName(SCANNER);
        getMainMenu();
    }
}
