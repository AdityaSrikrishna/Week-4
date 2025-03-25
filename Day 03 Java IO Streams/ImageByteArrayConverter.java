import java.io.*;
import java.nio.file.Files;

public class ImageByteArrayConverter {
    public static void main(String[] args) {
        String inputImagePath = "input.jpg";     // Original image
        String outputImagePath = "output.jpg";   // Copied image

        try {
            // Step 1: Read image file into byte array
            byte[] imageBytes = Files.readAllBytes(new File(inputImagePath).toPath());

            // Step 2: Use ByteArrayInputStream to simulate input stream from byte array
            ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);

            // Step 3: Read from ByteArrayInputStream and write to ByteArrayOutputStream
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int data;
            while ((data = bais.read()) != -1) {
                baos.write(data);
            }

            // Step 4: Write the byte array back to a new image file
            FileOutputStream fos = new FileOutputStream(outputImagePath);
            fos.write(baos.toByteArray());

            // Close all streams
            bais.close();
            baos.close();
            fos.close();

            System.out.println("Image has been copied from '" + inputImagePath + "' to '" + outputImagePath + "'.");

        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }
    }
}
