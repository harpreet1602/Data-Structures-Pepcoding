import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class l001{
    // 1. Two Sum
//     So in this brute force will be fixing one and checking with other TC O(n^2) SC O(1)
// Optimised solution will be to use a hashmap where we will be storing the addresses of the numbers
//     and then if target - current number already exists in the hashmap that means we got the pair 
public int[] twoSum(int[] nums, int target) {
    int[] ans= new int[2];
    HashMap<Integer,Integer> map = new HashMap<>();
    for(int i = 0;i<nums.length;i++)
    {
        if(map.containsKey(target-nums[i]))
        {
            ans[1] = i;
            ans[0] = map.get(target-nums[i]);
            return ans;
        }
        map.put(nums[i],i);
    }
    return ans;
}



// Sort the given array then use the concept of previous if the current ele = prev then 
// call will not be made for the duplicate element
// Rest of the question is then finding the subsets using this combination method
public int subsetsDup(int[] nums,int idx,List<Integer> smallAns, List<List<Integer>> ans)
    {
        List<Integer> base = new ArrayList<>(smallAns);
        ans.add(base);
        int count=0,prev=-11;
        for(int i =idx;i<nums.length;i++)
        {
            if(prev!=nums[i])
            {
            smallAns.add(nums[i]);    
            count+=subsetsDup(nums,i+1,smallAns,ans);
            smallAns.remove(smallAns.size()-1);
            }
            prev=nums[i];
        }
        
        
        return count;
        
    }
    
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> smallAns = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        subsetsDup(nums,0,smallAns,ans);
        return ans;
    }

    // Path Sum II
    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode() {}
             TreeNode(int val) { this.val = val; }
             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
             }
         }
        //    Path Sum II 
        // TC O(nlogn) SC O(logn) recursive space
        // Just apply the same technique of recursion to reach the target
        // traverse the tree and add the current val till leaf then check if
        //  it matches the target then add otherwise 
        // don't add.
        // then the recursive calls for both side
        // remove the current val at the end 
    public void path(TreeNode root,int targetSum,List<Integer> smallAns,List<List<Integer>> ans)
    {
        if(root==null)
            return;
        
        smallAns.add(root.val);
        if(root.left==null & root.right==null)
        {
            if(targetSum == root.val)
            {
            List<Integer> base = new ArrayList<>(smallAns);
                ans.add(base);
            }
        }
          path(root.left,targetSum-root.val,smallAns,ans);
        path(root.right,targetSum-root.val,smallAns,ans);
       
       
        smallAns.remove(smallAns.size()-1);
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> smallAns = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null)
            return ans;
        path(root,targetSum,smallAns,ans);
        return ans;
    }



}