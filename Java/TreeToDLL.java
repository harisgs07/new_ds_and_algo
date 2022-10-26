import java.util.Scanner;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.TreeMap;

public class TreeToDLL {
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

    ArrayDeque<dll> levelTraverse = new ArrayDeque<>();
    TreeMap<Integer, Node> nodes = new TreeMap<>();

    class dll {
        dll prev, next;
        Node data;

        dll(Node data) {
            this.data = data;
        }
    }

    dll head = null;

    void print() {
        dll temp = head;
        while (temp != null) {
            System.out.print(temp.data.data + " ");
            temp = temp.next;
        }
    }

    void linkListDll(Node data) {
        dll newNode = new dll(data);
        dll temp = head;
        if (head == null) {
            head = newNode;
        } else {
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
        }
        newNode.next = null;
        newNode.prev = temp;
    }

    void inOrder(Node root) {
        if (root == null)
            return;

        inOrder(root.left);
        linkListDll(root);
        inOrder(root.right);
    }

    public static void main(String[] args) {
        TreeToDLL obj = new TreeToDLL();
        Node root = obj.createNode();
        obj.inOrder(root);
        obj.print();
    }
}
