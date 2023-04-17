import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        //        Вычислить  n! (произведение чисел от 1 до n)
        int num = inputNumber("Please input number: ");
        System.out.println(factorial(num));           // Задача 2
    }

    public static int factorial(int number) {

        if (number == 2) return 2;
        return number * factorial(number - 1);
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
