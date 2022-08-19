public class splitArray {
    
    // 659. Split Array into Consecutive Subsequences
//     tc  O(n) sc O(n)
//     Two hashmaps will be used in the greedy algorithm
//     one availability map to put the numbers in the new group and one vacancy map to put the numbers in existing groups
//     if the element is not available then skip the case as it is already added earlier
//     If the element is available as well as vacant so add it in the existing group
//     Now maintain the stuff like if one number is present then simultaneously check if three numbers are present so make a group and put three numbers there and next one in the vacancy map which can enter in the group in future according to the requirement
//     Else return false group cannot be made because of the number
//     If all these cases pass for the whole array then return true.
public boolean isPossible(int[] nums) {
    HashMap<Integer,Integer> amap = new HashMap<>();
    HashMap<Integer,Integer> vmap = new HashMap<>();
    
    for(int num:nums){
        amap.put(num,amap.getOrDefault(num,0)+1);
    }
    
    for(int i=0;i<nums.length;i++){
        if(amap.get(nums[i])<=0){
            continue;
        }
        else if(vmap.getOrDefault(nums[i],0)>0){
            amap.put(nums[i],amap.get(nums[i])-1);
            vmap.put(nums[i],vmap.get(nums[i])-1);
//                 this number is stored in the group and next number is in vacancy map now
            vmap.put(nums[i]+1,vmap.getOrDefault((nums[i]+1),0)+1);
        }
        else if((amap.getOrDefault(nums[i],0)>0) && (amap.getOrDefault(nums[i]+1,0)>0) && (amap.getOrDefault(nums[i]+2,0)>0) ){
            amap.put(nums[i],amap.get(nums[i])-1);
            amap.put(nums[i]+1,amap.get(nums[i]+1)-1);
            amap.put(nums[i]+2,amap.get(nums[i]+2)-1);
            vmap.put(nums[i]+3,vmap.getOrDefault((nums[i]+3),0)+1);
        }
        else{
            return false;
        }
    }
    return true;
}
}
