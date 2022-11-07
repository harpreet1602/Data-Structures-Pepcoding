package Greedy;

public class max69 {
        // 1323. Maximum 69 Number
    // tc O(2*n)=>O(n) sc O(1)
    // Two traversals needed, where the first will reverse the number simply
    // Another traversal, we will be reversing but while doing it, we will change the first 6 to 9
    // then return the answer.
    public int maximum69Number (int num) {
        int pow = 10,temp=num,dig=0,revNum=0,ans=0;
        boolean flag=false;
        while(temp>0){
            dig = temp%10;
            temp = temp/10;
            revNum = (revNum*pow)+dig;
        }
        while(revNum>0){
            dig = revNum%10;
            revNum = revNum/10;
            if(dig==6 && !flag){
                flag = true;
                ans = ans*pow+9;
            }
            else{
                ans = ans*pow+dig;
            }
        }        
        return ans;
    }
}
