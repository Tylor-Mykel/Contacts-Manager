import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;

public class ContactsMain extends Contacts {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

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

        contactsMenu();

    }

    public static void contactsMenu() {

        System.out.println("1: View contacts");
        System.out.println("2: Add a new contact");
        System.out.println("3: Search a contact by name");
        System.out.println("4: Delete an existing contact");
        System.out.println("5: Exit");
        System.out.println("Enter an option (1, 2, 3, 4, 5): ");

        String input = sc.next();

        try {
            switch (input) {
                case "1":
                    System.out.println("#  Name | Phone Number");
                    System.out.println("----------------------");
                    ListAllContacts.listContacts();
                    break;
                case "2":
//                    AddContact();
                    break;
                case "3":
                    System.out.println("Name | Phone Number");
                    System.out.println("-------------------");
//                    SearchForContact();
                    break;
                case "4":
//                    DeleteContact();
                    break;
                case "5":
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