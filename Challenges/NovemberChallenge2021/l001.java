import java.util.List;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class l001{
    // 130. Surrounded Regions
    // Time: O(n^2), Space: O(1)
      
    public void dfs(char[][] board,int sr, int sc,int[][] dir){
        int n =board.length, m = board[0].length;
       for(int[] d:dir){
       int r = sr+d[0];
       int c = sc+d[1];
       if(r>=0 && c>=0 && r<n && c<m && board[r][c]=='O'){
           board[r][c] = 'P';
           dfs(board,r,c,dir);
       }
       }
   }
   public void solve(char[][] board) {
       int n =board.length, m = board[0].length;
       if(n==0 || m==0)
       {
           return;
       }
       int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
//         first column
       for(int i=0;i<n;i++){
           if(board[i][0] == 'O'){
               board[i][0] = 'P';
               dfs(board,i,0,dir);
           }
       }
       
       
//         last column
       for(int i=0;i<n;i++){
           if(board[i][m-1] == 'O'){
               board[i][m-1] = 'P';
               dfs(board,i,m-1,dir);
           }
       }
       
       
//         first row
       for(int j=0;j<m;j++){
           if(board[0][j] == 'O'){
               board[0][j] = 'P';
               dfs(board,0,j,dir);
           }
       }
       
       
//         last row
       for(int j=0;j<m;j++){
           if(board[n-1][j] == 'O'){
               board[n-1][j] = 'P';
               dfs(board,n-1,j,dir);
           }
       }
       
       for(int i=0;i<n;i++){
           for(int j=0;j<m;j++){
               if(board[i][j] == 'O'){
                   board[i][j] = 'X';
               }
           }
       }
       
       
       for(int i=0;i<n;i++){
           for(int j=0;j<m;j++){
               if(board[i][j] == 'P'){
                   board[i][j] = 'O';
               }
           }
       }
   }
//    980. Unique Paths III
// calculate all the zeroes and locate the starting indices
// after that go for th dfs operations where when you will get 2 then if zeroes has beem reduced
// to -1 then return 1 for finding one path covering all empty spaces
// mark the point visited as you don;t have to use one empty space more than one time
// decrease your one zero as you encountered zero on your path
// in the dfs just go for the valid calls only check if it is not visited or -1
// in the end mark the point unvisited 
// at each cell it will be storing the paths the cell can have to reach the destination

   public int dfs(int[][] grid, int sr,int sc,int zero,int[][] dir){
    int n = grid.length, m= grid[0].length;
   if(grid[sr][sc] == 2)
      return zero==-1?1:0;
   int totalpaths=0;
   grid[sr][sc] = -1;
   zero--;
   for(int[] d:dir){
       int r = sr+d[0];
       int c = sc+d[1];
       if(r>=0 && c>=0 &&r<n && c<m&&grid[r][c]!=-1){
           totalpaths +=dfs(grid,r,c,zero,dir);
       }
   }
   grid[sr][sc] = 0;
   return totalpaths;
}
public int uniquePathsIII(int[][] grid) {
   int n = grid.length, m= grid[0].length, zero =0 ,sr=0,sc=0;
   int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
   for(int i=0;i<n;i++){
       for(int j=0;j<m;j++){
           if(grid[i][j] == 0){
               zero++;
           }
           else if(grid[i][j] ==1)
           {
               sr = i;
               sc = j;
           }
       }
   }
   return dfs(grid,sr,sc,zero,dir);
}

    // 129. Sum Root to Leaf Numbers
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
       
    public void rootToLeaf(TreeNode root,ArrayList<Integer> smallAns,ArrayList<ArrayList<Integer>> ans)     {      
        if(root.left==null && root.right==null){
            
            smallAns.add(root.val);
            // if(!ans.contains(smallAns)){
            ArrayList<Integer> base = new ArrayList<>(smallAns);
            ans.add(base);
            // }

        smallAns.remove(smallAns.size()-1);
            return;
        }
        smallAns.add(root.val);
        if(root.left!=null){
        rootToLeaf(root.left,smallAns,ans);
        }
        if(root.right!=null){
        rootToLeaf(root.right,smallAns,ans);
        }
        smallAns.remove(smallAns.size()-1);
    }
    public int sumNumbers1(TreeNode root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> smallAns = new ArrayList<>();
        rootToLeaf(root,smallAns,ans);
        int sum=0;
        for(int i=0;i<ans.size();i++){
            int number=0;
            for(int j=0;j<ans.get(i).size();j++)
            {
                number = number*10 + ans.get(i).get(j);
            }
            sum +=number;
        }
        return sum;
    }

    //     2nd
    public int sumRootToLeaf(TreeNode root,int sum){
        if(root==null)
            return 0;
        sum = sum*10 + root.val;
        if(root.left == null && root.right == null){
            return sum;
        }
        int leftsum = sumRootToLeaf(root.left,sum);
        int rightsum = sumRootToLeaf(root.right,sum);
        return leftsum+rightsum;
    } 
    public int sumNumbers(TreeNode root) {
        return sumRootToLeaf(root,0);
    }

    // 70. Climbing Stairs
    public int climbStairs1(int n, int[] dp) {
        if(n == 0){
            return 1;
        }  
           
        int count = 0;
        if(dp[n-1]!=-1)
        {
          count +=dp[n-1];   
        }  
        else{
            count += climbStairs(n-1,dp);
        }
        if(n-2>=0)
        {
            if(dp[n-2]!=-1){
                count+=dp[n-2];
            }
            else
            {    
              count += climbStairs(n-2,dp);  
            }
        }
        return dp[n] = count;
      }
      public int climbStairs(int n,int[] dp){
          if(n==0){
              return 1;
          }
          if(n<0){
              return 0;
          }
          if(dp[n]!=0) return dp[n];
          int count = 0;
          count +=climbStairs(n-1,dp);
          count +=climbStairs(n-2,dp);
          return dp[n] = count;
      }
      public int climbStairsTab(int N,int[] dp){
          for(int n=0;n<=N;n++){
              int count = 0;
              if(n==0) count = 1;
              else if(n==1){
                  count = dp[n-1];
              }
              else{
                  count +=dp[n-1];
                  count +=dp[n-2];
              }
              dp[n] = count;
          }
          return dp[N];
      }
       public int climbStairs(int n) {
       int[] dp = new int[n+1];
       return climbStairsTab(n,dp);
       }

    //     1,2 ,3 jumps
    // https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/climb-stairs-official/ojquestion
    public static Scanner scn = new Scanner(System.in);
      public static int climbStairs2(int n,int[] dp){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(dp[n]!=0) return dp[n];
        int count = 0;
        count +=climbStairs2(n-1,dp);
        count +=climbStairs2(n-2,dp);
        count +=climbStairs2(n-3,dp);
        return dp[n] = count;
    }
    public static int climbStairsTab1(int N,int[] dp){
        for(int n=0;n<=N;n++){
            int count = 0;
            if(n==0) count = 1;
            else if(n==1){
                count = dp[n-1];
            }
            else if(n==2){
                count +=dp[n-1];
                count +=dp[n-2];
            }
            else{
                count += dp[n-1];
                count += dp[n-2];
                count += dp[n-3];
            }
            dp[n] = count;
        }
        return dp[N];
    }
    
    // 746. Min Cost Climbing Stairs
     public int minCostClimbingStairs(int[] cost,int[] dp,int idx) {
        if(idx >= cost.length){
            return 0;
        }
        if(dp[idx]!=0){
            return dp[idx];
        }
        int cost1 = minCostClimbingStairs(cost,dp,idx+1);
        int cost2 = minCostClimbingStairs(cost,dp,idx+2);
        return dp[idx] = Math.min(cost1,cost2) + cost[idx];
    }
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        
        int cost1 = minCostClimbingStairs(cost,dp,0);
        int cost2 = minCostClimbingStairs(cost,dp,1);
        return Math.min(cost1,cost2);
    }
    // https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/climb-stairs-with-minimum-moves-official/ojquestion
    public static int climbStairsMinMoves(int[] arr,int[] dp,int idx){
        if(idx>=arr.length){
            return 0;
        }
        if(dp[idx]!=0) return dp[idx];
        int min = (int)1e9;
        for(int i=1;i<=arr[idx];i++){
            min = Math.min(min,climbStairsMinMoves(arr,dp,idx+i));
        }
        return dp[idx] = min+1;
    }
    // Tabulation
    public static int climbStairsMinMovesTab(int[] arr,Integer[] dp,int idx){
        for(int i=idx;i>=0;i--){
            if(i==idx) dp[i] = 0;
            else{
                int min = (int)1e9;
                for(int j=1;j<=arr[i];j++){
                    if(i+j<=arr.length){
                        if(dp[i+j]!=null)
                        min = Math.min(min,dp[i+j]);
                    }
                }
                if(min!=(int)1e9)
                dp[i] = min+1;
                else
                dp[i] = null;
            }
        }
        return dp[0];
    }
    
    // 404. Sum of Left Leaves
     public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        int ans = 0;
        if(root.left!=null){
            if(root.left.left == null && root.left.right == null)
                ans +=root.left.val;
            else
                ans +=sumOfLeftLeaves(root.left);
        }
        ans += sumOfLeftLeaves(root.right);
        return ans;
    }
