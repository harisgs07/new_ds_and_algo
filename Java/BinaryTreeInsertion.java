import java.util.Scanner;

public class BinaryTreeInsertion {
    class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    Node createNode() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value ");
        int element = sc.nextInt();
        if (element == -1)
            return null;
        Node root = new Node(element);
        System.out.println("Enter value to the left of " + root.data);
        root.left = createNode();
        System.out.println("Enter value to the right of " + root.data);
        root.right = createNode();
        return root;
    }

    Node prev = null;

    void print(Node root) {
        if (root == null)
            return;
        print(root.left);
        System.out.print(root.data + " ");
        print(root.right);
    }

    Node insertNode(Node root, int element) {
        if (root == null) {
            Node newNode = new Node(element);
            return newNode;
        }

        if (root.data > element)
            root.left = insertNode(root.left, element);
        else
            root.right = insertNode(root.right, element);
        return root;
    }

    public static void main(String[] args) {
        BinaryTreeInsertion obj = new BinaryTreeInsertion();
        Node root = obj.createNode();
        obj.insertNode(root, 18);
        obj.print(root);
    }

}
