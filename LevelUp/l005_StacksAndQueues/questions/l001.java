import java.util.Arrays;
import java.util.LinkedList;
import java.util.ArrayList;
public class l001 {
    

    // NGOR
    public int[] NGOR(int[] arr){
        int n = arr.length;
        int[] ans =new int[n];
        Arrays.fill(ans,n);
        LinkedList<Integer> st = new LinkedList<>();
        st.addFirst(-1);
        for(int i=0;i<n;i++){
            while(st.getFirst()!=-1 && arr[st.getFirst()] < arr[i]){
                ans[st.removeFirst()] = i;
            }

            st.addFirst(i);
        }
        return ans;
    }


    public int[] NGOL(int[] arr){
        int n = arr.length;
        int[] ans =new int[n];
        Arrays.fill(ans,-1);
        LinkedList<Integer> st = new LinkedList<>();
        st.addFirst(-1);
        for(int i=n-1;i>=0;i--){
            while(st.getFirst()!=-1 && arr[st.getFirst()] < arr[i]){
                ans[st.removeFirst()] = i;
            }

            st.addFirst(i);
        }
        return ans;
    }
   
    public int[] NSOR(int[] arr){
        int n = arr.length;
        int[] ans =new int[n];
        Arrays.fill(ans,n);
        LinkedList<Integer> st = new LinkedList<>();
        st.addFirst(-1);
        for(int i=0;i<n;i++){
            while(st.getFirst()!=-1 && arr[st.getFirst()] > arr[i]){
                ans[st.removeFirst()] = i;
            }

            st.addFirst(i);
        }
        return ans;
    }

     public int[] NSOL(int[] arr){
        int n = arr.length;
        int[] ans =new int[n];
        Arrays.fill(ans,-1);
        LinkedList<Integer> st = new LinkedList<>();
        st.addFirst(-1);
        for(int i=n-1;i>=0;i--){
            while(st.getFirst()!=-1 && arr[st.getFirst()] > arr[i]){
                ans[st.removeFirst()] = i;
            }

            st.addFirst(i);
        }
        return ans;
    }

    // 503. Next Greater Element II

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
       int[] ans =new int[n];
       Arrays.fill(ans,-1);
       LinkedList<Integer> st = new LinkedList<>();
       st.add(-1);
       for(int i=0;i< 2*n;i++){
           while(st.getFirst()!=-1 && nums[st.getFirst()] < nums[i%n]){
               ans[st.removeFirst()] = nums[i%n];
           }

           st.addFirst(i%n);
       }
       return ans;
   }


