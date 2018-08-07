import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ListAllContacts extends Contacts {

    public static List<String> listContacts(){

        try {
            contacts = Files.readAllLines(dataFile);
//            for (String contact : contacts) {
//                System.out.println(contact);
//            }
            for (int i = 0; i < contacts.size(); i += 1) {
                System.out.println((i + 1) + ": " + contacts.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contacts;
    }

}