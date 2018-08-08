import java.io.IOException;
import java.nio.file.Files;

public class ContactsMain extends ContactVariables implements Contacts {

    public static void main(String[] args) {

        makeDirectoryAndFile();
        contactsMenu();

    }

    public static void makeDirectoryAndFile() {

        if (Files.notExists(dataDirectory)) {
            try {
                Files.createDirectories(dataDirectory);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (Files.notExists(dataFile)) {
            try {
                Files.createFile(dataFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void contactsMenu() {

        System.out.println("1: View contacts");
        System.out.println("2: Add a new contact");
        System.out.println("3: Search a contact by name");
        System.out.println("4: Delete an existing contact");
        System.out.println("5: Exit");
        System.out.println("Enter an option (1, 2, 3, 4, 5): ");

        String input = sc.next();
        sc.nextLine();

        try {
            switch (input) {
                case "1":
                    System.out.println("----------------------------------");
                    System.out.println("| Name            | Phone Number |");
                    System.out.println("----------------------------------");
                    ListAllContacts.listContacts();
                    contactsMenu();
                    break;
                case "2":
                    AddContact.addAContact();
                    contactsMenu();
                    break;
                case "3":
                    SearchForContact.searchForAContact();
                    contactsMenu();
                    break;
                case "4":
                    DeleteContact.deleteAContact();
                    contactsMenu();
                    break;
                case "5":
                    System.out.println("Have a good day! Goodbye");
                    break;
                default:
                    System.out.println("Invalid option, try again");
                    contactsMenu();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}