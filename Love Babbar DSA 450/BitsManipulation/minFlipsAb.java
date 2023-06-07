package BitsManipulation;

public class minFlipsAb {
    class Solution {
        // 1318. Minimum Flips to Make a OR b Equal to c
    // tc O(31) sc O(1)
    //     Bit Manipulation
    //     traverse for all the 0 to 30 bits and get each bit by shifting 1 left i times to position the 1 at ith position and take & (and) with the number to get its bitif it is 1 then mask will be 1 otherwise 0
    //     and on the basis of that evaluate the rules
    //     what will happen in four scenarios 00 01 10 11
    //     handle all the wrong cases like 11 if its cmask is 0 then we have to change two bits etc
        public int minFlips(int a, int b, int c) {
            int count = 0; 
            for(int i=0;i<31;i++){
                int x = (1 << i) & a; 
                int y = (1 << i) & b; 
                int z = (1 << i) & c; 
                
                if(z>0 && (x==0 && y==0)){
                    count++;
                }
                else if(z==0 && (x>0 && y>0)){
                    count += 2;
                }
                else if(z==0 && (x>0 || y>0)){
                    count++;
                }
            }
            return count;
        }
    }
}
