

public class backspaceStringCompare {
    
    // 844. Backspace String Compare
//     tc O(n) sc O(n)
// So make new stringbuilder and if the character is hash and size of stringbuilder > 0
//     then delete the last character
//     otherwise add the character into the stringbuilder
//     Compare both the new Strings to get the answer
private String updateString(String str){
    StringBuilder sb = new StringBuilder();
    
    for(char c : str.toCharArray()){
        if(c!='#'){
            sb.append(c);
        }
        else{
            if(sb.length()>0)
            sb.deleteCharAt(sb.length()-1);
        }
    }
    return sb.toString();
}

public boolean backspaceCompare(String s, String t) {
    return updateString(s).equals(updateString(t));
}
}
