import java.util.*;
import java.util.regex.*;

public class URLExtractor {

    public static List<String> extractLinks(String text) {
        String regex = "https?://[\\w.-]+(?:\\.[\\w.-]+)+[/\\w._%&=?#-]*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        List<String> links = new ArrayList<>();
        while (matcher.find()) {
            links.add(matcher.group());
        }
        return links;
    }

    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for more info.";

        List<String> links = extractLinks(text);

        System.out.println("Extracted Links:");
        for (String link : links) {
            System.out.println(link);
        }
    }
}
