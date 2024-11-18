package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.core.GameData;
import hexlet.code.utils.MathUtils;

import java.util.ArrayList;
import java.util.List;

public class Progression implements Game {
    private static final String GAME_DESCRIPTION = "What number is missing in the progression?";
    private static final int HIDDEN_INDEX_MIN = 1;
    private static Progression INSTANCE;

    private Progression() {
    }

    public static Progression getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Progression();
        }
        return INSTANCE;
    }

    @Override
    public void startGame() {
        Engine.runGame(GAME_DESCRIPTION, generateGameData());
    }

    private static List<GameData> generateGameData() {
        List<GameData> gameData = new ArrayList<>();

        for (int i = 0; i < Engine.difficulty.numberOfRounds; i++) {
            int progressionLength = MathUtils.getRandomNumber(Engine.difficulty.minProgressionLength,
                    Engine.difficulty.maxProgressionLength);
            int startProgression = MathUtils.getRandomNumber(Engine.difficulty.minProgressionLength,
                    Engine.difficulty.maxProgressionLength);
            int rangeProgression = MathUtils.getRandomNumber(Engine.difficulty.minProgressionStep,
                    Engine.difficulty.maxProgressionLength);
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
