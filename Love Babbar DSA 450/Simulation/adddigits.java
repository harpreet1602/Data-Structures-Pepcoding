public class adddigits {
    class Solution {
        // 258. Add Digits
    // tc O(n) sc O(1)
    //     Simulation  of what is said in the question can be done to do it as a brute force solution
    //     keep on adding the digits of the numbers till it become a single digit.
        public int addDigits(int num) {
            int ans = 0,tempnum=0;
            while(num>=10){
                tempnum = num;
                while(tempnum!=0){
                    int digit  = tempnum%10;
                    tempnum = tempnum/10;
                    ans += digit;
                }
                num = ans;
                ans = 0;
            }
            return num;
        }
    }
}
