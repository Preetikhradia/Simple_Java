import java.util.ArrayList;
import java.util.Scanner;

public class expensestracker {
    private static ArrayList<Double> expenses = new ArrayList<>();
    private static double totalExpense = 0;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Expense Tracker");
                System.out.println("1. Add Expense");
                System.out.println("2. View Expenses");
                System.out.println("3. View Total Expense");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter expense amount: ");
                        double amount = scanner.nextDouble();
                        expenses.add(amount);
                        totalExpense += amount;
                        System.out.println("Expense added.");
                        break;
                    case 2:
                        System.out.println("Expenses:");
                        for (double expense : expenses) {
                            System.out.println(expense);
                        }
                        break;
                    case 3:
                        System.out.println("Total expense: " + totalExpense);
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Invalid option.");
                }
            }
        }
    }
}
