import java.util.*;
import java.util.regex.*;

public class ProgrammingLanguageExtractor {

    public static List<String> extractLanguages(String text) {
        String[] languages = { "JavaScript", "Python", "Java", "Go", "C", "C++", "C#", "Ruby", "Rust", "Swift", "Kotlin", "TypeScript" };
        String regex = "\\b(" + String.join("|", languages) + ")\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        List<String> foundLanguages = new ArrayList<>();
        while (matcher.find()) {
            foundLanguages.add(matcher.group());
        }
        return foundLanguages;
    }

    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";

        List<String> langs = extractLanguages(text);
        System.out.println("Extracted Programming Languages:");
        for (String lang : langs) {
            System.out.println(lang);
        }
    }
}