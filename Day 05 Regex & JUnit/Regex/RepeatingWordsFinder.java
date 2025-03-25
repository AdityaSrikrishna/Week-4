import java.util.*;
import java.util.regex.*;

public class RepeatingWordsFinder {

    public static Set<String> findRepeatingWords(String text) {
        Set<String> repeatingWords = new HashSet<>();
        String regex = "\\b(\\w+)\\b(?=.*\\b\\1\\b)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            repeatingWords.add(matcher.group(1));
        }
        return repeatingWords;
    }

    public static void main(String[] args) {
        String sentence = "This is is a repeated repeated word test.";

        Set<String> repeatingWords = findRepeatingWords(sentence);

        System.out.println("Repeating Words:");
        for (String word : repeatingWords) {
            System.out.println(word);
        }
    }
}
