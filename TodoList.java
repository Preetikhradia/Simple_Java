import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {
    private static ArrayList<String> tasks = new ArrayList<>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("To-Do List Application");
                System.out.println("1. Add Task");
                System.out.println("2. Remove Task");
                System.out.println("3. View Tasks");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter task: ");
                        String task = scanner.nextLine();
                        tasks.add(task);
                        break;
                    case 2:
                        System.out.print("Enter task index to remove: ");
                        int index = scanner.nextInt();
                        if (index >= 0 && index < tasks.size()) {
                            tasks.remove(index);
                        } else {
                            System.out.println("Invalid index.");
                        }
                        break;
                    case 3:
                        System.out.println("Tasks:");
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println(i + ": " + tasks.get(i));
                        }
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
