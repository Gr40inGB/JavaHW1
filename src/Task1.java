import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        int num = inputNumber("Please input number: ");
        //        Вычислить n-ое треугольного число (сумма чисел от 1 до n)
        System.out.println(triangleNumber(num));      // Задача 1
    }

    public static int triangleNumber(int number) {
        return (number * (number + 1)) / 2;
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