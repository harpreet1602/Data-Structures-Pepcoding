public class powerOf4 {
    
    // 342. Power of Four
//     tc O(1) sc O(1)
//     If it is a power of 2 first of all that only one 1 exists in the binary number then 
//     check is it a power of four by looking at the index of 1 if the index is even then it is a power of 4 otherwise not
//     right shift with the index ampersand with 1 is one (check)
//     1 => 0001 yes
//     2 => 0010 no
//     4 => 0100 yes
//     8 => 1000 no
//     16=>10000 yes
public boolean isPowerOfFour(int n) {
    if((n&(n-1))==0){
        for(int i=0;i<32;i++){
            if(((n>>i)&1)==1){
                if(i%2==0){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
    }
    return false;
}
}
