import java.util.Scanner;

public class UnitConverter1 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Unit Converter");
            System.out.println("1. Convert meters to feet");
            System.out.println("2. Convert feet to meters");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            System.out.print("Enter value to convert: ");
            double value = scanner.nextDouble();
            double result;

            switch (choice) {
                case 1:
                    result = value * 3.28084;
                    System.out.println(value + " meters is " + result + " feet.");
                    break;
                case 2:
                    result = value / 3.28084;
                    System.out.println(value + " feet is " + result + " meters.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
