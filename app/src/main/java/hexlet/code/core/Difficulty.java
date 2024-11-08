package hexlet.code.core;

import static hexlet.code.Main.SCANNER;

public class Difficulty {
    public static DifficultyValue difficultyValue = DifficultyValue.EASY;

    public static int numberOfRounds = 3;
    public static int scoreValue = 1;
    public static int minNumber = 1;
    public static int maxNumber = 10;

    public static int minProgressionLength = 5;
    public static int maxProgressionLength = 10;
    public static int minProgressionStep = 1;
    public static int maxProgressionStep = 5;

    public static void setDifficulty(DifficultyValue value) {
        difficultyValue = value;
        switch (difficultyValue) {
            case EASY:
                numberOfRounds = 3;
                scoreValue = 1;
                minNumber = 1;
                maxNumber = 10;
                minProgressionLength = 8;
                maxProgressionLength = 12;
                minProgressionStep = 1;
                maxProgressionStep = 5;
                break;
            case NORMAL:
                numberOfRounds = 5;
                scoreValue = 2;
                minNumber = 1;
                maxNumber = 20;
                minProgressionLength = 6;
                maxProgressionLength = 10;
                minProgressionStep = 5;
                maxProgressionStep = 12;
                break;
            case HARD:
                numberOfRounds = 7;
                scoreValue = 3;
                minNumber = 1;
                maxNumber = 50;
                minProgressionLength = 3;
                maxProgressionLength = 6;
                minProgressionStep = 12;
                maxProgressionStep = 18;
                break;
        }
    }

    public static void selectDifficulty() {
        System.out.println("Select difficulty: Easy, Normal, or Hard");
        String input = SCANNER.next().toUpperCase();
        switch (input) {
            case "EASY" -> setDifficulty(DifficultyValue.EASY);
            case "NORMAL" -> setDifficulty(DifficultyValue.NORMAL);
            case "HARD" -> setDifficulty(DifficultyValue.HARD);
            default -> {
                System.out.println("Invalid input, defaulting to EASY");
                setDifficulty(DifficultyValue.HARD);
            }

        }
    }

    public enum DifficultyValue {
        EASY,
        NORMAL,
        HARD;

        @Override
        public String toString() {
            switch (this) {
                case EASY:
                    return "Easy";
                case NORMAL:
                    return "Normal";
                case HARD:
                    return "Hard";
                default:
                    throw new IllegalStateException("Unexpected value: " + this);
            }
        }

    }

}