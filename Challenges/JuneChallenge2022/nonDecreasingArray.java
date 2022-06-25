public class nonDecreasingArray {
    // 665. Non-decreasing Array
//     tc O(n) sc O(1)
//     
public boolean checkPossibility(int[] nums) {
    int n = nums.length,count=0;
    for(int i=1;i<n;i++){
        if(nums[i-1]>nums[i]){
//        downhill, maintain the count
            count++;
            if(i-2>=0 && nums[i-2]>nums[i]) //if i-2 th ele is greater than current then we have to take the i-1th value in current ith index
                nums[i] = nums[i-1];
            else
                nums[i-1] = nums[i];
//                 but if i-2th ele is smaller then we can take smallest possible value in the i-1th index of i th index.
//                 This way the array will be sorted with some modifications which will be as minimum as possible
        }
    }
//         return true if modification count is 1 or lesser other wise false.
    return count<=1;
}
}
