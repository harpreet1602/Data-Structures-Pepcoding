import java.util.*;
public class HashMapQuestions {
     // 128. Longest Consecutive Sequence
     public int longestConsecutive(int[] nums) {
        HashSet<Integer> map = new HashSet<>();
        for(int ele:nums){
            map.add(ele);
        }
        int maxRange = 0;
        for(int ele:nums){
            if(!map.contains(ele)) continue;
            map.remove(ele);
            int prev = ele - 1;
            int next = ele + 1;
            while(map.contains(prev)) map.remove(prev--);
            while(map.contains(next)) map.remove(next++);
            maxRange = Math.max(maxRange,next-prev-1);
        }
        return maxRange;
    }
    
    
}