// 441. Arranging Coins
    public int arrangeCoins(int n) {
        int rowcount = 0;
        while(n>0){
            rowcount++;
            n = n - rowcount;
        }
        return n==0?rowcount:rowcount-1;
    }

    // https://www.codechef.com/NOV21C/problems/CHEAPFUEL
    public static void solveCost(){
        int t=scn.nextInt();
		while(t-->0)
	    {
	     int x=scn.nextInt();
	     int y=scn.nextInt();
	     int a=scn.nextInt();
	     int b=scn.nextInt();
	     int k=scn.nextInt();
	     
	     x = x + a*k;
	     y = y + b*k;
	     if(x==y){
	         System.out.println("SAME PRICE");
	     }
	     else if(x<y){
	         System.out.println("PETROL");
	     }
	     else{
	         System.out.println("DIESEL");
	     }
	    }
    }
    
    // 260. Single Number III
     public int[] singleNumber(int[] nums) {
        int x =0,y=0,xor=0,xor_mask=0;
        for(int ele:nums){
            xor ^= ele;
        }
        xor_mask = (xor & (-xor));
//         -xor = (~xor + 1)
        for(int ele:nums){
            if((ele&xor_mask) == 0){
                x ^= ele;
            }
            else {
                y ^=ele;
            }
        }
        return new int[]{x,y};
    }
    

    // 43. Multiply Strings
    public String multiply(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        
        
        if(n==0 || m==0 || "0".equals(num1) || "0".equals(num2)){
            return "0";
        }
        if("1".equals(num1)){
            return num2;
        }
        
        if("1".equals(num2)){
            return num1;
        }
        
//         max size submission of both numbers
        int[] res = new int[n+m];
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                int product = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                product += res[i+j+1];
                
                res[i+j+1] = product%10;
                res[i+j] += product/10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int ele:res){
            if(sb.length() == 0 && ele==0)
                continue;
            sb.append(ele);
        }
        return sb.toString();
    }

    // 96. Unique Binary Search Trees
     public int numTrees(int n) {
        int[] dp = new int[n+1];
        for(int i=0;i<=n;i++){
            if(i<=1){
                dp[i] = 1;
                continue;
            }
            int l = 0;
            int r = i-1;
            while(l<=i-1){
                dp[i] += dp[l]*dp[r];
                l++;
                r--;
            }
        }
        return dp[n];
    }

    // 1178. Number of Valid Words for Each Puzzle
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        HashMap<Character,ArrayList<Integer>> map = new HashMap<>();
        
        for(int i=0;i<26;i++){
            map.put((char)(i+'a'),new ArrayList<>());
        }
        
        HashSet<Character> set = new HashSet<>();
        for(String word:words){
            int mask = 0;
            for(char ch:word.toCharArray()){
                int bit = (ch-'a');
                mask = (mask | (1<<bit));
            }
            
            for(char ch:word.toCharArray()){
                if(set.contains(ch)){
                   continue;
                }
                set.add(ch);
                map.get(ch).add(mask);
            }
            set.clear();
        }
        
        List<Integer> list = new ArrayList<>();
        for(String puzzle:puzzles){
            char ch = puzzle.charAt(0);
            ArrayList<Integer> wordsToCheck = map.get(ch);
            int pmask = 0, count=0;
            for(char c:puzzle.toCharArray()){
                pmask = pmask | (1<<(c-'a'));
            }
            
            for(int wmask:wordsToCheck){
                if((wmask&pmask) == wmask){
                    count++;
                }
            }
            
            list.add(count);
            
            
        }
        return list;
    }


    // 122. Best Time to Buy and Sell Stock II       
    //     tc O(n)
    //     sc O(1)
    public int maxProfit(int[] prices) {
        int i = 0, buy = 0, sell = 0, profit = 0, n = prices.length;
        while(i<n-1){
            while(i<n-1 && prices[i]>=prices[i+1]){
                i++;
            }
            buy = prices[i];
            while(i<n-1 && prices[i]<=prices[i+1]){
                i++;
            }
            sell = prices[i];
            profit += sell - buy;
        }
        return profit;
        
    }

    //     1413. Minimum Value to Get Positive Step by Step Sum
    //     tc O(n), sc O(n)
    //     this is what I think
    public int minStartValue1(int[] nums) {
        int n = nums.length, min;
        int[] prefix = new int[n];
        prefix[0] = min = nums[0];
        for(int i=1;i<n;i++){
            prefix[i] = prefix[i-1] + nums[i];
            min = Math.min(min,prefix[i]);
        }
        return min>=0?1:(min*-1) + 1;
    }
    //     this is what it should be
    //     tc O(n), sc O(1)
    public int minStartValue(int[] nums) {
        int min = 0, prefix=0;
        for(int ele:nums){
            prefix += ele;
            min = Math.min(min,prefix);
        }
        return min<0?Math.abs(min)+1:1;
    }


    // https://www.codechef.com/NOV21C/problems/MAKEPAL
    // If the count of a character is even then there is no problem half of it will be in one side and the other 
    // will be in the other side but when the count of the character is odd then we need to convert in some cases
    // So the total count of the characters who have odd count of character is even then by dividing it by 2 gives the
    // correct conversions but when total count is odd then one of the odd count character can stay in middle without
    // conversion and the other has to get converted so here also by dividing it with 2 the lowerbound gives the
    // correct value of conversion
    public static void solvePal(){
        int t=scn.nextInt();
		while(t-->0)
	    {
	     int n=scn.nextInt(),count=0;
	     for(int i=0;i<n;i++){
	         int ele = scn.nextInt();
	         if(ele%2!=0){
	             count++;
	         }
	     }
	     System.out.println(count/2);
	    }
    }
	

    public class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         }
    // 203. Remove Linked List Elements
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return null;
        ListNode prev = null, curr = head,forw;
        while(curr!=null){
            forw = curr.next;
            if(curr.val == val){
                // System.out.println(curr.val);
                if(prev!=null){
                    prev.next = curr.next;
                }
                else{
                    head = forw;
                }
               
                curr.next = null;
            }
            else{
            prev = curr;   
            }
            curr = forw; 
        }
        return head;
    }
    // dummy node way
    public ListNode removeElements1(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
         dummy.next = head;
        ListNode prev = dummy, curr = head, forw;
        
         while(curr!=null){
             forw = curr.next;
             if(curr.val == val){
                 prev.next = forw;
                 curr.next = null;
             }
             else{
                 prev = curr;
             }
             curr = forw;
         }
         return dummy.next;
     }


    //  2070. Most Beautiful Item for Each Query
     //     tle
    public int[] maximumBeauty1(int[][] items, int[] queries) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] ans = new int[queries.length];
        for(int[] arr:items){
            map.put(arr[0],Math.max(arr[1],map.getOrDefault(arr[0],0)));
        }
        
        for(int j=0;j<queries.length;j++){
            int max = 0;
            // for(int i=0;i<=queries[j];i++){
            
            for(Integer key:map.keySet()){
                if(key<=queries[j])
            max = Math.max(map.getOrDefault(key,0),max);
            }
            // }
            ans[j] = max;
        }
        return ans;
    }
    
     public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items,(a,b)->{
            return a[0]-b[0];
        });
