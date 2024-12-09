
import java.util.Scanner;

class Test_task {
    public static String calc(String input) {
        String[] parts = input.split(" ");

        // Проверка на правильное количество элементов
        if (parts.length != 3) {
            throw new IllegalArgumentException("Input must contain two numbers and one operator.");
        }

        int a = Integer.parseInt(parts[0]);
        String operator = parts[1];
        int b = Integer.parseInt(parts[2]);

        // Проверка диапазона чисел
        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new IllegalArgumentException("Numbers must be between 1 and 10.");
        }

        int result;

        // Выполнение арифметической операции
        switch (operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("Division by zero is not allowed.");
                }
                result = a / b;
                break;
            default:
                throw new IllegalArgumentException("Invalid operator. Use +, -, * or /.");
        }

        return String.valueOf(result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение (например, 1 + 2):");

        String input = scanner.nextLine();

        try {
            String output = calc(input);
            System.out.println(output);
        } catch (Exception e) {
            System.out.println("throws Exception // " + e.getMessage());
        }

        scanner.close();
    }
}