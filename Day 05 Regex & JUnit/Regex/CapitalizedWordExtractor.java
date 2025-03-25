import java.util.*;
import java.util.regex.*;

public class CapitalizedWordExtractor {

    public static List<String> extractCapitalizedWords(String text) {
        String regex = "\\b[A-Z][a-z]*\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        List<String> words = new ArrayList<>();
        while (matcher.find()) {
            words.add(matcher.group());
        }
        return words;
    }

    public static void main(String[] args) {
        String sentence = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";

        List<String> capitalizedWords = extractCapitalizedWords(sentence);

        System.out.println("Capitalized Words:");
        for (String word : capitalizedWords) {
            System.out.println(word);
        }
    }
}
