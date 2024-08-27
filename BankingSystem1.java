import java.util.Scanner;

public class BankingSystem1 {
    private static double balance = 0.0;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Simple Banking System");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Check Balance");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter amount to deposit: ");
                        double deposit = scanner.nextDouble();
                        balance += deposit;
                        System.out.println("Deposited: " + deposit);
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double withdraw = scanner.nextDouble();
                        if (withdraw <= balance) {
                            balance -= withdraw;
                            System.out.println("Withdrawn: " + withdraw);
                        } else {
                            System.out.println("Insufficient balance.");
                        }
                        break;
                    case 3:
                        System.out.println("Current balance: " + balance);
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
