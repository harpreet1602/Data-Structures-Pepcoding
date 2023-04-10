import java.util.LinkedList;
public class validParenthesis {
    
    // 20. Valid Parentheses
//     tc O(n) sc O(n)
//     Add the opening brackets in the stack,  
//     else check if stack is empty return false,
//     pop in the other cases and check for any false condition.
//     In the end, if size is zero return true otherwise false.    
    
public boolean isValid(String s) {
    LinkedList<Character> st = new LinkedList<>();
    
    for(char ch:s.toCharArray()){
        if(ch=='(' || ch=='[' || ch == '{'){
            st.addFirst(ch);
        }
        else{
            if(st.size()==0){
                return false;
            }
            char out = st.removeFirst();
            if(ch == ')' && out != '('){
                return false;
            }
            else if(ch == '}' && out != '{'){
                return false;
            }
            else if(ch == ']' && out != '['){
                return false;
            }
        }
    }
    return st.size()==0;
}
}

class Solution {
    //   20. Valid Parentheses
    //   tc O(n) sc O(n)
    //     just use stack add when opening bracket comes and remove and check when closing brackets come.
    //     simply apply the logic.
        public boolean isValid(String s) {
            int n = s.length();
            LinkedList<Character> st = new LinkedList<>();
            
            for(int i=0;i<n;i++){
                char ch = s.charAt(i);
                
                if(ch == '(' || ch == '[' || ch == '{'){
                    st.addFirst(ch);
                }
                else{
                    if(st.size()==0){
                        return false;
                    }
                    char top = st.removeFirst();
                    
                    if(ch == ')' && top != '('){
                        return false;
                    }
                    if(ch == ']' && top != '['){
                        return false;
                    }
                    if(ch == '}' && top != '{'){
                        return false;
                    }
                }
            }
            return st.size() == 0;
        }
    }
