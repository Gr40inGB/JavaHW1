import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        // Реализовать простой калькулятор
        // (введите первое число, введите второе число, введите требуемую операцию, ответ)
        System.out.println(calc(inputNumber("Please enter first number a: "),  // Задача 4
                inputNumber("Please enter second number b: "),
                operatorInput()));
    }

    public static String operatorInput() {
        System.out.print("Now enter the operation: ");
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }

    public static String calc(int a, int b, String operation) {
        switch (operation) {
            case ("+") -> {
                return "Your answer is " + String.valueOf(a + b);
            }
            case ("-") -> {
                return "Your answer is " + String.valueOf(a - b);
            }
            case ("*") -> {
                return "Your answer is " + String.valueOf(a * b);
            }
            case ("/") -> {
                if (b == 0) return "We cant decide by zero";
                return "Your answer is " + String.format("%.2f", a / (b * 1.0));
            }
        }
        return "Not found this \"" + operation + "\" operation";
    }

    public static int inputNumber(String welcome) {
        Scanner scan = new Scanner(System.in);
        boolean inputError = true;
        int rezult = 0;
        while (inputError) {
            System.out.print(welcome);
            try {
                rezult = Integer.parseInt(scan.nextLine());
                inputError = false;
            } catch (NumberFormatException nfe) {
                System.out.println("error - try again:");
            }
        }
        return rezult;
    }
}
