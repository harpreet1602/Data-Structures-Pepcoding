import java.util.*;

public class l001 {
    public static Scanner scn=new Scanner (System.in);

    public static void printDecreasing(int n){
        if(n==0)
        return;
        System.out.println(n);
        printDecreasing(n-1);
    }
    public static void printIncreasing(int n){
        if(n==0)
        return;
        printIncreasing(n-1);
        System.out.println(n);
    }
    public static void pdi(int n){
        if(n==0)
        return;
        System.out.println(n);
        pdi(n-1);
        System.out.println(n);
    }
    public static void ppppppp(int a,int b)
    {
        return ;
    }
    public static void pppppp(int a,int b)
    {
        System.out.println(a);
        ppppppp(a+1,b);
        System.out.println("hi"+a);
    }
    public static void ppppp(int a,int b)
    {
        System.out.println(a);
        pppppp(a+1,b);
        System.out.println("hi"+a);
    }
    public static void pppp(int a,int b)
    {
        System.out.println(a);
        ppppp(a+1,b);
        System.out.println("hi"+a);
    }
    public static void ppp(int a,int b)
    {
        System.out.println(a);
        pppp(a+1,b);
        System.out.println("hi"+a);
    }
    public static void pp(int a,int b)
    {
        System.out.println(a);
        ppp(a+1,b);
        System.out.println("hi"+a);
    }
    public static void p(int a,int b)
    {
        System.out.println(a);
        pp(a+1,b);
        System.out.println("hi"+a);
    }
    public static void print(int a,int b)
    {
        if(a>b)
        return;
        System.out.println(a);
        print(a+1,b);
        System.out.println("hi"+a);
    }
    public static void printDecreasing1(int a,int b)
    {
        if(a>b)
        return ;
        printDecreasing1(a+1, b);
        System.out.println(a);
    }
    public static void printIncreasingDecreasing(int a ,int b)
    {
        if(a>b)
        return;
        System.out.println(a);
        printIncreasingDecreasing(a+1,b);
        System.out.println(a);
    }

    public static void printIncreasingDecreasingEvenOdd(int a,int b)
    {
        if(a>b)
        return;
        if(a%2==0)
        System.out.println(a);
        printIncreasingDecreasingEvenOdd(a+1,b);
        if(a%2!=0)
        System.out.println(a);
    }
    //factorial
    public static int factorial(int n){
        if(n==0)
        return 1;
        int recAns=factorial(n-1);
        return recAns*n;
    }
    public static int factorial1(int n)
    {
        return n==0?1:factorial1(n-1)*n;
    }
    //power linear space
    public static int power(int x, int n){
        if(n==0)
        return 1;
        int recAns=power(x,n-1);
        return recAns*x;
    }
    //power function in logarithmic time(log n)
    public static int powerInLogTime(int x, int n){
        if(n==0)
        return 1;
        int recAns=power(x,n/2);
        recAns*=recAns;
        return n%2==0?recAns:recAns*x;
    }
    //tell the output by dry running the question
    // n = 5
    public static int recursionTree(int n) {
        if (n <= 1) {
            System.out.println("Base: " + n);
            return n + 1;
        }

        int count = 0;

        System.out.println("Pre: " + n);
        count += recursionTree(n - 1);

        System.out.println("In: " + n);
        count += recursionTree(n - 2);

        System.out.println("Post: " + n);

        return count + 3;
    }

    // n = 6
    public static int recursionTree2(int n) {
        if (n <= 1) {
            System.out.println("Base: " + n);
            return n + 1;
        }

        int count = 0;

        System.out.println("Pre: " + n);
        count += recursionTree2(n - 1);

        System.out.println("In1: " + n);
        count += recursionTree2(n - 2);

        System.out.println("In2: " + n);
        count += recursionTree2(n - 3);

        System.out.println("Post: " + n);
        return count + 3;
    }

    public static int fibo(int n) {
        if (n <= 1)
            return n;
        int count = 0;
        count += fibo(n - 1);
        count += fibo(n - 2);

        return count;
    }

    public static void main(String[] args) throws Exception {
        // write your code here
       // int n=scn.nextInt();
        // printDecreasing(n);
        printIncreasingDecreasingEvenOdd(2,7);
    }


}