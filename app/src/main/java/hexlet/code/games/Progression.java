package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Setup;

import java.util.Arrays;

public class Progression {
    private static final String GAME_DISCRIPTION = "What number is missing in the progression?";
    private static final int MIN = 5;
    private static final int MAX = 10;
    private static final int HIDDEN_INDEX = 1;

    public static void startGame() {
        String[][] gameData = new String[Setup.NUMBER_OF_ROUNDS][2];

        for (int i = 0; i < Setup.NUMBER_OF_ROUNDS; i++) {
            gameData[i][0] = "";

            int progressionLength = Engine.getRandomNumber(MIN, MAX);
            int startProgression = Engine.getRandomNumber(MIN, MAX);
            int rangeProgression = Engine.getRandomNumber(MIN, MAX);
            int hiddenNumber = Engine.getRandomNumber(HIDDEN_INDEX, progressionLength - 1);

            int[] progression = new int[progressionLength];
            progression[0] = startProgression;
            // Create int array
            for (int j = 1; j < progression.length; j++) {
                progression[j] = progression[j - 1] + rangeProgression;
            }
            // Convert int array to String
            String[] strProgression = new String[progressionLength];
            for (int k = 0; k < progression.length; k++) {
                strProgression[k] = String.valueOf(progression[k]);
            }

            strProgression[hiddenNumber] = "..";

            gameData[i][0] = Arrays.toString(strProgression).replaceAll("[\\[\\],]", ""); // Arrays with question
            gameData[i][1] = String.valueOf(progression[hiddenNumber]); // Arrays with answer
        }
        Engine.runGame(GAME_DISCRIPTION, gameData);
    }
}
