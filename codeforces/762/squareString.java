import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class squareString {
    public static Scanner scn = new Scanner(System.in);
    public static void solveQues(){
        int t = scn.nextInt();
        while(t-->0){
            String str = scn.next();
            int n = str.length();
            if(n%2!=0){
                System.out.println("No");
                continue;
            }

            String str1 = str.substring(0, n/2);
            String str2 = str.substring(n/2);

            // System.out.println(str1);
            if(str1.equals(str2)){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
        }
        
    }
    public static void main(String[] args){
        solveQues();
    }

}
