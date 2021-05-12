import java.util.*;
public class l002 {
    public static Scanner scn=new Scanner(System.in);
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
    public static void printAllPrime(int low,int high)
    {
        for(int i=low;i<=high;i++)
        {
            if(isPrime(i))
            {
                System.out.println(i);
            }
        }
    }
    public static void solve()
    {
        int n=0;
        boolean res;
            n=scn.nextInt();
            res=isPrime(n);
            if(res==true)
            {
                System.out.println("prime");
            }
            else
            {
                System.out.println("not prime");
            }
    }
    //l003
    //reverse a number
    public static void printDigitsInReverse(int n)
    {
        int rem=0;
        while(n!=0)
        {
            rem=n%10;
            n=n/10;
            System.out.println(rem);
        }
    }
    //digits of a number
    public static int powerEqualDigits(int n)
    {
        n=n/10;
        int pow=1;
        while(n!=0)
        {
            n=n/10;
            pow*=10;
        }
        return pow;
    }
    public static void printDigitsOfNumber(int n)
    {
       int pow=powerEqualDigits(n),quo;
       while(pow!=0)
       {
           quo=n/pow;
           n=n%pow;
           pow=pow/10;
           System.out.println(quo);
       }
        
    }
    //rotate a number
    public static int countDigits(int n)
    {
        int len=0;
        while(n!=0)
        {
            n=n/10;
            len++;
        }
        return len;
    }
     public static int reverseNumber(int n,int r)
     {
         int digit=countDigits(n);
         r=r%digit;
         if(r<0)
         {
             r=r+digit;
         }
         int mul=1,div=1;
         for(int i=1;i<=digit;i++)
         {
             if(i<=r)
             {
                 div=div*10;
             }
             else
             {
                 mul=mul*10;
             }
         }
         int a=n%div;
         int b=n/div;
         return ( (a*mul) + b);
     }
     //pythagorian triplet
    
  public static boolean pythagorianTriplet01(int a,int b,int c)
  {
      int max=a;
      if(b>=max)
      max=b;
      else if(c>=max)
      max=c;
      if(max==a)
      return ((a*a)==((b*b)+(c*c)));
      else if(max==b)
      return ((b*b)==((a*a)+(c*c)));
      else
      return ((c*c)==((b*b)+(a*a)));
    //   if((a*a)==((b*b)+(c*c)))
    //   return true;
    //   else if((b*b)==((a*a)+(c*c)))
    //   return true;
    //   else if((c*c)==((b*b)+(a*a)))
    //   return true;
    //   else 
    //   return false;
  }
  public static boolean pythagorianTriplet02(int a,int b,int c)
  {
      return ((a*a)==((b*b)+(c*c))) || ((b*b)==((a*a)+(c*c))) ||((c*c)==((b*b)+(a*a)));
  }
  public static void BenjaminBulbs(int n)
  {
      for(int i=1;i*i<=n;i++)
      {
          System.out.println(i*i);
      }
  }
  public static void printFibonacci(int n)
  {
      int a=0,b=1,c;
      for(int i=1;i<=n;i++)
      {
          System.out.println(a);
          c=a+b;
          a=b;
          b=c;
      }
  }
  public static int power(int rem)
{
    int i=1,p=1;
    while(i<rem)
    {
        p=p*10;
        i++;
    }
    return p;
}
  public static int inverse(int n)
{
    int i=1,p,rem,num=0;
    while(n!=0)
    {
        rem=n%10;
        n=n/10;
        p=power(rem);
        num+=i*p;
        i++;
    }
    return num;
}
public static int inverse2(int n)
{
    int op=1,od,ip,id,inv=0;
    while(n!=0)
    {
        od=n%10;
        n=n/10;
        ip=od;
        id=op;
        op++;
        inv =inv +id*(int)Math.pow(10,ip-1);
    }
    return inv;
    
}
public static int lcm(int n1,int n2)
    {
        int i=1,j=1;
        while(n1*i!=n2*j)
        {
            if(n1*i>n2*j)
            {
                j++;
            }
            else 
            {
                if(n1*i<n2*j)
                i++;
            }
        }
        return n1*i;
    }
    public static int gcd(int n1,int n2)
    {
        int max,max1=0;
        if(n1>=n2)
        {
            max=n1;
        }
        else
        {
            max=n2;
        }
        for(int i=1;i<=max/2;i++)
        {
            if(n1%i==0&&n2%i==0)
            {
                max1=i;
            }
        }
        return max1;
    }
    public static void solveGcdLcmOptimized(int n1,int n2)
    {
     int on1=n1;
     int on2=n2,rem,lcm;
     while(n1%n2!=0)
     {
         rem=n1%n2;
         n1=n2;
         n2=rem;
     }
     System.out.println(n2);
     lcm=(on1*on2)/n2;
     System.out.println(lcm);
    }    public static void main(String[] args)
    {
        int n=scn.nextInt();
        System.out.println(inverse(n));
      
    }
}