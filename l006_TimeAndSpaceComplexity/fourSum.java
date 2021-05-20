import java.util.*;
public class fourSum {
    public static void swap(int[] arr,int i,int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static int partition(int[] arr,int si,int ei,int pIdx)
    {
        swap(arr,ei,pIdx);
        int p=si-1,itr=si;
        while(itr<=ei)
        {
            if(arr[itr]<=arr[ei])
            {
                swap(arr,itr,++p);
            }
            itr++;
        }
        return p;
    }
    public static void quicksort(int[] arr,int si,int ei)
    {
        if(si>ei)
        return;
        int pIdx=ei;
        int p=partition(arr,si,ei,pIdx);
        quicksort(arr,si,p-1);
        quicksort(arr,p+1,ei);
    }
    //Myone not good
    public static void threesum(int[] arr,int target)
    {
        int n=arr.length;
        int first=0,second,third=n-1;
        while(first<=n-3)
        {
            second=first+1;
            while(second<=n-2)
            {
                int sum=arr[first]+arr[second]+arr[third];
                if(sum==target &&first!=second &&second!=third &&first!=third)
                {
                    System.out.println(arr[first]+", "+arr[second]+", "+arr[third]);
                    break;
                }
                else if(sum<target)
                {
                    second++;
                }
                else
                {
                    third--;
                }
                
            }
            first++;
        }   
    }
    //Sir code generic
    public static ArrayList<int[]> twoSum(int[] arr,int target,int si,int ei)
    {
        ArrayList<int[]> ans=new ArrayList<>();
        while(si<ei)
        {
            int sum=arr[si]+arr[ei];
            if(sum==target){
                // int[] p={arr[si++],arr[ei--]};
                // ans.add(p);
                ans.add(new int[]{arr[si++],arr[ei--]});
            }
            else if(sum<target)
            si++;
            else
            ei--;
        }
        return ans;
   }
    public static ArrayList<int[]> threesum1(int[] arr,int target,int si,int ei)
    {
        ArrayList<int[]> ans=new ArrayList<>();
        for(int i=si;i<=ei;i++)
        {
            ArrayList<int[]> smallAns=twoSum(arr, target-arr[i], i+1, ei);
            for(int[] a:smallAns)
            {
                ans.add(new int[]{arr[i],a[0],a[1]});
            }
        }
        return ans;
    }
    public static ArrayList<int[]> foursum(int[] arr,int target,int si,int ei)
    {
        ArrayList<int[]> ans=new ArrayList<>();
        for(int i=si;i<=ei;i++)
        {
            ArrayList<int[]> smallAns=threesum1(arr, target-arr[i], i+1, ei);
            for(int[] a:smallAns)
            {
                ans.add(new int[]{arr[i],a[0],a[1],a[2]});
            }
        }
        return ans;
    }

    public static void main(String[] args)
    {
        int[] arr={-2,-3,7,5,8,15,3,2,9,10,19};
        quicksort(arr,0,arr.length-1);
        // ArrayList<int[]> res=threesum1(arr,25,0,arr.length-1);
        ArrayList<int[]> res=foursum(arr,28,0,arr.length-1);
        for(int[] a:res)
        {
            System.out.println(a[0]+", "+a[1]+", "+a[2]+", "+a[3]);
        }
    }
}
