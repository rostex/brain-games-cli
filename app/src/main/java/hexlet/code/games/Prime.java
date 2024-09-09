package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {
    private static final String GAME_DISCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int MIN = 1;
    private static final int MAX = 20;

    public static void startGame() {
        String[][] gameData = new String[Engine.NUMBER_OF_ROUNDS][2];


        for (int i = 0; i < Engine.NUMBER_OF_ROUNDS; i++) {
            String randomNumber = String.valueOf(Engine.getRandomNumber(MIN, MAX));
            gameData[i][0] = randomNumber;
            gameData[i][1] = Prime.isPrime(Integer.parseInt(gameData[i][0])) ? "yes" : "no";
        }
        Engine.runGame(GAME_DISCRIPTION, gameData);
    }

    public static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }
        for (int j = 2; j < number; j++) {
            if (number % j == 0) {
                return false;
            }
        }
        return true;
    }
}
