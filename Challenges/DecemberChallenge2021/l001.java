import java.util.Arrays;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;
import java.util.PriorityQueue;
import java.util.Set;

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


    
// 1217. Minimum Cost to Move Chips to The Same Position
//  even to even and odd to odd doesn't cost us anything i.e. cost is 0
//  but even to odd or vice versa is costing us 1 unit i.e. cost = 1
// so count even and odd occurences and return the minimum of them as we will switch the minimum 
// one into the maximum one.
    
    public int minCostToMoveChips(int[] position) {
        int evenCt = 0, oddCt = 0;
        for(int ele:position){
            if(ele%2==0){
                evenCt++;
            }
            else{
                oddCt++;
            }
        }
        return Math.min(evenCt,oddCt);
    }

    // 1290. Convert Binary Number in a Linked List to Integer
    //     time  O(n) space O(n)
    public int binToDec(StringBuilder sb){
        int dnum = 0, count=0;
        for(int i=sb.length()-1;i>=0;i--){
            if(sb.charAt(i) == '1')
            dnum = dnum + 1*(int)Math.pow(2,count);
            count++;
        }
        return dnum;
    }
    public int getDecimalValue1(ListNode head) {
        ListNode curr = head;
        int dnum = 0;
        StringBuilder sb = new StringBuilder();
//         get bnum from linkedlist
        while(curr!=null){
            sb.append(curr.val);
            curr = curr.next;
        }
//         convert the bnum to dnum
        dnum = binToDec(sb);
        return dnum;
    }
    
//     time O(n) space O(1)
    public int getDecimalValue2(ListNode head) {
        int num = 0;
        ListNode curr = head;
        while(curr!=null){
            num = num * 2 + curr.val;
            curr = curr.next;
        }
        return num;
    }
//     more faster through bits
    public int getDecimalValue(ListNode head) {
        int num = 0;
        ListNode curr = head;
        while(curr!=null){
            num = (num<<1) | curr.val;
            curr = curr.next;
        }
        return num;
    }

        // 563. Binary Tree Tilt
//     time O(n) space O(log n)
    private int tilt = 0;
//     return the sum and change the tilt
    private int findSum(TreeNode root){
         if(root == null){
            return 0;
        }
        
        int lsum = findSum(root.left);
        int rsum = findSum(root.right);
        
        int ctilt = Math.abs(lsum-rsum);
        tilt+=ctilt;
        
        int sum = lsum + rsum + root.val;
        return sum;
    }
    public int findTilt(TreeNode root) {
        findSum(root);
        return tilt;
    }

    
//     some kind of graph traversal is needed here
//     so we can use dfs or bfs but in dfs we will take one node and stretch it to 
//     complete its traversal and we may not find the answer but in bfs we do the 
//     things parrallely so less time will be taken to calculate the answer
    // 1306. Jump Game III
    public boolean canReach(int[] arr, int start) {
        LinkedList<Integer> que = new LinkedList<>();
        int n = arr.length;
        boolean[] vis = new boolean[n];
        que.addLast(start);
        while(que.size()!=0){
            int size = que.size();
            while(size-->0){
                int rind = que.removeFirst();
                if(arr[rind] == 0){
                    return true;
                }
                int back = rind - arr[rind];
                int forw = rind + arr[rind];
                if(!vis[rind]){
                if(back>=0){
                    que.add(back);
                }
                if(forw<n){
                    que.add(forw);
                }
                vis[rind] = true;
                }
        }
        }
        return false;
    }



    