//          sort the array on the basis of price
         int n =items.length;
        for(int i=1;i<n;i++){
            items[i][1] = Math.max(items[i][1],items[i-1][1]);             
        }         
// store the maximum beauty till that price
         int[] ans = new int[queries.length];
         for(int q=0;q<queries.length;q++){
             int si = 0, ei = n -1;
             while(si<=ei){
                 int mid = (si + (ei-si)/2);
                 if(items[mid][0] <= queries[q]){
                     si = mid + 1;
                     ans[q] = Math.max(ans[q],items[mid][1]);
                 }
                 else{
                     ei = mid - 1;
                 }
             }
         }
         return ans;
     }

    //  739. Daily Temperatures
//     brute force check for the next greatest
//     time O(n^2) space O(1)
//     optimized: Monotonic Stack
//    favourite of google 
    public int[] dailyTemperatures(int[] temperatures) {
        LinkedList<Integer> st = new LinkedList<>();
        int n = temperatures.length;
        int[] ans = new int[n];
       
        for(int i=0;i<n;i++){
            while(st.size()!=0 && temperatures[st.getFirst()] < temperatures[i]){
                // found the greater element for the st.getFirst() index
                ans[st.getFirst()] = i- st.removeFirst();
            }
            st.addFirst(i);
        }
        return ans;
    }

    // 1286. Iterator for Combination    
    class CombinationIterator {

        public List<String> list = new ArrayList<>();
        
        public int combinations(String characters,int k,int val,StringBuilder sb){
            if(k==0){
                list.add(sb.toString());
                return 1;
            }
            
            int count=0;
            for(int i=val;i<characters.length();i++){
                sb.append(characters.charAt(i));
                count += combinations(characters,k-1,i+1,sb);
                sb.deleteCharAt(sb.length()-1);
            }
            return count;
        }
        public CombinationIterator(String characters, int combinationLength) {
            combinations(characters,combinationLength,0,new StringBuilder());
        }
        
        
        
        public String next() {
            if(hasNext()){
                String str = list.get(0);
                list.remove(0);
                return str;
            }
            return "";
        }
        
        public boolean hasNext() {
            return list.size()>0;
        }
    }
    
    /**
     * Your CombinationIterator object will be instantiated and called as such:
     * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
     * String param_1 = obj.next();
     * boolean param_2 = obj.hasNext();
     */

    //  https://www.codechef.com/NOV21C/problems/HILLSEQ 

    public static void solvehill(){
        int t=scn.nextInt();
		while(t-->0)
	    {
	     int n=scn.nextInt();
	     int[] arr = new int[n];
	     int max = -(int)1e9;
	     HashMap<Integer,Integer> map = new HashMap();
	     boolean flag = true;
	     for(int i=0;i<n;i++){
	         arr[i] = scn.nextInt();
	         map.put(arr[i],map.getOrDefault(arr[i],0)+1);
	         max = Math.max(max,arr[i]);
	     }
	     
	     for(Integer key:map.keySet()){
	         if(map.get(key)>2)
	         {
	            flag = false;
	         }
	     }
	     if(!flag || map.get(max)>1){
	         System.out.println(-1);
	         continue;
	     }
	     
	     
	     ArrayList<Integer> arr1 = new ArrayList<>();
	     ArrayList<Integer> arr2 = new ArrayList<>();
	      for(Integer key:map.keySet()){
	         if(map.get(key)==1)
	         {
	            arr2.add(key);
	         }
	         else if(map.get(key)==2){
	             arr1.add(key);
	             arr2.add(key);
	         }
	         
	     }
	    
	    Collections.sort(arr1);
	    Collections.sort(arr2, Collections.reverseOrder());

	    for(int ele:arr1){
	        System.out.print(ele+" ");
	    }
	    for(int ele:arr2){
	        System.out.print(ele+" ");
	    }
	     
	         
	     
	     System.out.println();
	    }
    }

    // Maximise the bridges 
    // https://www.codechef.com/problems/MAXBRIDGE
    public static void solveBridge(){
        int t=scn.nextInt();
		while(t-->0)
	    {
	        int n=scn.nextInt();
	        int m=scn.nextInt();
	        for(int i=1;i<n;i++){
	            m--;
	           System.out.print(i + " " + (i+1) +"\n");
	        }
	        
	        for(int i=3;i<=n;i++){
	            for(int j=1;j<=i-2;j++){
	                if(m-->0)
	                System.out.print(i + " " + j +"\n");
	                else
	                break;
	            }
	        }
	    }
    }

    //   368. Largest Divisible Subset
    public int getMaximumSubsequence(int[] nums,int[] dp)
    {
        int n = nums.length,max = 1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j] == 0){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
    public List<Integer> largestDivisibleSubset(int[] nums,int[] dp,int max){
        int idx = dp.length-1, prev = 0;
        LinkedList<Integer> list = new LinkedList<>();
        while(max>0 && idx>=0){
            if(dp[idx] == max && prev%nums[idx] == 0){
                list.addFirst(nums[idx]);  
                max--;
                prev = nums[idx];
            }
            idx--;            
        }
        return list;
    } 
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.sort(nums);
        Arrays.fill(dp,1);
        int max = getMaximumSubsequence(nums,dp);
        return largestDivisibleSubset(nums,dp,max);
    }


    // 668. Kth Smallest Number in Multiplication Table
    // time O(mlog(m*n)) space O(1)
    private int getCount(int mid,int m,int n,int k){
        int count = 0;
        for(int i=1;i<=m;i++){
            count += Math.min(mid/i,n);
        }
        return count;
    }
    public int findKthNumber(int m, int n, int k) {
        int low = 1, high = m*n, mid=0, count=0;
        while(low<high){
            mid = (low + ((high-low)/2));
            count = getCount(mid,m,n,k);
            if(count>=k)
            {
                high = mid;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }

//     tc O(m*n)
//     sc O(m*n)
//     as we only have two directions that is why we don't need visited check
    public int uniquePaths(int sr,int sc,int m, int n,int[][] dir,int[][] dp) {
        if(sr == m-1 && sc == n-1){
            return dp[sr][sc] = 1;
        }
        if(dp[sr][sc]!=0){
            return dp[sr][sc];
        }
        int count = 0;
        for(int[] d:dir){
            int r = sr + d[0];
            int c = sc + d[1];
            if(r>=0 && c>=0 && r<m && c<n){
                count += uniquePaths(r,c,m,n,dir,dp);
            }
        }
        return dp[sr][sc] = count;
    }
    
    public int uniquePaths(int m, int n) {
        int[][] dir = {{0,1},{1,0}};
        int[][] dp = new int[m][n];
        return uniquePaths(0,0,m,n,dir,dp);
    }
    
    // Starters 17
    // https://www.codechef.com/START17B/problems/NEWPIECE
    // New Piece
    public static void solvePiece(){
        int t=scn.nextInt();
		while(t-->0)
	    {
	     int a=scn.nextInt();
	     int b=scn.nextInt();
	     int p=scn.nextInt();
	     int q=scn.nextInt();
	     int sum1 = a+b;
	     int sum2 = p+q;
	     
	     if(a==p && b == q){
	         System.out.println(0);
	     }
	     else if(sum1%2==0 && sum2%2==0){
	         System.out.println(2);
	     }
	     
	     else if(sum1%2!=0 && sum2%2!=0){
	         System.out.println(2);
	     }
	     
	     else{
	         System.out.println(1);
	     }
	    }
    }

    // https://www.codechef.com/START17B/problems/GCDPRF
    // GCD of Prefixes
    public static void solveGCD(){
        int t=scn.nextInt();
		while(t-->0)
	    {
	     int n=scn.nextInt();
	     int[] a = new int[n];
	     for(int i=0;i<n;i++){
	         a[i] = scn.nextInt();
	     }
	     int div = 1;
	     for(int i=1;i<n;i++){
	         if(a[i-1]%a[i]!=0){
	             div = 0;
	             break;
	         }
	     }
	     if(div == 0){
	         System.out.println(-1);
	     }
	     else{
	      
	     for(int i=0;i<n;i++){
	           System.out.print(a[i]+" ");
	     }   
	     System.out.println();
	     }
	    }
    }

    // https://www.codechef.com/problems/BININV
    // Binary Inversion 
    public static int count(String s){
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '1')
            count++;
        }
        return count;
    }
    public static long getinvs(String s){
         long onecount = 0, ans = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '1'){
              onecount++;  
            }
            if(ch=='0'){
                ans += onecount;
            }
        }
        return ans;
    }

    public static class MyComparator implements Comparator<String> {
             public int compare(String s1, String s2){
                return count(s1) - count(s2);
            }
    }
    public static void solveInversion(){
        int t=scn.nextInt();
		while(t-->0)
	    {
	        int n = scn.nextInt();
	        int m = scn.nextInt();
	        ArrayList<String> arr = new ArrayList<>();
	        for(int i=0;i<n;i++){
	            arr.add(scn.next());
	        }
	        
            Collections.sort(arr, new MyComparator());
            StringBuilder sb = new StringBuilder();
            
            for(int i=0;i<arr.size();i++){
                String s = arr.get(i);
                sb.append(s);
            }
            
            System.out.println(getinvs(sb.toString()));
	    }
    }


    // https://www.codechef.com/START17B/problems/STRADJ
    // String Game 

    public static void solveArray(){
        int t=scn.nextInt();
		while(t-->0)
	    {
            int n=scn.nextInt();
            String s = scn.next();
              
            int c0 = 0, c1 = 0;
            for(int i=0;i<n;i++){
               char ch = s.charAt(i);
               if(ch == '0'){
                   c0++;
               }else{
                   c1++;
               }
             }
    
           if (Math.min(c0, c1) == 0) {
                System.out.println("Bob");
           }
           
           else if (Math.min(c0, c1) == 1) {
                System.out.println("Alice");
           }
           else{
               if(n%2==0){
                System.out.println("Bob");
               }
               else{
                   System.out.println("Alice");
               }
           }
    	  }
    }

    // 448. Find All Numbers Disappeared in an Array
    //     time O(n), space O(n)
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();

        int[] hash = new int[n+1];
        
        for(int i=0;i<n;i++){
            hash[nums[i]]++;
        }
        for(int i=1;i<hash.length;i++){
            if(hash[i]==0){
                list.add(i);
            }
        }
        return list;
    }

    //     time O(n) space O(1)
    // Whatever element is found in the array let us ignore that and only leave those elements in the array which are missing. 
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length, idx = 0;
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<n;i++){
                idx = Math.abs(nums[i]) - 1;
                
                if(nums[idx]>0)
                nums[idx] = -nums[idx];
        }
        
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                list.add(i+1);
            }
        }
        return list;
    }

    // 461. Hamming Distance
    public int hammingDistance(int x, int y) {
        int count=0;
        int xor = x^y;
        for(int i=0;i<32;i++){
            // System.out.println((1<<i));
            if((xor&(1<<i))!=0)
                count++;
        }
        return count;
    }

    // 540. Single Element in a Sorted Array
//     xor of all will give the ans
//     time: O(n), space O(1)
    public int singleNonDuplicate1(int[] nums) {
        int xor = 0;
        for(int ele:nums){
            xor ^= ele;
        }
        return xor;
    }
    
//     as the array is sorted so use this to optimize the solution
//     use binary search
//     time: O(log n), space O(1)
        public int singleNonDuplicate(int[] nums) {
            int n = nums.length, low = 0, high = n-1;
            while(low<high){
                int mid = low + (high- low)/2;
                if(mid%2 == 0){
                    if(nums[mid]==nums[mid+1]){
                        low = mid+2;
                    }
                    else{
                        high = mid;
                    }
                }
                else{
                    if(nums[mid] == nums[mid-1]){
                        low = mid+1;
                    }
                    else{
                        high = mid;
                    }
                }
            }
            return nums[low];
        }
    


   public static void main(String[] args){

   }



   
}