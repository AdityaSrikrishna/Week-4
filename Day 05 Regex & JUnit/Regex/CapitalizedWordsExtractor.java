import java.util.*;
import java.util.regex.*;

public class CapitalizedWordsExtractor {

    public static List<String> extractCapitalizedWords(String text) {
        String regex = "\\b[A-Z][a-zA-Z]*\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        List<String> capitalizedWords = new ArrayList<>();
        while (matcher.find()) {
            capitalizedWords.add(matcher.group());
        }
        return capitalizedWords;
    }

    public static void main(String[] args) {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";

        List<String> words = extractCapitalizedWords(text);

        System.out.println("Extracted Capitalized Words:");
        for (String word : words) {
            System.out.println(word);
        }
    }
}
