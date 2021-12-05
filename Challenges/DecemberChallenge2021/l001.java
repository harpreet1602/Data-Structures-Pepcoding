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
    
        //  codechef SnackDown 2021 - Elimination Parallel (Rated for Div 2)  
        // public static Scanner scn =new Scanner(System.in);
    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(
                new InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() { return Integer.parseInt(next()); }
 
        long nextLong() { return Long.parseLong(next()); }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    public static FastReader scn = new FastReader();
        // https://www.codechef.com/SDELP21B/problems/REMELEM
        // Remove Element 
        public static void solveRem(){
            int t=scn.nextInt();
            while(t-->0)
            {
                int n=scn.nextInt();
                int k = scn.nextInt();
                int[] arr = new int[n];
                for(int i=0;i<arr.length;i++){
                    arr[i] = scn.nextInt();
                }
                Arrays.sort(arr);
                int l =0, h =arr.length-1;
                while(l<h){
                if(arr[l]+arr[h]<=k){
                    h--;
                }
                else break;
                }
                if(l==h){
                    System.out.println("YES");
                }
                else{
                    System.out.println("NO");
                }
            
            }
        }


        // https://www.codechef.com/SDELP21B/problems/SUBPRB
        // Yet another subarray problem
        public static void solveSub(){
            int t=scn.nextInt();
            while(t-->0)
            {
             int n=scn.nextInt();
             int[] arr = new int[n];
             int p=1,q=2;
             if(n%2==0 || n==1){
                 for(int i=0;i<n;i++){
                     arr[i] = p;
                     p+=2;
                 }
             }
             else{
                 for(int i=0;i<n;i++){
                     arr[i] = q;
                     q+=2;
                 }
             }
             
                 for(int i=0;i<n;i++){
                     System.out.print(arr[i] + " ");
                 }
                 System.out.println();
            }
        }


        public class TreeNode {
                 int val;
                 TreeNode left;
                 TreeNode right;
                 TreeNode() {}
                 TreeNode(int val) { this.val = val; }
                 TreeNode(int val, TreeNode left, TreeNode right) {
                     this.val = val;
                     this.left = left;
                     this.right = right;
                 }
             }
    // 337. House Robber III
    //     time O(n) space  O(1) ignoring the recursive space

    // faith is that I will be asking from the left and right that what will be the profit if 
    // you will rob and will not rob then I will decide that what I have to do for profit by 
    // robbing and not robbing. Like we will be roobing current then we take 
    // l.q + r.q + root.val and when not then max(l.p,l.q) + max(r.p,r.q).  

//     interview related code
    private class housePair{
        int withRob = 0;
        int withoutRob = 0;
    }
    public housePair rob1_(TreeNode root){
        if(root == null) return new housePair();
        
        housePair left = rob1_(root.left);
        housePair right = rob1_(root.right);
        
        housePair myans = new housePair();
        myans.withRob = left.withoutRob + right.withoutRob + root.val;
        myans.withoutRob = Math.max(left.withRob,left.withoutRob) + Math.max(right.withRob,right.withoutRob);
        return myans;
    }
    public int rob1(TreeNode root) {
        housePair ans = rob1_(root);
        return Math.max(ans.withRob,ans.withoutRob);
    }
    
//     online test related code but do the upper one in interview.
//     {withRob,withoutRob} 1d array of size 2
    public int[] rob_(TreeNode root){
        if(root == null) return new int[2];
        
        int[] left = rob_(root.left);
        int[] right = rob_(root.right);
        
        int[] myans = new int[2];
        myans[0] = left[1] + right[1] + root.val;
        myans[1] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        return myans;
    }
    public int rob(TreeNode root) {
        int[] ans = rob_(root);
        return Math.max(ans[0],ans[1]);
    }


}