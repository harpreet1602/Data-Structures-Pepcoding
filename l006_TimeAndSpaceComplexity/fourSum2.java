import java.util.*;
public class fourSum2 {
    public static void swap(int[] arr,int i,int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static int partition(int[] arr,int pIdx,int si,int ei)
    {
        swap(arr,pIdx,ei);
        int p=si-1,itr=si;
        while(itr<=ei)
        {
            if(arr[itr]<=arr[ei])
            swap(arr,itr,++p);
            itr++;
        }
        return p;
    }
    public static void quicksort(int[] arr,int si,int ei)
    {
        if(si>ei)
        return;
        int pIdx=ei;
        int p=partition(arr,pIdx,si,ei);
        quicksort(arr,si,p-1);
        quicksort(arr,p+1,ei);
    }
    public static void twosum(int[] arr,int si,int ei,int target,int a1,int a,ArrayList<int[]> ans)
    {
        while(si<ei)
        {
            int sum=arr[si]+arr[ei];
            if(sum==target)
            {
                ans.add(new int[]{a1,a,arr[si++],arr[ei--]});
            }
            else if(sum<target)
            si++;
            else
            ei--;
        }
    }
    public static void threesum(int[] arr,int si,int ei,int ele,int target,ArrayList<int[]> ans)
    {
        for(int i=si;i<=ei;i++)
        twosum(arr,i+1,ei,target-arr[i],ele,arr[i],ans);
    }
    public static void foursum(int[] arr,int si,int ei,int target,ArrayList<int[]> ans)
    {
        for(int i=si;i<=ei;i++)
        {     
            threesum(arr,i+1,ei,arr[i],target-arr[i],ans);
        }
        for(int[] a:ans)
        {
            System.out.println(a[0]+", "+a[1]+", "+a[2]+", "+a[3]);
        }
    }
    public static void main(String[] args)
    {
        int[] arr={-2,-3,7,5,8,15,3,2,9,10,19};
        int n=arr.length;
        ArrayList<int[]> ans=new ArrayList<>();
        quicksort(arr,0,n-1);
        foursum(arr,0,n-1,38,ans);
    }    
}
