package hexlet.code.utils;

public final class MathUtils {

    private MathUtils() {
        throw new UnsupportedOperationException();
    }

    // Get random number method
    public static int getRandomNumber(final int min, final int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    // Is even check method
    public static boolean isEven(final int number) {
        return number % 2 == 0;
    }

    // Get GCD method of Euclid algorithm
    public static String getGcd(final int a, final int b) {
        if (b == 0) {
            return String.valueOf(a);
        }
        return getGcd(b, a % b);
    }

    // Check prime of number method
    public static boolean isPrime(final int number) {
        if (number == 1) {
            return false;
        }
        for (int j = 2; j < number; j++) {
            if (number % j == 0) {
                return false;
            }
        }
        return true;
    }
}
