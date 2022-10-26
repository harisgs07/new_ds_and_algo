import java.util.Scanner;

public class AVLTree {

    // Each Node Structure!!
    class Node {
        int data, height;
        Node left, right;

        Node(int data) {
            this.data = data;
            height = 1;
        }
    }

    // Checking height
    int height(Node N) {
        if (N == null)
            return 0;
        return N.height;
    }

    // function for returning height left - height right
    // for Checking whether the tree is balanced or not???
    // in general |heightL - heightR| < 2
    int balancedOrNot(Node N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    // rotating the tree to left
    Node leftRotate(Node x) {
        Node y = x.right;
        Node yLeft = y.left;

        y.left = x;
        x.right = yLeft;

        // Once rotated Need to find the height/set of new Nodes
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    Node rightRotate(Node x) {
        Node y = x.left;
        Node yRight = y.right;

        y.right = x;
        x.left = yRight;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // Insert the Node
    Node insertNode(Node root, int key) {
        if (root == null)
            return (new Node(key));
        if (key < root.data)
            root.left = insertNode(root.left, key);
        else if (key > root.data)
            root.right = insertNode(root.right, key);
        else
            return root;

        root.height = 1 + Math.max(height(root.left), height(root.right));

        int balance = balancedOrNot(root);

        if (balance > 1 && key < root.left.data)
            return rightRotate(root);
        if (balance < -1 && key > root.right.data)
            return leftRotate(root);
        if (balance > 1 && key > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if (balance < -1 && key < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    void printInOrder(Node root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        printInOrder(root.left);
        printInOrder(root.right);
    }

    Node createNode() {
        Scanner sc = new Scanner(System.in);
        System.out.println("initial Entry");
        int data = sc.nextInt();
        Node root = new Node(data);
        return root;
    }

    public static void main(String[] args) {
        AVLTree obj = new AVLTree();
        Scanner sc = new Scanner(System.in);
        Node root = obj.createNode();
        for (int i = 0; i < 8; i++)
            root = obj.insertNode(root, sc.nextInt());
        obj.printInOrder(root);
    }

}
