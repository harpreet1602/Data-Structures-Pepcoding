public class reorderedPower2{
    
    // 869. Reordered Power of 2
//     Brute
//     permutations and then check is it a power of 2
//     tc O( n! *logn) with log n check for checking power of 2 sc O(1)
//     tc O( n! *1) with bits (n&n-1) ==0 check sc O(1)
//     I think
    
//     tc O((log n)^2) sc O(log n)     
//     2^31 => 10^9
//     so check the frequency map of 2^0 to 2^31 with the current number to check is it a power of 2 or not.
public boolean reorderedPowerOf2(int n) {
    int[] freq = getFreq(n);
    int pow2 = 1;
    for(int i=0;i<31;i++){
        int[] freqPow2 = getFreq(pow2);
        if(arrEqual(freq,freqPow2)){
            return true;
        }
        pow2 = pow2*2;
   }
    return false;
}
private int[] getFreq(int temp){
    int[] freq = new int[10];
    while(temp!=0){
        int digit = temp%10;
        temp = temp/10;
        freq[digit]++;
    }
    return freq;
}
private boolean arrEqual(int[] freq1,int[] freq2){
    for(int i=0;i<freq1.length;i++){
        if(freq1[i]!=freq2[i]){
            return false;
        }
    }
    return true;
}
}