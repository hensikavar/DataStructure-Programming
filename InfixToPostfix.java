import java.util.Stack;

public class InfixToPostfix {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        String exp = "(A+B^C^D)*(E+F/D)";
        //ABCD^^+EFD/+*
        String ans = "";

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                ans = ans + ch;
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    ans = ans + stack.pop();
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
                    ans = ans + stack.pop();
                }
                stack.push(ch);
            }

        }

        while (!stack.isEmpty()) {
            ans = ans + stack.pop();
        }
        System.out.println("Postfix Expression : " + ans);
    }

    static int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
            default:
                return -1;
        }
    }
}