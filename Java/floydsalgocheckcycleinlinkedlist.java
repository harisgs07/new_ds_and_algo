public class floydsalgocheckcycleinlinkedlist {
    class Node {
        int data;
        Node next;

        Node(int value) {
            this.data = value;
        }
    }

    Node head = null;

    Node search(int value) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == value)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    void addElem(int value) {
        Node temp = head;
        Node returnvalue = search(value);
        if (returnvalue != null) {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = returnvalue;
        } else {
            Node newnode = new Node(value);
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
    }

    Node detectCycle() {
        Node slow = head;
        Node fast = head;
        Node check = null;
        while (fast != null) {
            slow = slow.next;
            check = fast.next;
            if (check == null)
                break;
            fast = fast.next.next;
            if (fast == slow) {
                System.out.println("Detect the cycle in the Linked List");
                return slow;
            }
        }
        return null;
    }

    Node detectIntersection(Node cyclereturn) {
        Node start = head;
        Node breakcycle = null;
        while (cyclereturn != start) {
            breakcycle = cyclereturn;
            cyclereturn = cyclereturn.next;
            start = start.next;
        }
        System.out.println("at " + start.data);
        return breakcycle;
    }

    void makeNullLast(Node makenull) {
        makenull.next = null;
    }

    void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        floydsalgocheckcycleinlinkedlist obj = new floydsalgocheckcycleinlinkedlist();
        obj.addElem(10);
        obj.addElem(20);
        obj.addElem(30);
        obj.addElem(40);
        obj.addElem(45);
        obj.addElem(48);
        obj.addElem(50);
        obj.addElem(60);
        obj.addElem(70);
        obj.addElem(80);
        obj.addElem(30);
        Node a = obj.detectCycle();
        Node brk = obj.detectIntersection(a);
        System.out.println("Break the Cycle");
        obj.makeNullLast(brk);
        System.out.println("printing");
        obj.print();
    }
}