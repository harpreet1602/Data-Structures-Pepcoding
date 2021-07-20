import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Random;

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

    //In this approach we have to create two hashmaps in which one is of character to character
    // type to map one character to the other and the second is for the second string's character
    // whether they are used or not that is of character to boolean type.
    // If the first character is mapped then if not mapped to the current value in the second string 
    //then two strings are not isomorphic strings.If the character in the first string is not mapped but the 
    //character in the second string is used already then they are not isomorphic strings
    //If the above mentioned conflicts don't come so the two strings are isomorphic.


    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())
            return false;
        HashMap<Character,Character> map1 = new HashMap<>();
        HashMap<Character,Boolean> map2 = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++)
        {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            
            if(map1.containsKey(ch1)==true)
            {
                if(map1.get(ch1)!=ch2)
                {
                    return false;
                }
            }
            else
            {
                if(map2.containsKey(ch2)==true)
                {
                    return false;
                }
                else
                {
                    map1.put(ch1,ch2);
                    map2.put(ch2,true);
                }
            }
        }
        
        return true;
    }

    //leetcode 162. Find Peak Element

        //time O(n) space O(1)
        public int findPeakElement(int[] nums) {
            int max=0;
            int left=0,right=0;
            for(int i=0;i<nums.length;i++)
            {
                left=i>0?nums[i-1]:Integer.MIN_VALUE;
                right=i<nums.length-1?nums[i+1]:Integer.MIN_VALUE;
                if(nums[i]>left && nums[i]>right)
                {
                    max=i;
                    break;
                }
            }
            return max;
        }
    
        //optimized
            //time:O(log(n)) space: O(1)
     public int findPeakElementOptimized(int[] nums) {
        int low=0,high=nums.length,max=0,left=0,right=0;
         while(low<=high)
         {
            int mid=(low+high)/2;
            left=mid>0?nums[mid-1]:Integer.MIN_VALUE;
            right=mid<nums.length-1?nums[mid+1]:Integer.MIN_VALUE;
            if(nums[mid]>left && nums[mid]>right)
            {
                max=mid;
                break;
            }
            else if(nums[mid]<=left)
            {
                high=mid-1;
            }
             else if(nums[mid]<=right)
             {
                low=mid+1;
             }
         }
         return max;
     }



     
     
