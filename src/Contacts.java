import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public abstract class Contacts {
    static Scanner sc = new Scanner(System.in);

    public static List<String> contacts = null;

    public static String directory = "data";
    public static String filename = "contacts.txt";
    public static Path dataDirectory = Paths.get(directory);
    public static Path dataFile = Paths.get(directory, filename);

}