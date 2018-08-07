import java.io.IOException;
import java.nio.file.StandardOpenOption;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class AddContact extends Contacts {

    public static List<String> addAContact() {

       List<String> newContactList = new ArrayList<>();

        System.out.println("Enter new contact's name: ");
        sc.nextLine();

        String name = sc.nextLine();
        System.out.println("Enter new contact's number: ");
        String number = sc.nextLine();

        String newContact = name + " | " + number;
        newContactList.add(newContact);
        System.out.println(newContactList);
        try {
            Files.write(dataFile, newContactList, StandardOpenOption.APPEND);
        } catch (IOException e){
            e.printStackTrace();
        }
        return newContactList;
    }

}