import java.util.*;
public class l001{
   public static Scanner scn=new Scanner(System.in);
    public static void printZ()
    {
        System.out.println("*****");
        System.out.println("   *");
        System.out.println("  *");
        System.out.println(" *");
        System.out.println("*****");
    }
    public static void test()
    {
        System.out.println("Input a no.");
        int n=scn.nextInt();
        System.out.println(n);
    }
    public static void test2()
    {
        int n=1000;
        System.out.println("no. is " + n);
    }
    public static void gradingSystem(int marks)
    {
        
        if(marks>90)
        {
            System.out.println("excellent");
        }
        else if(marks>80)
        {
            System.out.println("good");
        }
        else if(marks>70)
        {
            System.out.println("fair");
        }
        else if(marks>60)
        {
            System.out.println("meets expectations");
        }
        else
        {
            System.out.println("below par");
        }
    }
    public static void oddEven(int n)
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
    public static void printMultipleEvenOdd()
    {
        int count=scn.nextInt();
        for(int i=0;i<count;i++)
        {
            int n=scn.nextInt();
            oddEven(n);
        }
    }
    public static void table(int n)
    {
        for(int i=1;i<=10;i++)
        {
            System.out.println(n + " * " + i + " = " + n*i);
        }
    }
    public static void printMultipleTable(int n)
    {
        for(int i=1;i<=n;i++)
        {
      table(i);      
      System.out.println("\n");
        }
    }
    public static void main(String[] args)
    {
      //printZ();
      //  test();
        //test2();
        // int marks=scn.nextInt();
        // gradingSystem(marks);
        // printMultipleEvenOdd();
//        int n=scn.nextInt();
 //       table(n);
 int n=scn.nextInt();
 printMultipleTable(n);
    }
}