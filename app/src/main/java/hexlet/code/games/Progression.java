package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Arrays;

public class Progression {
    static String gameDiscription = "What number is missing in the progression?";

    public static void startGame() {
        String[][] gameData = new String[Engine.numberOfRounds][2];

        for (int i = 0; i < Engine.numberOfRounds; i++) {
            gameData[i][0] = "";

            int progressionLength = Engine.getRandomNumber(5, 10);
            int startProgression = Engine.getRandomNumber(3, 9);
            int rangeProgression = Engine.getRandomNumber(2, 7);
            int hiddenNumber = Engine.getRandomNumber(1, progressionLength - 1);

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

            gameData[i][0] = Arrays.toString(strProgression).replaceAll("\\[|\\]|,", ""); // Arrays with question
            gameData[i][1] = String.valueOf(progression[hiddenNumber]); // Arrays with answer
        }
        Engine.runGame(gameDiscription, gameData);
    }
}
