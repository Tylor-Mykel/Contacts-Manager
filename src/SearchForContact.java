import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("all")
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
        String[] numbers = searchNumber.split("");

        List<String> numberConvert = new ArrayList<>(Arrays.asList(numbers));

        if (numberConvert.size() == 10 || numberConvert.size() == 7 ) {

            if (numberConvert.size() == 10) {
                numberConvert.add(3, "-");
                numberConvert.add(7, "-");
                StringBuilder numberToConvert = new StringBuilder();

                for (String number : numberConvert) {
                    numberToConvert.append(number);
                }

                searchNumber = numberToConvert.toString();
                showContact = String.format("| %-15s | %-10s |", searchName, searchNumber);

            } else if (numberConvert.size() == 7) {
                numberConvert.add(3, "-");
                StringBuilder numberToConvert = new StringBuilder();

                for (String number : numberConvert) {
                    numberToConvert.append(number);
                }

                searchNumber = numberToConvert.toString();
                showContact = String.format("| %-15s | %-10s   |", searchName, searchNumber);
            }

            for (String contact : contacts) {
                if (contact.equals(showContact)) {
                    searchedContactList.add(contact);
                    break;
                } else if (!contacts.contains(showContact)) {
                    System.out.println("That contact doesn't exist, try another name and number");
                    searchForAContact();
                }
            }

            System.out.println("----------------------------------");
            System.out.println("| Name            | Phone Number |");
            System.out.println("----------------------------------");

            for (String contact : searchedContactList) {
                System.out.println(contact);
            }

            System.out.println("----------------------------------");
            System.out.println();
        } else {
            System.out.println("Invalid number length. Re-enter contact information.");
            searchForAContact();
        }
        return searchedContactList;
    }
}