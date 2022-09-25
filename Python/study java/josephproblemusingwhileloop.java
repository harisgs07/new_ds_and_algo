
public class josephproblemusingwhileloop {
    public static void main(String[] args) {
        int totalmebers = 8;
        int interval = 3;
        System.out.println(josph(totalmebers, interval));

    }

    static int josph(int tm, int i) {

        // T(complety) O(n)
        // S(Complexty) O(n) since its a recursion
        // if(tm == 1){
        // return 1;
        // }
        // return (josph(tm-1,i)+i-1)%tm+1;

        // T(complety) O(n)
        // S(Complexty) O(1) since its a recursion
        int sum = 0;
        for (int j = 2; j <= tm; j++) {
            sum = (sum + i) % j;
        }
        return sum + 1;

    }
}
