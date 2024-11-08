package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.core.GameData;
import hexlet.code.utils.MathUtils;
import hexlet.code.core.Difficulty;

import java.util.ArrayList;
import java.util.List;

public class Calc {
    private static final String GAME_DESCRIPTION = "What is the result of the expression?";

    public static void startGame() {
        Engine.runGame(GAME_DESCRIPTION, generateGameData());
    }

    private static List<GameData> generateGameData() {
        List<GameData> gameData = new ArrayList<>();

        for (int i = 0; i < Difficulty.numberOfRounds; i++) {
            int firstNumber = MathUtils.getRandomNumber(Difficulty.minNumber, Difficulty.maxNumber);
            int secondNumber = MathUtils.getRandomNumber(Difficulty.minNumber, Difficulty.maxNumber);

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
