import java.io.*;
public class ReadWriter{
    public static void main(String[] args) {
        String sourceLocation = "C:\\Users\\hp\\OneDrive\\Desktop\\All Folders\\Java Practise problems\\Week 4\\Day 03 - Java IO Streams\\Read.txt";
        String destLocation = "C:\\Users\\hp\\OneDrive\\Desktop\\All Folders\\Java Practise problems\\Week 4\\Day 03 - Java IO Streams\\Write.txt";
        File source = new File(sourceLocation);
        if(!source.exists()){
            System.out.println("The filepath \"" + sourceLocation + "\"does not exist");
            return;
        }
        try (
            BufferedReader reader = new BufferedReader(new FileReader(sourceLocation));
            BufferedWriter writer = new BufferedWriter(new FileWriter(destLocation));
        ){
            String line;
            while((line = reader.readLine()) != null){
                writer.write(line);
                writer.newLine();
            }
            System.out.println("File copied successfully from " + sourceLocation);
        } catch (Exception e) {
            System.out.println("An unexpected error occured." + e.getMessage());
        }
    }
}