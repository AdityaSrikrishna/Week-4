import java.io.*;

public class BufferedReaderWriter {
    public static void main(String[] args) {
        // Change these file paths as needed
        String sourceFilePath = "source.txt";
        String destinationFilePath = "destination.txt";

        File sourceFile = new File(sourceFilePath);

        if (!sourceFile.exists()) {
            System.out.println("Error: Source file '" + sourceFilePath + "' does not exist.");
            return;
        }

        try (
            BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFilePath))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine(); // To preserve line breaks
            }
            System.out.println("File has been copied successfully to '" + destinationFilePath + "'");
        } catch (IOException e) {
            System.out.println("An error occurred during file operations: " + e.getMessage());
        }
    }
}
