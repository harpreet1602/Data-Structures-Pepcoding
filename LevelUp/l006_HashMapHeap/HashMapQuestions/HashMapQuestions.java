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
    
    // 781. Rabbits in Forest

    public int numRabbits(int[] answers) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans=0;
        for(int ele:answers){
            if(!map.containsKey(ele)) {
            ans += 1+ele;
            map.put(ele,1);
            }
            else{
                map.put(ele,map.get(ele)+1);
            }
            // map.put(ele,map.getOrDefault(ele,0)+1);
            if(map.get(ele) == ele+1){
                map.remove(ele);
            }
        }
        return ans;        
    }

    // 1218. Longest Arithmetic Subsequence of Given Difference
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int maxLen=0;
        for(int ele:arr){
            map.put(ele,map.getOrDefault(ele-difference,0)+1);
            maxLen = Math.max(maxLen,map.get(ele));
        }
        return maxLen;
    }

        // 1424. Diagonal Traverse II   
    //     If you have to maintain order then linkedlist is the best to use
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        HashMap<Integer,LinkedList<Integer>> map = new HashMap<>();
        int len = 0,maxDiag=0;
        for(int i =0;i<nums.size();i++){
            for(int j=0;j<nums.get(i).size();j++){
                int idx = i+j;
                map.putIfAbsent(idx,new LinkedList());
                map.get(idx).addFirst(nums.get(i).get(j));
                maxDiag = Math.max(maxDiag,idx);
                len++;
            }
        }
        int[] ans = new int[len];
        int idx=0;
        for(int i=0;i<=maxDiag;i++){
            LinkedList<Integer> list = map.get(i);
            while(list.size()!=0)
            ans[idx++] = list.removeFirst(); 
        }
        return ans;
    }

    // 1027. Longest Arithmetic Subsequence
    // When inner loop goes right to left we have to take in consideration which value is bigger 
    // curr or new because of the duplicacy of elements
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer>[] dp = new HashMap[n];
        for(int i=0;i<n;i++){
            dp[i] = new HashMap<>();
        }
        int len = 0;
        for(int i=0;i<n;i++){
            for(int j=i-1;j>=0;j--){
                int diff = nums[i] - nums[j];
                int currlen = dp[i].getOrDefault(diff,0);
                int newlen = dp[j].getOrDefault(diff,1)+1;
                dp[i].put(diff,Math.max(newlen,currlen));
                len = Math.max(len,dp[i].get(diff));
            }
        }
        return len;
        
    }

    // [22,8,57,41,36,46,42,28,42,14,9,43,27,51,0,0,38,50,31,60,29,31,20,23,37,53,27,1,47,42,28,31,10,35,39,12,15,6,35,31,45,21,30,19,5,5,4,18,38,51,10,7,20,38,28,53,15,55,60,56,43,48,34,53,54,55,14,9,56,52]
    // but when the inner loop goes from left to right then automatically the maximum freq is taken in
    public int longestArithSeqLength1(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer>[] dp = new HashMap[n];
        
        int len = 2;
        for(int i=0;i<n;i++){
            dp[i] = new HashMap<>();
            for(int j=0;j<i;j++){
                int diff = nums[i] - nums[j];
                int newlen = dp[j].getOrDefault(diff,1)+1;
                dp[i].put(diff,newlen);
                len = Math.max(len,dp[i].get(diff));
            }
        }
        return len;
        
    }
    // 954. Array of Doubled Pairs
    public boolean canReorderDoubled(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = arr.length;
        Integer[] ARR = new Integer[n];
        for(int i=0;i<n;i++)
        {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            ARR[i] = arr[i];
        }
        Arrays.sort(ARR,(a,b)->{
            return Math.abs(a) - Math.abs(b);
        });
        for(Integer ele:ARR){
            if(map.get(ele)==0) continue;
            if(map.getOrDefault(2*ele,0) == 0) return false;
            
            map.put(ele,map.get(ele)-1);
            map.put(2*ele,map.get(2*ele)-1);
        }
        return true;
    }
    

}
