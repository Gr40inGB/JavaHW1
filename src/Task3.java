import java.util.List;
import java.util.stream.IntStream;

public class Task3 {
    public static void main(String[] args) {
        // Задача 3 //Вывести все простые числа от 1 до 1000 (числа, которые делятся только на 1 и на себя без остатка)
        System.out.println(allPrimeNumbers(1000));
    }

    public static List allPrimeNumbers(int number) {
        return IntStream.rangeClosed(1, number).filter(i -> isPrime(i)).boxed().toList();
    }

    public static boolean isPrime(int number) {
        return IntStream.range(2, number / 2).allMatch(i -> number % i != 0);
    }
}
