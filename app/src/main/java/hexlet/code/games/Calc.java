package hexlet.code.games;

import hexlet.code.core.GameData;
import hexlet.code.utils.MathUtils;

import java.util.ArrayList;
import java.util.List;

public class Calc extends Game {

    @Override
    protected String getGameDescription() {
        return "What is the result of the expression?";
    }

    @Override
    protected List<GameData> getGeneratedGameData() {
        List<GameData> gameData = new ArrayList<>();

        int minNumber = difficultyValue.minNumber;
        int maxNumber = difficultyValue.maxNumber;
        for (int i = 0; i < difficultyValue.numberOfRounds; i++) {
            int firstNumber = MathUtils.getRandomNumber(minNumber, maxNumber);
            int secondNumber = MathUtils.getRandomNumber(minNumber, maxNumber);

            Operator operator = Operator.getRandomOperator();

            String question = firstNumber + " " + operator.getSymbol() + " " + secondNumber;
            String rightAnswer = String.valueOf(operator.calculate(firstNumber, secondNumber));

            gameData.add(new GameData(question, rightAnswer));
        }
        return gameData;
    }

    private enum Operator {
        PLUS("+", (a, b) -> a + b),
        MINUS("-", (a, b) -> a - b),
        MULTIPLY("*", (a, b) -> a * b);

        private final String symbol;
        private final Operation operation;

        Operator(String symbol, Operation operation) {
            this.symbol = symbol;
            this.operation = operation;
        }

        public String getSymbol() {
            return symbol;
        }

        public int calculate(int a, int b) {
            return operation.apply(a, b);
        }

        @FunctionalInterface
        private interface Operation {
            int apply(int a, int b);
        }

        public static Operator getRandomOperator() {
            Operator[] operators = values();
            return operators[(int) (Math.random() * operators.length)];
        }
    }
}
