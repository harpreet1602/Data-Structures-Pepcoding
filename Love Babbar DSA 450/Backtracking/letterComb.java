public class letterComb {
    class Solution {
        // 17. Letter Combinations of a Phone Number
    // tc O(n*4^n) SC O()
    //     explained in prev submissions
        
        public List<String> letterCombinations(String digits) {
            List<String> ans = new ArrayList<>();
            int n = digits.length();
            
            if(n==0 || digits == null){
                return ans;
            }
            String[] set = new String[10];
            set[2] = "abc";
            set[3] = "def";
            set[4] = "ghi";
            set[5] = "jkl";
            set[6] = "mno";
            set[7] = "pqrs";
            set[8] = "tuv";
            set[9] = "wxyz";
             
            
            combinations(ans,digits,set,0,"");
            return ans;
        }
        
        private int combinations(List<String> ans, String digits,String[] set,int idx,String currStr){
            if(idx == digits.length()){
                ans.add(currStr);
                return 1;
            }
            
            String possibleChars = set[digits.charAt(idx)-'0'];
            int count = 0;
            for(char ch:possibleChars.toCharArray()){
                count += combinations(ans,digits,set,idx+1,currStr+ch);
            }
            return count;
        }
    } 
}
