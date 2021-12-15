import java.util.Scanner;
public class subsequence760a {
    public static Scanner scn = new Scanner(System.in);
    public static void solveQues(){
        int t = scn.nextInt();
        while(t-->0){
            int[] arr = new int[7];
            for(int i=0;i<7;i++){
                arr[i] = scn.nextInt();
            }
            System.out.print(arr[0]+" "+arr[1]+" ");
            if(arr[0] + arr[1] == arr[2]){
                System.out.println(arr[3]);
            }
            else {
                System.out.println(arr[2]);
            }

        }
        
    }
    public static void main(String[] args){
        solveQues();
    }
}
