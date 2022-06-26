public class maxPointCard {
    // 1423. Maximum Points You Can Obtain from Cards
//     tc O(k) sc O(1)
//     Two pointers, prefix sum
//     first of all take the sum of first k elements and then maintain two pointers
//     because we will take every possibility in consideration for finding the max sum
//     low's ele will be removed from the current sum and high's ele will be added in the current sum
//     max sum can also be checked.
//     Through this technique we will discover the possibility from first k elements to last k elements of the array.
//     We will get the maxsum 
public int maxScore(int[] cardPoints, int k) {
    int n=cardPoints.length, sum = 0, maxSum = 0,low = 0,high = n-1;
    
    for(int i=0;i<k;i++){
        sum += cardPoints[i];
    }
    low = k-1;
    maxSum = sum;
    while(low>=0){
        sum = sum - cardPoints[low] + cardPoints[high];
        low--;
        high--;
        maxSum = Math.max(sum,maxSum);
    }
    return maxSum;
}
}
