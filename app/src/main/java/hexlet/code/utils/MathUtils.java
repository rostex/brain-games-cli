package hexlet.code.utils;

/**
 * Utility class for performing common mathematical operations.
 * This class contains static methods to generate random numbers, check if a number is even,
 * calculate the greatest common divisor (GCD) using Euclid's algorithm, and check if a number is prime.
 */
public final class MathUtils {

    private MathUtils() {
        throw new UnsupportedOperationException("MathUtils is a utility class and cannot be instantiated.");
    }

    /**
     * Generates a random integer between the specified min and max values (inclusive).
     *
     * @param min the minimum value (inclusive)
     * @param max the maximum value (inclusive)
     * @return a random integer between min and max
     * @throws IllegalArgumentException if the min value is greater than the max value
     */
    public static int getRandomNumber(final int min, final int max) {
        if (min > max) {
            throw new IllegalArgumentException("Min value cannot be greater than Max value");
        }
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    /**
     * Checks if the given number is even.
     *
     * @param number the number to check
     * @return {@code true} if the number is even, {@code false} if the number is odd
     */
    public static boolean isEven(final int number) {
        return number % 2 == 0;
    }

    /**
     * Calculates the greatest common divisor (GCD) of two integers using Euclid's algorithm.
     *
     * @param a the first integer
     * @param b the second integer
     * @return the GCD of a and b as a string
     * @throws IllegalArgumentException if both a and b are zero (GCD is undefined)
     */
    public static String getGcd(final int a, final int b) {
        if (a == 0 && b == 0) {
            throw new IllegalArgumentException("GCD is undefined for both a and b being zero");
        }
        if (b == 0) {
            return String.valueOf(a);
        }
        return getGcd(b, a % b);
    }

    /**
     * Checks if the given number is a prime number.
     *
     * @param number the number to check
     * @return {@code true} if the number is prime, {@code false} otherwise
     */
    public static boolean isPrime(final int number) {
        if (number <= 1) {
            return false;
        }
        for (int j = 2; j < Math.sqrt(number) + 1; j++) {
            if (number % j == 0) {
                return false;
            }
        }
        return true;
    }
}
