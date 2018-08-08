import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class SearchForContact extends ContactVariables implements Contacts {

    public static List<String> searchForAContact() {

        try {
            contacts = Files.readAllLines(dataFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> searchedContactList = new ArrayList<>();

        System.out.println("Enter the name of the person you want to search for: ");
        String searchName = sc.nextLine();

        System.out.println("Enter the number of the person you want to search for: ");
        String searchNumber = sc.nextLine();
        String searchedContact = String.format("| %-15s |  %-10s |",searchName, searchNumber);

        for (String contact : contacts) {
            if (contact.equals(searchedContact)) {
                searchedContactList.add(contact);
                break;
            } else if (!contacts.contains(searchedContact)) {
                System.out.println("That contact doesn't exist, try another name and number");
                searchForAContact();
            }
        }

        System.out.println("Name | Phone Number");
        System.out.println("-------------------");

        for (String contact : searchedContactList) {
            System.out.println(contact);
        }

        System.out.println();
        return searchedContactList;
    }
}