//4.1.6
// package q11967;

import java.util.*;

class Node {
    int data;
    Node left, right;
    Node(int d) { data = d; }
}

public class Mirror {

    // Build tree from level order input
    static Node buildTree(int[] arr,int i){
		if(i>=arr.length || arr[i]==-1) return null;
		Node root=new Node(arr[i]);
		root.left=buildTree(arr, 2*i+1);
		root.right=buildTree(arr, 2*i+2);
		return root;
	}
    // Check if two trees are mirror images
    static boolean isMirror(Node a, Node b) {

    if (a == null && b == null) return true;
    if (a == null || b == null) return false;

    Queue<Node> q = new LinkedList<>();
    q.add(a);
    q.add(b);
    while (!q.isEmpty()) {
        Node n1 = q.poll();
        Node n2 = q.poll();
        if (n1 == null && n2 == null)
			continue;
        if (n1 == null || n2 == null)
            return false;

        if (n1.data != n2.data)
            return false;
        q.add(n1.left);
        q.add(n2.right);

        q.add(n1.right);
        q.add(n2.left);
    }

    return true;
}


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) arr1[i] = sc.nextInt();

        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) arr2[i] = sc.nextInt();

        Node root1 = buildTree(arr1,0);
        Node root2 = buildTree(arr2,0);

        System.out.println(isMirror(root1, root2) ? "YES" : "NO");

        sc.close();
    }
}
