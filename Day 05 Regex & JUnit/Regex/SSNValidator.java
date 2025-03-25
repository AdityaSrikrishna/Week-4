import java.util.regex.*;

public class SSNValidator {

    public static boolean isValidSSN(String ssn) {
        String regex = "\\d{3}-\\d{2}-\\d{4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ssn);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String[] testSSNs = {
            "123-45-6789",  // Valid ✅
            "123456789",    // Invalid ❌ (missing hyphens)
            "123-45-678",   // Invalid ❌ (too short)
            "12-345-6789"   // Invalid ❌ (incorrect hyphen placement)
        };

        for (String ssn : testSSNs) {
            if (isValidSSN(ssn)) {
                System.out.printf("\"%s\" is valid ✅%n", ssn);
            } else {
                System.out.printf("\"%s\" is invalid ❌%n", ssn);
            }
        }
    }
}
