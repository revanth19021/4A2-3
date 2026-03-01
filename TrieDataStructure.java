package q12051;
// package q12051;
import java.util.*;

public class TrieDataStructure {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();
        sc.nextLine(); // consume newline

        Set<String> words = new HashSet<>(); // store unique words

        while (Q-- > 0) {
            int command = sc.nextInt();
            String word = sc.next();
            sc.nextLine(); // consume newline if needed

            switch (command) {
                case 1: // Insert
                    if (words.add(word)) {
                        System.out.println("Inserted: " + word);
                    } else {
                        System.out.println(word + " already exists");
                    }
                    break;

                case 2: // Search
                    if (words.contains(word)) {
                        System.out.println("Found");
                    } else {
                        System.out.println("Not Found");
                    }
                    break;

                case 3: // Remove
                    if (words.remove(word)) {
                        System.out.println("Removed: " + word);
                    } else {
                        System.out.println("Word not found");
                    }
                    break;

                default:
                    System.out.println("Invalid operation");
            }
        }

        sc.close();
    }
}