public class queueUsingCircularArray {
    int rear;
    int[] a;
    int front;

    queueUsingCircularArray(int capacity) {
        a = new int[capacity];
        rear = -1;
        front = -1;
    }

    boolean isFull() {
        if ((rear + 1) % a.length == front)
            return true;
        return false;
    }

    boolean isEmpty() {
        if (rear == front)
            return true;
        return false;
    }

    void enqueue(int data) {
        if (isFull()) {
            System.out.println("Full queue");
            return;
        }
        rear = (rear + 1) % a.length;
        a[rear] = data;
    }

    void dequeue() {
        if (isEmpty()) {
            System.out.println("Empty queue");
            return;
        }
        front = (front + 1) % a.length;
        System.out.println(a[front]);
    }

    public static void main(String[] args) {
        queueUsingCircularArray obj = new queueUsingCircularArray(4);
        obj.enqueue(10);
        obj.enqueue(153);
        obj.enqueue(15);
        obj.enqueue(13);
        obj.dequeue();
        obj.dequeue();
        obj.enqueue(1);
        
    }
}
