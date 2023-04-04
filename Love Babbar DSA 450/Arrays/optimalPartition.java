public class optimalPartition {
    class Solution {
        //     2405. Optimal Partition of String
        // tc O(n) sc O(n)
        //     So take a hashset, add characters into it and once you get any character that is 
        //     already present then reset the hashset and repeat the process,
            public int partitionString(String s) {
                HashSet<Character> set = new HashSet<>();
                int partition = 1;
                for(int i=0;i<s.length();i++){
                    char ch = s.charAt(i);
                    
                    if(set.contains(ch)){
                        partition++;
                        set = new HashSet<>();
                    }
                    set.add(ch);
                }
                return partition;
            }
        }
}
