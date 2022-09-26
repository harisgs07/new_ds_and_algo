import java.util.Stack;

public class previousSmallerElements {
    Stack<Integer> smallelement = new Stack<>();

    void lookForSmaller(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                smallelement.push(arr[i]);
                System.out.print("-1 ");
            } else {
                if (smallelement.peek() < arr[i]) {
                    System.out.print(smallelement.peek() + " ");
                    smallelement.push(arr[i]);
                } else {
                    while (smallelement.peek() >= arr[i]) {
                        smallelement.pop();
                        if (smallelement.size() == 0)
                            break;
                    }
                    if (smallelement.size() != 0)
                        System.out.print(smallelement.peek() + " ");
                    else
                        System.out.print("-1 ");
                    smallelement.push(arr[i]);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 4, 10, 5, 18, 3, 12,7 };
        previousSmallerElements obj = new previousSmallerElements();
        obj.lookForSmaller(arr);
    }
}
