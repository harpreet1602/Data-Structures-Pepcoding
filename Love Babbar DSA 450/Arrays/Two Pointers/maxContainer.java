package Love Babbar DSA 450.Arrays.Two Pointers;

public class maxContainer {
    
    // 11. Container With Most Water
// Brute => O(n^2) time each height bar with every other bar

    //     Optimised
    // tc O(n) sc O(1)    
//     Two pointers 
//     one pointer in the start and one pointer in the end
//     take the minimum of two height bars and end - start index as current area
//     Track the maximum area encountered so far
//     That bar pointer will be moved which is smaller in hope of getting a bigger bar
public int maxArea(int[] height) {
    int start = 0, end = height.length-1, ans=0;
    
    while(start<end){
        int currArea = Math.min(height[start],height[end])*(end-start);
        ans = Math.max(ans,currArea);
        
        if(height[start]<=height[end]){
            start++;
        }
        else{
            end--;
        }
    }
    return ans;
}
}
