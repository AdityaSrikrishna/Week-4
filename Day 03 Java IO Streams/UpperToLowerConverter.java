import java.io.*;

public class UpperToLowerConverter {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        // Set encoding explicitly to handle character encoding issues
        try (
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(inputFile), "UTF-8")
            );
            BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8")
            )
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());  // Convert line to lowercase
                writer.newLine();                  // Preserve line breaks
            }

            System.out.println("Contents of '" + inputFile + "' have been written to '" + outputFile + "' in lowercase.");

        } catch (IOException e) {
            System.out.println("File processing error: " + e.getMessage());
        }
    }
}
