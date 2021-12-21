import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class squaresAndCubes {
    public static Scanner scn = new Scanner(System.in);
    public static boolean isRoot(int num){
        int root = (int)Math.sqrt(num);
        return root*root == num;
    }
    public static boolean isCube(int num){
        int root = (int)Math.cbrt(num);
        return root*root*root == num;
    }
    // tle
    public static void solveQues1(){
        int t = scn.nextInt();
        while(t-->0){
           int n = scn.nextInt();
           int count=1;
           for(int i=2;i<=n;i++){
                if(isRoot(i)){
                    count++;
                }
                else if(isCube(i)){
                    count++;
                }
           }

           System.out.println(count);
        }
        
    }
    
    public static void solveQues(){
        int t = scn.nextInt();
        while(t-->0){
           int n = scn.nextInt();
           int res = (int)Math.sqrt(n) + (int)Math.cbrt(n) - (int)Math.sqrt(Math.cbrt(n));
           System.out.println(res);

        }
    
    }
    public static void main(String[] args){
        solveQues();
    }

}




