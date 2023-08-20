import java.util.Stack;

public class InfixToPrefix {

    static int precedence(char ch){
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
            case '$':
                return 3;
            default:
                return -1;
        }
    }
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
    String exp = "(a+b^c^d)*(e+f/d)";
        String ans = "";

        //Reversing the expression
        String revExp = "";
        for(int i=exp.length()-1;i>=0;i--){
            if(exp.charAt(i) == '('){
                revExp += ')';
            }
            else if(exp.charAt(i) == ')'){
                revExp += '(';
            }
            else{
                revExp += exp.charAt(i);
            }
        }

        for(int i=0;i<revExp.length();i++){
            char ch = revExp.charAt(i);

            if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <='Z')){
                ans += ch;
            }
            else if(ch == '('){
                stack.push(ch);
            }
            else if(ch == ')'){
                while(!stack.isEmpty() && stack.peek() != '('){
                    ans += stack.pop();
                }
                stack.pop();
            }
            else if(ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^' || ch =='$'){
                while(!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)){
                    ans += stack.pop();
                }
                stack.push(ch);
            }
        }

        while(!stack.isEmpty()){
            ans += stack.pop();
        }

        StringBuffer sb2 = new StringBuffer(ans);
        sb2.reverse();
        String finalAns = sb2.toString();

        System.out.println("Prefix Expression : "+finalAns);
    }
}