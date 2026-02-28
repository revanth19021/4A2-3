
//4.2.2

// package q11803;

import java.util.*;

class Node {
    int data;
    Node left, right;
    Node(int d) { data = d; }
}

public class ValidateBST {

    // Build tree using level order
    static Node buildTree(int[] arr,int i){
		if(i>=arr.length || arr[i]==-1) return null;
		Node root=new Node(arr[i]);
		root.left=buildTree(arr, 2*i+1);
		root.right=buildTree(arr, 2*i+2);
		return root;
	}

    // Check BST using inorder traversal
	static boolean isBST(Node root){
		Stack<Node> st=new Stack<>();
		Integer prev=null;

		while(root!=null || !st.isEmpty()){
			while(root!=null){
				st.push(root);
				root=root.left;
			}
			root=st.pop();
			if(prev!=null && root.data<=prev) return false;
			prev=root.data;
			root=root.right;
		}
		return true;
	}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.println(isBST(buildTree(arr,0)) ? 1 : 0);
    }
}