//O(n^3) time and space O(1)
public int triangleNumber1(int[] nums) {
    int count =0 ;
    for(int i = 0;i<nums.length;i++)
    {
        for(int j=i+1;j<nums.length;j++)
        {
            for(int k=j+1;k<nums.length;k++)
            {
                if(nums[i]+nums[j]>nums[k] && nums[j] + nums[k]>nums[i] && nums[i]+nums[k]>nums[j])
                {
                    count++;
                }
            }
        }
    }
    return count;
}
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int i = nums.length-1,l,r,count=0;
            
        while(i>=2)
        {
            l=0;
            r=i-1;
        while(l<r)
        {
        if(nums[l]+nums[r]>nums[i])
        {
            count=count+r-l;
            r--;
        }
        else
        {
            l++;
        }
        }    
        i--;
        }
        return count;
        
    }



    //[1,2,3,1]
    // [1,2,1,3,5,6,4]
    // [-2147483648]
    //
    // [-2147483648,-2147483647]


     public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i<nums.length-3;i++) 
        {
            if(i!=0 && nums[i]==nums[i-1])
                continue;
            for(int j = i+1; j<nums.length-2;j++)
            {
                if(j!=i+1 && nums[j]==nums[j-1])
                    continue;
                int left = j+1,right=nums.length-1;
                while(left<right)
                {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target)
                    {
                        ArrayList<Integer> small = new ArrayList<>();
                        small.add(nums[i]);
                        small.add(nums[j]);
                        small.add(nums[left]);
                        small.add(nums[right]);
                        list.add(small);
                        
                        left++;
                        right--;
                        
                        while(left<right && nums[left]==nums[left-1])
                        {
                            left++;
                        }
                        while(left<right && nums[right] == nums[right+1])
                        {
                            right--;
                        }
                    }
                    else if(sum < target)
                    {
                           left++;
                    }
                    else
                    {
                        right--;
                    }
                }
            }
        }
        return list;
    }

    // time O(n) space: O(1)
    // in this ques, I have to see the total no of 1s first if it is not divisible by 3 then there not a possible answer 
    // if there are all zeroes return {0,2} because that will indicate the cut after 0 and after 1 and three equal parts are zero
    // then divide the noOf1s by 3 and run a loop over the array and check if whenever you get a 1 which one 1 it is 
    // of which part by the conditions implied once you get the indexOfFirst1InEachPart then run a loop till
    // indexOfFirst1Part2 goes out of array and checking the condition whether the numbers equal in each part if not 
    // return {-1,-1} if yes then after the loop return the value {indexOfFirst1Part0 - 1,indexOfFirst1Part1} 
    // because we have come up one step ahead of a cut. 
    public int[] threeEqualParts(int[] arr) {
        int noOf1s=0;
        for(int i = 0;i < arr.length;i++)
        {
            noOf1s+=arr[i];
        }
        if(noOf1s%3!=0)
        {
            return new int[]{-1,-1};
        }
        if(noOf1s == 0)
        {
            return new int[]{0,2};
        }
        
        int indexOfFirst1Part0=-1,indexOfFirst1Part1=-1,indexOfFirst1Part2=-1;
        int noOf1sInEachPart = noOf1s/3;
        noOf1s=0;
        for(int i = 0 ; i< arr.length;i++)
        {
            if(arr[i]==1)
            {
            noOf1s+=arr[i];
            if(noOf1s==noOf1sInEachPart+1)
            {
                indexOfFirst1Part1=i;
            }
            else if(noOf1s== 2 * noOf1sInEachPart + 1)
            {
                indexOfFirst1Part2=i;
            }
            else if(noOf1s==1)
            {
                indexOfFirst1Part0=i;
            }
            }
        }
        
        
        while(indexOfFirst1Part2 < arr.length)
        {
            if(arr[indexOfFirst1Part2] == arr[indexOfFirst1Part0] && arr[indexOfFirst1Part2] == arr[indexOfFirst1Part1])
            {
                indexOfFirst1Part2++;
                indexOfFirst1Part1++;
                indexOfFirst1Part0++;
            }
            else 
                return new int[]{-1,-1};
        }
        return new int[]{indexOfFirst1Part0 - 1,indexOfFirst1Part1};
        
        
    }

    public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         }

        //leetcode 25 time:O(n) space: O(1)
        //k group karke th tt oh ot ka concept use karke reverse karte chalo 
    public int size(ListNode node)
    {
        ListNode curr=node;
        int count=0;
        while(curr!=null)
        {
            count++;
            curr=curr.next;
        }
        return count;
    }
    public ListNode th=null,tt=null;
    public void addFirst(ListNode node)
    {
        if(th==null)
            tt=node;
        
        node.next=th;
        th=node;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null || k<1)
            return head;
        int size = size(head);
        ListNode oh,ot,c,f;
        oh=ot=null;
        c=head;
        f=head.next;
        while(size>=k)
        {
            int smallSize=k;
            while(smallSize>0)
            {   
                // f=c.next;
                c.next=null;
                addFirst(c);
                c=f;
                if(c!=null)
                f=c.next;
                smallSize--;
            }
            if(oh==null)
            {
                oh=th;
                ot=tt;
            }
            else
            {
                ot.next=th;
                ot=tt;
            }
            tt=th=null;
            size-=k;
        }
        ot.next=c;
        return oh;
    }


    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }

        //  235. Lowest Common Ancestor of a Binary Search Tree
    // pehli essi node o range mai  aajaye bst mai vohi answer hoga
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root.val>p.val && root.val>q.val)
        {
            return lowestCommonAncestor(root.left, p, q);
        }
        
        
        else if(root.val<p.val && root.val<q.val)
        {
           return lowestCommonAncestor(root.right, p, q);
        }
        else
        {
            return root;
        }
        
    }

    //Random class is used to get a random number
    public int[] original; 
    public Random random;
    
 public l001(int[] nums) {
    this.original = nums;
     this.random = new Random();
      
}
  
  public void swap(int[] arr,int i,int j)
  {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
  }
      
          /** Resets the array to its original configuration and return it. */
  public int[] reset() {
      return original;
  }

  //here fisher yarts algorithm is used
  //Time complexity is O(n)
  
  /** Returns a random shuffling of the array. */
  public int[] shuffle() {
      if(original.length==0)
          return original;
      int[] a = original.clone();
      for(int i = original.length-1;i>0;i--)
      {
          int j = random.nextInt(i+1);    //0 uptil original.length  (one higher index is needed)
          swap(a,i,j);
      }
      return a;
  }


}