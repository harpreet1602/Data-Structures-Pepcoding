import java.util.*;
  
  public class DTAB{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int b = scn.nextInt();
      int dn = getValueInBase(n, b);
      System.out.println(dn);
   }
  
   public static int getValueInBase(int n, int b){
       // write code here
       int digit,power=1,ans=0;
       while(n>0)
       {
           digit=n%b;
           n=n/b;
           ans+=digit*power;
           power=power*10;
       }
       return ans;
   }
  }