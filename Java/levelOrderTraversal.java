import java.util.ArrayDeque;
import java.util.Scanner;
import java.lang.Math;

class Node {
    Node left, right;
    int data;

    public Node(int data) {
        this.data = data;
    }
}

public class levelOrderTraversal {

    static Node createNode() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the data");
        int elm = sc.nextInt();
        if (elm == -1)
            return null;
        Node root = new Node(elm);
        System.out.println("Left number enter " + root.data);
        root.left = createNode();
        System.out.println("Right number enter " + root.data);
        root.right = createNode();
        return root;

    }

    static ArrayDeque<Node> levelelm = new ArrayDeque<>();

    static void levelOrder(Node root) {
        if (root == null && levelelm.isEmpty())
            return;
        if (root == null) {
            levelelm.offer(root);
            levelOrder(levelelm.poll());
        }
        System.out.print(root.data + " ");
        if (root.left != null)
            levelelm.offer(root.left);
        if (root.right != null)
            levelelm.offer(root.right);
        levelOrder(levelelm.pollFirst());
    }

    public static void main(String[] args) {
        levelOrderTraversal obj = new levelOrderTraversal();
        Node root = obj.createNode();
        obj.levelOrder(root);

    }

}
