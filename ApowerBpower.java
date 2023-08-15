import java.util.Stack;

public class ApowerBpower {
    public static void main(String[] args) {
        Stack<Character> st = new Stack<>();
        String str = "aabbaabb";
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a') {
                st.push(ch);
            } else if (ch == 'b') {
                count++;
            } else {
                System.out.println("Invalid String");
                return;
            }
        }
        if (st.size() == count) {
            System.out.println("Valid String");
        }
        else{
            System.out.println("Invalid String");
        }
    }
}