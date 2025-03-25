import java.util.*;
import java.util.regex.*;

public class CurrencyExtractor {

    public static List<String> extractCurrencies(String text) {
        String regex = "\\$?\\d+(?:\\.\\d{2})?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        List<String> currencies = new ArrayList<>();
        while (matcher.find()) {
            currencies.add(matcher.group());
        }
        return currencies;
    }

    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is 10.50.";

        List<String> currencies = extractCurrencies(text);

        System.out.println("Extracted Currency Values:");
        for (String currency : currencies) {
            System.out.println(currency);
        }
    }
}
