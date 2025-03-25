import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class WordCount {
    public static void main(String[] args) {
        String fileName = "textfile.txt";  // Replace with your text file path
        Map<String, Integer> wordCountMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int totalWords = 0;

            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");  // Split by whitespace
                totalWords += words.length;

                for (String word : words) {
                    word = word.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");  // Clean non-alphanumeric characters and convert to lowercase
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }

            // Display total words in the file
            System.out.println("Total words in the file: " + totalWords);

            // Sort the word count map by frequency (descending order)
            List<Entry<String, Integer>> sortedList = new ArrayList<>(wordCountMap.entrySet());
            sortedList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

            // Display the top 5 most frequent words
            System.out.println("\nTop 5 most frequent words:");
            for (int i = 0; i < Math.min(5, sortedList.size()); i++) {
                Entry<String, Integer> entry = sortedList.get(i);
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
