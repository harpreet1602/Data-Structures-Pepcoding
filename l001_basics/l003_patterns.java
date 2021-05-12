import java.util.*;
public class l003_patterns {
    public static Scanner scn=new Scanner(System.in);
    public static void printTriangle(int n)
    {
       int nst=1;
       for(int row=1;row<=n;row++)
       {
           for(int cst=1;cst<=nst;cst++)
           {
               System.out.print("*\t");
           }
           nst++;
           System.out.println();
       }
    }
    public static void printInvertedTriangle(int n)
    {
        int nst=n;
        for(int row=1;row<=n;row++)
        {
            for(int cst=1;cst<=nst;cst++)
            {
                System.out.print("*\t");
            }
            nst--;
            System.out.println();
        }
    }
    public static void printMirrorTriangle(int n)
    {
        int nsp=n-1;
        int nst=1;
        for(int row=1;row<=n;row++)
        {
            for(int csp=1;csp<=nsp;csp++)
            {
                System.out.print("\t");
            }
            for(int cst=1;cst<=nst;cst++)
            {
                System.out.print("*\t");
            }
            nsp--;
            nst++;
            System.out.println();
        }
    }
    public static void printInvertedMirrorTriangle(int n)
    {
        int nst=n;
        int nsp=0;
        for(int row=1;row<=n;row++)
        {
            for(int csp=1;csp<=nsp;csp++)
            {
                System.out.print("\t");
            }
            for(int cst=1;cst<=nst;cst++)
            {
                System.out.print("*\t");
            }
            nst--;
            nsp++;
            System.out.println();
        }
    }
    public static void printFullDiamond(int n)
    {
        int nst=1;
        int nsp=n/2;
        for(int row=1;row<=n;row++)
        {
            for(int csp=1;csp<=nsp;csp++)
            {
                System.out.print("\t");
            }
            for(int cst=1;cst<=nst;cst++)
            {
                System.out.print("*\t");
            }
            if(row<=n/2)
            {
                nsp--;
                nst+=2;
            }
            else
            {
                nsp++;
                nst-=2;
            }
            System.out.println();
        }
    }
    
