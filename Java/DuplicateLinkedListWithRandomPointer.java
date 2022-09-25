public class DuplicateLinkedListWithRandomPointer {
    class Node {
        int data;
        Node next;
        Node random;
        Node(int val) {
            this.data = val;
        }
    }

    Node head = null;

    // add each element
    void addElemnt(int value) {
        Node newnode = new Node(value);
        Node temp = head;
        if (head == null)
            head = newnode;
        else {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newnode;
        }
        newnode.next = null;
    }

    void print() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        DuplicateLinkedListWithRandomPointer obj = new DuplicateLinkedListWithRandomPointer();
        obj.addElemnt(10);
        obj.addElemnt(20);
        obj.addElemnt(30);
        obj.addElemnt(40);
        obj.print();
    }
}
