package hexlet.code.utils;

import java.io.File;

public class FileUtils {

    private static final String WIN = "win";
    private static final String MAC = "mac";
    private static final String APPDATA = "APPDATA";

    /**
     * Returns the file object for the specified game file.
     * Depending on the operating system, this method creates the necessary directory
     * if it doesn't exist and then returns the file path for the specified filename.
     *
     * @param filename The name of the file for the game data.
     * @return The File object representing the full path to the specified game file.
     */
    public static File getGameFile(String filename) {
        String os = System.getProperty("os.name").toLowerCase();
        String userHome = System.getProperty("user.home");
        File gameDirectory;

        if (os.contains(WIN)) {
            gameDirectory = new File(getAppDataDir(userHome), "Brain Games CLI");
        } else if (os.contains(MAC)) {
            gameDirectory = new File(userHome, "Library/Application Support/Brain Games CLI");
        } else {
            gameDirectory = new File(userHome, ".Brain Games CLI");
        }

        createDirectoryIfNeeded(gameDirectory);

        return new File(gameDirectory, filename);
    }

    /**
     * Returns the application data directory (APPDATA) for Windows or the user's home directory.
     *
     * @param userHome The user's home directory path (for non-Windows systems).
     * @return The path to the APPDATA directory on Windows, or the user's home directory for other systems.
     */
    private static String getAppDataDir(String userHome) {
        String appDataDir = System.getenv(APPDATA);
        return appDataDir != null ? appDataDir : userHome;
    }

    /**
     * Creates the specified directory if it does not already exist.
     *
     * @param gameDirectory The directory to be created if it doesn't exist.
     */
    private static void createDirectoryIfNeeded(File gameDirectory) {
        if (!gameDirectory.exists()) {
            boolean created = gameDirectory.mkdirs();
        }
    }
}

