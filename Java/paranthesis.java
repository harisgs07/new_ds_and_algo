import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class paranthesis {

    Deque<Character> openbrackets = new ArrayDeque<>();

    boolean isMatching(char a, char b) {
        return (a == '{' && b == '}') || (a == '[' && b == ']') || (a == '(' && b == ')');
    }

    boolean isOpening(char i) {
        return i == '{' || i == '[' || i == '(';
    }

    boolean checkChar(char i) {
        return i == '{' || i == '[' || i == '(' || i == '}' || i == ']' || i == ')';
    }

    boolean checkParan(String paran) {
        for (int i = 0; i < paran.length(); i++) {
            if (checkChar(paran.charAt(i))) {
                if (isOpening(paran.charAt(i)))
                    openbrackets.push(paran.charAt(i));
                else {
                    if (!openbrackets.isEmpty()) {
                        if (isMatching(openbrackets.peek(), paran.charAt(i)))
                            openbrackets.pop();
                        else
                            return false;
                    } else
                        return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String paran = "()({{@}}'['])";
        paranthesis obj = new paranthesis();
        if (obj.checkParan(paran))
            System.out.println("No missing paranthesis");
        else
            System.out.println("Missing paranthesis");
    }
}
