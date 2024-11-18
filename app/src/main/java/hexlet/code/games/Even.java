package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.core.GameData;
import hexlet.code.utils.MathUtils;

import java.util.ArrayList;
import java.util.List;

public class Even implements Game {
    private static final String GAME_DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static Even INSTANCE;

    private Even() {
    }

    public static Even getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Even();
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
            int randomNumber = MathUtils.getRandomNumber(min, max);
            String rightAnswer = MathUtils.isEven(randomNumber) ? "yes" : "no";
            gameData.add(new GameData(String.valueOf(randomNumber), rightAnswer));
        }
        return gameData;
    }
}
