package hexlet.code;

public class Even {
    static int a = 1; // Начальный диапазон случайного числа
    static int b = 20; // Конечный диапазон случайного числа

    public static void evenGame() {
        Cli.greeting(); // Приветствие
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        firstQuestion(); // Первый вопрос
        secondQuestion(); // Второй вопрос
        thirdQuestion(); // Третий вопрос

    }

    // Первый вопрос
    public static void firstQuestion() {
        int randomNumber1 = a + (int) (Math.random() * b);
        System.out.println("Question: " + randomNumber1);
        System.out.println("Your answer: ");
        String answer1 = App.scanner.next();

        if (randomNumber1 % 2 == 0 && "yes".equals(answer1)) {
            System.out.println("Correct!");
        } else if (randomNumber1 % 2 != 0 && "no".equals(answer1)) {
            System.out.println("Correct!");
        } else {
            System.out.println("'" + answer1 + "' is wrong answer ;(. Correct answer was 'no'."); // инверсия к ответу
            System.out.println("Let's try again,"); // добавить юзера
            App.main(null);
        }
    }

    // Второй вопрос
    public static void secondQuestion() {
        int randomNumber2 = a + (int) (Math.random() * b);
        System.out.println("Question: " + randomNumber2);
        System.out.println("Your answer: ");
        String answer2 = App.scanner.next();

        if (randomNumber2 % 2 == 0 && "yes".equals(answer2)) {
            System.out.println("Correct!");
        } else if (randomNumber2 % 2 != 0 && "no".equals(answer2)) {
            System.out.println("Correct!");
        } else {
            System.out.println("'" + answer2 + "' is wrong answer ;(. Correct answer was 'no'."); // инверсия к ответу
            System.out.println("Let's try again,"); // добавить юзера
            App.main(null);
        }
    }

    // Третий вопрос
    public static void thirdQuestion() {
        int randomNumber3 = a + (int) (Math.random() * b);
        System.out.println("Question: " + randomNumber3);
        System.out.println("Your answer: ");
        String answer3 = App.scanner.next();
        if (randomNumber3 % 2 == 0 && "yes".equals(answer3)) {
            System.out.println("Correct!");
            System.out.println("Congratulations, Bill!");
            App.main(null);
        } else if (randomNumber3 % 2 != 0 && "no".equals(answer3)) {
            System.out.println("Correct!");
            System.out.println("Congratulations, Bill!");
            App.main(null);
        } else {
            System.out.println("'" + answer3 + "' is wrong answer ;(. Correct answer was 'no'."); // инверсия к ответу
            System.out.println("Let's try again,"); // добавить юзера
            App.main(null);
        }
    }
}
