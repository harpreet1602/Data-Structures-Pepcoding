import java.util.List;
import java.util.ArrayList;

public class letterCombination {
     // 17. Letter Combinations of a Phone Number
//     tc O() sc O()
//  Backtracking solutions as we have to find all the possible combinations
//     Ṭhis is done using backtracking
//     Time Complexity
    //Since there are no more than 4 possible characters for each digit, the number of recursive calls, T(n), satisfies T(n) < 4T(n - 1), where n is the number of digits in the number. This solves to T(n) = O(4^n).
//Each base case entails making a copy of a string and adding it to the result. Since each such string has length n, each base case takes time O(n). Therefore, the time complexity is O(n * 4^n).
    
public void combinationPhone(List<String> ans,String[] set, String digits, int index, String currString){
    //         Whenver the index will reach the length this means digits is exhausted 
    //         for the current combinations so add it and backtrack from here 
    //         to add another combinations.
            if(index == digits.length()){
                ans.add(currString);
                return;
            }
    //         Find the string that is mapped to the number present on the current index of digits.
            String possibleChars = set[digits.charAt(index)-'0'];
    //         Get each and every character of the current possibleChars string that is generated
    //         Call for making the combinations with increment in the index as well as
    //         add the current character in the currString
            for(char c:possibleChars.toCharArray()){
                combinationPhone(ans,set,digits,index+1,currString+c);
            }
        }
        public List<String> letterCombinations(String digits) {
            String[] set = new String[10];
            set[2] = "abc";
            set[3] = "def";
            set[4] = "ghi";
            set[5] = "jkl";
            set[6] = "mno";
            set[7] = "pqrs";
            set[8] = "tuv";
            set[9] = "wxyz";
            
            List<String> ans = new ArrayList<>();
            
            if(digits == null || digits.length()==0){
                return ans;
            }
    //         index through which we will be traversing in the digits string
    //         "" empty string is the current string in the stage of recursion
    //         that will be made.
            combinationPhone(ans,set,digits,0,"");
            return ans;
        }
}