//     790. Domino and Tromino Tiling
//     time O(n) space O(n)
//     just to come with this equation is tough 
//     so dry run it and then do code
// previous will be taken care of and first three cases are special 
// then after that only trominoes have to be taken that are 2 more in the existing answer which is already 
// taken care of. Rest checkout the dry run. 
    public int numTilings(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        int mod = (int)1e9 +7;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for(int i=4;i<=n;i++){
            dp[i] = ((2*dp[i-1]%mod) + (dp[i-3]%mod))%mod;
        }
        return dp[n];
    }


    // https://www.codechef.com/START19B/problems/INDIPERM
    //  Indivisible Permutation 
        public static void solveIndivisible(){
            int t=scn.nextInt();
            while(t-->0)
            {
            int n=scn.nextInt();
            if(n==2){
                System.out.println("2 1");
                continue;
            }
            System.out.print("1 ");
            for(int itr=3;itr<=n;itr++){
                System.out.print(itr+" ");
            }
            System.out.print("2 ");
            System.out.println();
            }
            
        }

        // https://www.codechef.com/START19B/problems/CHEFCONTEST
        // Chef and Contest  
        public static void solveContest(){
            int t=scn.nextInt();
            while(t-->0)
            {
                int x = scn.nextInt();
                int y = scn.nextInt();
                int p = scn.nextInt();
                int q = scn.nextInt();
                int chef,chefina;
                
                chef = x + (p*10);
                chefina = y + (q*10);
                
                if(chef == chefina){
                    System.out.println("Draw");
                }
                
                else if(chef<chefina){
                    System.out.println("Chef");
                }
                else{
                    System.out.println("Chefina");
                }
                
            }
        }



        // https://www.codechef.com/START19B/problems/DISTELE
        // Distinct Elements

        public static void solveDistinct(){
            int t=scn.nextInt();
            while(t-->0)
            {
                int n=scn.nextInt(), mod = ((int)1e9) + 7,value;
                long ans = 1;
                HashMap<Integer,Integer> map = new HashMap<>();
                for(int i=0;i<n;i++){
                    int ele = scn.nextInt();
                    map.put(ele,map.getOrDefault(ele,0)+1);
                }
                
                for(int key:map.keySet())
                {
                    value = map.get(key);
                    if(value == 1) ans *=2;
                    else ans *= (value+1);
                    ans %= mod;
                }
                
                System.out.println(ans-1);
            }
        }


        // https://www.codechef.com/START19B/problems/FILL01
        // Sleepy Chef

        public static void solveSleepy(){
            int t=scn.nextInt();
            while(t-->0)
            {
                int n=scn.nextInt(),ans = 0,count=0;
                int k=scn.nextInt();
                String s = scn.next();
                
                for(int i=0;i<n;i++){
                    if(s.charAt(i) == '0'){
                        count++;
                        if(count==k){
                            ans++;
                            count=0;
                        }
                    }
                    else 
                    count=0;
                }
                
                
                System.out.println(ans);
            }
        }




            
    //  878. Nth Magical Number
    //  tc O(log n) sc O(1) 
    //  we need to analyse the pattern here and first of all why binary search 
    //  because of large constraints and the range that we are having will be
    //  considered in sorted order. After that we will see the series of factors
    //  of a and b respectively then we can only consider n/a and n/ b
    //  where repetition can be there so to subtract that we will subtract 
    //  n/lcm(a,b).
    //  a=2-> 2,4,6,8,10....   
    //  b=3-> 3,6,9,12,15....  
    //  n = 4
    //  l = 2, h =8
    // 6/2 + 6/3 - 6/6 = 3 + 1 -0 = 4
    // if the factor other than 6 here is < 4 then go in upper half otherwise go in lower half.
    // to get this result we will be applying binary search, rest do it by dry run
        
    public int gcd(int a,int b){
        if(a==0) return b;
        return gcd(b%a,a);
    }
    public int nthMagicalNumber(int n, int a, int b) {
        long mod = ((int)1e9) + 7;
        long lcm = (a*b)/gcd(a,b);
        long low = Math.min(a,b);
        long high = low*n,factor=1;
        while(low<high){
            long mid = low + (high-low)/2;
            factor = (mid/a) + (mid/b) - (mid/lcm);
            if(factor<n){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        return (int)(low%mod);
    }


    
    
    // 416. Partition Equal Subset Sum
    //    tc O(nums.length*totSum)
//    sc O(nums.length*totSum)
//     In this question we will be searching for the totSum/2 target
//     if it can be acheived then we can return true otherwise false
//    in dp we are having two choices for each element for its inclusion or
//     exclusion but in inclusion only if we can accomadate that in our sum.

    
    //     perfect exaplanation of a coder
//     This problem is essentially let us to find whether there are several numbers in a set which are able to sum to a specific value (in this problem, the value is sum/2).

// Actually, this is a 0/1 knapsack problem, for each number, we can pick it or not. Let us assume dp[i][j] means whether the specific sum j can be gotten from the first i numbers. If we can pick such a series of numbers from 0-i whose sum is j, dp[i][j] is true, otherwise it is false.

// Base case: dp[0][0] is true; (zero number consists of sum 0 is true)

// Transition function: For each number, if we don't pick it, dp[i][j] = dp[i-1][j], which means if the first i-1 elements has made it to j, dp[i][j] would also make it to j (we can just ignore nums[i]). If we pick nums[i]. dp[i][j] = dp[i-1][j-nums[i]], which represents that j is composed of the current value nums[i] and the remaining composed of other previous numbers. Thus, the transition function is dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]]
    
    
    public boolean canPartition(int[] nums) {
        int totSum = 0;
        for(int ele:nums){
            totSum += ele;
        }
        if(totSum%2!=0){
            return false;
        }
        boolean[][] dp = new boolean[nums.length+1][totSum/2 + 1];
        for(int i=0;i<dp.length;i++){
            dp[i][0] = true;
        }
        
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
//                 for exclusion
                dp[i][j] = dp[i-1][j];
//                 for inclusion
                if(j>=nums[i-1]){
                    dp[i][j] = dp[i][j] || dp[i-1][j-nums[i-1]];  
                }
            }
        }
        return dp[nums.length][totSum/2];
    }


    
    // 1446. Consecutive Characters
    // set one character and check for the other character if it is equal or not and according update the answer
