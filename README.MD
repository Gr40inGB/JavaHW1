```java
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
```

```java
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

```
```java
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

```
```java
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

```

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//* Задано уравнение вида q + w = e, q, w, e >= 0.
// Некоторые цифры могут быть заменены знаком вопроса,
// например, 2? + ?5 = 69. Требуется восстановить выражение до верного равенства.
// Предложить хотя бы одно решение или сообщить, что его нет.
public class Task5 {
    public static void main(String[] args) {

        List listOk = new ArrayList();
        String expression = (inputNumberWithQuestionMark("Введите Q состоящее из цифр (0-9) или знаков вопроса(?): ") +
                "+" +
                inputNumberWithQuestionMark("Введите W состоящее из цифр (0-9) или знаков вопроса(?): ") +
                "=" +
                inputNumberWithQuestionMark("Введите E состоящее из цифр (0-9) или знаков вопроса(?): "));
        Combinations(expression, listOk);

        if (listOk.isEmpty()) {
            System.out.print("Не удалось восстаовить уравнение до верного");
        } else {
            System.out.println("Вот все возможные выражения: ");
            for (Object o : listOk) {
                System.out.println(o);
            }
        }
    }

    public static boolean eval(String s) {
        int q = Integer.parseInt(s.substring(0, s.indexOf("+")));
        int w = Integer.parseInt(s.substring(s.indexOf("+") + 1, s.indexOf("=")));
        int e = Integer.parseInt(s.substring(s.indexOf("=") + 1));
        return q + w == e;
    }

    public static void Combinations(String s, List l) {
        if (s.contains("?")) {
            for (int j = 0; j < 10; j++) {
                Combinations(s.replaceFirst("\\?", String.valueOf(j)), l);
            }
        } else {
            if (eval(s)) {
                l.add(s);
            }
        }
    }

    public static String inputNumberWithQuestionMark(String welcome) {

        String regex = "^[1-9?]?[0-9?]+";
        Scanner scan = new Scanner(System.in);
        boolean inputError = true;
        String res = " ";
        while (inputError) {
            System.out.print(welcome);
            res = scan.nextLine();
            if (res.matches(regex)) inputError = false;
            else System.out.println("Не должно начинаться с нуля и не должно содержать " +
                    "других символов кроме цифр и знаков вопроса");
        }
        return res;
    }
}
```