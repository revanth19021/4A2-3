// 4.2.3


import java.util.*;

class Node {
    int data;
    Node left, right;
    Node(int d) { data = d; }
}

public class BoundaryTraversal {

    static Node buildTree(int[] a) {
        Node root = new Node(a[0]);
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        for (int i = 1; i < a.length; ) {
            Node cur = q.poll();

            if (i < a.length && a[i] != -1)
                q.add(cur.left = new Node(a[i]));
            i++;

            if (i < a.length && a[i] != -1)
                q.add(cur.right = new Node(a[i]));
            i++;
        }
        return root;
    }

    static void addLeaves(Node root, List<Integer> res) {
    if (root == null) return;

    if (root.left == null && root.right == null) {
        res.add(root.data);
        return;
    }

    addLeaves(root.left, res);
    addLeaves(root.right, res);
}

static List<Integer> boundary(Node root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) return res;

    res.add(root.data);

    // Left boundary
    Node cur = root.left;
    while (cur != null) {
        if (!(cur.left == null && cur.right == null))
            res.add(cur.data);
        cur = (cur.left != null) ? cur.left : cur.right;
    }

    // Leaves (exclude root)
    addLeaves(root.left, res);
    addLeaves(root.right, res);

    // Right boundary (reverse)
    Stack<Integer> stack = new Stack<>();
    cur = root.right;
    while (cur != null) {
        if (!(cur.left == null && cur.right == null))
            stack.push(cur.data);
        cur = (cur.right != null) ? cur.right : cur.left;
    }

    while (!stack.isEmpty())
        res.add(stack.pop());

    return res;
}

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) a[i] = sc.nextInt();

    List<Integer> res = boundary(buildTree(a));
    for (int x : res) System.out.print(x + " ");
}

}
