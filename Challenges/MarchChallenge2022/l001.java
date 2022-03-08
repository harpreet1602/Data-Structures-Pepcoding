


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
    









}