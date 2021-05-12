import java.util.*;

public class DTB {
    // decimal to Binary

    public static Scanner scn = new Scanner(System.in);
    public static int decimalToBinary(int n) {
    int ans=0,digit,power=1;
    while(n>0)
    {
        digit=n%2;
        n=n/2;
        ans+=(digit*power);
        power=power*10;
    }
    return ans;
    }

    public static void main(String[] args) {
        System.out.println(decimalToBinary(scn.nextInt()));
    }

}