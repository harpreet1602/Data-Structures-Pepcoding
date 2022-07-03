public class wiggleSbsequence {
    
//     376. Wiggle Subsequence
//     tc O(n) sc O(1)
//     Greedy approach => Maintain two pointers up and down which will have the formula like up = down+1 and down = up+1 and don't do anything in the case of equal difference
//     which will make the equal included in a unit and if the opposite value is not 
//     getting changes for some time this means that the whole unit of opposite is getting traversed.
//     So basically, alternate up and down hills count will be maintained in the two pointers
//     Maximum of both will be the answer in the end.
    
public int wiggleMaxLength(int[] nums) {
    int up = 1, down = 1, n = nums.length;
    
    for(int i=1;i<n;i++){
        int diff = nums[i] - nums[i-1];
        
        if(diff>0){
            up = down+1;
        }
        else if(diff<0){
            down = up+1;
        }
    }
    return Math.max(up,down);
}
}