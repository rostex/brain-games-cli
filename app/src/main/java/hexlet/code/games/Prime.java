package hexlet.code.games;

import hexlet.code.core.GameData;
import hexlet.code.utils.MathUtils;

import java.util.ArrayList;
import java.util.List;

public class Prime extends Game {

    @Override
    protected String getGameDescription() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    @Override
    protected List<GameData> getGeneratedGameData() {
        List<GameData> gameData = new ArrayList<>();

        int minNumber = difficultyValue.minNumber;
        int maxNumber = difficultyValue.maxNumber;
        for (int i = 0; i < difficultyValue.numberOfRounds; i++) {
            String question = String.valueOf(MathUtils.getRandomNumber(minNumber, maxNumber));
            String rightAnswer = MathUtils.isPrime(Integer.parseInt(question)) ? "yes" : "no";
            gameData.add(new GameData(question, rightAnswer));
        }
        return gameData;
    }

}