//     tc O(n^2) sc O(1) => brute
    public int maxPower1(String s) {
        int ans = 0, count = 1,i=0,j=0, n =s.length();
        while(i<n){
            char ch = s.charAt(i);
            j=i+1;
            count=1;
            while(j<n){
                char ch1 = s.charAt(j);
                if(ch == ch1){
                    count++;
                    j++;
                }else{
                    i=j-1;
                    break;
                }
            }
            i++;
            ans = Math.max(ans,count);
        }
        return ans;
        
    }
//     tc O(n) sc O(1) => Optimised
// this is nice we can just compare the current with lasgt one if it is equal increase count and also check
// for the max ans so far and if not reset the counter to 1 and after traversing you will get the answer. 
     public int maxPower(String s) {
         int count=1,ans=1;
         for(int i=1;i<s.length();i++){
             if(s.charAt(i) == s.charAt(i-1)){
                 if(++count>ans){
                     ans = count;
                 }
             }
             else{
                 count=1;
             }
         }
         return ans;
     }


    //  938. Range Sum of BST
//     brute force
//     tc O(n) sc O(height)
//     if I am in the range add me in the answer and take the ans
//     from both sides along with it and return and if not return 0
//     this can also be done in binary trees bst property is not used here
    public int rangeSumBST1(TreeNode root,int low,int high){
        if(root == null) return 0;
        
        int sum = 0;
        sum+=rangeSumBST1(root.left,low,high);
        sum+=rangeSumBST1(root.right,low,high);
        
        if(root.val>=low && root.val<=high){
            sum += root.val;
        }
        
        return sum;
    }
//         optimised    
//     if I am in the range i will call both sides but if I am not 
//    then i will call in only one side depending upon the condition 
    // tc O(n) sc O(height) , height= log n  but for skewed tree height = n
    public int sum = 0;
    public void rangeSumBST2(TreeNode root,int low,int high){
        if(root==null){
            return;
        }
        if(root.val>=low && root.val<=high){
            sum += root.val;
            rangeSumBST2(root.left,low,high);
            rangeSumBST2(root.right,low,high);
        }
        else if(root.val<low){
            rangeSumBST2(root.right,low,high);
        }
        else if(root.val>high){
            rangeSumBST2(root.left,low,high);
        }
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        // return rangeSumBST1(root,low,high);

        rangeSumBST2(root,low,high);
        return sum;
    }


    
    // 147. Insertion Sort List
//     my solution
//     tc O(n^2) sc O(1)
    public ListNode insertionSortList1(ListNode head) {
        ListNode curr = head,tail=head,prev,forw=curr,ime;
        ListNode ans = new ListNode(-5001);
        prev=ans;
        ans.next = curr;
        curr = curr.next;
        ans.next.next=null;
        while(curr!=null){
            ime = curr.next;
            if(tail.val<=curr.val)
            {
                tail.next = curr;
                tail = curr;
                curr.next = null;
            }
            else{
            prev = ans;
            forw = ans.next;
            while(forw!=null){
                if(curr.val>=prev.val && curr.val<=forw.val){
                    prev.next = curr;
                    curr.next = forw;
                    break;
                }
                prev = prev.next;
                forw = forw.next;
            }
            }
            curr = ime;
        }
        return ans.next;
    }
