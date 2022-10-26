
import java.util.ArrayDeque;
import java.util.Deque;

public class flattenTheMultilevelLinkedListNoSpace {

    class Node {
        Node next;
        Node down;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    Deque<Node> downQueue = new ArrayDeque<>();

    Node head = null;

    void addElement(int data) {
        Node newNode = new Node(data);
        Node temp = head;
        if (head == null)
            head = newNode;
        else {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        newNode.down = null;
        newNode.next = null;
    }

    void addElement(int data, int position) {
        Node newNode1 = new Node(data);
        Node temp = head;

        while (temp != null) {
            if (temp.data == position) {
                temp.down = newNode1;
                newNode1.next = null;
                newNode1.down = null;
                break;
            }
            temp = temp.next;
        }
    }

    void flattenList(Node temp) {
        if (head == null)
            System.out.println("Null");
        else {
            while (temp != null) {
                if (temp.down != null)
                    downQueue.offer(temp.down);
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            if (!downQueue.isEmpty())
                flattenList(downQueue.poll());
            return;
        }
    }

    public static void main(String[] args) {
        flattenTheMultilevelLinkedListNoSpace obj = new flattenTheMultilevelLinkedListNoSpace();
        obj.addElement(1);
        obj.addElement(2);
        obj.addElement(3);
        obj.addElement(4);
        obj.addElement(5);
        obj.addElement(6);
        obj.addElement(7, 3);
        obj.flattenList(obj.head);
    }

}
