

public class RemoveDuplicate {
    //     316. Remove Duplicate Letters
//     tc O(n) sc O(n)
//     
public String removeDuplicateLetters(String s) {
    //         As a Stack, stringbuilder will be used.
            StringBuilder st = new StringBuilder();
            int n = s.length();
    //         It does not matter what greater freequency the character have, if it is visited once and assigned its correct place in the stack then no need to add it.
            boolean[] vis = new boolean[26];
    //         We need to maintain  the frequency map as well so that we get to know is it availble to use or not in present as well as future scenarios.
            int[] freq = new int[26];
    // frequency map is created        
            for(int i = 0;i<n;i++){
                freq[s.charAt(i) - 'a']++;
            }
            
            for(int i=0;i<n;i++){
    //             current character has come so no matter what frequency will be decreased.
                char ch = s.charAt(i);
                freq[ch-'a']--;
    // this character is already been assigned the correct position in the stack.            
                if(vis[ch-'a']){
                    continue;
                }
                
    //             If the stack is not empty then consider the comparisons of adding the small characters first and then the big characters.
    //             Also check if the top of my stack character is greater than the current character of the string
    //             And also the top character has frequency>0 then it is sure that the top character bigger than the current one can come later
    //             so mark it false and delete it
    //             This removal will go on till we find the suitable position for the current character
                while(st.length()!=0 && st.charAt(st.length()-1) > ch && freq[st.charAt(st.length()-1)-'a']>0){
                    vis[st.charAt(st.length()-1)-'a'] = false;
                    st.deleteCharAt(st.length()-1);
                }
    //             After the loop, the correct position has come so mark and add it
                vis[ch-'a'] = true;
                st.append(ch);
            }
            
            return st.toString();
    
        }

}
