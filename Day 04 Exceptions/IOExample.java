import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class IOExample{
    public static void main(String[] args) {
        String file = "C:\\Users\\hp\\OneDrive\\Desktop\\All Folders\\Java Practise problems\\Week 4\\Day 04 Exceptions\\Ants.txt";
        try (
            BufferedReader br = new BufferedReader(new FileReader(file));
         ){
            String line;
            while((line = br.readLine())!=null){
                System.out.println(line);
            }
         }catch (IOException e) {
            System.out.println("An IO error has occured: " + e.getMessage());
        }
    }
}