import java.nio.file.Path;
import java.nio.file.Paths;

public interface Contacts {

    String directory = "data";
    String filename = "contacts.txt";
    Path dataDirectory = Paths.get(directory);
    Path dataFile = Paths.get(directory, filename);

}