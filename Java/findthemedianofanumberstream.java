import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class findthemedianofanumberstream {

    PriorityQueue<Double> fmax = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Double> fmin = new PriorityQueue<>();

    void insElement(double elm) {
        if (fmax.isEmpty() || fmax.peek() >= elm)
            fmax.offer(elm);
        else
            fmin.offer(elm);

        if (fmax.size() < fmin.size())
            fmax.offer(fmin.poll());
        else if (fmax.size() > (fmin.size() + 1))
            fmin.offer(fmax.poll());
    }

    double findMedian() {
        if (fmax.size() == fmin.size())
            return fmax.peek() / 2 + fmin.peek() / 2;
        else
            return fmax.peek();
    }

    public static void main(String[] args) {
        findthemedianofanumberstream obj = new findthemedianofanumberstream();
        obj.insElement(2);
        obj.insElement(5);
        obj.insElement(7);
        obj.insElement(4);
        System.out.println(obj.findMedian());
    }
}
