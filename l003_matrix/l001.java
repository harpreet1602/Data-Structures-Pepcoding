import java.util.*;
import java.util.concurrent.CountDownLatch;
public class l001 {
public static Scanner scn=new Scanner(System.in);
public static void input(int[][] arr)
{
    int n=arr.length;
    int m=arr[0].length;
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<m;j++)
        {
            arr[i][j]=scn.nextInt();   
        }
    }
} 
public static void output(int[][] arr)
{
    int n=arr.length;
    int m=arr[0].length;
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<m;j++)
        {
            System.out.print(arr[i][j]+" ");
        }
        System.out.println();
    }
}
public static int maximum(int[][] arr)
{
    int n=arr.length;
    int m=arr[0].length,max=-(int)1e9;
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<m;j++)
        {
            if(arr[i][j]>max)
            {
                max=arr[i][j];
            }
        }
    }
    return max;
}
public static int minimum(int[][] arr)
{
    int n=arr.length;
    int m=arr[0].length;
    int min=(int)1e9;
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<m;j++)
        {
            if(arr[i][j]<min)
            min=arr[i][j];
        }
    }
    return min;
}
public static boolean find(int[][] arr,int data)
{
    int n=arr.length;
    int m=arr[0].length;
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<m;j++)
        {
            if(data==arr[i][j])
            {
                return true;
            }
        }
    }
    return false;
}
//Wave raversal left to right then right to left and then repeat
public static void waveTraversal1(int[][] arr)
{
    int n=arr.length;
    int m=arr[0].length;
    for(int i=0;i<n;i++)
    {
        if(i%2==0)
        {
        for(int j=0;j<m;j++)
        {
            System.out.print(arr[i][j]+" ");
        }
        }
        else
        
            for(int j=m-1;j>=0;j--)
            {
                System.out.print(arr[i][j]+" ");
            }
        }
     }
//wave traversal from up to down and down to up and repeat (state of wakanda1)
public static void stateOfWakanda1(int[][] arr)
{
    int n=arr.length;
    int m=arr[0].length;
    for(int j=0;j<m;j++)
    {
        if(j%2==0)
        {   
            for(int i=0;i<n;i++)
            {
                System.out.println(arr[i][j]);
            }
        }
        else
        {
            for(int i=n-1;i>=0;i--)
            {
                System.out.println(arr[i][j]);
            }
        }
    }
}

