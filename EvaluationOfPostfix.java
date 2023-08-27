import java.util.Stack;

public class EvaluationOfPostfix {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        //(a+b^c^d)*(e+f/d)
        //ABC^D^+EFD/+*
        //a=2,b=3,c=4,d=5,e=6,f=7
        String exp = "2345^^+675/+*";

        for(int i=0;i<exp.length();i++){
            char ch = exp.charAt(i);

            if(ch >= 48 && ch <= 57){
                stack.push((int)ch - 48);
            }
            else if(ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^' || ch == '&'){
                int opr1 = stack.pop();
                int opr2 = stack.pop();
                stack.push(performOperation(opr2,opr1,ch));
            }
        }

        System.out.println(stack.peek());
    }

    static int performOperation(int opr2,int opr1, char op){
        switch (op) {
            case '+':
                return opr2+opr1;
            case '-':
                return opr2-opr1;
            case '*':
                return opr2*opr1;
            case '/':
                return opr2/opr1;
            case '^':
            case '$':
                return (int)(Math.pow(opr2, opr1));
            default:
                return 0;
        }
    }
}