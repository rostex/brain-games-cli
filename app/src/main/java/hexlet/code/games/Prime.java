package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.core.GameData;
import hexlet.code.utils.MathUtils;

import java.util.ArrayList;
import java.util.List;

public class Prime implements Game {
    private static final String GAME_DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static Prime INSTANCE;

    private Prime() {
    }

    public static Prime getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Prime();
        }
        return INSTANCE;
    }

    @Override
    public void startGame() {
        Engine.runGame(GAME_DESCRIPTION, generateGameData(Engine.difficulty.minNumber,  Engine.difficulty.maxNumber));
    }

    private static List<GameData> generateGameData(int min, int max) {
        List<GameData> gameData = new ArrayList<>();
        for (int i = 0; i < Engine.difficulty.numberOfRounds; i++) {
            String question = String.valueOf(MathUtils.getRandomNumber(min, max));
            String rightAnswer = MathUtils.isPrime(Integer.parseInt(question)) ? "yes" : "no";
            gameData.add(new GameData(question, rightAnswer));
        }
        return gameData;
    }
}
