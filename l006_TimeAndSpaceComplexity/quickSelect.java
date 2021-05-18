import java.util.*;
public class quickSelect {
    public static void swap(int[] arr,int i,int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static int partition(int[] arr,int pivot,int si,int ei)
    {
        int p=si-1,itr=si;
        swap(arr,pivot,ei);
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
    public static void quickSort(int[] arr,int si,int ei,int idx)
    {
        if(si>ei)
        return;
        int pivot=ei;
        int p=partition(arr,pivot,si,ei);
        if(p==idx)
        {
            return;
        }
        else if(idx<p)
        {
            quickSort(arr,si,p-1,idx);
        }
        else
        {
            quickSort(arr,p+1,ei,idx);
        }
    }
    public static int quickselect(int[] arr, int lo, int hi, int k) {
      //write your code here
      int n=arr.length;
     quickSort(arr,0,n-1,n-k);
     return arr[n-k];
    }
    //kth smallest
    public static int quickselectSmallest(int[] arr, int lo, int hi, int k) {
      //write your code here
      int n=arr.length;
     quickSort(arr,0,n-1,k);
     return arr[k];
    }
    public static void main(String[] args)
    {
        int[] arr={7,-2,4,1,3};
        int k=1;
       System.out.println(quickselect(arr, 0, arr.length-1, 1));
       System.out.println(quickselectSmallest(arr, 0, arr.length-1, k-1));
    }

}
