package Two Pointers;

public class summaryRanges {
    
    // 228. Summary Ranges
// tc O(n) sc O(1)
    
//     Use two pointers approach simply 
// start and end starts from same point, we see that end ele and end+1 element is same so keep on increasing the window and when it is not in range, add it in the list accordingly and if one ele is there then add only one ele 
//     slide the window ahead to find the next range
//     Do a dry run, it is a simple one.
    
public List<String> summaryRanges(int[] nums) {
    List<String> ans = new ArrayList<>();
    int n = nums.length, start=0, end=0, next=0;
    
    while(start<n){
        while(end+1<n && nums[end]+1 == nums[end+1]){
            end++;
        }
        
        if(start == end){
            ans.add(nums[start]+"");
        }
        else{
            ans.add(nums[start]+"->"+nums[end]);
        }
        start = end+1;
        end++;
    }
    return ans;
}

}
