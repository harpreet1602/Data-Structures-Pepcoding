import java.util.*;
  
  public class ABTAB{
  public static int ABTD(int n,int b)
  {
    int digit,pow=1,ans=0;
    while(n>0)
    {
        digit=n%10;
        n=n/10;
        ans+=digit*pow;
        pow*=b;
    }
    return ans;
  }
  public static int DTAB(int n,int b)
  {
      int digit,ans=0,pow=1;
      while(n>0)
      {
        digit=n%b;
        n=n/b;
        ans+=digit*pow;
        pow*=10;
      }
      return ans;
  }
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int sourceBase = scn.nextInt();
     int  destBase= scn.nextInt();
     int decNumber=ABTD(n,sourceBase);
     System.out.println(DTAB(decNumber,destBase));
   }   
  }