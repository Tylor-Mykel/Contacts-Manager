import java.io.IOException;
import java.nio.file.StandardOpenOption;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class AddContact extends ContactVariables implements Contacts {

    public static List<String> addAContact() {

       List<String> newContactList = new ArrayList<>();

        System.out.println("Enter new contact's name: ");
        String nameToAdd = sc.nextLine();

        System.out.println("Enter new contact's number: ");
        String numberToAdd = sc.nextLine();

        String newContact = String.format("| %-15s |  %-10s  |",nameToAdd, numberToAdd);
        newContactList.add(newContact);

        try {
            Files.write(dataFile, newContactList, StandardOpenOption.APPEND);
            System.out.println(nameToAdd + " was added");
            System.out.println();
        } catch (IOException e){
            e.printStackTrace();
        }

        return newContactList;
    }
}