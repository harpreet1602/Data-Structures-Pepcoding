import java.util.*;
public class q004_digitFrequency {
    public static Scanner scn = new Scanner(System.in);

    public static int getDigitFrequency(long n, int d) {
        // write code here
        int count=0;
        long digit;
        while(n>0)
        {
            digit=n%10;
            n=n/10;
            if(digit==d)
            count++;
        }
        return count;
    }
    public static void digitFreq(long n, int[] query) {
        long d;
        int[] freq=new int[10];            //O(n+q)===O(q) time and O(1) space mai karna tha
        while(n>0)
        {
            d=n%10;
            n=n/10;
            freq[(int)d]++;
        }
        for (int q : query) {
            System.out.println(freq[q]);
        }
    }

    public static void main(String[] args) {
        long n = scn.nextLong();
        int[] query = new int[scn.nextInt()];
        for (int i = 0; i < query.length; i++) {
            query[i] = scn.nextInt();
        }
        digitFreq(n,query);
    }

}
