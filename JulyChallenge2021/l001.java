import java.util.List;
import java.util.ArrayList;
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


}