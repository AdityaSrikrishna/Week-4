import java.util.InputMismatchException;
import java.util.Scanner;
public class NumberExceptions{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter Numerator: ");
            int num = scanner.nextInt();
            System.out.println("Enter Denominator: ");
            int den = scanner.nextInt();
            int result = num + den;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Denominator should not be 0.");
        } catch (InputMismatchException e) {
            System.out.println("Error: Enter valid numbers.");
        }finally{
            scanner.close();
            System.out.println("Program has ended.");
        }
    }
}