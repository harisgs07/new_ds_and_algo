import java.util.Stack;

public class QueeImplementUsingStack {
    Stack<Integer> insertStack = new Stack<>();
    Stack<Integer> deleteStack = new Stack<>();

    void enqueue(int data) {
        insertStack.push(data);
    }

    void dequeue() {
        if(insertStack.isEmpty()){
            System.out.println("Its Empty Nothing to delete");
            return;
        }
        while (!insertStack.isEmpty()) 
            deleteStack.push(insertStack.pop());
        System.out.println(deleteStack.pop());
        while (!deleteStack.isEmpty()){ 
            insertStack.push(deleteStack.pop());
        }
    }

    public static void main(String[] args) {

        QueeImplementUsingStack obj = new QueeImplementUsingStack();
        obj.enqueue(10);
        obj.enqueue(20);
        obj.enqueue(30);
        obj.dequeue();
        obj.dequeue();
    }

}
