package hexlet.code;

public class Gcd {

    public static void gcdGame() {
        Cli.greeting(); // Greeting
        System.out.println("Find the greatest common divisor of given numbers.");

        putTask();
        putTask();
        putTask();

        Engine.putCongratulationMessage();
    }

    public static void putTask() {
        int number1 = Engine.getRandomNumber(1, 20);
        int number2 = Engine.getRandomNumber(1, 20);
        int result = Engine.getGcd(number1, number2);

        System.out.println("Question: " + number1 + " " + number2);
        System.out.println("Your answer: ");
        int answer = Integer.parseInt(Engine.scanner.next());

        if (result == answer) {
            Engine.putCorrectMessage();
        } else {
            System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + result + "'.");
            System.out.println("Let's try again,"); // добавить юзера
            App.main(null);
        }
    }
}
