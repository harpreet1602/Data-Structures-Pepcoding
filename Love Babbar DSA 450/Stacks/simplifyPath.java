public class simplifyPath {
    class Solution {
        // 71. Simplify Path
    // tc O(n) sc O(n)
    //     split the the string on the basis of "/" with the escape character "\/"
    //     then traverse on that array 
    //     look for cases where if . comes or empty string comes, continue it
    //     .. comes then remove the previous string from the stack
    //     other string comes add in the stack
    //     then make the string with "/" in between from the stack.
        public String simplifyPath(String path) {
            String[] pathList = path.split("\\/");
            LinkedList<String> st = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            for(String p:pathList){
                if(p.length()==0 || p.equals(".")){
                    continue;
                }
                else if(p.equals("..")){
                    if(st.size()!=0){
                        st.removeFirst();
                    }
                }
                else{
    //                 string case
                    st.addFirst(p);
                }
            }
            
            while(st.size()!=0){
                sb.insert(0,st.removeFirst()+"/");
            }
            if(sb.length()==0){
                return "/";
            }
            return "/"+sb.toString().substring(0,sb.length()-1);
        }
    }
}
