import java.util.Scanner;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.TreeMap;

public class BottomViewOfTreeByUtube {
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

    ArrayDeque<Pair> levelTraverse = new ArrayDeque<>();
    TreeMap<Integer, Node> nodes = new TreeMap<>();

    class Pair {
        int pos;
        Node root;

        Pair(int pos, Node root) {
            this.pos = pos;
            this.root = root;
        }
    }

    void print() {
        for (int i : nodes.keySet()) {
            System.out.print(nodes.get(i).data + " ");
        }
    }

    void bottomViewDict(Node root, int traverseIndex) {
        if (root == null)
            return;
        nodes.put(traverseIndex, root);
        if (root.left != null)
            levelTraverse.offer(new Pair(traverseIndex - 1, root.left));
        if (root.right != null)
            levelTraverse.offer(new Pair(traverseIndex + 1, root.right));
        if (!levelTraverse.isEmpty()) {
            Pair val = levelTraverse.poll();
            bottomViewDict(val.root, val.pos);
        } else
            print();
    }

    public static void main(String[] args) {
        BottomViewOfTreeByUtube obj = new BottomViewOfTreeByUtube();
        Node root = obj.createNode();
        obj.bottomViewDict(root, 0);
    }
}