//     coding decoded approach
     // tc O(n^2) sc O(1)
     public ListNode insertionSortList(ListNode head) {
         if(head == null || head.next==null){
             return head;
         }
         
         ListNode currIt = head,toIns,preIns;
         ListNode dummy = new ListNode(-5001);
         dummy.next = currIt;
         while(currIt!=null && currIt.next!=null){
             if(currIt.val<=currIt.next.val){
                 currIt = currIt.next;
             }
             else{
                 preIns = dummy;
                 toIns = currIt.next;
                 currIt.next = toIns.next;
                 while(preIns.next.val<toIns.val){
                     preIns = preIns.next;
                 }
                 toIns.next = preIns.next;
                 preIns.next = toIns;
             }
         }
         return dummy.next;
         
         
     }



     //     310. Minimum Height Trees
//     tc O(edges) sc O(edges)
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if(n==0){
            return ans;
        }
        if(n==1){
            ans.add(0);
            return ans;
        }
        
// in the queue only nodes with degree 1 will be added 
// according to total elements the last one or last two ele which will be 
// left in queue will be the answer. Why?
// because they were at the center of the graph, whosever node will be in
// the center will have the minimum height
// in odd only 1 node will be the answer, in even 2 nodes will be the answer
        LinkedList<Integer> leaves = new LinkedList<>();
        HashMap<Integer,HashSet<Integer>> map = new HashMap<>();
        int[] degree = new int[n];
        
//         make adjacency list of graph
        for(int[] edge:edges){
            degree[edge[0]]++;
            map.putIfAbsent(edge[0],new HashSet<>());
            map.get(edge[0]).add(edge[1]);
            
            degree[edge[1]]++;
            map.putIfAbsent(edge[1],new HashSet<>());
            map.get(edge[1]).add(edge[0]);
        }
        
//         now add the nodes with 1 degree into the queue
        for(int i=0;i<n;i++){
            if(degree[i] == 1){
                leaves.addLast(i);
            }
        }
        
        int count = n;
        while(count>2){
            int size = leaves.size();
            count = count - size;
            while(size-->0){
                int leaf = leaves.removeFirst();
                for(int connection:map.get(leaf)){
                    degree[connection]--;
                    // map.get(leaf).remove(connection);
                    // map.get(connection).remove(leaf);
                    if(degree[connection] == 1){
                        leaves.addLast(connection);
                    }
                }
            }
        }
        return new ArrayList<>(leaves);
    }

    
//     Brute force => tc O((mn)^2) sc O(1)
//     find largest square for every cell
    
//     Hint There are overlapping subproblems
//     so we will use dp for optimisation
    
    
//     In this question, dp is used to get the answer, we have used bottom-top
//     top-bottom can also be used.
//     Meaning to the cell => largest square from here will be stored
//     Travel from smallest problem at bottom right to top left
//     because at bottom right there will be the smallest answer
//     What? While teversing upward take min of all three directions of (right,
//     down, diag ) +1 
//     how ? it is giving me right answer as the original ques.
//     why? because that min was not able to expand itself so it will also
//     not allow me to expand more than min + 1, +1 because except that min 
//     other directions I can expand so min + 1 will definitely give the right 
//     answer at that point.
//     tc O(mn) sc O(mn)
    public int maximalSquare1(char[][] matrix) {
        int n = matrix.length,m = matrix[0].length,right,down,diag,max=0;  
        int[][] dp = new int[n][m];
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(matrix[i][j] == '0'){
                    dp[i][j] = 0;
                }
                else{
                    right = j+1<m?dp[i][j+1]:0;
                    down = i+1<n?dp[i+1][j]:0;
                    diag = i+1<n && j+1<m? dp[i+1][j+1]:0;
                    dp[i][j] = Math.min(Math.min(right,down),diag) + 1;
                    max = Math.max(dp[i][j],max);
                }
            }
        }
        return max*max;
    }
    
