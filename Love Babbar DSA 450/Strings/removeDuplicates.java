import java.util.HashSet;
public class removeDuplicates {
    
    // https://practice.geeksforgeeks.org/problems/remove-all-duplicates-from-a-given-string4321/1#
    // Remove all duplicates from a given string
    // TC O(n*amotised(O(1)) => O(n) SC O(n)
    // In the traversal, maintain a hashset and if the character is coming for the first time
    // add it into the ans string otherwise ignore it.
    String removeDuplicates1(String str) {
        // code here
        HashSet<Character> set = new HashSet<>();
        String s = "";
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(!set.contains(ch)){
                set.add(ch);
                s = s + ch;
            }
        }
        return s;
    }
    
    // TC O(n) SC O(n)
    // Have to the mapping of the alphabets in the array
    // So consider the mapping of capital character along with the small alphabets
    // for lowercase => ind = ch - 'a';
    // for uppercase => ind = ch - 'A' + 26;
    
    String removeDuplicates(String str) {
        int[] arr = new int[52];
        String ans = "";
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            int ind=0;
            if(Character.isLowerCase(ch))
                ind = ch - 'a';
            else
                ind = ch - 'A' + 26;
            if(arr[ind]==0)
            {
                arr[ind] = 1;
                ans = ans + ch;
            }
            }
            
            return ans;
        }

}
