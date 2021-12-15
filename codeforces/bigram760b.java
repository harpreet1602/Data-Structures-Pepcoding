import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class bigram760b {
    public static Scanner scn = new Scanner(System.in);
    public static void solveQues(){
        int t = scn.nextInt();
        while(t-->0){
            int n = scn.nextInt();
            List<String> big = new ArrayList<>();
            for(int i=0;i<n-2;i++){
                big.add(scn.next());
            }
            StringBuilder sb = new StringBuilder();
            sb.append(big.get(0));
            for(int i=1;i<big.size();i++){
                String str = big.get(i-1);
                String str1 = big.get(i);
                
                if(str.charAt(1) == str1.charAt(0)){
                    sb.append(str1.charAt(1));
                }
                else{
                    sb.append(str1);
                }
            }
            if(sb.length()!=n){
                sb.append('a');
            }

            System.out.println(sb.toString());

        }
        
    }
    public static void main(String[] args){
        solveQues();
    }

}
