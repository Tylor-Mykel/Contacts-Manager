import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeleteContact extends ContactVariables implements Contacts {

    public static List<String> deleteAContact() {

        try {
            contacts = Files.readAllLines(dataFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> updatedContactList = new ArrayList<>();

        System.out.println("Enter the contact's name to delete: ");
        String nameToDelete = sc.nextLine();

        System.out.println("Enter the contact's number to delete: ");
        String numberToDelete = sc.nextLine();
        String[] num = numberToDelete.split("");

        List<String> numberConvert = new ArrayList<>(Arrays.asList(num));

        if (numberConvert.size() == 10 || numberConvert.size() == 7 ) {

            if (numberConvert.size() == 10) {
                numberConvert.add(3, "-");
                numberConvert.add(7, "-");
                StringBuilder numberToConvert = new StringBuilder();

                for (String number : numberConvert) {
                    numberToConvert.append(number);
                }

                numberToDelete = numberToConvert.toString();
                targetToDelete = String.format("| %-15s | %-10s |", nameToDelete, numberToDelete);

            } else if (numberConvert.size() == 7) {
                numberConvert.add(3, "-");
                StringBuilder numberToConvert = new StringBuilder();

                for (String number : numberConvert) {
                    numberToConvert.append(number);
                }

                nameToDelete = numberToConvert.toString();
                targetToDelete = String.format("| %-15s | %-10s   |", nameToDelete, numberToDelete);
            }

            if (!contacts.contains(targetToDelete)) {
                System.out.println("That contact doesn't exist, try another name and number");
                deleteAContact();
            } else {
                for (String contact : contacts) {
                    if (contact.equals(targetToDelete)) {

                    } else {
                        updatedContactList.add(contact);
                    }
                }

                try {
                    Files.write(dataFile, updatedContactList);
                    System.out.println(nameToDelete + " was removed");
                    System.out.println();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }  else {
            System.out.println("Invalid number length. Re-enter contact information.");
            deleteAContact();
        }

        return updatedContactList;
    }
}