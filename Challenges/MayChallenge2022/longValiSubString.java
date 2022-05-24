public class longValiSubString {
    // 32. Longest Valid Parentheses
//     tc O(2*n) => O(n) sc O(n)
//     Stack solution
public int longestValidParentheses(String s) {
    LinkedList<Integer> st = new LinkedList<>();
    int prev = s.length(), ans=0;
    
//         Enter all the indexes which makes the substring unbalanced in the stack

    for(int i=0;i<s.length();i++){
        char ch = s.charAt(i);
        
        if(ch == ')' && st.size()!=0 && s.charAt(st.getFirst())=='('){
            st.removeFirst();
        }
        else{
            st.addFirst(i);
        }
    }
// find the difference between two unbalanced indexes from the stack
    while(st.size()!=0){
        System.out.println(st.getFirst());
        int diff = prev - st.getFirst()-1;
        prev = st.removeFirst();
        ans = Math.max(ans,diff);
    }
    ans = Math.max(ans,prev);
    return ans;
}
}
