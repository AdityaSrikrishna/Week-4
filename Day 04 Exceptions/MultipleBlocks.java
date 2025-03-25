import java.util.Scanner;
public class MultipleBlocks{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = null;
        try {
            System.out.print("Enter size of array: ");
            int size = scanner.nextInt();
            arr = new int[size];
            for(int i=0; i<size; i++){
                arr[i] = scanner.nextInt();
            }
            System.out.print("Enter index: ");
            int index = scanner.nextInt();
            System.out.println("The value at " + index + " is: " + arr[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Index is out of bounds.");
        }catch (NullPointerException e){
            System.out.println("Error: Array has not been initialized.");
        }catch(Exception e){
            System.out.println("Error: Invalid input.");
        }finally{
            scanner.close();
            System.out.println("The program has ended.");
        }
    }
}