import java.util.Scanner;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.TreeMap;

public class VerticalOrderTraversal {
    class Node {
        Node left, right;
        Integer data;

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

    class verticalStore {
        ArrayList<Integer> store = new ArrayList<>();

        verticalStore(ArrayList<Integer> store) {
            for (int i : store)
                this.store.add(i);
        }
    }

    class Pair {
        int level;
        Node root;

        public Pair(int level, Node root) {
            this.root = root;
            this.level = level;
        }
    }

    ArrayDeque<Pair> levelOrder = new ArrayDeque<>();

    TreeMap<Integer, ArrayList<Integer>> dictVertical = new TreeMap<>();

    void verticalOrder(Node root, int level) {

        if (root == null)
            return;
        if (dictVertical.containsKey(level)) {
            dictVertical.get(level).add(root.data);
        } else {
            ArrayList<Integer> store = new ArrayList<>();
            store.add(root.data);
            dictVertical.put(level, store);
        }

        if (root.left != null)
            levelOrder.offer(new Pair(level - 1, root.left));
        if (root.right != null)
            levelOrder.offer(new Pair(level + 1, root.right));

        if (!levelOrder.isEmpty()) {
            Pair val = levelOrder.pollFirst();
            verticalOrder(val.root, val.level);
        }
    }

    void print() {
        for (ArrayList<Integer> i : dictVertical.values()){
            for (int j : i) { 
                System.out.print(j + " ");
            }
        }
    }

    public static void main(String[] args) {
        VerticalOrderTraversal obj = new VerticalOrderTraversal();
        Node root = obj.createNode();
        obj.verticalOrder(root, 0);
        obj.print();
    }
}
