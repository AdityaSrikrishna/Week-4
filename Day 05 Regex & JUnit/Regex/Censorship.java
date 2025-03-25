import java.util.regex.*;

public class Censorship {

    public static String censorBadWords(String input, String[] badWords) {
        for (String word : badWords) {
            // Build regex to match whole word (case-insensitive)
            String regex = "\\b" + Pattern.quote(word) + "\\b";
            input = input.replaceAll("(?i)" + regex, "****");
        }
        return input;
    }

    public static void main(String[] args) {
        String sentence = "This is a damn bad example with some stupid words.";
        String[] badWords = {"damn", "stupid"};

        String censored = censorBadWords(sentence, badWords);

        System.out.println("Original: " + sentence);
        System.out.println("Censored: " + censored);
    }
}
