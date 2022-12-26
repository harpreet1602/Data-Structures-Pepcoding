public class jumpGame{
    
//     55. Jump Game
// ṭc O(n) sc O(1)
//     Greedy algorithm
//     we will start from last to see if we can reach the 0th index or not
//     for that we are having the lastPos as n-1
//     We will ask the question to n-2 cell if I can reach the n-1 cell from you or not if I can reach so new lastPos will become n-2 and so on.
public boolean canJump(int[] nums) {
    int n = nums.length;
    int lastPos = n-1;
    
    for(int i=n-2;i>=0;i--){
        if(nums[i]+i>=lastPos){
            lastPos = i;
        }
    }
    return lastPos == 0;
}
}