//     tc O(mn) sc O(m)
//     here we are using dp[j] as the down value 
//     previous value of dp[j] as the diag value
//     current value of dp[j+1] as the right value.
     public int maximalSquare(char[][] matrix) {
        int n = matrix.length,m = matrix[0].length,right,max=0,prev=0;  
        int[] dp = new int[m];
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                int temp = dp[j];
                if(matrix[i][j] == '0'){
                    dp[j] = 0;
                }
                else{
                    right = j+1<m?dp[j+1]:0;
                    dp[j] = Math.min(Math.min(right,dp[j]),prev) + 1;
                    max = Math.max(dp[j],max);
                }
                prev = temp;
            }
        }
        return max*max;
    }
	//902. Numbers At Most N Given Digit Set
    
//     mathematical solution
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String num = n + "";
        int numLen = num.length();
        int digitsLen = digits.length;
        int total = 0;
        boolean hasSomeNo = false;
        
// base case which will be done for every case
// for one less than the numLen powers of the digitLen which will give 
// all permutations as a base case
        for(int i=1;i<numLen;i++){
            total += Math.pow(digitsLen,i);
        }
        
//  now comes the little bit tricky equations
        for(int i=0;i<numLen;i++){
            hasSomeNo = false;
            for(String digit:digits){
// if it is going in this only then we need to return the
// as we have traversed and calculated all the answers
// if( the current no position is less than the required no position)
// then this will get added to my answer generating all permutations
                if(digit.charAt(0) < num.charAt(i)){
                    total += Math.pow(digitsLen,numLen-i-1);
                }
// else if it is same go on for next number 
// but special case will be that if it has reached end of the original no
// so this is the only permutation to be added.
                else if(digit.charAt(0) == num.charAt(i)){
                    hasSomeNo = true;
                    if(i == numLen -1){
                        total++;
                    }
                }
            }
            if(!hasSomeNo){
                return total;
            }
        }
        return total;
    }


    
    // 394. Decode String
// My solution
// so here we need to use two stacks
// because we are seeing the parenthesis thing that it will open 
// so something happen and closed then also something happens
// Here we will be having four cases 
    
// one that we find a number then we need to add it at the last of 
// already existing number like 1 is there 2 comes so it will be 1*10 + 2.
// this number thing is used for continuous number like 12

// Second when we see a character letter then we add into the stringbuilder
// Third when we see a open bracket we add the stringbuilder into one stack
//and number into another stack and then reset both the no and stringbuilder
// Fourth when we see a closing bracket then  we take out the stringbuilder
// from one stack and copy the current stringbuilder's value and also the 
// no. from another stack now in the stringbuilder we will append the 
// str from st1 and then n times we will add the previous val of 
// stringbuilder then reset the no =0 and stringbuilder is containing the 
// answer

    public String decodeString(String s) {
        LinkedList<String> st1 = new LinkedList<>();
        LinkedList<Integer> st2 = new LinkedList<>();
        StringBuilder sb = new StringBuilder("");
        int num=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='['){
                st1.addFirst(sb.toString());
                st2.addFirst(num);
                num = 0;
                sb = new StringBuilder();
            }
            else if(ch==']'){
                String str = st1.removeFirst();
                int n = st2.removeFirst();
                StringBuilder sc = sb;
                sb = new StringBuilder();
                sb.append(str);        
                for(int j=0;j<n;j++){
                    sb.append(sc);
                }
                num=0;
            }
            else if(Character.isDigit(ch)){
                num = (num*10) + (ch-'0');
            }
            else if(Character.isLetter(ch)){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    
//     coding decoded
    public String decodeString1(String s) {
        Stack<Integer> freqStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();

        StringBuilder currStr = new StringBuilder();
        int k =0;
        for(char c :  s.toCharArray()){
            if(Character.isDigit(c)){
                k = k*10 + (c-'0');
            } else if (Character.isLetter(c)){
                currStr.append(c);
            } else if(c == '['){
                freqStack.push(k);
                strStack.push(currStr);
                k =0;
                currStr = new StringBuilder();
            } else if(c == ']'){
                StringBuilder temp = currStr;
                int freq = freqStack.pop();
                currStr = strStack.pop();
                while(freq-->0){
                    currStr.append(temp);

                }
                k = 0;
            }
        }
        return currStr.toString();
    }

    
    //     1200. Minimum Absolute Difference
//     ṭc O(n log n) sc O(1)
//     sort the array find the minimum diff of array
//     then in another pass check out all the consecutive pairs with that
//     difference and add it to the ans
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int diff = (int)1e9;
        for(int i=1;i<n;i++){
            diff = Math.min(diff,arr[i]-arr[i-1]);    
        }
        
        for(int i=1;i<n;i++){
            if(diff == arr[i]-arr[i-1]){
                // List<Integer> smallAns = new ArrayList<>();
                // smallAns.add(arr[i-1]);
                // smallAns.add(arr[i]);
                // ans.add(smallAns);
                ans.add(Arrays.asList(arr[i-1],arr[i]));
            }
        }
        return ans;
    }

    
    // 231. Power of Two
