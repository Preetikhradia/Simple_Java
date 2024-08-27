import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactManager {
    private static ArrayList<String> contacts = new ArrayList<>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            loadContacts();
            while (true) {
                System.out.println("Contact Manager");
                System.out.println("1. Add Contact");
                System.out.println("2. Remove Contact");
                System.out.println("3. View Contacts");
                System.out.println("4. Save and Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter contact name: ");
                        String contact = scanner.nextLine();
                        contacts.add(contact);
                        break;
                    case 2:
                        System.out.print("Enter contact index to remove: ");
                        int index = scanner.nextInt();
                        if (index >= 0 && index < contacts.size()) {
                            contacts.remove(index);
                        } else {
                            System.out.println("Invalid index.");
                        }
                        break;
                    case 3:
                        System.out.println("Contacts:");
                        for (int i = 0; i < contacts.size(); i++) {
                            System.out.println(i + ": " + contacts.get(i));
                        }
                        break;
                    case 4:
                        saveContacts();
                        return;
                    default:
                        System.out.println("Invalid option.");
                }
            }
        }
    }

    private static void loadContacts() {
        try (BufferedReader br = new BufferedReader(new FileReader("contacts.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                contacts.add(line);
            }
        } catch (IOException e) {
            System.out.println("No previous contacts found.");
        }
    }

    private static void saveContacts() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("contacts.txt"))) {
            for (String contact : contacts) {
                bw.write(contact);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving contacts.");
        }
    }
}
