import java.util.*;

public class revisionl001
{
    public static Scanner scn=new Scanner(System.in);
    public static void printmsg()
    {
        System.out.println("Hello world");
        System.out.println("HI");
        System.out.println("YO");
    }
    public static void printOddEven(int n)
    {
        if(n%2==0)
        {
            System.out.println("even");
        }
        else
        {
            System.out.println("odd");
        }
    }
    public static boolean isEven(int n)
    {
        if(n%2==0)
        {
            return true;
        }
        else{
            return false;
        }
    }
    //sumit malik sir
    public static void inputoutput()
    {
        // int n=scn.nextInt();
        // System.out.println("Your input was " + n);
        // System.out.print("hello world");
        // System.out.print("hello world");
        String s;
        s=scn.nextLine();
        System.out.println(s);
    }
    public static void swap()
    {
        int temp=a;
        a=b;
        b=temp;
    }
    public static boolean isPrime(int n)
    {
        for(int i=2;i*i<=n;i++)
        {
            if(n%i==0)
            {
                return false;
            }
        }
        return true;
    }
    public static void printPrimeInRange(int a ,int b)
    {
        for(int i=a;i<=b;i++)
        {
            if(isPrime(i))
            System.out.println(i);
        }
    }
    public static void printTable(int n)
    {
        for(int i=1;i<=10;i++)
        {
            System.out.println(n+" X "+i+" = "+(n*i));
        }
    }
    public static void printTableInRange(int a,int b)
    {
        for(int i=a;i<=b;i++)
        {
            printTable(i);
            System.out.println();
        }
    }
    static int a=10,b=20;
    public static void arrayfun(int[] arr)
    {
        arr[2]=30;
        arr[3]=40;
        // for(int i=0;i<arr.length;i++)
        // {
        //     System.out.println(arr[i]);
        // }
    }
    public static void twodarray(int[][] a)
    {
        a[0][0]=10;
        a[0][1]=20;
        a[0][2]=30;
        
        a[1][0]=40;
        a[1][1]=50;
        a[1][2]=60;
        
        for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<a[i].length;j++)
            {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void twodjackedarray(int[][] a)
    {
        a[0][0]=10;
        a[0][1]=20;
        a[0][2]=30;
        
        a[1][0]=40;
        a[1][1]=50;
        a[1][2]=60;
        a[1][3]=70;
        
        for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<a[i].length;j++)
            {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void arrlist(ArrayList<Integer> list)
    {
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list+" -> "+list.size());
        list.add(1,10);
        System.out.println(list+" -> "+list.size());
        list.set(1,100);
        System.out.println(list+" -> "+list.size());
        int val=list.get(1);
        System.out.println(val);
        list.remove(1);
        System.out.println(list+" -> "+list.size());
        ArrayList<String> li=new ArrayList<>();
        li.add("hello");
        li.add("bello");
        li.add("cello");
        for(int i=0;i<li.size();i++)
        System.out.println(list.get(i));
        for(String val1:li)
        System.out.println(val1);
        System.out.println(li);
    }
    public static void main(String[] args)
    {
        // int n=scn.nextInt();
        // //System.out.println(isEven(n));
        // boolean ans=isEven(n);
        // if(ans==true)
        // {
        //     System.out.println("even");
        // }    
        // else{
        //     System.out.println("odd");
        // }
         //   printTableInRange(scn.nextInt(),scn.nextInt());
        // int[] arr=new int[5];
        // arr[0]=10;
        // arr[1]=20;
        // arr[4]=50;
        // arrayfun(arr);
        // for(int val: arr)
        // {
        //     System.out.println(val);
        // }
      //  int[][] a=new int[2][3];
      // int[][] b=new int[2][];
        // b[0]=new int[3];
        // b[1]=new int[4];
        // twodjackedarray(b);
        ArrayList<Integer> list=new ArrayList<>();
        arrlist(list);
        
    }
}