//     tc O(log n) sc O(1)
    public boolean isPowerOfTwo1(int n) {
        for(int i=0;i<=n/2;i++){
            if(Math.pow(2,i) == n){
                return true;
            }
            else if(Math.pow(2,i) > n){
                return false;
            }
        }
        return false;
    }
    
//     tc O(log n) sc O(1)
    public boolean isPowerOfTwo2(int n) {
        if(n<=0) return false;
        while(n%2==0){
            n =n/2;
        }
        return  n==1;
    }
    
//     tc O(log n) sc O(1)
    public boolean isPowerOfTwo3(int n) {
        if(n<=0) return false;
        while(n%2==0){
           return isPowerOfTwo(n/2);
        }
        return  n==1;
    }
    
//     tc O(1) sc O(1)
    public boolean isPowerOfTwo4(int n) {
        if(n<=0){
            return false;
        }
        boolean hasFound = false;
        for(int i=0;i<32;i++){
            if(((n>>i)&1)==1){
                if(hasFound){
                    return false;
                }
                hasFound = true;
            }
        }
        return true;
    }
    
//     tc O(1) sc O(1)
    public boolean isPowerOfTwo(int n) {
        if(n<=0) return false;
        
        return (n &(n-1)) == 0; 
    }
   

    
//     tc O(V+E)
//     sc O(V+E)
// So in this question we have implemented topological sort with bfs
// First of all make a graph where dependency course is connected to the
// course and depdency course will be completed first then other courses.
// According to that we taken the indegree concept and we will keep on
// going in the graph as soon as the dependency gets over we decrease the 
// indegree and when it will reach to 0 then this course can be done 
// as its pre courses are done
// So for this purpose we have used BFS where we add course in the que 
// whenever indegree goes to 0. And when all the courses are not covered 
// so this means ans can't be calculated

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer,Set<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        
        for(int i=0;i<numCourses;i++){
            map.put(i, new HashSet<>());
        }
        
        for(int[] prerequisite:prerequisites){
            int course = prerequisite[0];
            int dependencyCourse = prerequisite[1];
            map.get(dependencyCourse).add(course);
            indegree[course]++;
        }
        
        LinkedList<Integer> que = new LinkedList<>();
        
        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0){
                que.addLast(i);
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        while(que.size()!=0){
            int size = que.size();
            while(size-->0){
                int course = que.removeFirst();
                ans.add(course);
                for(int children:map.get(course)){
                    indegree[children]--;
                    if(indegree[children] == 0){
                        que.addLast(children);
                    }
                }
            }
        }
        
        if(ans.size()!=numCourses){
            return new int[]{};
        }
        
        int[] res = new int[numCourses];
        int i=0;
        for(int ele:ans){
            res[i++] = ele;
        }
        return res;
    }


    
