public class queueImplementUsingArray {
    int[] a;
    int rear;
    int front = 0;
    int result;

    queueImplementUsingArray(int capacity) {
        a = new int[capacity];
        rear = -1;
    }

    void enqueue(int element) {
        if (rear == a.length - 1) {
            System.out.println("Full Queue");
            return;
        }
        rear++;
        a[rear] = element;
    }

    void dequeue() {
        if (rear == -1){
            System.out.println("No Elements Found");
        }
        result = a[front];
        System.out.println(result);
        for (int i = 0; i <= a.length - 2; i++) {
            a[i] = a[i + 1];
        }
        rear--;
    }

    public static void main(String[] args) {
        queueImplementUsingArray obj = new queueImplementUsingArray(4);
        obj.enqueue(10);
        obj.enqueue(13);
        obj.enqueue(15);
        obj.enqueue(13);
        obj.enqueue(13);
        obj.dequeue();

    }

}