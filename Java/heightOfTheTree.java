import java.util.Scanner;
import java.lang.Math;

class Node {
    Node left, right;
    int data;

    public Node(int data) {
        this.data = data;
    }
}

public class heightOfTheTree {
    static int res = 0;
    static int sum = 0;

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

    static int height(Node root) {
        if (root == null)
            return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    static int maxElement(Node root) {
        if (root == null)
            return Integer.MIN_VALUE;
        return Math.max(root.data, Math.max(maxElement(root.left), maxElement(root.right)));
    }

    static int numberOfNodes(Node root) {
        if (root == null)
            return 0;
        return numberOfNodes(root.left) + numberOfNodes(root.right) + 1;
    }

    public static void main(String[] args) {
        heightOfTheTree obj = new heightOfTheTree();
        Node root = obj.createNode();
        System.out.println(obj.height(root));
        System.out.println(obj.maxElement(root));
        System.out.println(obj.numberOfNodes(root));

    }
}
