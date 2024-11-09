package hexlet.code;

import hexlet.code.core.Player;

import java.util.Scanner;

import static hexlet.code.menu.Menu.getMainMenu;

public class Main {
    public static final Scanner SCANNER = new Scanner(System.in);
    public static Player player = new Player();

    public static void main(String[] args) {
        System.out.println("Welcome to the Brain Games!");
        Player.selectName();
        getMainMenu();
    }
}
