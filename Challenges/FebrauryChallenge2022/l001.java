import java.util.HashMap;


public class l001{
    
//     121. Best Time to Buy and Sell Stock
//     tc O(n) sc O(1)
//     We are coming to a price and we will ask two questions that can I buy here or
//     sell here. If we will get a negative profit then we will keep it as 0.
//     If we haven't buy yet we can't sell so these condition is also taken care by
//     minus infinity starting point for buying.

    public int maxProfit(int[] prices) {
        int dpi0 = 0, dpi1 = -(int)1e9;
        for(int i=0;i<prices.length;i++){
            dpi0 = Math.max(dpi0,dpi1+prices[i]);  //selling
            dpi1 = Math.max(dpi1,0-prices[i]);     //buying
        }
        return dpi0;
    }

    
//  438. Find All Anagrams in a String

//     tc O(n) sc O(n)
//     Now the basic idea is to maintain a frequency array of alphabets
//     and first of all add the frequency of character of p in it
//     then run a loop for the length of p in s for initial settlement
//     after that check if matchedChar is 0 or not and accordingly add in the 
//     ans list. After that we need to run a loop which will do all the work
//     first of all removing the starting index by maintaining the matchedChar
//     as if the character was present then we will increment the matchedChar
//     we will increment the start pointer and now we will check the end pointer
//     that end pointer if gets matched with p character then decrement the 
//     matchedChar and if at any point the matchedChar reaches 0 add the start
//     in the ans list
    
    
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        
        int n1 = s.length(), n2 = p.length();
        if(n2>n1){
            return ans;
        }
        int[] freq = new int[26];
        int start = 0, end = 0, unmatchedChar=n2;
        
//         fill the freq arr with the string for which we need anagrams.
        for(int i=0;i<n2;i++){
            int index = p.charAt(i)-'a';
            freq[index]++;
        }
        
//         now start the process
        
        for(;end<n2;end++){
            int index = s.charAt(end)-'a';
            if(freq[index]>0){
                unmatchedChar--;
            }
            
            freq[index]--;
        }
        
        if(unmatchedChar == 0){
            ans.add(start);
        }
        
        for(;end<n1;){
//             remove the starting index
            int startindex = s.charAt(start)-'a';
            if(freq[startindex]>=0){
//                 char was present in p
                unmatchedChar++;
            }
            
            freq[startindex]++;
            start++;
            
            // traverse the next ending index
            int endindex = s.charAt(end)-'a';
            if(freq[endindex]>0){
//                 char was present in p
                unmatchedChar--;
            }
            
            freq[endindex]--;
            end++;
            
             if(unmatchedChar == 0){
                 ans.add(start);
             }
        }
        return ans;
    }
    
//     454. 4Sum II
//     Brute force => time O(n^4) space O(1)
//     So first of all brute force is to run 4 loops and find the answer
    
    
//     Another optimisation:- time O(n^3) space O(1)
//     Sort all the arrays then run two loops for A and B and apply
//     two pointer approach in C and D to find the other two elements
    
//     tc O(n^2) sc O(n)
//     Optimised solution can be done with the help of HashMap
//     In which all two elements sum can be stored with  their frequency.
//     After that all last two elements will come and find their respective
//     companions to make the answer
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int e:nums1){
            for(int f:nums2){
                map.put(e+f,map.getOrDefault(e+f,0)+1);
            }
        }
        int count=0;
        for(int e:nums3){
            for(int f:nums4){
                if(map.containsKey(0-(e+f)))
                count+=map.get(0-(e+f));           
            }
        }
        return count;
    }

    //     525. Contiguous Array
// Brute tc O(n^2)
    
//     Optimised
//     tc O(n) sc O(n)
//     Keep a hashmap of sum,index till which sum is calculated
//     so this is a prefix sum actually
//     Initially the prefix sum =0 for index -1 
//    and then traverse the nums array and then make your sum 
//     For 0 you will replace it by -1 so decrementing  the prefix sum
//     by 1 in case of a 0 because this will neautrilise the effect 
//     whenever you will get the same sum back which previously has come
//     then you can check the max of prev ans and current i-map.get(sum)
//     otherwise just add the sum,index pair.
    
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0, ans = 0;
        map.put(0,-1);
