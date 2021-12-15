import java.util.Scanner;
public class paint760c {
    public static Scanner scn = new Scanner(System.in);

    public static int gcd(int a,int b){
        if(a==0) return b;
        return gcd(b%a,a);
    }
    public static void solveQues(){
        int t = scn.nextInt();
        while(t-->0){
            int n = scn.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = scn.nextInt();
            }
            int even = 0, odd = 0;
            for(int i=0;i<n;i+=2){
                odd = gcd(odd,arr[i]);
            }

            
            for(int i=1;i<n;i+=2){
                even = gcd(even,arr[i]);
            }

            boolean flag =false;
            for(int i=0;i<n;i+=2){
                if(arr[i]%even==0){
                    flag=true;
                    break;
                }
            }
            if(!flag){
                System.out.println(even);
                continue;
            }

            for(int i=1;i<n;i+=2){
                if(arr[i]%odd==0){
                    flag=true;
                    break;
                }
            }
            if(!flag){
                System.out.println(odd);
                continue;
            }
            System.out.println(0);
        }
        
    }
    public static void main(String[] args){
        solveQues();
    }   
}
