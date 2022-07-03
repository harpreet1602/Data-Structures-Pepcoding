import java.util.LinkedList;

public class reversePolishNotation {
    
    // 150. Evaluate Reverse Polish Notation
//     tc O(n) sc O(n)
//  If token is any operand then pop two elements from the stack and then do the operation "num1 operand num2" and push it into the stack
//  If it is a number so directly push it into the stack
//     Remember that Integer.parseInt() will convert the string to the integer.
    
public int evalRPN(String[] tokens) {
    int n = tokens.length;
    LinkedList<Integer> st = new LinkedList<>();
    for(String token:tokens){
        if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
            int num2 = st.removeFirst();
            int num1 = st.removeFirst();
            if(token.equals("+")){
                st.addFirst(num1+num2);
            }
            else if(token.equals("-")){
                st.addFirst(num1-num2);
            }
            else if(token.equals("*")){
                st.addFirst(num1*num2);
            }
            else if(token.equals("/")){
                st.addFirst(num1/num2);
            }
        }
        else{
            st.addFirst(Integer.parseInt(token));
        }
    }
    return st.removeFirst();
}
}
