public class LinkedListCration {

    class Node {
        int data;
        Node next;

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

    // Insert after particular element
    void insertValue(int value, int aftr) {
        Node newnode = new Node(value);
        Node temp = head;
        Node newtemp;
        if (head == null)
            System.out.println("No Elements");
        else {
            while (temp != null) {
                if (temp.data == aftr) {
                    newtemp = temp.next;
                    temp.next = newnode;
                    newnode.next = newtemp;
                }
                temp = temp.next;
            }
        }
    }

    // delete from particular position
    void deleteElemnt(int pos) {
        int count = 0;
        int check = 0;
        Node temp = head;
        Node newtemp = null;
        if (pos - 1 == 0)
            head = head.next;
        else {
            while (temp != null) {
                if (count == pos - 1) {
                    check = 1;
                    newtemp.next = temp.next;
                    break;
                }
                newtemp = temp;
                temp = temp.next;
                count += 1;
            }
        }
        if (check != 1)
            System.out.println("given position is not in the range");
    }

    public static void main(String[] args) {
        LinkedListCration obj = new LinkedListCration();
        obj.addElemnt(10);
        obj.addElemnt(20);
        obj.insertValue(15, 20);
        obj.insertValue(89, 15);
        obj.deleteElemnt(2);
        obj.print();
    }
}
