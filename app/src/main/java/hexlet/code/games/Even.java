package hexlet.code.games;

import hexlet.code.Engine;

public class Even {
    private static final String GAME_DISCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int MIN = 1;
    private static final int MAX = 20;

    public static void startGame() {
        String[][] gameData = new String[Engine.NUMBER_OF_ROUNDS][2];

        for (int i = 0; i < Engine.NUMBER_OF_ROUNDS; i++) {
            gameData[i][0] = String.valueOf(Engine.getRandomNumber(MIN, MAX)); // Array with question
            gameData[i][1] = Even.isEven(Integer.parseInt(gameData[i][0])) ? "yes" : "no"; // Array with answer

        }
        Engine.runGame(GAME_DISCRIPTION, gameData);
    }
    // IS even check method
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}


