import java.util.Arrays;

public class l001{
    // 198. House Robber
//     time O(n) space O(n)
    public int rob1(int[] nums) {
        int n = nums.length,max=0;
        int[] dp = new int[n];
        if(n==0)
            return 0;
        else if(n==1)
            return nums[0];
        else if(n==2){
            return Math.max(nums[0],nums[1]);
        }
        else{
            dp[0] = nums[0];
            dp[1] = nums[1];
            dp[2] = nums[2] + nums[0];
            max = Math.max(dp[1],dp[2]);
            for(int i=3;i<n;i++){
                dp[i] = Math.max(dp[i-2],dp[i-3]) + nums[i];
                max = Math.max(dp[i],max);
            }
        }
        return max;
    }
      public int rob(int[] nums,int n,int[] dp) {
         if(n<=0) return 0;
         if(dp[n]!=-1) return dp[n];
         int robCurr = nums[n-1] +  rob(nums,n-2,dp);   
         int notRobCurr = rob(nums,n-1,dp);
        
         return dp[n] = Math.max(robCurr,notRobCurr);
         
      }
    
     public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return rob(nums,n,dp);
     }
//     time O(n) space O(1)
    public int rob2(int[] nums) {
        int n = nums.length,max=0,prev2,prev3,ans=0;
        if(n==1)
            return nums[0];
        else if(n==2){
            return Math.max(nums[0],nums[1]);
        }
        else{
            prev3 = nums[0];
            prev2 = nums[1];
            int prev1 = nums[2] + nums[0];
            max = Math.max(prev1,prev2);
            for(int i=3;i<n;i++){
                ans = Math.max(prev2,prev3) + nums[i];
                max = Math.max(ans,max);
                prev3 = prev2;
                prev2 = prev1;
                prev1 = ans;
            }
        }
        return max;
    }

    public class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         }
    // 328. Odd Even Linked List
    // O(n) time , O(1) space 
    public ListNode oddEvenList1(ListNode head) {
        ListNode even = new ListNode(-1);
        ListNode odd = new ListNode(-1);
        int count = 0;
        ListNode ptr = head, ep=even, op = odd;
        while(ep!=null){
            count++;
            if(count%2!=0){
                if(ptr==null)
                    break;
                op.next = ptr;
                op = ptr;
            }
            else{
                ep.next = ptr;
                ep = ptr;
            }
            if(ptr!=null)
            ptr = ptr.next;
        }
        op.next = even.next;
        return odd.next;
    }
    
    public ListNode oddEvenList(ListNode head) {
        if(head!=null){
            ListNode odd = head, even = head.next, evenhead = even;
            while(even!=null && even.next!=null){
                odd.next = odd.next.next;
                even.next = even.next.next;
                odd = odd.next;
                even = even.next;
            }
            odd.next = evenhead;
        }
        return head;
    }

    // 152. Maximum Product Subarray
    public int maxProduct(int[] nums) {
        int n = nums.length, currmax,currmin,prevmax,prevmin, ans;
        currmax = currmin = prevmax = prevmin = ans = nums[0];
        for(int i=1;i<n;i++){
            currmax = Math.max(prevmax*nums[i],Math.max(nums[i],prevmin*nums[i]));
            currmin = Math.min(prevmax*nums[i],Math.min(nums[i],prevmin*nums[i]));
            prevmax = currmax;
            prevmin = currmin;
            ans = Math.max(ans,currmax);
        }
        return ans;
    }

    
    class StreamChecker {
        // 1032. Stream of Characters
        // for this question it is like suffix matching of words with the characters of query present
        // so we will use trie here then how to use it here
        // we will store the words in the reverse order in th trie then one by one when the
        // character will come we will out that into a stringbuilder and check for the matching by 
        // starting from the end of the stringbuilder to its start and here if at any point of time
        // curr reaches null this means no match so return false
        // and if it reaches the character in the trie whose isEnd = true then return true as 
        // the matching is done. If the whole stringbuilder is traversed then also there is no
        // matching of the word with the characters as something may be left in the word to be matched
        // so return false.
        //     time O( n*m + q^2) space O(n*m + q)
            private class TrieNode{
                TrieNode[] children;
                boolean isEnd;
                public TrieNode(){
                    children = new TrieNode[26];
                    isEnd = false;
                }
            }
            private TrieNode root;
            private StringBuilder sb;
            public StreamChecker(String[] words) {
                root = new TrieNode();
                sb = new StringBuilder();
                
                for(String word:words){
                    TrieNode curr = root;
                    for(int i=word.length()-1;i>=0;i--){
                        char ch = word.charAt(i);
                        if(curr.children[ch-'a']==null){
                            curr.children[ch-'a'] = new TrieNode();
                        }
                        curr = curr.children[ch-'a'];
                    }
                    curr.isEnd = true;
                }
            }
            
            public boolean query(char letter) {
                sb.append(letter);
                TrieNode curr = root;
                for(int i=sb.length()-1;i>=0;i--){
                    char ch = sb.charAt(i);
                    curr = curr.children[ch-'a'];
                    
                    if(curr==null){
                        return false;
                    }
                    if(curr.isEnd) return true;
                }
                return false;
            }
        }
        
        /**
         * Your StreamChecker object will be instantiated and called as such:
         * StreamChecker obj = new StreamChecker(words);
         * boolean param_1 = obj.query(letter);
         */
    
}