import java.util.LinkedList;


public class l001{
    
//     338. Counting Bits
//     tc O(n) sc O(n)
//     So observe the pattern by doing a dry run for 10 numbers that for even index the 
//     answer will be same as ind/2 as it is just the left shift operation of the ind/2
//     ans for odd ind the ans is same as ind-1 as after even ine more one comes in the pattern
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        ans[0] = 0;
        for(int i=1;i<=n;i++){
            if(i%2==0){
                ans[i] = ans[i/2];
            }
            else{
                ans[i] = ans[i-1] + 1;
            }
        }
        return ans;        
    }

    
//     392. Is Subsequence
    // tc O(O(t.length)) sc O(1)
//    Just apply two pointer approach and just check regularly the subsequence  
    public boolean isSubsequence(String s, String t) {
        int i=0,j=0;
        while(i<s.length() && j<t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        return i == s.length();
    }


    // 740. Delete and Earn
//     tc O(n) sc O(n)
//     In this question, dp has been applied whether to take the current ele or not
//     WIth tabulation, where we are making use of the freq array and dp array
//     we have made the size of the array 10002 to get the answer at 10001 index
//     Because the the answer uses the last two indices answer
//     so if we are considering the last one or we consider the second last one
//    plus ind * freq[ind] i.e.   dp[i] = Math.max(dp[i-1],dp[i-2] + i*freq[i]);
//     By this our answer will be made in the end.
    
    public int deleteAndEarn(int[] nums) {
        int[] freq = new int[10002];
        int[] dp = new int[10002];
        
        for(int i=0;i<nums.length;i++){
            freq[nums[i]]++;
        }
        
        dp[0] = 0;
        dp[1] = 1 * freq[1];
        
        for(int i=2;i<=10001;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2] + i*freq[i]);
        }
        
        return dp[10001];
        
    }

//     21. Merge Two Sorted Lists

//     tc O(n) sc O(1)
//     So just sort the two sorted list like you do in arrays
//     so whatever node will be smaller that will be selected
//    we can just checkout the technique here of doing it. 
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
          if(l1==null || l2==null)
        {
            return l1!=null?l1:l2;
        }
        ListNode dummy=new ListNode(-1);
        ListNode dp=dummy,p1=l1,p2=l2;
        while(p1!=null && p2!=null)
        {
            if(p1.val<=p2.val)
            {
                dp.next=p1;
                p1=p1.next;
            }
            else
            {
                dp.next=p2;
                p2=p2.next;
            }
            dp=dp.next;
        }
        dp.next=p1!=null?p1:p2;
        return dummy.next;
    }

    class ListNode {
             int val;
             ListNode next;
             ListNode(int x) {
                 val = x;
                 next = null;
             }
         }
//     141. Linked List Cycle
//     tc O(n) sc O(1)
//     Two pointers one slow and one fast
//     if slow becomes equal to fast then there is a cycle 
//     otherwise fast becomes null anytime then there is no cycle
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null){
            return false;
        }
        ListNode slow,fast;
        slow = fast = head;
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
            if(fast!=null){
                fast = fast.next;
            }
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
    

    
//     2. Add Two Numbers
//     tc O(n) => for addition sc O(n) => for making a new list for answer
//     numbers are given in reverse order and the answer will also come in reverse order
//     so we don't need to take the tention as we are getting the flow from 
//     LSB to MSB (most siginificant bit) of both numbers and sum
//     so just keep on going untill this condition  while(n1!=null || n2!=null || carry==1) => for understanding this condition we can see 
//     Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
// Output: [8,9,9,9,0,0,0,1]
//     keep on computing the addition, digit and next carry 
//     Just do a dry run to get a logic 
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n1 = l1, n2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        int carry = 0;
        while(n1!=null || n2!=null || carry==1){
            
            int sum = (n1!=null?n1.val:0) + (n2!=null?n2.val:0) + carry;
            int digit = sum%10;
            curr.next = new ListNode(digit);
            curr = curr.next;
            carry = sum/10;
            if(n1!=null)
            n1 = n1.next;
            if(n2!=null)
            n2 = n2.next;
        }
        return dummy.next;
    }


    
