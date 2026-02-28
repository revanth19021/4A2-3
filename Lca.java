// 4.1.5
// package q11943;

import java.util.*;

class Node {
    int data;
    Node left, right;
    Node(int d) { data = d; }
}

public class Lca {

    // Build tree using level order
    static Node buildTree(int[] arr,int i) {
        if (i>=arr.length || arr[0] == -1) return null;

        Node root = new Node(arr[i]);
		root.left=buildTree(arr,2*i+1);
		root.right=buildTree(arr,2*i+2);
        
        return root;
    }

    // LCA logic
    static Node lca(Node root, int x, int y) {
        if (root == null) return null;
        if (root.data == x || root.data == y) return root;

        Node left = lca(root.left, x, y);
        Node right = lca(root.right, x, y);

        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        int x = sc.nextInt();
        int y = sc.nextInt();

        Node root = buildTree(arr,0);
        Node ans = lca(root, x, y);

        if (ans != null)
            System.out.println("LCA: " + ans.data);

        sc.close();
    }
}
