package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.core.GameData;
import hexlet.code.utils.MathUtils;

import java.util.ArrayList;
import java.util.List;

public class Gcd implements Game {
    private static final String GAME_DESCRIPTION = "Find the greatest common divisor of given numbers.";
    private static Gcd INSTANCE;

    private Gcd() {
    }

    public static Gcd getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Gcd();
        }
        return INSTANCE;
    }

    @Override
    public void startGame() {
        Engine.runGame(GAME_DESCRIPTION, generateGameData(Engine.difficulty.getMinNumber(),  Engine.difficulty.getMaxNumber()));
    }

    private static List<GameData> generateGameData(int min, int max) {
        List<GameData> gameData = new ArrayList<>();
        for (int i = 0; i < Engine.difficulty.getNumberOfRounds(); i++) {
            int firstNumber = MathUtils.getRandomNumber(min, max);
            int secondNumber = MathUtils.getRandomNumber(min, max);
            String question = firstNumber + " " + secondNumber;
            String rightAnswer = MathUtils.getGcd(firstNumber, secondNumber);
            gameData.add(new GameData(question, rightAnswer));
        }
        return gameData;
    }
}
