import java.util.Scanner;
public class watermelon{
    public static Scanner scn = new Scanner(System.in);
    public static void solveQues(){
        int n = scn.nextInt();
        if(n%2 == 0 && n!=2){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
    public static void main(String[] args){
        solveQues();
    }
}