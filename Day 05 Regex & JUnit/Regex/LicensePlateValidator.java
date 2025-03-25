import java.util.regex.*;

public class LicensePlateValidator {

    public static boolean isValidPlate(String plate) {
        String regex = "^[A-Z]{2}[0-9]{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(plate);
        return matcher.matches();
    }

    public static void main(String[] args) {
        // Test cases
        String[] plates = {"AB1234", "A12345", "ab1234", "XY5678", "XYZ123"};

        for (String plate : plates) {
            System.out.printf("Plate: %-8s → %s%n", plate, isValidPlate(plate) ? "Valid ✅" : "Invalid ❌");
        }
    }
}
