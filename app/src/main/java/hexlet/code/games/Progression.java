package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.core.GameData;
import hexlet.code.utils.MathUtils;
import hexlet.code.core.Difficulty;

import java.util.ArrayList;
import java.util.List;

public class Progression {
    private static final String GAME_DESCRIPTION = "What number is missing in the progression?";
    private static final int HIDDEN_INDEX_MIN = 1;

    public static void startGame() {
        Engine.runGame(GAME_DESCRIPTION, generateGameData());
    }

    private static List<GameData> generateGameData() {
        List<GameData> gameData = new ArrayList<>();

        for (int i = 0; i < Difficulty.numberOfRounds; i++) {
            int progressionLength = MathUtils.getRandomNumber(Difficulty.minProgressionLength,
                    Difficulty.maxProgressionLength);
            int startProgression = MathUtils.getRandomNumber(Difficulty.minProgressionLength,
                    Difficulty.maxProgressionLength);
            int rangeProgression = MathUtils.getRandomNumber(Difficulty.minProgressionStep,
                    Difficulty.maxProgressionStep);
            int hiddenIndex = MathUtils.getRandomNumber(HIDDEN_INDEX_MIN, progressionLength - 1);

            int[] progression = new int[progressionLength];
            progression[0] = startProgression;

            for (int j = 1; j < progressionLength; j++) {
                progression[j] = progression[j - 1] + rangeProgression;
            }

            StringBuilder questionBuilder = new StringBuilder();
            for (int k = 0; k < progression.length; k++) {
                if (k == hiddenIndex) {
                    questionBuilder.append("..");
                } else {
                    questionBuilder.append(progression[k]);
                }
                if (k < progression.length - 1) {
                    questionBuilder.append(" ");
                }
            }
            String question = questionBuilder.toString();
            String rightAnswer = String.valueOf(progression[hiddenIndex]);

            gameData.add(new GameData(question, rightAnswer));
        }
        return gameData;
    }
}
