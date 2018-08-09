import java.io.IOException;
import java.nio.file.StandardOpenOption;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("all")
public class AddContact extends ContactVariables implements Contacts {

    public static List<String> addAContact() {

        List<String> newContactList = new ArrayList<>();

        System.out.println("Enter new contact's name: ");
        String nameToAdd = sc.nextLine();

        System.out.println("Enter new contact's number: ");
        String numberToAdd = sc.nextLine();
        String[] nums = numberToAdd.split("");

        List<String> numberFormat = new ArrayList<>(Arrays.asList(nums));

        if (numberFormat.size() == 10 || numberFormat.size() == 7 ){

            if (numberFormat.size() == 10) {
                numberFormat.add(3, "-");
                numberFormat.add(7, "-");
                StringBuilder numberToFormat = new StringBuilder();

                for (String number : numberFormat) {
                    numberToFormat.append(number);
                }

                numberToAdd = numberToFormat.toString();
                newContact = String.format("| %-15s | %-10s |", nameToAdd, numberToAdd);

            } else if (numberFormat.size() == 7) {
                numberFormat.add(3, "-");
                StringBuilder numberToFormat = new StringBuilder();

                for (String number : numberFormat) {
                    numberToFormat.append(number);
                }

                numberToAdd = numberToFormat.toString();
                newContact = String.format("| %-15s | %-10s   |", nameToAdd, numberToAdd);
            }

            newContactList.add(newContact);

            try {
                Files.write(dataFile, newContactList, StandardOpenOption.APPEND);
                System.out.println(nameToAdd + " was added");
                System.out.println();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid number length. Re-enter contact information.");
            addAContact();
        }

        return newContactList;
    }
}