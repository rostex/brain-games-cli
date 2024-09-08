package hexlet.code;

public class Even {
    static String gameDiscription = "Answer 'yes' if number even otherwise answer 'no'";

    public static void startGame() {
        String[][] gameData = new String[Engine.numberOfRounds][2];

        for (int i = 0; i < Engine.numberOfRounds; i++) {
            gameData[i][0] = String.valueOf(Engine.getRandomNumber(1, 20)); // Array with question
            gameData[i][1] = Even.isEven(Integer.parseInt(gameData[i][0])) ? "yes" : "no"; // Array with answer

        }
        Engine.runGame(gameDiscription, gameData);
    }
    // IS even check method
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}