//         sum,index
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
//             consider 0 as -1
            if(nums[i] == 0) sum-=1;
            
            if(map.containsKey(sum)){
                ans = Math.max(ans,i-map.get(sum));
            }else
            {
                map.put(sum,i);
            }
        }
        return ans;
    }


    
    

    // 80. Remove Duplicates from Sorted Array II
// tc O(n) sc O(1)
// Two pointer approach but basically three pointers will be used.
//     one for start index of the element
//     one for the end index of the element
//     one for changing the array at previous indexes
//     according to the frequency of the element that is calculated
       public int removeDuplicates(int[] nums) {
           int n = nums.length, oIndex = 0, sIndex,i=0;
           
           while(i<n){
               sIndex = i;
               while(i<n-1 && nums[i] == nums[i+1]){
                   i++;
               } 
               int length = i - sIndex + 1;
               int freq = Math.min(length,2);
               while(freq-->0){
                   nums[oIndex] = nums[sIndex];
                   oIndex++;
               }
               i++;
           }
           return oIndex;
       }
    

       
//     389. Find the Difference
//     add the characters of s in a freq array of 26 size and then subtract the 
//     freq with characters of t then whichever freq will not be zero i.e -1
//     that will be our ans
//     tc O(t.length) sc O(26) => O(1)
    public char findTheDifference1(String s, String t) {
        //         frequency table of characters
                int[] freq = new int[26];
                for(int i=0;i<s.length();i++){
                    int ind = s.charAt(i) - 'a';
                    freq[ind]++;
                }
                
                for(int i=0;i<t.length();i++){
                    int ind = t.charAt(i) - 'a';
                    freq[ind]--;
                }
                
                
                for(int i=0;i<26;i++){
                    if(freq[i] != 0)
                        return (char)(i + 'a');
                    }
                   return ' ';
            }
            
        //     Optimisation
        //     tc O(t.length) sc O(1)
        //     using bit manipulation as a^a = 1
        //     so we can take xor of all the character of s and t
        //     then only the ans character will be left and '0' character thing is done
        //     for smoothness like first of all add some character for initiation
        //     then cancel it by taking the xor again.
            
            public char findTheDifference(String s, String t) {
                char ans = '0';
                for(char ch:s.toCharArray()){
                    ans ^= ch;
                }
                
                for(char ch:t.toCharArray()){
                    ans ^= ch;
                }
                ans ^= '0';
                return ans;
            }
           
        
        
//     258. Add Digits
//     tc O(n) sc O(1)
//     Just find the sum of the digits using typical maths
    
    public int helperSum(int num){
        int ans = 0;
        while(num!=0){
            ans += num%10;
            num = num/10;
        }
        return ans;
    }
    
//     Just find the sum of the digits using string manipulation
    public int helperSumStr(int num){
        int digitsSum = 0;
        String str = num + "";
        for(char ch:str.toCharArray()){
            digitsSum += (ch-'0');
        }
        return digitsSum;
    }
//     then just go on till this process doesn't produce the sum<10
//     then return the ans
    public int addDigits(int num) {
        int n = 0;
        while(true){
            n = helperSumStr(num);
            if(n<10){
                break;
            }
            num = n;
        }
        return n;
    }

    
    // 532. K-diff Pairs in an Array
// tc O(n) sc O(n)
//     we can use set also but for case 0 we have to use map
//     Store the elements in map because we have to handle zero case where ele's
//     freq greater than 2 matter for us as it increment our ans
//     for other value of k we just need to check key + k if it is present 
// increment the ans.    
    public int findPairs(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;
//         make freq map
        for(int ele:nums){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
//         now run the algorithm to get the ans for k=0 special case
//         and other cases.
        for(int key:map.keySet()){
            if(k==0){
                if(map.get(key)>=2){
                    count++;
                }
            }
            else{
                if(map.containsKey(key+k)){
                    count++;
                }
            }
        }
        return count;
    }


    
    // 560. Subarray Sum Equals K
// tc O(n) sc O(n)
//     Brute can be O(n^2)
//     But we have optimised by storing the prefix sum in the hashmap
//     we are using it to know that till where we are getting what sum
//     according to that we incrementing our ans
//     do a dry run to know more about the technique
//     that from which index to which index it contains the sum k
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int ans = 0, preSum = 0;
        map.put(0,1);
        for(int i =0; i<nums.length;i++){
            preSum += nums[i];
            if(map.containsKey(preSum-k)){
                ans += map.get(preSum-k);
            }
            map.put(preSum,map.getOrDefault(preSum,0)+1);
        }
        return ans;
        
    }

    
    // 567. Permutation in String
