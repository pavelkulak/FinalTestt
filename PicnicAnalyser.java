import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PicnicAnalyzer {
    
    public static int countWords(String fileName) {
        int wordCount = 0;
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNext()) {
                scanner.next();
                wordCount++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return wordCount;
    }

    
    public static String findLongestWord(String fileName) {
        String longestWord = "";
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNext()) {
                String word = scanner.next();
                if (word.length() > longestWord.length()) {
                    longestWord = word;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return longestWord;
    }

    
    public static Map<String, Integer> calculateWordFrequency(String fileName) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNext()) {
                String word = scanner.next();
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return wordFrequency;
    }

    public static void main(String[] args) {
        String fileName = "input.txt";

        
        int wordCount = countWords(fileName);
        System.out.println("Количество слов в файле: " + wordCount);

        
        String longestWord = findLongestWord(fileName);
        System.out.println("Самое длинное слово в файле: " + longestWord);

        
        Map<String, Integer> wordFrequency = calculateWordFrequency(fileName);
        System.out.println("Частота слов в файле:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
