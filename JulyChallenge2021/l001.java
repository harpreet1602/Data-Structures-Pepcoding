import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
public class l001{
    //leetcode 89. Gray Code
     //for n=3, copy all the answers for n=2 and then add 2^2 to all the numbers of the answer fro n=2 from the backward and it will work for me to give the gray code 
     public List<Integer> grayCode(int n) {
        if(n==0)
        {
            List<Integer> base = new ArrayList<Integer>();
            base.add(0);
            return base;
        }
       
       List<Integer> prev = grayCode(n-1);
       
       List<Integer> curr = new ArrayList<Integer>(prev);
       int addNo = (int)Math.pow(2,n-1);
       for(int i = prev.size()-1; i>=0; i--)
       {
           curr.add(prev.get(i)+addNo);
       }
       return curr;
   }


   //leetcode 658. Find K Closest Elements

   //O(n)
   public List<Integer> findClosestElements1(int[] arr, int k, int x) {
    int low=0,n=arr.length,high=n-1;
       while(high-low>=k)
       {
           if(Math.abs(x-arr[low]) > Math.abs(x-arr[high]))
               low++;
           else
               high--;
       }
        List<Integer> ans = new ArrayList<Integer>();
        for(int i=low ; i<=high; i++ )
        {
            ans.add(arr[i]);
        }
        return ans;
    
    }



    //O(log(N-k)+k)
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left=0,right=arr.length-k;
        while(left<right)            //O(log(N-k))
         {
            int mid=(left+right)/2;
            if(x-arr[mid]>arr[mid+k]-x)
            {
                left=mid+1;
                
            }
            else
                right=mid;
        }
        List<Integer> ans=new ArrayList<Integer>();
        for(int i=left;i<left+k;i++)             //O(k)
        {
            ans.add(arr[i]);
        }
        return ans;   
    }


    //leetcode 1220. Count Vowels Permutation
    
// Dp(bottom-up) time O(n) and space O(n)
    public int countVowelPermutation1(int n) {
        long[] acount = new long[n];
        long[] ecount = new long[n];
        long[] icount = new long[n];
        long[] ocount = new long[n];
        long[] ucount = new long[n];
        
        
        acount[0]=1L;
        ecount[0]=1L;
        icount[0]=1L;
        ocount[0]=1L;
        ucount[0]=1L;
        
        int Mod=1000000007;
        
        for(int i=1;i<n;i++)
        {
            acount[i] = (ecount[i-1]+icount[i-1]+ucount[i-1])%Mod;
            ecount[i] = (acount[i-1] + icount[i-1])%Mod;
            icount[i] = (ecount[i-1]+ocount[i-1])%Mod;
            ocount[i] = (icount[i-1])%Mod;
            ucount[i] = (icount[i-1]+ocount[i-1])%Mod;
        }
        long result=0L;
        result = (acount[n-1] + ecount[n-1] + icount[n-1] + ocount[n-1] +ucount[n-1])%Mod;
        return (int)result;
    }


    //Dp(bottom-up) time O(n) and space O(1)
    public int countVowelPermutation(int n) {
    long acount=1,ecount=1,icount=1,ocount=1,ucount=1;
    
    int mod=(int)1e9+7;
    for(int i=1;i<n;i++)
    {
        long acountnew=(ecount+icount+ucount)%mod;
        long ecountnew=(acount+icount)%mod;
        long icountnew=(ecount+ocount)%mod;
        long ocountnew=(icount)%mod;
        long ucountnew=(icount+ocount)%mod;
        
        acount=acountnew;
        
        ecount=ecountnew;
        
        icount=icountnew;
        
        ocount=ocountnew;
        
        ucount=ucountnew;
    }
        long result = (acount +ecount +icount +ocount +ucount )%mod; 
    return (int)result;
    }


    //leetcode 566. Reshape the Matrix

    public int[][] matrixReshape1(int[][] mat, int r, int c) {
        int m=mat.length,n=mat[0].length;
        if((m*n)!=(r*c))
        {
            return mat;
        }
        
        int[][] newmat=new int[r][c];
        int x=0,y=0;
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                newmat[i][j]=mat[x][y];
                y++;
                if(y==n)
                {
                    x++;
                    y=0;
                }
            }
        }
        return newmat;
    }
        public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m=mat.length,n=mat[0].length;
        if((m*n)!=(r*c))
        {
            return mat;
        }
        
        int[][] newmat=new int[r][c];
        int total = m*n;
            for(int i=0;i<total;i++)
            {
                newmat[i/c][i%c] = mat[i/n][i%n];
            }
        
        return newmat;
        }
        //leetcode 1338. Reduce Array Size to The Half

        //     =>I will try to explain,  in this solution what we are doing is first of all finding the maximum element of the array because all other elements will lie between 0 to max-1. 