//     tc O(s.length) sc O(26)
 // Now the basic idea is to maintain a frequency array of alphabets
//     and first of all add the frequency of character of p in it
//     then run a loop for the length of p in s for initial settlement
//     after that check if matchedChar is 0 or not and accordingly return true 
//     If not then after that we need to run a loop which will do all the work
//     first of all removing the starting index by maintaining the matchedChar
//     as if the character was present then we will increment the matchedChar
//     we will increment the start pointer and now we will check the end pointer
//     that end pointer if gets matched with p character then decrement the 
//     matchedChar and if at any point the matchedChar reaches 0 return true
//     otherwise the ans will be false
    
    public boolean checkInclusion(String p, String s) {
        int n1 = s.length(), n2 = p.length();
        if(n2>n1){
            return false;
        }
        int[] freq = new int[26];
        int start = 0, end = 0, unmatchedChar=n2;
        
//         fill the freq arr with the string for which we need anagrams.
        for(int i=0;i<n2;i++){
            int index = p.charAt(i)-'a';
            freq[index]++;
        }
        
//         now start the process
        
        for(;end<n2;end++){
            int index = s.charAt(end)-'a';
            if(freq[index]>0){
                unmatchedChar--;
            }
            
            freq[index]--;
        }
        
        if(unmatchedChar == 0){
            return true;
        }
        
        for(;end<n1;){
//             remove the starting index
            int startindex = s.charAt(start)-'a';
            if(freq[startindex]>=0){
//                 char was present in p
                unmatchedChar++;
            }
            
            freq[startindex]++;
            start++;
            
            // traverse the next ending index
            int endindex = s.charAt(end)-'a';
            if(freq[endindex]>0){
//                 char was present in p
                unmatchedChar--;
            }
            
            freq[endindex]--;
            end++;
            
             if(unmatchedChar == 0){
                 return true;
             }
        }
        return false;   
    }


    
    // 78. Subsets
// tc O(2^n) (doubt)=> to generate all subsets and along with it, copy them into output list. 
    // sc O(n) => for current List
//     Backtracking approach
//     Backtracking is an algorithm for finding all solutions by exploring all potential candidates. If the solution candidate turns to be not a solution (or at least not the last one), backtracking algorithm discards it by making some changes on the previous step, i.e. backtracks and then try again.
//     Backtracking steps
//     1.maintain the current state of object.
//     2. Loop through all the sample set
//     3.Add a new element from the sample set
//     4. recursively invoke for next entry.
//     5. remove the last element that was added in the sample set.
    
    
public void findSubsets(int[] nums,List<List<Integer>> ans,List<Integer> currList,int idx){
    if(idx>=nums.length){
        return;
    }
    for(int i=idx;i<nums.length;i++){
        currList.add(nums[i]);
        ans.add(new ArrayList<>(currList));
        findSubsets(nums,ans,currList,i+1);
        currList.remove(currList.size()-1);
    }
    
}
public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    ans.add(new ArrayList<>());
    findSubsets(nums,ans,new ArrayList<>(),0);
    return ans;
}


    
//    104. Maximum Depth of Binary Tree 
//tc O(n) sc O(n) -> recursive space in worst case of skew tree, every node on one side 
//     otherwise for the general case tc O(log n) sc O(log n) => height of tree
//     Ask the height from left and right and take the maximum out of it and add 
//     one into it for current height and return.
//     Understand the recursion, you will get the answer.
    
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }

    


}