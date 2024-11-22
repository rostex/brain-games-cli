package hexlet.code.games;

import hexlet.code.core.GameData;
import hexlet.code.utils.MathUtils;

import java.util.ArrayList;
import java.util.List;

public class Even extends Game {

    @Override
    protected String getGameDescription() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    @Override
    protected List<GameData> getGeneratedGameData() {
        List<GameData> gameData = new ArrayList<>();
        int minNumber = difficultyValue.minNumber;
        int maxNumber = difficultyValue.maxNumber;
        for (int i = 0; i < difficultyValue.numberOfRounds; i++) {
            int randomNumber = MathUtils.getRandomNumber(minNumber, maxNumber);
            String rightAnswer = MathUtils.isEven(randomNumber) ? "yes" : "no";
            gameData.add(new GameData(String.valueOf(randomNumber), rightAnswer));
        }
        return gameData;
    }

}
