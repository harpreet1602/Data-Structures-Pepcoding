import java.util.*;
public class l002 {
public static Scanner scn=new Scanner(System.in);

public static void displayArr(int[] arr, int idx){
    if(idx==arr.length)
    return;
    
    System.out.println(arr[idx]);
    displayArr(arr,idx+1);
}
public static void displayArrReverse(int[] arr, int idx) {
    if(idx==arr.length)
    return;
    displayArrReverse(arr,idx+1);
    System.out.println(arr[idx]);
    }
    public static int maxOfArray(int[] arr, int idx){
        if(idx==arr.length)
        {
            return -(int)1e9;
        }
        int recMax=maxOfArray(arr,idx+1);
        return Math.max(recMax,arr[idx]);
    }
    public static int firstIndex(int[] arr, int idx, int x){
        if(idx==arr.length)
        return -1;
        if(arr[idx]==x)
        {
        return idx;
        }
        return firstIndex(arr,idx+1,x);
    }
    public static int lastIndex(int[] arr,int idx,int data)
    {
    if(idx==arr.length)
    return -1;
    int ind=lastIndex(arr,idx+1,data);
    if(ind==-1&&arr[idx]==data)
    {
        ind=idx;
    }
    return ind;
    }
    public static int[] allIndices(int[] arr, int x, int idx, int fsf) {
        // write ur code here
        if(idx==arr.length)
        return new int[fsf];
        if(arr[idx]==x)
        fsf++;
        int[] ans=allIndices(arr,x,idx+1,fsf);
        if(arr[idx]==x)
        ans[fsf-1]=idx;
        return ans;
    }
    public static void main(String[] args) throws Exception {
        // write your code here
        int n=scn.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=scn.nextInt();
        }
        displayArr(arr,0);
    }

   
}
