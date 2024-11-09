package hexlet.code.core;

import hexlet.code.utils.FileUtils;

import java.io.File;

public class GameData {
    private final String question;
    private final String answer;
    private static final String filename = "PlayersStat.yml";
    public static final File gameDataFile = FileUtils.getGameFile(filename);

    public GameData(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
