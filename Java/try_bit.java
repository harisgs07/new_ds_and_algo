//finding the i th bit
public class try_bit {
    public static void main(String[] args) {
        int a = 4;
        // mentioning the which bit to find starting from 0. her its 2nd bit which means
        // '1' (i) then performe
        // single shift
        int i = 1;
        // (1 << i) creating mask for the bit we finding bying shifting to that bit
        int b = a & (1 << i);
        // performe AND operation with the number and mask and right shift the value as
        // much u left shifted here i is the value
        // if out put is one its is one
        if (b >> i == 1)
            System.out.println("one");
        else
            System.out.println("Zero");
    }

}
