import java.util.*;

public class BTD {
    // decimal to Binary

    public static Scanner scn = new Scanner(System.in);

    public static int binaryToDecimal(int n) {
    int digit,ans=0,power=1;
     while(n>0)
    {
        digit=n%10;
        n=n/10;
        ans+=digit*power;
        power=power*2;
    }
    return ans;
    }

    public static void main(String[] args) {
    System.out.println(binaryToDecimal(scn.nextInt()));
    }

}