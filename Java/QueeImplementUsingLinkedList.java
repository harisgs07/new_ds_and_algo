public class QueeImplementUsingLinkedList {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node head = null;
    Node tail = null;
    int size = 0;

    void addElementQuee(int elem) {
        Node newNode = new Node(elem);
        if (head == null)
            head = newNode;
        else
            tail.next = newNode;
        tail = newNode;
        tail.next = null;
        size++;
    }

    void removeElement() {
        if (head == null)
            System.out.println("No element");
        else
            head = head.next;
        size--;
    }

    void peek() {
        if (head == null)
            System.out.println("Not Possible");
        else
            System.out.println(head.data);
    }

    void sizeCheck() {
        System.out.println(size);
    }

    public static void main(String[] args) {
        QueeImplementUsingLinkedList obj = new QueeImplementUsingLinkedList();
        obj.removeElement();
        obj.addElementQuee(10);
        obj.addElementQuee(8);
        obj.peek();
        obj.removeElement();
        obj.peek();
    }
}