//print upper diagonal state of wakanda 2
public static void stateOfWakanda2(int[][] arr)
{
    int i,j;
    int n=arr.length,m=arr[0].length;
    for(int gap=0;gap<m;gap++)
    {
        for(i=0,j=gap;i<n&&j<m;i++,j++)
        {
            System.out.println(arr[i][j]);
        }
    }
}
//print lower diagonals along with upper diagonals
public static void printFullDiagonal(int[][] arr)
{
    int i,j;
    int n=arr.length;
    int m=arr[0].length;
    for(int gap=n-1;gap>=1;gap--)
    {
        for(i=gap,j=0;i<n && j<m;i++,j++)
        {
            System.out.print(arr[i][j]+" ");
        }
    }
    for(int gap=0;gap<m;gap++)
    {
        for(i=0,j=gap;i<n&&j<m;i++,j++)
        {
            System.out.print(arr[i][j]+" ");
        }
    }
    System.out.println();
}
public static void printFloorCeil(int[] arr,int data)
{
    int floor=-(int)1e9,ceil=(int)1e9;
    int low=0,high=arr.length;
    while(low<=high)
    {
        int mid=(low+high)/2;
        if(data==arr[mid])
        {
            floor=ceil=arr[mid];
            break;
        }
        else if(data<arr[mid])
        {
            high=mid-1;
            ceil=arr[mid];
        }
        else
        {
            low=mid+1;
            floor=arr[mid];
        }
    }
    System.out.println(ceil);
    System.out.println(floor);
}
//spiral display anticlockwise
public static void printSpiral(int[][] arr)
{
    int n=arr.length;
    int m=arr[0].length;
    int tnel=n*m;
    int rmin=0,rmax=n-1,cmin=0,cmax=m-1;
    while(tnel>0)
    {
        for(int r=rmin;r<=rmax&&tnel>0;r++)
        {
            System.out.println(arr[r][cmin]);
            tnel--;
        }
        cmin++;
        for(int c=cmin;c<=cmax&&tnel>0;c++)
        {
            System.out.println(arr[rmax][c]);
            tnel--;
        }
        rmax--;
        for(int r=rmax;r>=rmin&&tnel>0;r--)
        {
            System.out.println(arr[r][cmax]);
            tnel--;
        }
        cmax--;
        for(int c=cmax;c>=cmin&&tnel>0;c--)
        {
            System.out.println(arr[rmin][c]);
            tnel--;
        }
        rmin++;
    }
}
public static void printExitPoint(int[][] arr)
{
    int n=arr.length,m=arr[0].length,i=0,j=0,dir=0;
    while(true)
    {
        dir=(dir+arr[i][j])%4;
        if(dir==0)       //north
        {
            j++;
            if(j==m)
            {
                System.out.println(i+"\n"+(j-1));
                break;
            }
        }
        else if(dir==1) //east
        {
            i++;
            if(i==n)
            {
                System.out.println((i-1)+"\n"+j);
                break;
            }
        }
        else if(dir==2)   //south
        {
            j--;
            if(j==-1)
            {
                System.out.println(i+"\n"+(j+1));
                break;
            }
        }
        else              //west
        {
            i--;
            if(i==-1)
            {
                System.out.println((i+1)+"\n"+j);
                break;
            }
        }
    }
}
//rotate by 90 degree matrix  first transpose the upper matrix and then reverse the columns
public static void swap(int[][] arr,int i1,int j1,int i2,int j2)
{
    int temp=arr[i1][j1];
    arr[i1][j1]=arr[i2][j2];
    arr[i2][j2]=temp;
}
public static void rotateBy90(int[][] arr)
{
    int n=arr.length,m=arr[0].length;
    for(int i=0;i<n;i++)
    {
        for(int j=i;j<m;j++)
        {
            swap(arr,i,j,j,i);
        }
    }
    int sti=0,edi=m-1;
    while(sti<edi)
    {
        for(int i=0;i<n;i++)
        {
            swap(arr,i,sti,i,edi);
        }
        sti++;
        edi--;
    }
}
//saddle point find minimum in rows and for that minimum traverse that column and find maximum
//if it come out to be the same then we have got saddle point otherwise Invalid input
public static int maxInCol(int[][] arr,int c)
{
    int max=-(int)1e9,r=-1;
    for(int i=0;i<arr.length;i++)
    {
        if(arr[i][c]>max)
        {
            max=arr[i][c];
            r=i;
        }
    }
    return r;
}
public static void printSaddlePoint(int[][] arr)
{
    int min=(int)1e9,n=arr.length,m=arr[0].length,flag=0,c=-1,r=-1;
    for(int i=0;i<n;i++)
    {
    min=(int)1e9;
    for(int j=0;j<m;j++)
    {
        if(arr[i][j]<min)
        {
        min=arr[i][j];
        c=j;
        }
    }
    r=maxInCol(arr,c);
    if(r==i)
    {
        System.out.println(arr[r][c]);
        flag=1;
    }
    }
    if(flag==0)
    {
        System.out.println("Invalid input");
    }
}
public static void searchInSorted2d(int[][] arr,int data)
{
    int n=arr.length,m=arr[0].length;
    int i=0,j=m-1;
    while(i<n&&j>=0)
    {
        if(arr[i][j]==data)
        {
            System.out.println(i);
            System.out.println(j);
            return;
        }
        else if(arr[i][j]<data)
        {
            i++;
        }
        else
        {
            j--;
        }
    }
    System.out.println("Not Found");
}
public static void main(String[] args)
{
    int[][] arr=new int[scn.nextInt()][scn.nextInt()];
    input(arr);
    output(arr);
    System.out.println(maximum(arr));
    System.out.println(minimum(arr));
    System.out.println(find(arr,50));
    waveTraversal1(arr);
    System.out.println();
    printFullDiagonal(arr);
}
    
}
