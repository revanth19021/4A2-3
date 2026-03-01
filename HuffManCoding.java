//package q12052;
//6.1.4
import java.util.*;

public class HuffManCoding {

    static class Node {
        int val;
        Node left, right;

        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public ArrayList<String> huffmanCodes(String S, int f[], int N) {
        // Min-heap based on frequency
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) ->
            (a.val != b.val) ? a.val - b.val : 1
        );

        // Create leaf nodes for all frequencies
        for (int v : f) {
            pq.add(new Node(v, null, null));
        }

        // Construct Huffman Tree
        while (pq.size() > 1) {
            Node n1 = pq.poll();
            Node n2 = pq.poll();
            pq.add(new Node(n1.val + n2.val, n1, n2));
        }

        // Preorder traversal to collect Huffman codes
        ArrayList<String> result = new ArrayList<>();
        traverse(pq.poll(), "", result);
        return result;
    }

    private void traverse(Node node, String code, ArrayList<String> codes) {
        if (node.left == null && node.right == null) {
            codes.add(code);
            return;
        }
        traverse(node.left, code + "0", codes);
        traverse(node.right, code + "1", codes);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input N
        int N = sc.nextInt();
        sc.nextLine(); // Consume newline

       
        String S = sc.nextLine();

        // Input frequencies
        int[] f = new int[N];
        
        for (int i = 0; i < N; i++) {
            f[i] = sc.nextInt();
        }

        // Generate Huffman Codes
      CTJ12052 sol = new CTJ12052();
        ArrayList<String> codes = sol.huffmanCodes(S, f, N);

        for (String s : codes) System.out.print(s + " ");
        sc.close();
    }
}