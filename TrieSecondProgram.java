//package q12053;

//6.1.2

import java.util.*;

public class TrieSecondProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        Set<String> substrings = new HashSet<>();
        int n = s.length();

        substrings.add(""); // add empty substring

        // Generate all substrings
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < n; j++) {
                sb.append(s.charAt(j));
                substrings.add(sb.toString());
            }
        }

        // Convert to list and sort for consistent output
        List<String> result = new ArrayList<>(substrings);
        Collections.sort(result);

        // Print results
        System.out.println("Total distinct substrings: " + result.size());
        System.out.println("Distinct Substrings:");
        for (String str : result) {
            if (str.isEmpty())
                System.out.println("[]");
            else
                System.out.println(str);
        }

        sc.close();
    }
}