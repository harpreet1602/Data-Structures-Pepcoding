import java.util.*;
public class quickSort {
    public static void swap(int[] arr,int i,int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static int partionOverAnArray(int[] arr,int si,int ei,int pIdx)
    {
        int p=si-1,itr=si;
        while(itr<=ei)
        {
            if(arr[itr]<=arr[pIdx])
            {
                swap(arr,itr,++p);
            }
            itr++;
        }
        return p;
    }
    public static void quickSort(int[] arr,int si,int ei)
    {
        if(si>=ei)
        return;
        int idx=si,prev=si;
        // while(idx<=ei && arr[prev]<=arr[ei])
        // {
        //     prev=idx;
        //     idx++;
        // }
        // if(idx==ei+1)
        // return;
        int pIdx=ei;
        int p=partionOverAnArray(arr,si,ei,pIdx);
        quickSort(arr,si,p-1);
        quickSort(arr,p+1,ei);
    }
    public static void main(String[] args)
    {
        int[] arr={-12,2,7,4,34,23,0,1,-1,-50,16,23,7,4,2,3};
        quickSort(arr,0,arr.length-1);
        for(int ele:arr)
        {
            System.out.print(ele+" ");
        }
    }
}
