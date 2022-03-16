import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        HashMap<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            String lowercased = word.toLowerCase(Locale.ROOT);
            if (wordCount.containsKey(lowercased)) {
                wordCount.put(lowercased, wordCount.get(lowercased) + 1);
            } else {
                wordCount.put(lowercased, 1);
            }
        }

        for (Map.Entry wordCountEntry : wordCount.entrySet()) {
            System.out.printf("%s %d\n", wordCountEntry.getKey(), wordCountEntry.getValue());
        }
    }
}