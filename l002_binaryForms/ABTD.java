import java.util.*;
  
  public class ABTD{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int b = scn.nextInt();
      int d = getValueIndecimal(n, b);
      System.out.println(d);
   }
  
   public static int getValueIndecimal(int n, int b){
      // write your code here
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
  }