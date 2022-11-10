public class removeDup {
     // 1047. Remove All Adjacent Duplicates In String
    // tc O(n) sc O(1)
    // Stringbuilder last character will be checked with curr character and then keep on deleting 
    // when the characters match, simple
    // 
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(sb.length()==0){
                sb.append(ch);
            }
            else{
                if(sb.charAt(sb.length()-1) == ch){
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
