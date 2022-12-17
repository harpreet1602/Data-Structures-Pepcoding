public class reversePostfix {
    
    // 150. Evaluate Reverse Polish Notation
//     tc O(n) sc O(n)
//  If token is any operand then pop two elements from the stack and then do the operation "num1 operand num2" and push it into the stack
//  If it is a number so directly push it into the stack
//     Remember that Integer.parseInt() will convert the string to the integer.
public int evalRPN(String[] tokens) {
    LinkedList<Integer> st = new LinkedList<>();
    
    for(String s:tokens){
        if(s.equals("+")){
            int b = st.removeFirst();
            int a = st.removeFirst();
            
            st.addFirst(a+b);
            
        }
        else if(s.equals("-")){
            int b = st.removeFirst();
            int a = st.removeFirst();
            st.addFirst(a-b);

        }else if(s.equals("*")){
            int b = st.removeFirst();
            int a = st.removeFirst();
            st.addFirst(a*b);
            
        }else if(s.equals("/")){
            int b = st.removeFirst();
            int a = st.removeFirst();
            
            st.addFirst(a/b);            
        }
        else{
            st.addFirst(Integer.valueOf(s));
        }
        
    }
    return st.getFirst();
}
}
