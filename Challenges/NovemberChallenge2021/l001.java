import java.util.List;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;
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
   public static void main(String[] args){

   }



   
}