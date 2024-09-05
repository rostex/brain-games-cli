package hexlet.code;

import java.util.Arrays;

public class Progression {
    public static void progressionGame() {
        Engine.putWelcomeMessage();
        Engine.getUserName();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        putTask(); // First question
        putTask(); // Second question
        putTask(); // Third question

        Engine.putCongratulationMessage();

    }

    public static void putTask() {
        int progressionLength = Engine.getRandomNumber(5, 10);
        int firstNumber = Engine.getRandomNumber(3, 9);
        int[]  progression = new int[progressionLength];
        int range = Engine.getRandomNumber(2, 7);
        progression [0] = firstNumber;

        for (int i = 1; i < progressionLength; i++) {
            progression[i] = progression[i + 1] + range;
        }

        System.out.println(Arrays.toString(progression));

        /*System.out.println("Question: " + randomNumber);
        System.out.println("Your answer: ");
        String answer = Engine.scanner.next();

        if (randomNumber % 2 == 0 && "yes".equals(answer)) {
            Engine.putCorrectMessage();
        } else if (randomNumber % 2 != 0 && "no".equals(answer)) {
            Engine.putCorrectMessage();
        } else {
            System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was 'no'."); // add var correct-number
            System.out.println("Let's try again,"); // add userName
            App.main(null);
        }

         */
    }

}
