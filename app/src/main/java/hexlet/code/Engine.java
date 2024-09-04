package hexlet.code;

public class Engine {

    public static int getRandomNumber(int min, int max) {
        int randomNumber = min + (int) (Math.random() * max);
        return randomNumber;
    }

    public static String getRandomOperator() {
        String[] operators = {"+", "-", "*"};
        return operators[getRandomNumber(0, 2)];

    }

//    Нужен код для случайного операнда и оператора
//    public  static int getRandomExpression() {
//
//        int randomNumber = Engine.getRandomNumber(1, 20);
//        int randomNumber2 = Engine.getRandomNumber(1, 20);
//        return randomNumber;
//    }


}
