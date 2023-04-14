package HashTable;

public class array2d {
    class Solution {
        //     2610. Convert an Array Into a 2D Array With Conditions
        // tc O(n*freq) sc O(n)
        //     make a frequency map and then traverse in the key set and add the element 
        //     in all the rows equal to how much frequency the element has.
            public List<List<Integer>> findMatrix1(int[] nums) {
                List<List<Integer>> ans = new ArrayList<>();
                HashMap<Integer,Integer> map = new HashMap<>();
                int max = 0;
                
                for(int ele:nums){
                    map.put(ele,map.getOrDefault(ele,0)+1);
                    max = Math.max(max,map.get(ele));
                }
                for(int i=0;i<max;i++){
                    ans.add(new ArrayList<>());
                }
                for(Integer key:map.keySet()){
                    int val = map.get(key);
                    for(int i=0;i<val;i++){
                        ans.get(i).add(key);
                    }
                }
                return ans;
            }
            
        //     optimized
        //     tc O(n) sc O(n)
        //     so logic is same but the optimized way if doing it will be to take just an array count of size n
        //     and then traverse through each ele and if the freq of the ele exceeds the size 
        //    then add another array list in to it
        //     according to the current freq-1 add the ele into the row.
            public List<List<Integer>> findMatrix(int[] nums) {
                List<List<Integer>> ans = new ArrayList<>();
                int n = nums.length;
                int[] count = new int[n+1];
                
                for(int ele:nums){
                    if(ans.size() < ++count[ele]){
                        ans.add(new ArrayList<>());
                    }
                    ans.get(count[ele]-1).add(ele);
                }
                return ans;
            }
        }
}
