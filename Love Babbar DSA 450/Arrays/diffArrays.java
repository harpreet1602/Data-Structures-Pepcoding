public class diffArrays {
    class Solution {
        // 2215. Find the Difference of Two Arrays
    //     Brute
    //     tc O(m*n) sc O(1)
    //     using one ele find it in the other array if it is present or not
        
    //     Optimized
    // tc O(m+n) sc O(m+n)
    //     Hashset will be used we can store the array elements in the set and then ask that what are the elements of first array that are not there in the second array.
        public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
            HashSet<Integer> set1 = new HashSet<>();
            HashSet<Integer> set2 = new HashSet<>();
            
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            List<List<Integer>> ans = new ArrayList<>();
            
            for(int i=0;i<nums1.length;i++){
                set1.add(nums1[i]);
            }
            for(int i=0;i<nums2.length;i++){
                set2.add(nums2[i]);
            }
            
            for(int key:set1){
                if(!set2.contains(key)){
                    list1.add(key);
                }
            }
            for(int key:set2){
                if(!set1.contains(key)){
                    list2.add(key);
                }
            }
            ans.add(list1);
            ans.add(list2);
            
            return ans;
        }
    }
}
