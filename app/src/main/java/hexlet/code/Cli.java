package hexlet.code;

import java.util.Scanner;

public class Cli {

    public static void greeting() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        String userName = App.scanner.next();
        System.out.println("Hello, " + userName);
    }
}
