public class concatBin {
    
    // 1680. Concatenation of Consecutive Binary Numbers
//     tc O(n*binNumberRepresentation) sc O(1) I think
//     
public int concatenatedBinary(int n) {
    int mod = (int)1e9+7, newNum=0;
    
    for(int i=1;i<=n;i++){
//             inbuilt function of java to convert decimal number to binary number
//             we can use our custom function as well.
        String num = Integer.toBinaryString(i);
        for(char c:num.toCharArray()){
            int val = c == '0'?0:1;
            newNum = ((newNum*2)%mod + val)%mod;
        }
//             1 => 1
//             newNum = 0*2+1 = 1
//             2 => 10
//             newNum = 1*2+1 = 3
//             newNum = 3*2+0 = 6
//             3 => 11
//             newNum = 6*2+1 = 13
//             newNum = 13*2+1 = 27
//             This is how the algorithm is working here.
    }
    return newNum;
}
}
