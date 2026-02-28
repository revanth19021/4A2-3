//4.2.1

// package q11804;
import java.util.*;

class Node
{
    int data;
    Node left, right;
    Node(int value)
    {
        data = value;
        left = right = null;
    }
}
public class Buildbst {
    static Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (key < root.data) {
            root.left = insert(root.left, key);
        } else if (key > root.data) {
            root.right = insert(root.right, key);
        }
        return root;
    }

    static void preorder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        Node root = null;
        for (int i = 0; i < n; i++)
        {
            int value = sc.nextInt();
            root = insert(root, value);
        }
        preorder(root);
    }
}
