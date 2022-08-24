public class power3{
    
    // 326. Power of Three
//     tc O((log n)base3) sc O(1)
//     Keep on dividing by 3 until we get 1 in power of three case
//     at any point the number is not divisible by 3 return false;
public boolean isPowerOfThree(int n) {
    if(n<1){
        return false;
    }
    while(n>1){
        int rem = n%3;
        if(rem != 0){
            return false;
        }
        n = n / 3;
    }
    return true;
}
}