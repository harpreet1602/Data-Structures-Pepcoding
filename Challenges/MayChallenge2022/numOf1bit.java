public class numOf1bit {
    
    // 191. Number of 1 Bits
//     tc O(32) sc O(1)
//     32 times loop will run to do left shift operation and take and of it with 1
//     if the result is 1, then increase the count.
    
    // you need to treat n as an unsigned value
    public int hammingWeight1(int n) {
        int count = 0;
        
        for(int i=0;i<32;i++){
            if(((n>>i)&1)==1){
                count++;
            }
        }
        return count;
    }
//     Optimised
//     tc O(no. of bits present in the number)=> O(1) sc O(1)
//     The number of iterations required to make the n & (n-1) as 0 is the number of 1's in n.
    
//     1 time iteration = 1 bit set in 8
//     8 => 1000
//   & 7 => 0111 
//       => 0000    
    
     public int hammingWeight(int n) {
         int count = 0;
         while(n!=0){
             n = n & (n-1);
             count++;
         }
         return count;
   
     }
}
