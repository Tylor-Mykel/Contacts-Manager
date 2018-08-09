import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@SuppressWarnings("all")
public class ListAllContacts extends ContactVariables implements Contacts {

    static List<String> listContacts(){

        try {
            contacts = Files.readAllLines(dataFile);
            for (String contact : contacts) {
                System.out.println(contact);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("----------------------------------");
        System.out.println();
        return contacts;
    }
}