import java.util.List;
import java.util.ArrayList;


public class l001{
   
//     tc: O(n^3) sc: O(n^2)
//     gap strategy is used.
//    https://www.youtube.com/watch?v=YzvF8CqPafI
//     Make dp table then you will understand the solution
//     for every gap we go from si  to ei
//     then in that we go for bursting the current cut at the last
//      so bring the answer from left and right in that interval of (si-ei)
//    then cut ele * si-1 ele * ei+1 ele will act as the val for bursting 
//     curr cut ele and then in it as we are going for all permutations
//     go for the maximum one and then assign it into the dp
//     in the end ans will be contained like from 0 to n-1 in dp[0][n-1]
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int gap = 0;gap<n;gap++){
            for(int si=0,ei=gap;ei<n;si++,ei++){
            int max = -(int)1e9;
                for(int cut=si;cut<=ei;cut++){
                    int left = cut==si?0:dp[si][cut-1];
                    int right = cut==n-1?0:dp[cut+1][ei];
                    int currVal = (si==0?1:nums[si-1])*nums[cut]*(ei==n-1?1:nums[ei+1]);
                    int total = left+right+currVal;
                    max = Math.max(total,max);
                }
                dp[si][ei] = max;
            }
        }
        return dp[0][n-1];
    }

    //     1010. Pairs of Songs With Total Durations Divisible by 60
// check for every number for the pair
//     tle => brute force => tc O(n^2) sc O(1)
    public int numPairsDivisibleBy601(int[] time) {
        int count=0,n=time.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if((time[i]+time[j])%60==0){
                    count++;
                }
            }
        }
        return count;
    }
    
//     tc O(n) + 30 => O(n)
    // sc O(1)
    // now here if we divide a no by 60 we get remainders from 0 to 59
    // so make a array of 60 and store the remainders of all the numbers
    // then from 1 to 29 if their pair exist then the combinations will be mC1 * nC1 = m*n
    // for 0 and 30 the combinations will be pC2 = p*(p-1)/2
    public int numPairsDivisibleBy60(int[] time) {
        int[] freqMap = new int[60];
        int ans=0;
        for(int i=0;i<time.length;i++){
            int rem = time[i]%60;
            freqMap[rem]++;
        }
        
        for(int i=1;i<30;i++){
            ans += freqMap[i] * freqMap[60-i];
        }
        
        if(freqMap[0]>0)
        ans += freqMap[0]*(freqMap[0]-1)/2;
    
        if(freqMap[30]>0)
        ans += freqMap[30]*(freqMap[30]-1)/2;
        return ans;
    }
        
    
//    997. Find the Town Judge 
//    tc O(n) sc O(n) 
//     any node with outdegree = 0 && indegree = n-1 will be the town judge
    public int findJudge(int n, int[][] trust) {
        int[] inwardDegree = new int[n+1];
        int[] outwardDegree = new int[n+1];
        for(int i=0;i<trust.length;i++){
            int countOut = outwardDegree[trust[i][0]];
            outwardDegree[trust[i][0]] = countOut + 1;
            int countIn = inwardDegree[trust[i][1]];
            inwardDegree[trust[i][1]] = countIn + 1;
        }
        
        for(int i=1;i<=n;i++){
            if(outwardDegree[i] == 0 && inwardDegree[i] == n-1){
                return i;
            }
        }
        return -1;
    }

    
//     cut the string first part and check if it is a pallindrome if it is then find all the 
//     possible combinations for the second part by this method only so it is done by
//     backtracking and when full string becomes first part then add it into the ans
//     and for pallindrome reverse the string and then check
    private boolean isPallindrome(String s){
        String revStr = new StringBuilder(s).reverse().toString();
        return s.equals(revStr);
    }
    public void fillPalindrome(List<List<String>> res,List<String> currRes,String inpStr){
        if(inpStr.length()==0){
            res.add(new ArrayList<>(currRes));
            return;
        }
        for(int i=0;i<inpStr.length();i++){
            String firstPart = inpStr.substring(0,i+1);
            if(isPallindrome(firstPart)){
                String secondPart = inpStr.substring(i+1,inpStr.length());
                currRes.add(firstPart);
                fillPalindrome(res,currRes,secondPart);
                currRes.remove(currRes.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        fillPalindrome(res,new ArrayList<>(),s);
        return res;
    }

    
//     1094. Car Pooling
//     In occupancy array index, how many passengers are there at this current position
//     will be stored and the prefix sum of this will tell you have this much
//     passenger from 0 to curr pos and anytime it exceeds capacity return false
//     if not then return true
    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;
        int[] occupancy = new int[1001];
        for(int i=0;i<n;i++){
            occupancy[trips[i][1]] += trips[i][0];
            occupancy[trips[i][2]] -= trips[i][0];
        }
        int sum = 0;
        for(int i=0;i<1001;i++){
            sum += occupancy[i];
            if(sum>capacity){
                return false;
            }
        }
        return true;
    }

    // 382. Linked List Random Node
    public class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         }
// tc O(n) for random sc O(1)
// so simply maintaining the probability by the condition in the loop
// for one ele probability =1
// for two ele probability =1/2
// for three ele probability =1/1 * 1/2 *2/3 = 1/3
class Solution {
    private ListNode head = null;
    private Random rand = null;
    public Solution(ListNode head) {
         this.head = head;
         rand = new Random();
    }
    
    public int getRandom() {
        int res = -1;
        ListNode curr = this.head;
        for(int i=1;curr!=null;i++){
            if(rand.nextInt(i) == i-1){
                res = curr.val;
            }
            curr = curr.next;
        }
        return res;
    }
}

    //3D DP
// three things are getting changed one row and two columns for the robot to have a choice
// of selecting one out of three choice. When one robot will select one position for that
// the other robot will go into its three options and together wherever they will get the 
// maximum answer for the cell will be the value of that cell.
// whatever the answer comes for maxCherries is through the faith that from you how much
// maximum cherries be taken and pick the current cherry as well keeping in consideration 
// the overlapping  case as only one robot can take one cell's cherry.
// tc O(n * m^2) sc O(n * m^2) as for the worst case we need to calculate all the values.
    private int dfs(int[][] grid,int n,int m,int r,int col1,int col2,Integer[][][] dp){
        if(r<0 || r>=n || col1<0 || col1>=m || col2<0 || col2>=m){
            return 0;
        }
        
        if(dp[r][col1][col2]!=null){
            return dp[r][col1][col2];
        }
        
        int maxCherries = 0;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                int newCol1 = col1 + i;
                int newCol2 = col2 + j;
                maxCherries = Math.max(maxCherries,dfs(grid,n,m,r+1,newCol1,newCol2,dp));
            }
        }
        
        int currCherry = 0 ;
        if(col1 == col2){
            currCherry = grid[r][col1];
        }
        else {
            currCherry = grid[r][col1] + grid[r][col2];
        }
        return dp[r][col1][col2] = currCherry + maxCherries;
    }
    public int cherryPickup(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        
        Integer[][][] dp = new Integer[n][m][m];
        return dfs(grid,n,m,0,0,m-1,dp);
    }

}