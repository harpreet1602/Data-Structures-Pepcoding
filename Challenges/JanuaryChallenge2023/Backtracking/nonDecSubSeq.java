public class nonDecSubSeq {
    
    // 491. Non-decreasing Subsequences
// tc O() sc O()
//     Simple Backtracking template is applied
//     Maintain the current state =>
//          Loop through the possible values
//              add the value
//              call for next value
//              remove the last added value.
//     In this template only check was to call when the size is 0 or we get the curr ele greater than the last ele of prevList.
//     In the base case we add all the subsequences with size greater than 2 
//     Set<List<Integer>> is used to avoid duplicates and helps in removing the TLE
    
private void findSubsequences(int[] nums,int index,List<Integer> smallAns,Set<List<Integer>> ans){
    if(smallAns.size()>=2){
        List<Integer> base = new ArrayList<>(smallAns);
        ans.add(base);
    }
    
    for(int i=index;i<nums.length;i++){
        if(smallAns.size()==0 || (smallAns.get(smallAns.size()-1)<=nums[i])){
            smallAns.add(nums[i]);
            findSubsequences(nums,i+1,smallAns,ans);    
            smallAns.remove(smallAns.size()-1);
        }
    }
}
public List<List<Integer>> findSubsequences(int[] nums) {
    Set<List<Integer>> ans = new HashSet<>();
    List<Integer> smallAns = new ArrayList<>();
    
    findSubsequences(nums,0,smallAns,ans);
    return new ArrayList<>(ans);
}
}
