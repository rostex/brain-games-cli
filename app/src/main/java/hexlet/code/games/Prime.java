package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {
    private static final String gameDiscription = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int min = 1;
    private static final int max = 20;

    public static void startGame() {

        String[][] gameData = new String[Engine.numberOfRounds][2];

        for (int i = 0; i < Engine.numberOfRounds; i++) {

            gameData[i][0] = String.valueOf(Engine.getRandomNumber(min, max));
            gameData[i][1] = Prime.isPrime(Integer.parseInt(gameData[i][0])) ? "yes" : "no";
        }
        Engine.runGame(gameDiscription, gameData);
    }

    public static boolean isPrime(int number) {
        if(number == 1) {
            return false;
        }
        for (int j = 2; j < number; j++) {
            if(number % j == 0) {
                return false;
            }
        }
        return true;
    }
}
