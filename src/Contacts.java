import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class Contacts {

    public static String directory = "data";
    public static String filename = "contacts.txt";
    public static Path dataDirectory = Paths.get(directory);
    public static Path dataFile = Paths.get(directory, filename);

}