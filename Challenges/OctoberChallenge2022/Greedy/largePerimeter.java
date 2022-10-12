public class largePerimeter {
    
    // 976. Largest Perimeter Triangle
//     tc O(nlogn) sc O(1)
//     Sort the array and then apply the property of triangle that sum of any two sides must be greater than one side
//     For this purpose we are sorting the array and then with three pointers from the last
//     we are having a window in that we take two smallest numbers' sum and check whether it is greater than the greatest side in that window, if it is then return the perimeter
//     otherwise shift the window back
//     After traversing we didn't met the condition then return 0
public int largestPerimeter(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length,sum=0;
    for(int i=n-1;i>=2;i--){
        sum = nums[i-1]+nums[i-2];
        if(sum > nums[i]){
            return sum + nums[i];
        }
    }
    return 0;
}
}
