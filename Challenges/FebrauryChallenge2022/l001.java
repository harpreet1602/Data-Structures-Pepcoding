import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;


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

    
//    136. Single Number

//     tc O(n) sc O(1)
//     just take the XOR of all, the XOR of pair of same elements will give 0
//     so they will get cancelled eventually and you will get the single number in 
//     the end.
    public int singleNumber(int[] nums) {
        int ans=0;
        for(int ele:nums)
        {
            ans^=ele;
        }
        return ans;
    }

    
    // 24. Swap Nodes in Pairs
//     tc O(n) sc O(1)
//     Just make a dummy node to start the operation 
//     do a dry run by taking prev, curr and forw pointers in your list 
//     how can you make your ans
//     first of all prev.next = forw
//     then curr.next = forw.next
//     then forw.next = curr
//    after that do the work for new iteration
//     prev = curr
//     then curr =curr.next;
//     then forw = curr.next;
    public ListNode swapPairs(ListNode head) {       
        if(head == null || head.next==null){
           return head;
        }    
        ListNode dummy = new ListNode(-1);
        ListNode prev,curr,forw;
        prev = dummy;
        curr = head;
        forw = curr.next;
        while(curr!=null && curr.next!=null){
            prev.next = forw;
            if(forw!=null)
            curr.next = forw.next;
            forw.next = curr;
            prev = curr;
            curr = curr.next;
            if(curr!=null){
                forw = curr.next;
            }
        }
        return dummy.next;
    }

    
//      tc O( 2^n) sc O(n) -> recursive space
//     So out of all the combinations whichever combination's sum will be fulfilled
//     that will be added into our solution.
//      In recursion we will explore all the combinations and inside we will check
//     possibilities in the iteration while on a stage of recursion.
//     Suppose [2,2] has come so
//    [2,2,2] ,  [2,2,3] , [2,2,6], [2,2,7] will be checked.
//     Rest do the dry run to understand backtracking.
    public void combinations(int[] candidates,int target, int idx, List<Integer> smallAns,List<List<Integer>> ans)
    {
        if(target == 0)
        {
            List<Integer> base = new ArrayList<>(smallAns); //deep copy  (values)
            ans.add(base); //shallow copy (address)
            return;
        }
        
        for(int i = idx;i<candidates.length;i++)
        {
            if(target - candidates[i] >= 0 )
            {
                smallAns.add(candidates[i]);
                combinations(candidates,target-candidates[i],i,smallAns,ans);
                smallAns.remove(smallAns.size()-1);
            }
        }
        
    }
    
    
    
    
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<Integer> smallAns = new ArrayList<>();
            List<List<Integer>> ans = new ArrayList<>();
            
            combinations(candidates,target,0,smallAns,ans);
        return ans;
    }


    
//     402. Remove K Digits
//     tc O(n) sc O(n)
//  Use monotonic Stack, the approach is to iterate over the string, the first character will be added as it is
//     after that check the stack.top()>current character so keep poping out from 
//     the stack so that bigger numbers can be eliminated by maitaing the count of k
//     after all the iteration for the corner case we will be deleting the from the 
//     top of the stack by the time k reaches 0
//     in the end from the starting of the string in the stack we can compute
//     the answer into a stringbuilder and in the end if the stringbuilder is empty
//     then return "0" otherwise the ans string
    
public String removeKdigits(String num, int k) {
    ArrayList<Character> st = new ArrayList<>();
    for(int i =0 ;i<num.length();i++){
        char ch = num.charAt(i);
        while(st.size()!=0 && st.get(st.size()-1)>ch && k>0){
            k--;
            st.remove(st.size()-1);
        }
        st.add(ch);
    }
    while(k-->0){
        st.remove(st.size()-1);
    }

    StringBuilder sb = new StringBuilder();
    boolean nonzero = false;
    for(char ele:st){
        if(ele=='0' && !nonzero) continue;
        
        nonzero = true;
        sb.append(ele);
    }
    return sb.length()==0?"0":sb.toString();

    }

    // 169. Majority Element

// brute
//     tc O(nlog n) sc O(1)
//     So sort the array and check each position with i + n/2+1 index if it is same
//     then that is the ele.

    // little optimized     
    //     tc O(n) sc O(n)
//just make the frequency map and then return the ele that is appearing more than n/2 times.
    public int majorityElement1(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(int key:map.keySet()){
            if(map.get(key)>n/2){
                return key;
            }
        }
        return -1;
    }
    
//     Optimised space
//     tc O(n) sc O(1)
//     Just remember that the number that is having more than n/2 + 1
// occcurences so just maitain the count and majElele and you will get majEle throug dry run
    public int majorityElement(int[] nums) {
        int majorityEle = nums[0];
        int count = 1;
        for(int i=1;i<nums.length;i++){
            int ele = nums[i];
            if(ele == majorityEle){
                count++;
            }
            else{
                count--;
            }
            if(count==0){
                majorityEle = ele;
                count = 1;
            }
        }
        return majorityEle;
    }
   
    public class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         }

