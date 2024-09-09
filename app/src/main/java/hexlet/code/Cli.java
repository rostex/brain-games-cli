package hexlet.code;

public class Cli {

    public static void greeting() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        String userName = Engine.scanner.next();
        System.out.println("Hello, " + userName + "!");
    }
}
