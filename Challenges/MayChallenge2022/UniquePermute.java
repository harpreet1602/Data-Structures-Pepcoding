import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;



public class UniquePermute {
    
        // 47. Permutations II
//     tc O() sc O()
//     Time complexity has to be studied for backtracking questions.
    
private void findPermuteUnique(Set<List<Integer>> ansSet,List<Integer> smallAns,int[] nums,boolean[] vis){
    if(smallAns.size() == nums.length){
//         only unique list will be added into the hashset of lists
//         which eventually gives unique permutations
        ansSet.add(new ArrayList<>(smallAns));
    }
//         Backt5racking template, only visited thing is added to find the permutations nicely
//         as only one element can be considered only once.
    for(int i=0;i<nums.length;i++){
        if(!vis[i])
        {
            vis[i] = true;
            smallAns.add(nums[i]);
            findPermuteUnique(ansSet,smallAns,nums,vis);
            smallAns.remove(smallAns.size()-1);
            vis[i] = false;
        }
    }
    
}
public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> smallAns = new ArrayList<>();
//         so that Duplicate list does not get added.
    Set<List<Integer>> ansSet = new HashSet<>();
//         So that the permutations can be made perfectly and one element can be used one time.
    boolean[] vis = new boolean[nums.length];
    
    findPermuteUnique(ansSet,smallAns,nums,vis);
    
    for(List<Integer> list:ansSet){
        ans.add(list);
    }
    
    return ans;
}
}
