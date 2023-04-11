public class removeStars {
    class Solution {
        // 2390. Removing Stars From a String
    // tc O(n) sc O(n)
    //     Use stack as it is about removing the closest non star character 
    //     this thing will be easily tracked using a stack.
    //     then simply keep on adding the non star characters in the stack 
    //     remove the character from the stack when star is seen 
    //     then take the string out from the stack, reverse of that will be the remaining  string.
        public String removeStars(String s) {
            LinkedList<Character> st = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            
            for(int i=0;i<s.length();i++){
                char ch = s.charAt(i);
                
                if(ch == '*'){
                    st.removeFirst();
                }
                else{
                    st.addFirst(ch);
                }
            }
            
            while(st.size()!=0){
                sb.append(st.removeFirst());
            }
            return sb.reverse().toString();
        }
    }
}
