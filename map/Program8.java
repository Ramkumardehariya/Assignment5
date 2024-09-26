import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Program8 {
    // TreeMap to store the contacts, where the key is the contact name, and the value is the phone number.
    private TreeMap<String, String> contacts;

    // Constructor to initialize the phone book.
    public Program8() {
        contacts = new TreeMap<>();
    }

    // Method to add a contact.
    public void addContact(String name, String phoneNumber) {
        contacts.put(name, phoneNumber);
        System.out.println("Contact added: " + name + " -> " + phoneNumber);
    }

    // Method to remove a contact.
    public void removeContact(String name) {
        if (contacts.containsKey(name)) {
            contacts.remove(name);
            System.out.println("Contact removed: " + name);
        } else {
            System.out.println("Contact not found: " + name);
        }
    }

    // Method to search for a contact by name.
    public void searchContact(String name) {
        if (contacts.containsKey(name)) {
            System.out.println("Found contact: " + name + " -> " + contacts.get(name));
        } else {
            System.out.println("Contact not found: " + name);
        }
    }

    // Method to display all contacts in sorted order.
    public void displayAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Phone book is empty.");
        } else {
            System.out.println("All contacts:");
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }
    }

    // Main method to run the phone book.
    public static void main(String[] args) {
        Program8 phoneBook = new Program8();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nPhone Book Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Remove Contact");
            System.out.println("3. Search Contact");
            System.out.println("4. Display All Contacts");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String nameToAdd = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    phoneBook.addContact(nameToAdd, phoneNumber);
                    break;

                case 2:
                    System.out.print("Enter name to remove: ");
                    String nameToRemove = scanner.nextLine();
                    phoneBook.removeContact(nameToRemove);
                    break;

                case 3:
                    System.out.print("Enter name to search: ");
                    String nameToSearch = scanner.nextLine();
                    phoneBook.searchContact(nameToSearch);
                    break;

                case 4:
                    phoneBook.displayAllContacts();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
