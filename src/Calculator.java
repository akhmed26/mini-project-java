import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        System.out.println("\t\tКалькулятор");
        caluculate();
    }

    public static void caluculate() {
        String[] expression = lists();

        // Преобразование строковых значений в числа
        int a = Integer.parseInt(expression[0]);
        int b = Integer.parseInt(expression[2]);
        String operator = expression[1];

        // Выполнение операции
        switch (operator) {
            case "+":
                System.out.println(addition(a, b));
                break;
            case "-":
                System.out.println(subtraction(a, b));
                break;
            case "*":
                System.out.println(multiplication(a, b));
                break;
            case "/":
                if (b != 0) {
                    System.out.println(division(a, b));
                } else {
                    System.out.println("Error/На ноль делить нельзя!");
                }
                break;
            default:
                System.out.println("Неизвестный оператор.");
        }
    }

    public static String[] lists(){
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Введите ваше выражение вот так\n" +
                    "1 + 2\n" +
                    "первое значение/оператор/второе значение\n" +
                    "'/' = пробел");
            System.out.println("Введите выражение: ");
            String input = sc.nextLine();
            String[] expression = input.split(" ");

            // Проверка на правильное количество элементов
            if (expression.length != 3) {
                System.out.println("Error/Нужно только выражение из 3 элементов!!!");
            } else if (!expression[0].matches("-?\\d+") || !expression[2].matches("-?\\d+")) {
                //Проверка на цифры
                System.out.println("Нужно только цифры для значений!");
            } else if (!expression[1].matches("[+\\-*/]")) {
                // Проверка на символы
                System.out.println("Нужно только символы ( +, -, *, / )");
            }else if (expression[2].equals("0") && expression[1].equals("/")){
                System.out.println("На ноль делить нельзя");
            }else{
                return expression;
            }

        }while (true);
    }

    // Сложение
    public static int addition(int a, int b){
        return a + b;
    }

    // Вычитание
    public static int subtraction(int a, int b){
        return a - b;
    }

    // Умножение
    public static int multiplication(int a, int b){
        return a * b;
    }

    // Деление
    public static float division(int a, int b){
        return (float) a / b;
    }

}