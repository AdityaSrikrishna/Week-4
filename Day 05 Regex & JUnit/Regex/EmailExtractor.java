import java.util.*;
import java.util.regex.*;

public class EmailExtractor {

    public static List<String> extractEmails(String text) {
        String regex = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        List<String> emails = new ArrayList<>();
        while (matcher.find()) {
            emails.add(matcher.group());
        }
        return emails;
    }

    public static void main(String[] args) {
        String sampleText = "Contact us at support@example.com and info@company.org for assistance. You can also reach john.doe123@edu.school.net.";

        List<String> emails = extractEmails(sampleText);

        System.out.println("Extracted Emails:");
        for (String email : emails) {
            System.out.println(email);
        }
    }
}
