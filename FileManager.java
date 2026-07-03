import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * A simple FileManager class with basic file operation methods.
 * Used for the CrossPlatformLab multi-OS testing exercise.
 */
public class FileManager {

    /** Create a file and write the given text to it. */
    public void writeFile(String fileName, String content) throws IOException {
        Files.write(Paths.get(fileName), content.getBytes());
        System.out.println("Wrote file: " + fileName);
    }

    /** Read and return the contents of a file. */
    public String readFile(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    /** Check whether a file exists. */
    public boolean fileExists(String fileName) {
        return Files.exists(Paths.get(fileName));
    }

    /** Delete a file if it exists. */
    public void deleteFile(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        if (Files.exists(path)) {
            Files.delete(path);
            System.out.println("Deleted file: " + fileName);
        }
    }

    public static void main(String[] args) throws IOException {
        FileManager fm = new FileManager();
        fm.writeFile("sample.txt", "Hello from FileManager by Sunny Dagar");
        System.out.println("Contents: " + fm.readFile("sample.txt"));
        System.out.println("Exists: " + fm.fileExists("sample.txt"));
        fm.deleteFile("sample.txt");
    }
}
