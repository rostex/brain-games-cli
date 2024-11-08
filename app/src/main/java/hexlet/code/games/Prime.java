package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.core.GameData;
import hexlet.code.utils.MathUtils;
import hexlet.code.core.Difficulty;

import java.util.ArrayList;
import java.util.List;

public class Prime {
    private static final String GAME_DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void startGame() {
        Engine.runGame(GAME_DESCRIPTION, generateGameData(Difficulty.minNumber, Difficulty.maxNumber));
    }

    private static List<GameData> generateGameData(int min, int max) {
        List<GameData> gameData = new ArrayList<>();
        for (int i = 0; i < Difficulty.numberOfRounds; i++) {
            String question = String.valueOf(MathUtils.getRandomNumber(min, max));
            String rightAnswer = MathUtils.isPrime(Integer.parseInt(question)) ? "yes" : "no";
            gameData.add(new GameData(question, rightAnswer));
        }
        return gameData;
    }
}
