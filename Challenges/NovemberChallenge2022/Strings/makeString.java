public class makeString {
    
    // 1544. Make The String Great
    // tc O(n) sc O(n)
    // end point of the stack and current point of the string is taken into consideration.
    public String makeGood1(String s) {
        LinkedList<Character> st = new LinkedList<>();
        int n = s.length();
        String ans = "";
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(st.size()!=0){
                if(Math.abs(st.getFirst()-ch) == 32){
                    st.removeFirst();
                }
                else{
                    st.addFirst(ch);
                }
            }
            else{
                st.addFirst(ch);
            }
        }
        while(st.size()!=0){
            ans = st.removeFirst()+ans;
        }
        return ans;
    }
        // tc O(n) sc O(1)
    // end point of the stringbuilder and current point of the string is taken into consideration.
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(sb.length()==0){
                sb.append(ch);
            }
            else{
                if(Math.abs(sb.charAt(sb.length()-1)-ch) == 32){
                    sb.deleteCharAt(sb.length()-1);
                }
                else{
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
}