    public static void printFigure(int n)
    {
       // int nst=(n/2)+1;
        int nst=n/2;
        int nsp=1;
        for(int row=1;row<=n;row++)
        {
            for(int cst=1;cst<=nst;cst++)
            {
                System.out.print("*\t");
            }
            for(int csp=1;csp<=nsp;csp++)
            {
                System.out.print("\t");
            }
            for(int cst=1;cst<=nst;cst++)
            {
                System.out.print("*\t");
            }
            if(row<=n/2)
            {
                nst--;
                nsp+=2;
            }
            else
            {
                nst++;
                nsp-=2;
            }
            System.out.println();
        }
    }
    //pattern 7
    public static void printLeftDiagonal(int n)
    {
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=i;j++)
            {
                if(i==j)
                System.out.print("*\t");
                else
                System.out.print("\t");
            }
            System.out.println();
        }
    }
    //pattern 8
    public static void printRightDiagonal(int n)
    {
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(i+j==n+1)
                {
                    System.out.print("*\t");
                }
                else
                {
                    System.out.print("\t");
                }
                
            }
            System.out.println();
        }
    }
    //pattern 10
    public static void printHollowDiamond(int n)
    {
        int os=n/2;
        int is=-1;
        for(int row=1;row<=n;row++)
        {
            for(int csp=1;csp<=os;csp++)
            {
                System.out.print("\t");
            }
            System.out.print("*\t");
            if(row>1&&row<n)
            {
            for(int csp=1;csp<=is;csp++)
            {
                System.out.print("\t");
            }
            System.out.print("*");
            }
            System.out.println();
            if(row<=n/2)
            {
                os--;
                is+=2;
            }
            else
            {
                os++;
                is-=2;
            }
        }
    }
    //pattern 11
    public static void printNumberTriangle(int n)
{
    int val=1;
    for(int row=1;row<=n;row++)
    {
        for(int con=1;con<=row;con++)
        {
            System.out.print(val+"\t");
            val++;
        }
        System.out.println();
    }
}
    //pattern 12
    public static void printFibonacciTriangle(int n)
{
    int a=0,b=1,c;
    for(int row=1;row<=n;row++)
    {
        for(int con=1;con<=row;con++)
        {
            System.out.print(a+"\t");
            c=a+b;
            a=b;
            b=c;
        }
        System.out.println();
    }
}
//pattern 13 o(n^3)
public static int factorial(int n)
{
    int f=1;
    for(int i=n;i>=1;i--)
    {
        f=f*i;
    }
    return f;
}
public static int combination(int n,int r)
{
    int num=factorial(n);
    int den=(factorial(n-r)*factorial(r));
    int c=num/den;
    return c;
}
public static void printCombinationTriangle(int n)
{
    int nst=1;
    for(int row=0;row<n;row++)
    {
        for(int cst=0;cst<nst;cst++)
        {
            System.out.print(combination(row,cst)+"\t");
        }
        nst++;
        System.out.println();
    }
}
//pattern 13 o(n^2)
public static void binomialPattern(int n)
{
    for(int i=0;i<n;i++)
    {
        int ncr=1;
        for(int j=0;j<=i;j++)
        {
            System.out.print(ncr+"\t");
            int ncr1=(((i-j)*ncr)/(j+1));
            ncr=ncr1;
        }
        System.out.println();
    }
}
//pattern 14
public static void printTable(int n)
{
    for(int i=1;i<=10;i++)
    {
        System.out.println(n+" * "+i+" = "+n*i);
    }
}
//pattern 15
public static void printNumberDiamond(int n)
    {
        int nsp=n/2;
        int nst=1;
        for(int row=1;row<=n;row++)
        {
            for(int csp=1;csp<=nsp;csp++)
            {
                System.out.print("\t");
            }
            int val=row;
            if(row>(n/2)+1)
            {
                val=n-row+1;
            }
            for(int cst=1;cst<=nst;cst++)
            {
                System.out.print(val+"\t");
                if(cst<=nst/2)
                {
                    val++;
                }
                else
                {
                    val--;
                }
            }
            if(row<=n/2)
            {
                nsp--;
                nst+=2;
            }
            else
            {
                nsp++;
                nst-=2;
            }
            System.out.println();
        }
    }
    //pattern 16
    public static void printmirrorNumberTriangle(int n)
{
    int nsp=((2*n)-3);
    int nst=1;
    for(int row=1;row<=n;row++)
    {
        int val=1;
        for(int cst=1;cst<=nst;cst++)
        {
            System.out.print(val++ +"\t");
        }
        for(int csp=1;csp<=nsp;csp++)
        {
            System.out.print("\t");
        }
        if(row==n)
        {
            val--;
            nst--;
        }
        for(int cst=1;cst<=nst;cst++)
        {
            System.out.print(--val+"\t");
        }
        nst++;
        nsp-=2;
        System.out.println();
    }
}
//pattern 17
public static void printArrow(int n)
{
    int nsp=n/2;
    int nst=1;
    for(int row=1;row<=n;row++)
    {
        for(int csp=1;csp<=nsp;csp++)
        {
            if(row!=(n/2)+1)
        {
            System.out.print("\t");
        }
        else
        {
            System.out.print("*\t");
        }
        }
        for(int cst=1;cst<=nst;cst++)
        {
            System.out.print("*	");
        }
        if(row<=n/2)
        {
            nst++;
        }
        else
        {
            nst--;
        }
        System.out.println();
    }
}
//pattern 18
public static void printRTriangle(int n)
{
    int nst=n;
    int nsp=0;
    for(int row=1;row<=n;row++)
    {
        for(int csp=1;csp<=nsp;csp++)
        {
            System.out.print("\t");
        }
        for(int cst=1;cst<=nst;cst++)
        {
            if(row>1 && row<=n/2 && cst>1 && cst<nst)
            {
                System.out.print("\t");
            }
            else
            System.out.print("*\t");
        }
        if(row<=n/2)
        {
            nst-=2;
            nsp++;
        }
        else
        {
            nst+=2;
            nsp--;
        }
        System.out.println();
    }
}
//pattern 19 not good
public static void printSwastik(int n)
{
    for(int row=1;row<=n;row++)
    {
        for(int cst=1;cst<=n;cst++)
        {
            if(cst==1 && (row==1||row>n/2))
            {
                System.out.print("*\t");
            }
            else if(cst==n && (row<=n/2+1||row==n))
            {
                System.out.print("*\t");
            }
            else if(row==1&&cst>1&&cst<=n/2)
            {
                System.out.print("*\t");
            }
            else if(row==n&&cst>n/2+1&&cst<n)
            {
                System.out.print("*\t");
            }
            else if(cst==n/2+1)
            {
                System.out.print("*\t");
            }
            else 
            {
                System.out.print("\t");
            }
          
        }
          System.out.println();
    }
}
//pattern19 optimized
public static void printSwastik1(int n)
{
    for(int i=1;i<=n;i++)
    {
        for(int j=1;j<=n;j++)
        {
            if(i==1)
            {
                if(j<=n/2+1 || j==n)
                {
                    System.out.print("*\t");
                }
                else
                {
                    System.out.print("\t");
                }
            }
            else if(i<=n/2)
            {
                if(j==n/2+1 || j==n)
                {
                    System.out.print("*\t");
                }
                else
                {
                    System.out.print("\t");
                }    
                
            }
            else if(i==n/2+1)
            {
                System.out.print("\t");
            }
            else if(i<n)
            {
                if(j==1 || j==n/2+1)
                {
                    System.out.print("*\t");
                }
                else
                {
                    System.out.print("\t");
                } 
            }
            else
            {
                if(j<=n/2+1 || j==n)
                {
                    System.out.print("*\t");
                }
                else
                {
                    System.out.print("\t");
                } 
            }
            
        }
        System.out.println();
    }
}
//pattern 20
public static void printW(int n)
{
    for(int i=1;i<=n;i++)
    {
        for(int j=1;j<=n;j++)
        {
            if(j==1 || j==n)
            {
                System.out.print("*\t");
            }
            else if(i>n/2 && ((i==j||i+j==n+1)))
            System.out.print("*\t");
            else 
            System.out.print("\t");
        }
        System.out.println();
    }
}
public static void main(String[] args) {
    int n=scn.nextInt();
    printHollowDiamond(n);
}
}