//     56. Merge Intervals
//     tc O(nlogn) sc O(n)
//     In this we have to first sort on the basis of start index 
//     because we will check and merge the intervals while traversing
//     for this purpose we have to use stack so the interval from the top
//     of stack will be compared with current interval and according to the
//     condition we can see what to add and remove from the stack
//     when merged then remove and then add the new one
//     otherwise just add the current interval in the stack
//     in the end the answer will be contained in the stack and from 
//     that make the answer accordingly
public int[][] merge(int[][] intervals) {
    //         O(nlogn)
            Arrays.sort(intervals, (a,b) -> {
                return a[0]-b[0];
            });
            LinkedList<int[]> st = new LinkedList<>();
            
    //         O(n)
            for(int i=0;i<intervals.length;i++){
                int[] interval = intervals[i];
                if(st.size()==0){
                    st.addFirst(interval);
                }
                else{
                    int[] top = st.getFirst();
    //                 overlap is there then merge them into one big interval
                    if(top[1]>=interval[0]){
                        st.removeFirst();
                        int minstart = top[0];
                        int maxend = Math.max(top[1],interval[1]);
                        st.addFirst(new int[]{minstart,maxend});
                    }
                    else{
                        st.addFirst(interval);
                    }
                }
            }
            
    //         make the answer from the stack now
            int[][] ans = new int[st.size()][2];
            int count=st.size()-1;
            while(st.size()!=0){
                int[] interval = st.removeFirst();
                ans[count][0] = interval[0];
                ans[count][1] = interval[1];
                count--;
            }
            return ans;
        }


        
// 227. Basic Calculator II  
// time O(n) space O(n)
// Here we will use stack to evaluate the expression and find the answer
// Previous number along with previous operator will be used to get into 
// the stack and do the evaluation everytime we see next operator or end 
// of string.
    public int calculate(String s) {
        LinkedList<Integer> st = new LinkedList<>();
        int currNo = 0, n=s.length();
        char op = '+';
        
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                currNo = (currNo*10) + (ch-'0');
            }
            if((!Character.isDigit(ch) && ch!=' ') || i==n-1){
                if(op=='+'){
                    st.addFirst(currNo);
                }
                else if(op =='-'){
                    st.addFirst(-currNo);
                }
                else if(op=='*'){
                    st.addFirst(st.removeFirst() * currNo);
                }
                
                else if(op=='/'){
                    st.addFirst(st.removeFirst() / currNo);
                }
                op = ch;
                currNo = 0;
            }
        }
        int ans = 0;
        while(st.size()!=0){
            ans += st.removeFirst();
        }
        
        return ans;
    }


    
//     973. K Closest Points to Origin
//     tc O(nlog k) sc O(k) 
public int[][] kClosest1(int[][] points, int k) {
    //         to store the row number and then accordingly calculate the
    //         distance and do other - this to make  maxheap 
    //         in the end k coordinates will be left in priority queue
    //         which will be the k closest points from origin.
    //         tc O(logk)  for adding/removing sc O(k) for maxheap
            PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
                int d1 = points[a][0]*points[a][0] + points[a][1]*points[a][1];
                int d2 = points[b][0]*points[b][0] + points[b][1]*points[b][1]; 
                return d2-d1;
    //             other - this => maxheap
            });
    //         It happens for n elements that is why tc O(n log k)
    //         standard technique for k things while using priority queue
            for(int i=0;i<points.length;i++){
                pq.add(i);
                if(pq.size()>k) pq.remove();
            }
            
    //        direct transfer the 1d array in a 2d array again and again 
            int i=0;
            int[][] ans = new int[k][];
            while(pq.size()!=0){
                int idx = pq.remove();
                ans[i++] = points[idx];
            }
            return ans;
        }
        
        public int[][] kClosest(int[][] points, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
                int d1 = points[a][0]*points[a][0] + points[a][1]*points[a][1];
                int d2 = points[b][0]*points[b][0] + points[b][1]*points[b][1];
                return d2-d1;
            });
            
            for(int i=0;i<points.length;i++){
                pq.add(i);
                if(pq.size()>k) pq.remove();
            }
            
            int[][] ans = new int[k][2];
            for(int i=0;i<k;i++){
                ans[i] = points[pq.remove()];
            }
            return ans;
        }


        
//     2114. Maximum Number of Words Found in Sentences
//     just count the max spaces + 1, it will be the answer 
//     tc O(n) sc O(1)
    public int mostWordsFound(String[] sentences) {
        int count=0,ans=0;
        for(String str:sentences){
            count=0;
            for(int i=0;i<str.length();i++){
                char ch = str.charAt(i);
                if(ch==' '){
                    count++;
                }
            }
            ans = Math.max(ans,count);
        }
        return ans+1;
    }


        
   // 2115. Find All Possible Recipes from Given Supplies
