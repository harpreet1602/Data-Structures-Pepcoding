public class trappingRainWater{
    
    // 42. Trapping Rain Water
//     tc O(3*n)=>O(n) sc O(2*n)=>O(n)
//     Maintain the leftmax and rigtht max arrays
//     The logic is that the minimum of leftmax and rightmax minus height will tell that how much units of water can be stored here.
  
public int trap(int[] height) {
    int n = height.length,ans=0,currHeight=0;
    int[] leftMax = new int[n];
    int[] rightMax = new int[n];
    
    for(int i=1;i<n;i++){
        leftMax[i] = Math.max(leftMax[i-1],height[i-1]);
    }
    for(int i=n-2;i>=0;i--){
        rightMax[i] = Math.max(rightMax[i+1],height[i+1]);
    }
    for(int i=0;i<n;i++){
        currHeight = Math.min(leftMax[i],rightMax[i]) - height[i];
        if(currHeight>0){
            ans += currHeight;
        }
    }
    
    return ans;
}
}