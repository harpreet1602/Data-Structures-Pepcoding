public class pallindromePart {
    
//     131. Palindrome Partitioning
//     tc O() sc O()
//     Backtracking in dfs fashion is applied to get the list of list of pallindromes
//     for consider the current string, and cut every possible substring from the start
//     and if it is pallindrome then call for the other string 
//     and while coming backtracking remove the last string of the list to traverse through all possibilities
//     In the base case if empty string comes to be considered this means that a list of pallindrome strings is made so add it into the answer
public List<List<String>> partition(String s) {
    List<List<String>> ans = new ArrayList<>();
    List<String> smallAns = new ArrayList<>();
    dfsHelper(ans,s,smallAns);
    return ans;
}
private void dfsHelper(List<List<String>> ans,String s,List<String> smallAns){
    if(s.length() == 0){
        ans.add(new ArrayList<>(smallAns));
        return;
    }
    
    for(int i=0;i<s.length();i++){
        if(isCheckPallindrome(s,0,i)){
            smallAns.add(s.substring(0,i+1));
            dfsHelper(ans,s.substring(i+1),smallAns);
            smallAns.remove(smallAns.size()-1);
        }
    }
}
private boolean isCheckPallindrome(String s,int i,int j){
    while(i<j){
        if(s.charAt(i)!=s.charAt(j)){
            return false;
        }
        i++;
        j--;
    }
    return true;
}
}
