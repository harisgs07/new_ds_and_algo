import java.util.Scanner;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.TreeMap;

public class TreeToDLLNoSpace {
    class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    Node createNode() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number");
        int data = sc.nextInt();
        if (data == -1)
            return null;
        Node root = new Node(data);
        System.out.println("Enter the number left to" + root.data);
        root.left = createNode();
        System.out.println("Enter the number right to" + root.data);
        root.right = createNode();
        return root;
    }

    ArrayDeque<Node> stackDll = new ArrayDeque<>();

    Node head = null;

    void linkListDll(Node root) {
        if (stackDll.isEmpty()) {
            root.left = null;
            stackDll.push(root);
            head = root;

        } else {
            Node temp = stackDll.pop();
            root.left = temp;
            temp.right = root;
            stackDll.push(root);
        }
    }

    void inOrder() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.right;
        }
    }

    void inOrderDllTransfer(Node root) {
        if (root == null)
            return;

        inOrderDllTransfer(root.left);
        linkListDll(root);
        inOrderDllTransfer(root.right);
    }

    public static void main(String[] args) {
        TreeToDLLNoSpace obj = new TreeToDLLNoSpace();
        Node root = obj.createNode();
        obj.inOrderDllTransfer(root);
        obj.inOrder();
    }
}
