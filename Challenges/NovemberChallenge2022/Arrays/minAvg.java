public class minAvg{
    
    // 2256. Minimum Average Difference
// tc O(n) sc O(1)
// Just keep the track of the prefix sum => start sum and end sum in a variable and use it to find the minimum difference
// Analyse the code and dry run 
public int minimumAverageDifference(int[] nums) {
    int n = nums.length,idx=0;
    long sumStart = 0, sumEnd=0,up, down,diff,minDiff=(int)1e9;
    for(int i=0;i<n;i++){
        sumEnd += nums[i];
    }

    for(int i=0;i<n;i++){
        sumStart += nums[i];
        sumEnd -= nums[i];
        up = (sumStart/(i+1));
        down = i==n-1?0:(sumEnd/(n-i-1));
        diff = Math.abs(up-down);
        if(diff<minDiff){
            minDiff = diff;
            idx = i;
        }
    }
    return idx;
}
}