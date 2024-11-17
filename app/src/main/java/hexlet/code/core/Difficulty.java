package hexlet.code.core;

import static hexlet.code.Main.SCANNER;

public enum Difficulty {
    EASY("Easy", 3, 1, 1, 10, 5, 10, 1, 5),
    NORMAL("Normal", 5, 2, 1, 20, 6, 10, 5, 12),
    HARD("Hard", 7, 3, 1, 50, 3, 6, 12, 18);

    private String title;

    private int numberOfRounds;
    private int scoreValue;
    private int minNumber;
    private int maxNumber;

    private int minProgressionLength;
    private int maxProgressionLength;
    private int minProgressionStep;
    private int maxProgressionStep;

    Difficulty(String title, int numberOfRounds, int scoreValue, int minNumber, int maxNumber, int minProgressionLength,
               int maxProgressionLength, int minProgressionStep, int maxProgressionStep) {
        this.title = title;
        this.numberOfRounds = numberOfRounds;
        this.scoreValue = scoreValue;
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
        this.minProgressionLength = minProgressionLength;
        this.maxProgressionLength = maxProgressionLength;
        this.minProgressionStep = minProgressionStep;
        this.maxProgressionStep = maxProgressionStep;

    }

    public String getTitle() {
        return title;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public int getScoreValue() {
        return scoreValue;
    }

    public int getMinNumber() {
        return minNumber;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public int getMinProgressionLength() {
        return minProgressionLength;
    }

    public int getMaxProgressionLength() {
        return maxProgressionLength;
    }

    public int getMinProgressionStep() {
        return minProgressionStep;
    }

    public int getMaxProgressionStep() {
        return maxProgressionStep;
    }

    @Override
    public String toString() {
        return title;
    }
}