// brute force
//     time O(n^2) space O(n).
//     Why this cyclic thing is happening do a dry run for the case 
//     where bread depends on sandwitch, sandwitch depends on burger
//     burger depends on yeast and flour which is already in supplies
//     then you will understand the dependancy thing
//     It is running n^2 time to get the answer
//     rest of the answer is just like keep on adding the included recipes 
// in the set and accordingly the algorithm gives the answer    
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashSet<String> sup = new HashSet<>();
        for(String s:supplies) sup.add(s);
        
        List<String> ans = new ArrayList<>();
         boolean found=true;
        
        while(found){
            found = false;
            for(int i=0;i<recipes.length;i++){
                if(sup.contains(recipes[i])) continue;
                
                List<String> ing = ingredients.get(i);
                boolean f = true;
                for(String s:ing){
                if(sup.contains(s) == false){
                    f = false;
                    break;
                }
                }
                if(f){
                    found = true;
                    ans.add(recipes[i]);
                    sup.add(recipes[i]);
                }
            }
            
        }
        return ans;
    }


    
//     476. Number Complement
//     tc O(32)=>O(1) sc O(1)
//     for example:
// 100110, its complement is 011001, the sum is 111111. So we only need get
// the min number large or equal to num, then do substraction
    
//         5 => 2 => 1 => 0
//last bit 1    0    1    
//comp.    0    1    0
//     0*2^2 + 1*2^1 + 0*2^0 = 2   
    public int findComplement1(int num) {
        int ans=0;
        int multi = 1;
        while(num!=0){
            int digit = (num%2==0)?1:0;
            ans = digit*multi + ans;
            multi = multi*2;
            num=num/2;
        }
        return ans;
    }
//     11111(31) -10000(16) => 01111(15)
//     for 16 it will go to 31 and then 31-16 = 15
//     11111(31) -11111(31) = 0
    public int findComplement(int num) {
        int ans=0;
        int power=0;
        while(ans<num){
            ans += Math.pow(2,power);
            power++;
        }
        return ans-num;
    }

    
 // 876. Middle of the Linked List
//     tc O(n) sc O(1)
    public ListNode middleNode(ListNode head) {
        ListNode[] arr = new ListNode[100];
        int ind = 0;
        ListNode curr = head;
        while(curr!=null){
            arr[ind++] = curr;
            curr = curr.next;
        }
        return arr[ind/2];
    }
//     tc O(n) sc O(1)
    public ListNode middleNode1(ListNode head) {
        ListNode slow,fast;
        slow = fast = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    
        public Node() {}
        
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    
    // 116. Populating Next Right Pointers in Each Node
//     tc:- O(n) sc O(log n)
//     Explanation:- done by myself
// Applying bfs and always assigning the next pointer except the last 
// element of the current level. This will give me the result that I want.
    public Node connect1(Node root) {
        if(root == null){
            return root;
        }
        LinkedList<Node> que = new LinkedList<>();
        que.addLast(root);
        while(que.size()!=0){
            int size = que.size();
            while(size-->0){
                Node rnode = que.removeFirst();
                if(size != 0){
                    rnode.next = que.getFirst();
                }
                if(rnode.left!=null){
                    que.addLast(rnode.left);
                }
                
                if(rnode.right!=null){
                    que.addLast(rnode.right);
                }
            }
        }
        return root;
    }
    
// tc O(n) scO(1)
// do a dry run you will understand how we are dealing 
// basically on one level upper we are doing the work for the children's
// next elements.
    
    public Node connect(Node root) {
        Node start = root, curr = root;
        while(start!=null && start.left!=null){
            while(curr!=null){
                curr.left.next = curr.right;
                if(curr.next == null) break;
                curr.right.next = curr.next.left;
                curr = curr.next;
            }
            curr = start.left;
            start = start.left;
        }
        return root;
    }
   
    
    // 1015. Smallest Integer Divisible by K
// tc O(k) sc O(1)
// from n=(n*10+1)
// and do %k and you will get n%k=(n*10+1)%k
// you will be able to derive rem = (rem*10 +1)%k
// and the maximum pattern that you will behaving is between 1 to k
// to get the remainder as 0 otherwise no number can b divisible by k so
// return -1.
    public int smallestRepunitDivByK(int k) {
        if(k==2||k==5) return -1;
        
        int rem = 0;
        for(int counter = 1; counter<=k; counter++){
            rem = ((rem*10) + 1)%k;
            if(rem==0) return counter;
        }
        return -1;
    }

    

}