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
    
    // tc O(l) sc O(1)
    // Traverse one time
    // Find the latest first location of the 6 while traversing from backward to forward
    // then suppose we find 6 at 2nd position we add num + 3*10^2 => num+300
    // otherwise same num
    public int maximum69Number (int num) {
        int first6 = -1,temp=num,dig=0,idx=0;
        while(temp>0){
            dig = temp%10;
            temp = temp/10;
            if(dig == 6){
                first6 = idx;
            }
            idx++;
        }
        return first6 == -1? num : num+3*(int)Math.pow(10,first6);
    }    
}
