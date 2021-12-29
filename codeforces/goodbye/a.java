import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
public class a {
    public static Scanner scn = new Scanner(System.in);
    public static void solveQues(){
        int t = scn.nextInt();
        while(t-->0){
            int n = scn.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = scn.nextInt();
            }
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int ele:arr){
                map.put(Math.abs(ele),map.getOrDefault(Math.abs(ele),0)+1);
            }
            int val=0,count=0;
            for(int key:map.keySet()){
                val = map.get(key);
                if(key==0 || val==1){
                    count++;
                }
                else if(val>1){
                    count +=2;
                }
            }
            System.out.println(count);


        }
        
    }
    public static void main(String[] args){
        solveQues();
    }

}