//   20. Valid Parentheses  
//     tc O(n) sc O(n)
//     So just keep on adding the opening parentheses in the stack 
//     and pop the corresponding ones by checking the condition
//     At any point the corresponding parentheses are not found return false 
//     If the stack does not become empty after traversing then also return false
//     If the stack becomes empty return true.
    public boolean isValid(String s) {
        LinkedList<Character> st = new LinkedList<>();
        st.addFirst('1');
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='(' || ch=='{' || ch=='['){
                st.addFirst(ch);
            }
            else if(ch==')' && st.getFirst()=='('){
                st.removeFirst();
            }
            else if(ch=='}' && st.getFirst()=='{'){
                st.removeFirst();
            }
            else if(ch==']' && st.getFirst()=='['){
                st.removeFirst();
            }
            else{
                return false;
            }
        }
        if(st.getFirst()=='1'){
            return true;
        }
        return false;
    }

    
//     946. Validate Stack Sequences
//     tc O(n) sc O(n)
//     So we will be adding the ele from pushed arr and also we will have rigrous
//     remove when the top of the stack matches with popped of idx
//     then we keep on removing the ele from stack and increment the idx of popped
//     in the end if we reached end of the popped array then return true
//     otherwise false.
//     Do dry run on example test case.
    
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        LinkedList<Integer> st = new LinkedList<>();
        int idx=0;
        for(int ele:pushed){
            st.addFirst(ele);
            while(st.size()!=0 && st.getFirst() == popped[idx]){
                idx++;
                st.removeFirst();
            }
        }
        return idx == popped.length;
    }

    
//     1029. Two City Scheduling
    
//     tc O(nlogn) sc O(1)
//     So just sort the two d array on the basis of the difference in the increasing order
//     from negative difference to positive one 
//     so that the in most of the negative differences there is benefit in going to city a
    // in the most of the positive difference there is bennefit in going to city b.
//     so initially put all elements of the half array into city a and rest in b to get 
//     minimum answer
public int twoCitySchedCost(int[][] costs) {
    Arrays.sort(costs,(a,b)->{
       return ((a[0]-a[1]) - (b[0]-b[1])); 
    });
    int ans = 0;
    for(int i=0;i<costs.length;i++){
        if(i<costs.length/2){
            ans += costs[i][0];
        }else{
            ans += costs[i][1];
        }
    }
    return ans;
}


  // 704. Binary Search
//     tc O(logn) sc O(1)
//     So ust applying the binary search and setting the low and high one ahead and one earlier 
//     position from mid and the loop will run till low <= high.
public int search(int[] nums, int target) {
    int low = 0, high = nums.length-1;
    while(low<=high){
        int mid = (low + ((high-low)/2));
        
        // int mid = (high+low)/2;
        if(nums[mid] == target){
            return mid;
        }
        else if(target < nums[mid]){
            high = mid - 1;
        }
        else {
            low = mid + 1;
        }
    }
    return -1;
       
}


//     1337. The K Weakest Rows in a Matrix
//     Brute linear search along with priority queue
//     where we are putting count,ind in pq and accordingly eliminating the wrong answers
//     by making maxheap
//     Then make our answer out of it.
//     tc O(nlogk + n^2) sc O(k)
//    
    public int getcount1(int[] row){
        int count = 0;
        for(int i=0;i<row.length;i++){
            if(row[i] == 1){
                count++;
            }
        }
        return count;
    }
    
    //     tc O(nlogk + nlogn) sc O(k)
//     Optimized binary search along with priority queue

      public int getcount(int[] row){
        int low = 0,high=row.length;
          while(low<high){
              int mid = low + (high-low)/2;
              if(row[mid]==1){
                  low = mid+1;
              }
              else{
                  high = mid;
              }
          }
        return low;
    }
//         count, index
        public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
           if(a[0]==b[0]){
               return b[1] - a[1];
           } 
           else{
               return b[0] - a[0];
            }
        });
        
        for(int i=0;i<mat.length;i++){
            int count = getcount(mat[i]);
            
            pq.add(new int[]{count,i});
            
            if(pq.size()>k){
                pq.remove();
            }
        }
        
        int ind = k-1;
        int[] ans = new int[k];
        while(pq.size()!=0){
            ans[ind--] = pq.remove()[1];
        }
        
        return ans;
        
        
    }












}