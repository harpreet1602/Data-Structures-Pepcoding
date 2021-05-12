import java.util.*;

public class l004_arrays {
    public static Scanner scn=new Scanner(System.in);
    public static void test(int n)
    {
        int[] arr=new int[n];
        System.out.print(arr);
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=scn.nextInt();
        }
        
    }
    public static int[] input(int n)
    {
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=scn.nextInt();
        }
        return arr;
    }
    public static void display(int[] arr)
    {
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
    public static void display2(int[] arr)
    {
        //forEach loop
        //1.get
        // 2.auto increment by 1
        // 3.always move in forward direction
        //4.range of loop: [0,n-1]
        for(int ele:arr)
        {
            System.out.print(ele+" ");
        }
        System.out.println();
    }
    //don't take arr[0] as intial element because array can 
    //be of size 0 
    public static int maximum(int[] arr)
    {
        int max=-(int)1e9-1;
        for(int ele:arr)
        {
            if(ele>max)
            {
                max=ele;
            }
        }
        return max;
    }
    public static int minimum(int[] arr)
    {
        int min=(int)1e9+1;
        for(int ele:arr)
        {
            if(ele<min)
            min=ele;
        }
        return min;
    }
    public static int find(int[] arr,int num)
    {
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==num)
            {
                return i;
            }
        }
        return -1;
    }
    //1.span of array
    public static int Span(int[] arr)
{
    int max=-(int)1e9-1;
    int min=(int)1e9+1;
    for(int ele:arr)
    {
        max=Math.max(max,ele);
        min=Math.min(min,ele);
    }
    return max-min;
}
//2.find an ele in array
public static int find(int d,int[] arr)
{
    for(int i=0;i<arr.length;i++)
    {
        if(arr[i]==d)
        {
            return i;
        }
    }
    return -1;
}
//3.reverse an array
public static void swap(int[] arr,int i,int j)
{
    int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
}
public static void reverse(int[] arr)
{
    int i=0,j=arr.length-1;
    while(i<j)
    {
        swap(arr,i,j);
        i++;
        j--;
    }
    display(arr);
}
//4.inverse of an array
public static void inverseofarray(int[] arr)
{
    int[] result=new int[arr.length];
    for(int i=0;i<arr.length;i++)
    {
        result[arr[i]]=i;
    }
    display(result);
}
//5.Rotate an array
public static int[] rotate(int[] a, int k){
    // write your code here
    //extra space
    int n=a.length;
    int[] b=new int[n];
    k=k%n;
    if(k<0)
    {
        k=k+n;
    }
    for(int i=0;i<n;i++)
    {
        int index=(i+k)%n;
        b[index]=a[i];
    }
    return b;
  }
  //not extra space
  public static void reverse(int[] a,int i,int j)
  {
      while(i<j)
      {
      int temp=a[i];
      a[i]=a[j];
      a[j]=temp;
      i++;
      j--;
      }
  }
  public static void rotate1(int[] a,int k)
  {
      int n=a.length;
      k%=n;
      if(k<0)
      {
        k+=n;
      }
      reverse(a,0,n-1);
      reverse(a,0,k-1);
      reverse(a,k,n-1);
  }
  //6.Sum of two arrays
  public static void SumOfTwoArrays(int[] arr1,int[] arr2)
{
    int m=arr1.length;
    int n=arr2.length;
    int o,carry=0;
    o=Math.max(m,n)+1;
    int[] arr3=new int[o];
    int sum=0;
    int i=m-1,j=n-1,k=o-1;
    while(k>=0)
    {
        sum=carry + (i>=0?arr1[i]:0)+ (j>=0?arr2[j]:0);
        arr3[k]=sum%10;
        carry=sum/10;
        i--;
        j--;
        k--;
    }
    for(int ind=0;ind<arr3.length;ind++)
    {
        if(ind==0 && arr3[ind]==0) continue;
        System.out.println(arr3[ind]);
    }
}
//7.subtract of two arrays
public static void subtractOfTwoArray1(int[] a1,int[] a2)
{
    int[] diff=new int[a2.length];
    int i=a2.length-1;
    int j=a1.length-1;
    int k=diff.length-1,vala1,c=0,d=0;
    while(k>=0)
    {
        
        vala1=j>=0?a1[j]:0;
        if(a2[i]+c>=vala1)
        {
            d=a2[i]+c-vala1;
            c=0;
        }
        else
        {
            d=a2[i]+c+10-vala1;
            c=-1;
        }
            diff[k]=d;
            i--;
            j--;
            k--;
    }
    int idx=0;
    while(idx<diff.length)
    {
        if(diff[idx]==0)
        {
            idx++;
        }
        else 
        break;
    }
    if(idx==diff.length)
    {
        System.out.println(diff[idx-1]);
    }
    else
    {
    while(idx<diff.length)
    {
        System.out.println(diff[idx]);
        idx++;
    }
    }
}
//15.print subsets
public static void printInRange(int[] arr,int sti,int edi)
{
    while(sti<=edi)                                       // O(n) time
    {
        System.out.print(arr[sti]+"\t");
        sti++;
    }
}
public static void printSubarray(int[] arr)
{
    int n=arr.length;
    for(int i=0;i<n;i++)            //O(n^2) time
    {                               //So total time is O(n^3)
        for(int j=i;j<n;j++)
        {
            printInRange(arr,i,j);
            System.out.println();
        }
    }
}
public static int binaryNumber(int[] arr,int data)
{
    int sti=0,edi=arr.length-1;
    while(sti<=edi)
    {
        int mid=(sti+edi)/2;
        if(arr[mid]==data)
        return mid;
        else if(arr[mid]<data)
        sti=mid+1;
        else
        edi=mid-1;
    }
    return -1;
}
//16.print subsets
public static void printSubsets(int[] arr)
{
    int n=arr.length;
    int num=1;
    for(int i=0;i<n;i++)
    {
        num*=2;
    }
    for(int i=0;i<num;i++)
    {
        int temp=i;
        String str="";
        int j=n-1;
        for(int k=0;k<n;k++)
        {
            int digit=temp%2;
            temp=temp/2;
            if(digit==1)
            {
                str=arr[j]+"\t"+str;
            }
            else
            {
                str="-"+"\t"+str;
            }
            j--;
        }
        System.out.println(str);
    }
}
//17.first index and last index of an element
public static int firstIndex(int[] arr,int data)
{
    int low=0,high=arr.length-1;
    while(low<=high)
    {
        int mid=(low+high)/2;
        if(arr[mid]==data)
        {
            if((mid-1)>=0 &&arr[mid-1]==data)
            {
                high=mid-1;
            }
            else 
            {
                return mid;
            }
        }
        else if(arr[mid]<data)
        {
            low=mid+1;
        }
        else
        high=mid-1;
    }
    return -1;
}
public static int lastIndex(int[] arr,int data)
{
    int n=arr.length;
    int low=0,high=n-1;
    while(low<=high)
    {
        int mid=(low+high)/2;
        if(arr[mid]==data)
        {
            if((mid+1)<n &&arr[mid+1]==data)
            low=mid+1;
            else
            return mid;
        }
        else if(data<arr[mid])
        {
            high=mid-1;
        }
        else
        low=mid+1;
    }
    return -1;
}

    public static void main(String[] args)
    {
     //   test(scn.nextInt());
        int n=scn.nextInt();
        //int no;
        int[] arr=input(n);
        display2(arr);
        // System.out.println("Max is: "+maximum(arr));
        // System.out.println("Min is: "+minimum(arr));
        // no=scn.nextInt();
        // System.out.println(no+" is at : "+find(arr,no));
       // inverseofarray(arr);
       //printSubarray(arr);
       //System.out.println(binaryNumber(arr, 10));

    }
}
