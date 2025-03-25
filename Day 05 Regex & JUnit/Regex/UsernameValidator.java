import java.util.regex.*;

public class UsernameValidator {

    // Method to validate username
    public static boolean isValidUsername(String username) {
        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }

    public static void main(String[] args) {
        // Example test cases
        String[] usernames = {"user_123", "123user", "us", "user_name_1", "user@123", "u__1"};

        for (String username : usernames) {
            System.out.printf("Username: %-12s → %s%n", username, isValidUsername(username) ? "Valid ✅" : "Invalid ❌");
        }
    }
}