// =>So Make a hash type array which will be used to store the frequency of each number ,How? 
// =>As we will make the element of the original array as an index in the hash type array and the value in the hash type array will be the frequency of the index number of hash type array.

// =>After that we will sort this hash type array so that the maximum frequency comes to the end of the array , now start maintaining the sum of the elements and maintain a count of the number of elements, when by the time your sum will become greater than or equal to arr.length/2 break the loop and return the count.
    public int minSetSize(int[] arr) {
        int max=-(int)1e9;
        for(int i=0;i<arr.length;i++)
        {
            max=Math.max(max,arr[i]);
        }
        int[] hash=new int[max+1];
        for(int i=0;i<arr.length;i++)
        {
            hash[arr[i]]++;
        }
        Arrays.sort(hash);
        int sum=0;
        int count=0;
        for(int i=hash.length-1;i>=0;i--)
        {
            sum+=hash[i];
            count++;
            if(sum>=arr.length/2)
                break;
        }
        return count;
    }


//718. Maximum Length of Repeated Subarray
    //bottom to top dp
    public int findLength1(int[] nums1, int[] nums2) {
        int ans=0;
        int[][] memo = new int[nums1.length+1][nums2.length+1];
        for(int i=nums1.length-1;i>=0;i--)
        {
            for(int j=nums2.length-1;j>=0;j--)
            {
                if(nums1[i]==nums2[j])
                {
                    memo[i][j]=memo[i+1][j+1]+1;
                      if(ans<memo[i][j])
                    ans=memo[i][j];
                }
              
            }
        }
        return ans;
    }
// main concept to yehi hai ki first and second arrays ke numbers ke basis par dp vale array mai ans store karvaenge
//prefix ko consider karke maximum matching suffix ki value store karani hogi

    //top to bottom dp
    public int findLength(int[] num1,int[] num2)
    {
        int[][] dp = new int[num1.length + 1][num2.length + 1];
        int ans = 0;
        for(int i = 1; i < dp.length; i++)
        {
            for(int j =1; j < dp[0].length;j++)
            {
                if(num1[i-1] == num2[j-1])
                {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    ans = Math.max(ans,dp[i][j]);
                }
            }
        }
        return ans;
    }


    //378. Kth Smallest Element in a Sorted Matrix


//brute force
O(N2)
    public int kthSmallest1(int[][] matrix, int k) {
        int n=matrix.length;
        ArrayList<Integer> arr=new ArrayList<>();
           for(int i=0;i<n;i++)
            {
            for(int j=0;j<n;j++)
                {
                    arr.add(matrix[i][j]);
                }
            }
        Collections.sort(arr);
        return arr.get(k-1);
        
    }
    
