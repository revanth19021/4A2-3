package q12108;

import java.util.*;

class Node {
	int data;
	Node left, right;
	Node(int d) { data = d; }
}

public class Leftview {

    static Node buildTree(int[] arr) {
        if (arr.length == 0 || arr[0] == -1) return null;
		Node root = new Node(arr[0]);
		Queue<Node> q = new ArrayDeque<>();
		q.add(root);
		int i = 1;
		while (i < arr.length) {
			Node cur = q.poll();
			if (i < arr.length && arr[i] != -1) {
				cur.left = new Node(arr[i]);
				q.add(cur.left);
			}
			i++;
			if (i < arr.length && arr[i] != -1) {
				cur.right = new Node(arr[i]);
				q.add(cur.right);
			}
			i++;
		}
		return root;
	}
	static void leftView(Node root) {
	    if (root == null) return;
		Queue<Node> q = new ArrayDeque<>();
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node n = q.poll();
	            if (i == 0) {
	                System.out.print(n.data + " ");
	            }

	            if (n.left != null) q.add(n.left);
	            if (n.right != null) q.add(n.right);
	        }
    }
}



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        leftView(buildTree(arr));
    }
}
