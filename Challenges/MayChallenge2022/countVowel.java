import java.util.Arrays;
public class countVowel{
    
    // 1641. Count Sorted Vowel Strings

//     Brute backtracking to be done later
    
    //     tc O(n) sc O(1)
//     Optimised
//     ḌP
//     Do dry run to understand tabulation that is applied
//     one corresponding row  will be 1
//     After that this is main (ii,io,iu) + (oo,ou,uu) => (iii,iio,iiu,ioo,iou,iuu) 
//     Imagine 2d dp array
//     So one row before me will tell all the combinations that starts with current character
//     And one column after the current cell will give the combinations starting with all the chracters after the current character in the vowels.
public int countVowelStrings(int n) {
    int[] dp = new int[5];
    int ans = 0;
    Arrays.fill(dp,1);
    for(int i=2;i<=n;i++){
        for(int j=3;j>=0;j--){
            dp[j] = dp[j] + dp[j+1];
        }
    }
    
    for(int el:dp){
        ans += el;
    }
    return ans;
}
}