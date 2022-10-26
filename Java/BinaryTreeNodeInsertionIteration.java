import java.util.Scanner;

public class BinaryTreeNodeInsertionIteration {
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

    Node prevParent = null;

    void print(Node root) {
        if (root == null)
            return;
        print(root.left);
        System.out.print(root.data + " ");
        print(root.right);
    }

    Node insertNode(Node root, int key) {
        Node newNode = new Node(key);
        while (root != null) {
            prevParent = root;
            if (root.data > key)
                root = root.left;
            else if (root.data < key)
                root = root.right;
        }
        if (prevParent.data > key)
            prevParent.left = newNode;
        else
            prevParent.right = newNode;
        return root;
    }

    public static void main(String[] args) {
        BinaryTreeNodeInsertionIteration obj = new BinaryTreeNodeInsertionIteration();
        Node root = obj.createNode();
        obj.print(obj.insertNode(root, 9));
    }
}
