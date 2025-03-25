import java.util.regex.*;

public class HexColorValidator {

    public static boolean isValidHexColor(String color) {
        String regex = "^#[0-9a-fA-F]{6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(color);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String[] colors = {"#FFA500", "#ff4500", "#123", "#ABCDEF", "#GHIJKL", "#1234567"};

        for (String color : colors) {
            System.out.printf("Color: %-10s → %s%n", color, isValidHexColor(color) ? "Valid ✅" : "Invalid ❌");
        }
    }
}
