public class twoSum {
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
            {
                swap(arr,itr,++p);
            }
            itr++;
        }
        return p;
    }
    public static void quickSort(int[] arr,int si,int ei)
    {
        if(si>ei)
        return;
        int pIdx=ei;
        int p=partition(arr,pIdx,si,ei);
        quickSort(arr,si,p-1);
        quickSort(arr,p+1,ei);
    }
    //Time Complexity=O(NlogN)
  public static void targetSumPair(int[] arr, int target){
    //write your code here
    quickSort(arr,0,arr.length-1);
    int n=arr.length;
    int si=0,ei=n-1;
    while(si<ei)
    {
        int sum=arr[si]+arr[ei];
        if(sum==target)
            System.out.println(arr[si++]+", "+arr[ei--]);
        else if(sum<target)
        si++;
        else
        ei--;
    }
  }
  public static void main(String[] args)
  {
      int[] arr={10,5,4,-1,3,2};
      targetSumPair(arr, 9);

  }
}
