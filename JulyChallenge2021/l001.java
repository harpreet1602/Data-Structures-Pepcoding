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

}