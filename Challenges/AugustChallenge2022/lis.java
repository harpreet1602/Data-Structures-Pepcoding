public class lis{
    
    // 300. Longest Increasing Subsequence
    
//      normal > Dp tc O(n^2) sc O(n)
//     dp [i] = max(dp[(0,i-1)],dp[i])
//     simply apply this logic to get LIS
    
// optimised
//     treeset
    //     tc O(nlogn) sc O(n)
// if there is a just larger value already existing remove it and then add it simply
//     if not add it without concern
//     in the end size of the treeset which implements bst internally with add and remove and ceil of logn time will give the answer
public int lengthOfLIS(int[] nums) {
    TreeSet<Integer> bst = new TreeSet<>();
    
    for(int num:nums){
        Integer higherOrEqual = bst.ceiling(num);
        
        if(higherOrEqual == null){
            bst.add(num);
        }else{
            bst.remove(higherOrEqual);
            bst.add(num);
        }
    }
    return bst.size();
}
}