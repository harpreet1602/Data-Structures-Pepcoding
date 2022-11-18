public class uglyNumber {
    // 263. Ugly Number
// tc O(log n) sc O(1)
// Keep on dividing with 2,3,5 until n>1, in the end if n==1 return true otherwise false.
public boolean isUgly(int n) {
    while(n>1){
        if(n%2 == 0){
            n = n/2;
        }
        else if(n%3 == 0){
            n = n/3;
        }
        else if(n%5 == 0){
            n = n/5;
        }
        else{
            break;
        }
    }
    return n == 1;
}
}
