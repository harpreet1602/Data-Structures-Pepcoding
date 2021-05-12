import java.util.*;
  
  public class AbAddition{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int b = scn.nextInt();
      int n1 = scn.nextInt();
      int n2 = scn.nextInt();
  
      int d = getSum(b, n1, n2);
      System.out.println(d);
   }
  
   public static int getSum(int b, int n1, int n2){
       // write ur code here
       int carry=0,digit1,digit2,ans=0,sum=0,pow=1;
       while(n1>0||n2>0||carry>0)
       {
           digit1=n1%10;
           digit2=n2%10;
           n1=n1/10;
           n2=n2/10;
           sum=carry+digit1+digit2;
               carry=sum/b;
               sum=sum%b;
           ans+=sum*pow;
           pow=pow*10;
       }
       return ans;
   }
   public static int getDifference(int b, int n1, int n2){
    // write your code here
    int borrow=0,pow=1,ans=0;
    while(n2>0)
    {
        int diff=borrow+n2%10-n1%10;
        n1=n1/10;
        n2=n2/10;
        if(diff<0)
        {
            diff+=b;
            borrow=-1;
        }
        else
        borrow=0;
        ans+=diff*pow;
        pow=pow*10;
    }
    return ans;
}
public static int multiplyNumberWithDigit(int n,int d,int b)
{
    int ans=0,pow=1,digit,carry=0;
    while(n!=0||carry!=0)
    {
       int prod=carry+(n%10)*d;
       n=n/10;
       digit=prod%b;
       carry=prod/b;
       ans+=digit*pow;
       pow=pow*10;
    }
    return ans;
}
public static int getProduct(int b, int n1, int n2){
    // write your code here
    int pow=1,ans=0;
    while(n2>0)
    {
        int d=n2%10;
        n2=n2/10;
        int prodResult=multiplyNumberWithDigit(n1,d,b)*pow;
        ans=getSum(b,ans,prodResult);
        pow=pow*10;
    }
    return ans;
}

