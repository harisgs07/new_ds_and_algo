import java.util.Scanner;

class Node {
    Node left;
    Node right;
    int data;

    public Node(int data) {
        this.data = data;
    }
}

public class TreeStructure {

    static Node createNode() {

        Scanner obj = new Scanner(System.in);
        System.out.println("Enter data");
        int dataitem = obj.nextInt();
        if (dataitem == -1)
            return null;
        Node root = new Node(dataitem);

        System.out.println("Enter data left to " + root.data);
        root.left = createNode();
        System.out.println("Enter data right to " + root.data);
        root.right = createNode();
        return root;

    }

    static void inOrder(Node root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    static void preOrder(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    static void postOrder(Node root) {
        if (root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {

        Node root = createNode();
        inOrder(root);
        System.out.println();
        preOrder(root);
        System.out.println();
        postOrder(root);
    }
}