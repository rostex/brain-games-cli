package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.core.GameData;
import hexlet.code.utils.MathUtils;
import hexlet.code.core.Difficulty;

import java.util.ArrayList;
import java.util.List;

public class Even {
    private static final String GAME_DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void startGame() {
        Engine.runGame(GAME_DESCRIPTION, generateGameData(Difficulty.minNumber, Difficulty.maxNumber));
    }

    private static List<GameData> generateGameData(int min, int max) {
        List<GameData> gameData = new ArrayList<>();
        for (int i = 0; i < Difficulty.numberOfRounds; i++) {
            int randomNumber = MathUtils.getRandomNumber(min, max);
            String rightAnswer = MathUtils.isEven(randomNumber) ? "yes" : "no";
            gameData.add(new GameData(String.valueOf(randomNumber), rightAnswer));
        }
        return gameData;
    }
}


