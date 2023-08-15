import java.util.Stack;

public class RecognizeAlgo{
    public static void main(String[] args) {
        Stack<Character> st = new Stack<>();
        String str = "abcba";
        char ch = str.charAt(0);
        int index = 0;

        if(ch == 'c' || str.length()%2 == 0){
            System.out.println("Invalid String");
            return;
        }
        
        else{
            while(ch != 'c'){
                if(ch == ' '){
                    System.out.println("Invalid String.");
                    return;
                }
                else{
                    st.push(ch);
                    index++;
                    ch = str.charAt(index);
                }
            }

            index++;

            while(!st.isEmpty()){
                ch = str.charAt(index);
                char x = st.pop();
                if(ch != x){
                    System.out.println("Invalid String");
                    return;
                }
                index++;
            }

            if(str.length() == index){
                System.out.println("Valid String");
            }
            else{
                System.out.println("Invalid String");
            }
        }
    }
}