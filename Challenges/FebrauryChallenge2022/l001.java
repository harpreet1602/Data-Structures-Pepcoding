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
    


}