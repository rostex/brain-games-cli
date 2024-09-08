package hexlet.code;

public class Prime {
    static String gameDiscription = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void startGame() {

        String[][] gameData = new String[Engine.numberOfRounds][2];

        for (int i = 0; i < Engine.numberOfRounds; i++) {

            gameData[i][0] = String.valueOf(Engine.getRandomNumber(1, 20));
            gameData[i][1] = Prime.isPrime(Integer.parseInt(gameData[i][0])) ? "yes" : "no";
        }
        Engine.runGame(gameDiscription, gameData);
    }

    public static boolean isPrime(int number) {
        if (number == 1) {
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
