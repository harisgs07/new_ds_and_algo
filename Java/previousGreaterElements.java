import java.util.Stack;

public class previousGreaterElements {

    Stack<Integer> greaterelement = new Stack<>();

    void lookForGreater(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            while (greaterelement.size() != 0) {
                if (greaterelement.peek() > arr[i]) {
                    System.out.print(greaterelement.peek() + " ");
                    break;
                } else if (greaterelement.peek() <= arr[i])
                    greaterelement.pop();
            }
            if (greaterelement.size() == 0)
                System.out.print("-1 ");
            greaterelement.push(arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 4, 10, 5, 8, 20, 15, 3, 12 };
        previousGreaterElements obj = new previousGreaterElements();
        obj.lookForGreater(arr);
    }
}
