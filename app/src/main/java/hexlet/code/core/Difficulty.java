package hexlet.code.core;

public enum Difficulty {
    EASY("Easy", 3, 1, 1, 10, 5, 10, 1, 5),
    NORMAL("Normal", 5, 2, 1, 20, 6, 10, 5, 12),
    HARD("Hard", 7, 3, 1, 50, 3, 6, 12, 18);

    public final String title;
    public final int numberOfRounds;
    public final int scoreValue;
    public final int minNumber;
    public final int maxNumber;

    public final int minProgressionLength;
    public final int maxProgressionLength;
    public final int minProgressionStep;
    public final int maxProgressionStep;

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

    @Override
    public String toString() {
        return title;
    }
}
