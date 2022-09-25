public class ReversedLinkedList {
    class Node {
        int data;
        Node next;

        Node(int value) {
            this.data = value;
        }
    }

    Node head = null;

    void addElement(int value) {
        Node newNode = new Node(value);
        Node temp = head;
        if (head == null)
            head = newNode;
        else {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        newNode.next = null;
    }

    void reverseList() {
        Node temp = head;
        Node prev = null;
        Node cur = null;
        while (temp != null) {
            cur = temp;
            temp = temp.next;
            cur.next = prev;
            prev = cur;
        }
        head = cur;
    }

    void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        ReversedLinkedList obj = new ReversedLinkedList();
        obj.addElement(10);
        obj.addElement(20);
        obj.print();
        obj.reverseList();
        System.out.println();
        obj.print();
        obj.addElement(100);
        obj.addElement(200);
        System.out.println();
        obj.print();
        obj.reverseList();
        System.out.println();
        obj.print();
    }
}
