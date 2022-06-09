public class twoSum2 {
    
//       167. Two Sum II - Input Array Is Sorted
//     BRute force
//     tc O(n^2) sc O(1) => apply nested for loop to check the target
    
//     Hashmap
//     tc O(n) sc O(n)
//     Add the elements if its pair is already present in the hashmap then return that
    
//     Binary Search 
//     tc O(nlogn) sc O(1)
//     Haven't done but yes at each starting point, apply binary search
    
//     Optimised
//     ṭc O(n) sc O(1)
//     Two pointers are applied and you can adjust them accordingly and get your answer 
    
public int[] twoSum(int[] numbers, int target) {
    int low = 0, high = numbers.length - 1;
    int[] ans = new int[2];
    while(low<high){
        if((numbers[low] + numbers[high]) == target){
            ans[0] = low + 1;
            ans[1] = high + 1;
            break;
        }
        else if(target < (numbers[low] + numbers[high])){
            high--;
        }
        else{ 
            low++;
        }
    }
    return ans;
}
}
