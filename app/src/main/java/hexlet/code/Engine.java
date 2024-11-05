package hexlet.code;

import static hexlet.code.Setup.*;

public class Engine {

    public static void runGame(String gameDescription, String[][] gameData) {

        System.out.println("Hello, " + user.getName() + "!");
        System.out.println(gameDescription);

        for (int i = 0; i < NUMBER_OF_ROUNDS; i++) {
            System.out.println("Question: " + gameData[i][0]);
            System.out.println("Answer: ");
            String userAnswer = SCANNER.next();

            if (userAnswer.equals(gameData[i][1])) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer
                        + "' is wrong answer ;(. Correct answer was '"
                        + gameData[i][1] + "'.");
                System.out.println("Let's try again, " + user.getName() + "!\n");
                Menu.getGamesMenu();
            }
        }
        System.out.println("Congratulations, " + user.getName() + "!\n");
        Menu.getGamesMenu();
    }

    public static void greeting() {
        System.out.println("Welcome to the Brain Games!");
        if (user.getName() == null) {
            System.out.println("May I have your name?");
            user.setName(SCANNER.next());
        }
    }


}
