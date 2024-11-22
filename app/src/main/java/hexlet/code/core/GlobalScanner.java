package hexlet.code.core;

import java.util.Scanner;

public class GlobalScanner {
    private static java.util.Scanner instance;

    public GlobalScanner() {
    }

    public static Scanner getInstance() {
        if (instance == null) {
            instance = new java.util.Scanner(System.in);
        }
        return instance;
    }
}
