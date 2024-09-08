package hexlet.code;

import java.util.Arrays;

public class Progression {
    public static void progressionGame() {
        Engine.putWelcomeMessage();
        Engine.getUserName();
        System.out.println("What number is missing in the progression?");

        putTask(); // First question
        putTask(); // Second question
        putTask(); // Third question

        Engine.putCongratulationMessage();

    }

    public static void putTask() {
        int progressionLength = Engine.getRandomNumber(5, 10);
        int firstNumber = Engine.getRandomNumber(3, 9);
        int[] progression = new int[progressionLength];
        int range = Engine.getRandomNumber(2, 7);
        progression [0] = firstNumber;

        for (int i = 1; i < progression.length; i++) {
            progression[i] = progression[i - 1] + range;
        }

        String[] strProgression = new String[progression.length];
        for (int j = 0; j < progression.length; j++) {
            strProgression[j] = String.valueOf(progression[j]);
        }

        var randomNumberProgression = Engine.getRandomNumber(1, progression.length - 1);
        strProgression[randomNumberProgression] = "..";

        System.out.println("Question: " + Arrays.toString(strProgression).replaceAll("\\[|\\]|,", ""));
        System.out.println("Your answer: ");
        int answer = Integer.parseInt(Engine.scanner.next());

        if (answer == progression[randomNumberProgression]) {
            Engine.putCorrectMessage();
        } else {
            System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + progression[randomNumberProgression] + "'."); // add var correct-number
            System.out.println("Let's try again,"); // add userName
            App.main(null);
        }

    }

}
