import java.util.*;
public class l001{
    public static Scanner scn = new Scanner(System.in);
    //1p
    public static void sort01(int[] arr){
        //write your code here
        int p=-1,itr=0;
        while(itr<arr.length)
        {
            if(arr[itr]==0)
            {
                swap(arr,itr,++p);
            }
            itr++;
        }
      }

    
      // used for swapping ith and jth elements of array
      public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping index " + i + " and index " + j);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    
      public static void print(int[] arr){
        for(int i = 0 ; i < arr.length; i++){
          System.out.println(arr[i]);
        }
      }
      //2p
  public static void sort012(int[] arr){
    //write your code here
    int p=-1,itr=0,q=arr.length;
    while(itr<q)
    {
        if(arr[itr]==0)
        {
            swap(arr,itr,++p);
            itr++;
        }
        else if(arr[itr]==1)
        {
            itr++;
        }
        else 
        {
            swap(arr,itr,--q);
        }
    }
  }
  //2 portal sir 
  public static void sortSir012(int[] arr){
    //write your code here
    int p=-1,itr=0,q=arr.length-1;
    while(itr<=q)
    {
        if(arr[itr]==0)
        {
            swap(arr,itr++,++p);
        }
        else if(arr[itr]==2)
        {
            swap(arr,itr,q--);
        }
        else 
        {
            itr++;
        }
    }
  }
  //3p
  public static void mergeWithNoSpace(int[] arr1, int[] arr2) {
    //Write your code here
    int i=0,j=0,k=0,n=arr1.length,m=arr2.length;
    int[] ans=new int[n+m];
    while(i<n && j<m)
    {
        if(arr1[i]<arr2[j])
        {
            ans[k++]=arr1[i++];
        }
        else
        {
           ans[k++]=arr2[j++];
        }
    }
    while(i<n){
        ans[k++]=arr1[i++];
    }
    while(j<m)
    {
        ans[k++]=arr2[j++];
    }
    for(int g=0;g<ans.length;g++)
    {
        System.out.print(ans[g]+" ");
    }
   }
   public static void mergeWithNoSpace1(int[] arr1, int[] arr2)
   {
       int i=0,j=0,k=0,n=arr1.length,m=arr2.length;
       int[] ans=new int[n+m];
       while(i<n || j<m)
       {
          long val1=(i<n)?arr1[i]:(long)1e18;
          long val2=(j<m)?arr2[j]:(long)1e18;
          if(val1<val2)
          {
              ans[k++]=(int)val1;
              i++;
          }
          else {
              ans[k++]=(int)val2;
              j++;
          }
       }
       for(int g=0;g<ans.length;g++)
       {
           System.out.print(ans[g]+" ");
       }
   }
   public static void mergeWithNoSpace2(int[] arr1, int[] arr2)
   {
       int i=0,j=0,k=0,n=arr1.length,m=arr2.length;
       int[] ans=new int[n+m];
       while(i<n || j<m)
       {
           if(i==n)
           {
               ans[k++]=arr2[j++];
           }
           else if(j==m)
           {
               ans[k++]=arr1[i++];
           }
           else if(arr1[i]<arr2[j])
           {
               ans[k++]=arr1[i++];
           }
           else 
           {
               ans[k++]=arr2[j++];
           }
       }
       for(int h=0;h<ans.length;h++)
       {
          System.out.print(ans[h]+" ");
       }
   }
   
   //4 BUBBLE SORT  
   //Best,Average,Worst case complexity=O(n^2)
   public static void bubbleSort(int[] arr) {
    //write your code here
    int n=arr.length;
    for(int i=0;i<n;i++)
    {
        for(int j=1;j<n-i;j++)
        {
            if(isSmaller(arr,j,j-1))
            swap1(arr,j,j-1);
        }
    }
  }

  // used for swapping ith and jth elements of array
  public static void swap1(int[] arr, int i, int j) {
    System.out.println("Swapping " + arr[i] + " and " + arr[j]);
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  // return true if ith element is smaller than jth element
  public static boolean isSmaller(int[] arr, int i, int j) {
    System.out.println("Comparing " + arr[i] + " and " + arr[j]);
    if (arr[i] < arr[j]) {
      return true;
    } else {
      return false;
    }
  }
  //Best Case in the case of Bubble sort optimised=O(n) when the array is completely sorted
  public static void bubbleSortOptimized(int[] arr) {
    int n=arr.length;
    for(int li=n-1;li>0;li--)
    {
        boolean isSorted=true;
        for(int i=1;i<=li;i++)
        {
            if(isSmaller(arr,i,i-1))
            {
                isSorted=false;
                swap(arr,i,i-1);
            }
        }
        if(isSorted)
        {
            break;
        }
    }
   }
   //5 Selection sort
   //Best,Average,Worst case complexity=O(n^2)
   public static void selectionSort(int[] arr) {
    //write your code here
    int n=arr.length;
    for(int i=0;i<n-1;i++)
    {
        int minIdx=i;
        for(int j=i+1;j<n;j++)
        {
            if(isSmaller(arr,j,minIdx))
            {
                minIdx=j;
            }
        }
        swap(arr,i,minIdx);
    }
  }
   //6 Insertion sort 
   //Best case complexity=O(n)
   //Worst,Average Case complexity=O(n^2)
   public static void insertionSort(int[] arr) {
    //write your code here
    int n=arr.length;
    for(int i=1;i<n;i++)
    {
        int j=i-1;
        int temp=i;
        while(j>=0)
        {
            if(isGreater(arr,j,temp))
            {
                swap(arr,j,temp);     
                temp=j;
                j--;
            }
            else
            break;
        }
    }
  }
  //6.sir ka tareeka
  public static void insertionSort1(int[] arr) 
{
    int n=arr.length;
    for(int i=1;i<n;i++)
    {
        for(int j=i;j>0;j--)
        {
            if(isGreater(arr,j-1,j))
            {
                swap(arr,j-1,j);
            }
            else
            break;
        }
    }
}
 // return true if jth element is greater than ith element
 public static boolean isGreater(int[] arr, int j, int i) {
    System.out.println("Comparing " + arr[i] + " and " + arr[j]);
    if (arr[i] < arr[j]) {
      return true;
    } else {
      return false;
    }
  }
//7. Partition an array
    public static void partition(int[] arr, int pivot){
    //write your code here
    int p=-1,itr=0,n=arr.length;
    while(itr<n)
    {
        if(arr[itr]<=pivot)
        {
            swap(arr,itr,++p);
        }
        itr++;
    }
    
    }
    public static int partition2(int[] arr,int pivot)
    {
        int n=arr.length;
        int itr=0,p=n-1;
        while(itr<=p){
            if(arr[itr]>pivot)
            {
                swap(arr,itr,p--);
            }
            else
            itr++;
        }
        return p;
    }
    //Partition an array with pivot index
    public static void partitionWithIndex(int[] arr,int index)
    {
        int n=arr.length;
        swap(arr,index,n-1);
        int p=-1,itr=0,li=n-1;
        while(itr<li)
        {
            if(arr[itr]<=arr[li])
            {
                swap(arr,itr,++p);
            }
            itr++;
        }
        swap(arr,n-1,++p);
    }

      public static void main(String[] args) throws Exception {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ;i < n; i++){
          arr[i] = scn.nextInt();
        }
        // sort01(arr);
        // partitionWithIndex(arr, 3);
        partition(arr, 4);
     //  System.out.println("\nIndex: "+partition2(arr,4));
        print(arr);
        
      }
    
}