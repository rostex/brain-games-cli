package hexlet.code.games;

import hexlet.code.core.GameData;
import hexlet.code.utils.MathUtils;

import java.util.ArrayList;
import java.util.List;

public class Progression extends Game {
    private static final int HIDDEN_INDEX_MIN = 1;

    @Override
    protected String getGameDescription() {
        return "What number is missing in the progression?";
    }

    @Override
    protected List<GameData> getGeneratedGameData() {
        List<GameData> gameData = new ArrayList<>();

        for (int i = 0; i < difficultyValue.numberOfRounds; i++) {
            int progressionLength = MathUtils.getRandomNumber(difficultyValue.minProgressionLength,
                    difficultyValue.maxProgressionLength);
            int startProgression = MathUtils.getRandomNumber(difficultyValue.minProgressionLength,
                    difficultyValue.maxProgressionLength);
            int rangeProgression = MathUtils.getRandomNumber(difficultyValue.minProgressionStep,
                    difficultyValue.maxProgressionLength);
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
