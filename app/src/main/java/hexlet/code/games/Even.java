package hexlet.code.games;

import hexlet.code.Engine;

public class Even {
    private static final String gameDiscription = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int min = 1;
    private static final int max = 20;

    public static void startGame() {
        String[][] gameData = new String[Engine.numberOfRounds][2];

        for (int i = 0; i < Engine.numberOfRounds; i++) {
            gameData[i][0] = String.valueOf(Engine.getRandomNumber(min, max)); // Array with question
            gameData[i][1] = Even.isEven(Integer.parseInt(gameData[i][0])) ? "yes" : "no"; // Array with answer

        }
        Engine.runGame(gameDiscription, gameData);
    }
    // IS even check method
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}


