import java.util.Scanner;

public class Calculator1 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Simple Calculator");
            System.out.println("Enter first number:");
            double num1 = scanner.nextDouble();
            System.out.println("Enter operator (+, -, *, /):");
            char operator = scanner.next().charAt(0);
            System.out.println("Enter second number:");
            double num2 = scanner.nextDouble();

            double result;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        System.out.println("Error: Division by zero.");
                        return;
                    }
                    break;
                default:
                    System.out.println("Error: Invalid operator.");
                    return;
            }

            System.out.println("Result: " + result);
        }
    }
}
