import java.util.Stack;

public class EvaluationOfPrefix {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        String exp = "-+7*45+20";

        for(int i=exp.length()-1;i>=0;i--){
            char ch = exp.charAt(i);

            if(ch >= 48 && ch <= 57){
                stack.push((int)ch-48);
            }
            else if(ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^' || ch == '$'){
                int op1 = stack.pop();
                int op2 = stack.pop();
                stack.push(performOperation(op1,op2,ch));
            }
        }

        System.out.println("Answer will be : "+stack.peek());
    }

    static int performOperation(int op1,int op2,char ch){
        switch(ch){
            case '+':
            return op1+op2;
            case '-':
            return op1-op2;
            case '*':
            return op1*op2;
            case '/':
            return op1/op2;
            case '^':
            case '$':
            return (int)Math.pow(op1,op2);
            default:
            return -1;
        }
    }
}