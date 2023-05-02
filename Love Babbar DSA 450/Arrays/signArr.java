public class signArr {
    // 1822. Sign of the Product of an Array
// tc O(n) sc O(1)
//     If zero is present then answer will be zero
//     otherwise just count the negative elements in the array
//     if there are even number of negative elements answer will be positive 
//     otherwise negative.
    public int arraySign(int[] nums) {
        int negCount = 0;
        for(int ele:nums){
            if(ele == 0){
                return 0;
            }
            if(ele<0){
                negCount++;
            }
        }
        return negCount%2==0?1:-1;
    }

    
}
