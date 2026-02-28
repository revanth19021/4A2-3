//6.1.1

import java.util.*;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord;

    TrieNode() {
        isEndOfWord = false;
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
    }
}

public class TrieDataStructure {
    static TrieNode root = new TrieNode();

    // Insert a word into the Trie
    static void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
        System.out.println("Inserted: " + word);
    }

    // Search for a word in the Trie
    static boolean search(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null)
                return false;
            current = current.children[index];
        }
        return current.isEndOfWord;
    }

    // Helper method to check if node has any children
    static boolean isEmpty(TrieNode node) {
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null)
                return false;
        }
        return true;
    }

    // Remove a word from the Trie
    static TrieNode remove(TrieNode node, String word, int depth) {
        if (node == null)
            return null;

        if (depth == word.length()) {
            if (node.isEndOfWord)
                node.isEndOfWord = false;

            if (isEmpty(node))
                node = null;

            return node;
        }

        int index = word.charAt(depth) - 'a';
        node.children[index] = remove(node.children[index], word, depth + 1);

        if (isEmpty(node) && !node.isEndOfWord)
            node = null;

        return node;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();

        while (Q-- > 0) {
            int command = sc.nextInt();
            String word = sc.next();

            switch (command) {
                case 1:
                    insert(word);
                    break;
                case 2:
                    if (search(word))
                        System.out.println("Found");
                    else
                        System.out.println("Not Found");
                    break;
                case 3:
                    if (search(word)) {
                        remove(root, word, 0);
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