//    735. Asteroid Collision
public int[] asteroidCollision(int[] asteroids) {
    LinkedList<Integer> st = new LinkedList<>();

    for(int ele:asteroids){
        if(ele>0){
            st.addFirst(ele);
            continue;
        }
        while(st.size()!=0 && st.getFirst()>0 && st.getFirst()<-ele){
            st.removeFirst();
        }
        if(st.size()!=0 && st.getFirst()>0 && st.getFirst() == -ele){
            st.removeFirst();
        }
        else if(st.size() == 0 || st.getFirst()<0){
            st.addFirst(ele);
        }
        else{
            // do nothing
        }
    }

    int[] ans = new int[st.size()];
    int ind = ans.length-1;
    while(st.size()!=0){
        ans[ind--] = st.removeFirst();
    }
    return ans;


}
       
     // 946. Validate Stack Sequences
     public boolean validateStackSequences(int[] pushed, int[] popped) {
        LinkedList<Integer> st = new LinkedList<>();
        int idx=0;
        for(int ele:pushed){
            st.addFirst(ele);
            while(st.size()!=0 && st.getFirst() == popped[idx]){
                idx++;
                st.removeFirst();
            }
        }
        return idx==popped.length;      //st.size()==0
}

    // 856. Score of Parentheses
    public int scoreOfParentheses(String s) {
        LinkedList<Integer> st = new LinkedList<>();
        st.addFirst(0);
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '(')
            st.addFirst(0);
            else{
                int a = st.removeFirst();
                int b = st.removeFirst();
                int val = b + Math.max(2*a,1);
                st.addFirst(val);
            }
        }
        return st.removeFirst();
    }

    // 84. Largest Rectangle in Histogram
    // 7n
    public int largestRectangleArea1(int[] heights) {
        int[] nsol = NSOL(heights);         //3n
        int[] nsor = NSOR(heights);         //3n

        int maxArea = 0;
        for(int i=0;i<heights.length;i++){     //n
            maxArea = Math.max(maxArea,heights[i]*(nsor[i] - nsol[i] - 1));
        }
        return maxArea;
    }

    // 84. Largest Rectangle in Histogram
    // 2m
    public int largestRectangleArea(int[] heights) {
        
        int n=heights.length,maxArea=0;
        LinkedList<Integer> st = new LinkedList<>();
        st.addFirst(-1);
        for(int i=0;i<n;i++){
            while(st.getFirst()!=-1 && heights[st.getFirst()]>=heights[i]){
                int h = heights[st.removeFirst()];
                int w = i - st.getFirst() -1;
                maxArea = Math.max(maxArea,h*w);
            }
            st.addFirst(i);
        }
        
        while(st.getFirst()!=-1){
            int h = heights[st.removeFirst()];
            int w = n - st.getFirst()-1;
            maxArea = Math.max(maxArea,h*w);
        }

        return maxArea;
    
    }


    // 85. Maximal Rectangle
    // 3mn time and space m
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0 || matrix[0].length==0) return 0;
           int n = matrix.length, m = matrix[0].length;
        
          int[] heights = new int[m];
          int maxArea=0;
          for(int i=0;i<n;i++){       //n
              for(int j=0;j<m;j++){
                  heights[j] = matrix[i][j] == '0'? 0:heights[j]+1;       //m
              }
              maxArea = Math.max(maxArea,largestRectangleArea(heights));    //2m
          }
          return maxArea;
      }

    //   32. Longest Valid Parentheses
    public int longestValidParentheses(String s) {
        LinkedList<Integer> st = new LinkedList<>();
           st.addFirst(-1);
           int n = s.length();
           int maxLen = 0;
           for(int i=0;i<n;i++){
               if(st.getFirst()!=-1 && s.charAt(st.getFirst()) == '('&&  s.charAt(i)==')'){
                   st.removeFirst();
                   maxLen = Math.max(maxLen,i - st.getFirst());
               }
               else{
                   st.addFirst(i);
               }
               
           }
           return maxLen;
       }

    //    402. Remove K Digits
       public String removeKdigits(String num, int k) {
        ArrayList<Character> st = new ArrayList<>();
        for(int i =0 ;i<num.length();i++){
            char ch = num.charAt(i);
            while(st.size()!=0 && st.get(st.size()-1)>ch && k>0){
                k--;
                st.remove(st.size()-1);
            }
            st.add(ch);
        }
        while(k-->0){
            st.remove(st.size()-1);
        }

        StringBuilder sb = new StringBuilder();
        boolean nonzero = false;
        for(char ele:st){
            if(ele=='0' && !nonzero) continue;
            
            nonzero = true;
            sb.append(ele);
        }
        return sb.length()==0?"0":sb.toString();
        }
            // 316. Remove Duplicate Letters
            // 1081. Smallest Subsequence of Distinct Characters
            // Both are same
            public String removeDuplicateLetters(String s) {
                StringBuilder st = new StringBuilder();
                int[] freq = new int[26];
                int n = s.length();
                boolean[] vis =new boolean[26];
            
                for(int i=0;i<n;i++){
                    freq[s.charAt(i)-'a']++;
                }

                for(int i=0;i<n;i++){
                    char ch = s.charAt(i);
                    freq[ch-'a']--;

                    if(vis[ch-'a']){
                        continue;
                    }
                    while(st.length()!=0 && st.charAt(st.length()-1)>ch && freq[st.charAt(st.length()-1)-'a']>0){
                        vis[st.charAt(st.length()-1)-'a']=false;
                        st.deleteCharAt(st.length()-1);
                    }

                    vis[ch-'a']=true;
                    st.append(ch);
                }            
                return st.toString();

            }

                
        // 1249. Minimum Remove to Make Valid Parentheses
        public String minRemoveToMakeValid(String s) {
            LinkedList<Integer> st =new LinkedList<>();
            char[] arr = s.toCharArray();
            int n = s.length();
            for(int i=0;i<n;i++){
                char ch = s.charAt(i);
                if(ch == ')'){
                    if(st.size()!=0){
                        st.removeFirst();
                    }
                    else{
                        arr[i] = '#';
                    }
                }
                else if(ch=='('){
                    st.addFirst(i);
                }
            }
            while(st.size()>0){
                arr[st.removeFirst()] ='#';
            }
            StringBuilder sb = new StringBuilder();
            for(char ch:arr){
                if(ch!='#'){
                    sb.append(ch);
                }
            }
            return sb.toString();
        }

}
