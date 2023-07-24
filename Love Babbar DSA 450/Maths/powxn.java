package Maths;

public class powxn {
    class Solution {
        // 50. Pow(x, n)
        // tc O(n) sc O(1)
        //  take long for power because integer will overflow in the negative to postive integer power condition
        //     the logic is when the power is odd then ans till now multiplied with x which has been made till now and power reduces by 1 
        //     when the power is even, x is getting prepared then x is assigned with x * x and power reduces by half
        //     Do dry run to understand the insight.
        //     for the negative power case return 1 / ans
            public double myPow(double x, int n) {
                long num = n;
                double ans = 1.0;
                if(num<0){
                    num = -num;
                }
                
                while(num>0){
                    if(num%2==1){
                        ans = ans * x;
                        num = num - 1;
                    }
                    else{
                        x = x*x;
                        num = num/2;
                    }
                }
                if(n<0){
                    ans = (double)(1.0) / (double)(ans);
                }
                return ans;
            }
        }
}