//     148. Sort List
//     tc O(n logn)
//     So we will go with recursion until we get single element in the list from one side
//     then we will backtrack then we will merge the two sorted parts together.
//     So with this method applied on log n tree we will get a sorted list through merge sort method
    public ListNode mergeTwoSortedLists(ListNode l1,ListNode l2)
    {
        if(l1==null || l2==null)
        return l1!=null?l1:l2;
        
        ListNode dummy=new ListNode(-1);
        ListNode prev=dummy,c1=l1,c2=l2;
        while(c1!=null && c2!=null)
        {
            if(c1.val<=c2.val)
            {
                prev.next=c1;
                c1=c1.next;
            }else
            {
                prev.next=c2;
                c2=c2.next;
            }
            prev=prev.next;
        }
        prev.next=c1!=null?c1:c2;
        return dummy.next;
    }
    public ListNode midNode(ListNode head)
    {
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null &&fast.next.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
//     nlog n
    public ListNode sortList(ListNode head) {
        
        if(head==null ||head.next==null)
        {
            return head;
        }
        ListNode mid=midNode(head);
        ListNode nhead=mid.next;
        mid.next=null;
        ListNode leftSortedList=sortList(head);          // log n 
        ListNode rightSortedList=sortList(nhead);        // log n 
        return mergeTwoSortedLists(leftSortedList,rightSortedList);     //n
    }


    
    // 165. Compare Version Numbers
//     tc O(n) sc O(n)
//     So first of all we need to split the strings into the string array so that we can get the no.s in
//     string format "//." because with this only we are doing the work of "." split.
//     When we will get it then we can run a loop and we can delete the leading zeroes and get a number
//     Integer.parseInt() and then we can compare accordingly and if any of the one terminates 
//     then also check with 0 and return the answer accordingly.
    
    public int compareVersion(String version1, String version2) {
        String[] versionlist1 = version1.split("\\.");
        String[] versionlist2 = version2.split("\\.");
        
        int idx1 = 0, idx2 = 0, n1 = versionlist1.length, n2=versionlist2.length;
        
        while(idx1<n1 && idx2<n2){
            int num1 = Integer.parseInt(versionlist1[idx1]);
            int num2 = Integer.parseInt(versionlist2[idx2]);
            idx1++;
            idx2++;
            if(num1>num2){
                return 1;
            }
            else if(num1<num2){
                return -1;
            }
            
        }
        
        
        while(idx1<n1){
            int num1 = Integer.parseInt(versionlist1[idx1]);
            idx1++;
            if(num1>0){
                return 1;
            }
        }
        
        
        while(idx2<n2){
            int num2 = Integer.parseInt(versionlist2[idx2]);
            idx2++;
            if(num2>0){
                return -1;
            }
        }
        
        return 0;
    }

    //     133. Clone Graph
//     tc O(n) sc O(n)
    
//     Here we are applying BFS approach to traverse in the graph and accordingly 
//     we are maintaining a hashmap to keep a track when we add a node in a queue
//     also to get new nodes corresponding to the original nodes of the graph.
//     when the child of a node is not there already in the map then only we add it
//     into the map and que and if yes or if no then make the current node's neighbor list by adding the current child
    
    
    
    
    
    public Node cloneGraph(Node node) {
        if(node==null){
            return node;
        }
        Map<Node,Node> map = new HashMap<>();
        LinkedList<Node> que = new LinkedList<>();
        que.addLast(node);
        Node newNode = new Node(node.val);
        map.put(node,newNode);
        
        while(que.size()!=0){
            int size = que.size();
            while(size-->0){
                Node orgNode = que.removeFirst();
                for(Node child:orgNode.neighbors){
                if(!map.containsKey(child)){
                    Node newChild = new Node(child.val);
                    map.put(child,newChild);
                    que.addLast(child);
                }
                Node newN = map.get(orgNode);
                newN.neighbors.add(map.get(child));
                }
            } 
        }
        return map.get(node);
        
    }

    

//     171. Excel Sheet Column Number
//     tc O(n) sc O(1)
//     So make the arrangements that Starting from the last index keep
//     on calculating the sum with the factor of 26 just like binary to decimal conversion
    
    
    public int titleToNumber(String columnTitle) {
        int sum=0;
        int fact=1;
        for(int i=columnTitle.length()-1;i>=0;i--){
            char ch = columnTitle.charAt(i);
            sum = sum + (ch - 'A' + 1)*fact;
            fact *= 26;
        }
        return sum;
    }

    
//     1288. Remove Covered Intervals
//     tc O(nlogn) sc O(1)
//     we will count the removal of intervals by first sorting the array on the basis
//     of first index and then in decreasing order of second index if first index is equal
//     Then accordingly we will maintain the msf and if any interval's second index is smaller
//     than msf increment the removeCount.
    
    
    public int removeCoveredIntervals(int[][] intervals) {
        int removeCount = 0, msf=-1;
        Arrays.sort(intervals,(a,b)->{
           return a[0] == b[0]? b[1]-a[1] : a[0]-b[0];
        });
        
        for(int[] interval:intervals){
            if(msf>=interval[1]){
                removeCount++;
            }
            msf = Math.max(msf,interval[1]);
        }
        
        return intervals.length-removeCount;
        
    }




    // word ladder pending
    // do it 




}