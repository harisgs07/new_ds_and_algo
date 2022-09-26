public class stackImplementationLinkedList {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node top = null;

    void push(int element) {
        Node newNode = new Node(element);
        newNode.next = top;
        top = newNode;
    }

    void pop() {
        if (top == null)
            System.out.println("No data Found No pop Function");
        else {
            System.out.println(top.data);
            top = top.next;
        }

    }

    void peek() {
        if (top == null)
            System.out.println("No data Found");
        else
            System.out.println(top.data);
    }

    public static void main(String[] args) {
        stackImplementationLinkedList obj = new stackImplementationLinkedList();
        obj.pop();
        obj.push(10);
        obj.push(8);
        obj.peek();
        obj.pop();
        obj.peek();
    }
}
