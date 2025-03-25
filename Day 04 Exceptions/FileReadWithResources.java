import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReadWithResources {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\hp\\OneDrive\\Desktop\\All Folders\\Java Practise problems\\Week 4\\Day 04 Exceptions\\Ants.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String firstLine = reader.readLine();

            if (firstLine != null) {
                System.out.println("First line of the file:");
                System.out.println(firstLine);
            } else {
                System.out.println("The file is empty.");
            }

        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}
