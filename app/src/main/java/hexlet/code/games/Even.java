package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.MathUtils;
import hexlet.code.Setup;

public class Even {
    private static final String GAME_DISCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int MIN = 1;
    private static final int MAX = 20;

    public static void startGame() {
        Engine.runGame(GAME_DISCRIPTION, generateGameData());
    }

    private static String[][] generateGameData() {
        String[][] gameData = new String[Setup.NUMBER_OF_ROUNDS][2];
        for (int i = 0; i < Setup.NUMBER_OF_ROUNDS; i++) {
            gameData[i][0] = String.valueOf(MathUtils.getRandomNumber(MIN, MAX)); // Array with question
            gameData[i][1] = MathUtils.isEven(Integer.parseInt(gameData[i][0])) ? "yes" : "no"; // Array with answer
        }
        return gameData;
    }
}


