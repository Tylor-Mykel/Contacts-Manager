import java.io.IOException;
import java.nio.file.StandardOpenOption;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class DeleteContact extends Contacts {

    public static List<String> deleteAContact() {

        try {
            contacts = Files.readAllLines(dataFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> updatedContactList = new ArrayList<>();
        System.out.println("Enter the contact's name to delete: ");
        sc.nextLine();

        String name = sc.nextLine();
        System.out.println("Enter the contact's number to delete: ");
        String number = sc.nextLine();
        String targetToDelete = name + " | " + number;

        for (String contact : contacts) {
            if (contact.equals(targetToDelete)) {

            } else {
                updatedContactList.add(contact);
            }

        }

        try {
            Files.write(dataFile, updatedContactList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return updatedContactList;
    }

}