//brute force
// O(n2logk)
    public int kthSmallest2(int[][] matrix, int k) {
    int m=matrix.length,n=matrix[0].length;
    PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
        return b-a;
    });
    for(int i=0;i<m;i++)
    {
        for(int j=0;j<n;j++)
        {
            pq.add(matrix[i][j]);
            if(pq.size()>k)
                pq.remove();
        }
    }
        
        return pq.peek();
    }
    //optimised approach
    public int lessEqual(int[][] matrix,int target)
    {
        int i = matrix.length - 1, j=0,count =0;
        while(i >= 0 && j< matrix.length)
        {
            if(matrix[i][j] > target) i--;
            else
            {
                count = count + i + 1;
                j++;
            }
        }
        return count;
    }
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length,low = matrix[0][0], high = matrix[n-1][n - 1], count=0;
        while(low<high)
        {
            int mid = low + (high - low)/2;
            count = lessEqual(matrix, mid);
            if(count < k) low = mid + 1;
            else
            high = mid;
            
        }
        return low;
    }  









    //longest common substring
    //https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1
    int longestCommonSubstr(String S1, String S2, int n, int m){
        // code here
        int[][] dp = new int[S1.length()+1][S2.length()+1];
        int ans = 0;
        for(int i = 1; i < dp.length ; i++)
        {
            for(int j = 1; j < dp[0].length ; j++)
            {
                if(S1.charAt(i-1) == S2.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    ans = Math.max(ans,dp[i][j]);
                }
            }
        }
        return ans;
    }

    //first bad version
    //leetcode 
    static int bad = 0;
    public boolean isBadVersion(int val) {
        if (val >= bad) {
          return true;
        }
        else {
          return false;
        }
      }
      public void solve(int n, int fbv) {
        bad = fbv;
        System.out.println(firstBadVersion(n));
      }
    
    public int firstBadVersion1(int n) {
        for(int i=1;i<n;i++)
        {
            if(isBadVersion(i))
            {
                 return i;
            }
        }
        return n;
    }
    public int firstBadVersion(int n)
    {
          int low=1,high=n;
        while(low<high)
        {
            int mid=low+(high-low)/2;
            if(isBadVersion(mid))
            {
                high=mid;
            }
            else
            {
                low=mid+1;
            }
        }
        return low;
    }


    //240. Search a 2D Matrix II
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n=matrix[0].length, row = 0, col = n-1;
        while( col>=0 && row <m)
        {
            if(matrix[row][col] == target)
            {
                return true;
            }
            else if(matrix[row][col] < target)
            {
                row++;
            }
            else
            {
                col--;
            }
        }
        return false;       
    }

    
    //leetcode 74. Search a 2D Matrix
    public int binarySearchRowSelect(int[][] matrix,int target)
    {
        int m = matrix.length,n =matrix[0].length, low = 0, high = m-1, lc = n-1;
        while(low<=high)
        {
            int mid = low + (high - low)/2;
            if(matrix[mid][0] <= target && matrix[mid][lc] >= target)
            {
                return mid;
            }
            else if(matrix[mid][0] < target)
            low = mid + 1;
            else if(matrix[mid][0] > target)
            {
               high = mid-1; 
            }
        }
        return -1;
    }
    
    public boolean binarySearch(int[][] matrix, int row,int target)
    {
        int low = 0, high = matrix[0].length-1;
        while(low<=high)
        {
            int mid = low + (high - low)/2; 
            if(matrix[row][mid] == target)
            return true;
            
            else if(matrix[row][mid] > target)
            high = mid-1;
            
            else
            low = mid + 1;
        }
        return false;
    }
   
    
    public boolean searchMatrix1(int[][] matrix, int target) {
    int row = binarySearchRowSelect(matrix,target);
    
    if(row == -1)
    return false;
    
    boolean res = binarySearch(matrix,row,target);
    
    return res;
    
        
    } 
    

    //300. Longest Increasing Subsequence
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int omax = 0;
        for(int i = 0 ;i < n; i++)
        {
            int max = 0;
            for(int j = 0;j<i;j++)
            {
                if(nums[j]<nums[i])
                {
                    if(dp[j]>max)
                        max = dp[j]; 
                }
            }
            dp[i] = max + 1;
            if(dp[i] > omax)
                omax = dp[i]; 
        }
        return omax;
    }

    //91. Decode Ways
    public int numDecodings(String str) {
        int n=str.length();
        int[] dp = new int[n];
        if(n>0 && str.charAt(0)=='0')
            return 0;
        dp[0] = 1;
        for(int i = 1; i<n ;i++)
        {
            if(str.charAt(i-1)=='0' && str.charAt(i)=='0')
                   dp[i] = 0;
            else if(str.charAt(i-1)=='0' && str.charAt(i)!='0'){
                    dp[i] = dp[i-1];        
                }
            else if(str.charAt(i-1)!='0' && str.charAt(i)=='0'){
                if(str.charAt(i-1)=='1' || str.charAt(i-1)=='2'){    
                dp[i] = (i >=2)? dp[i-2] : 1;
                }
                }
            else {
                    if(Integer.parseInt(str.substring(i-1,i+1)) <= 26 )
                    {
                        dp[i] = dp[i-1] + ((i >=2)? dp[i-2] : 1);   
                    }
                    else
                    {
                        dp[i] = dp[i-1];
                    }
                }
        }
        return dp[n-1];
    }
    
    public class MedianFinder{
    public PriorityQueue<Integer> small;
    public PriorityQueue<Integer> large;
    
    public MedianFinder() {
        small = new PriorityQueue<>((a,b)->{
       return b-a; 
        });
        large = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(large.size()>0 && num > large.peek())
        {
            large.add(num);
        }
        else
        {
            small.add(num);
        }
        
        if((large.size()-small.size())==2)
        {
            small.add(large.remove());
        }
        else if((small.size()-large.size())==2)
        {
            large.add(small.remove());
        }
        
    }
    
    public double findMedian() {
        if(small.size() == large.size())
        {
            return (small.peek()+large.peek())/2.0;
        }
        else if(large.size()>small.size())
        {
            return large.peek();
        }
        
        else
        {
            return small.peek();
        }
    }

    }

}