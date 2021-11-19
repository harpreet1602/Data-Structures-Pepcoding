import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Deque;
import java.util.ArrayDeque;
public class l001{
    
// Right Rotate Array by k
//  negative case of k is also handled

public void swap(int[] nums,int i,int j){
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}
public void reverse(int[] nums,int si,int ei){
    int i = si, j =ei;
    while(i<j){
        swap(nums,i++,j--);
    }
}
public void rotate1(int[] nums, int k) {
    int size = nums.length;
//         both cases handled for positive as well as negative
    k = ((k%size) + size) % size;
    reverse(nums,0,k-1);
    reverse(nums,k,size-1);
    reverse(nums,0,size-1);
}
    // 189. Rotate Array
    // time O(n) space O(1)
    public void rotate(int[] nums, int k) {
        int size = nums.length;
    //         both cases handled for positive as well as negative
        k = ((k%size) + size) % size;
        reverse(nums,0,size-1);
        reverse(nums,0,k-1);
        reverse(nums,k,size-1);
        
    }

    // segregate positive and negative
    void segregateposandneg(int[] arr, int n) {
        // code here
        int neg =-1, ptr = 0;
        while(ptr<n){
            if(arr[ptr]<0){
                swap(arr,++neg,ptr);
            }
            ptr++;
        }
    }
    // https://practice.geeksforgeeks.org/problems/segregate-0s-and-1s5106/1
    void segregate0and1(int[] arr, int n) {
        // code here
        int neg =-1, ptr = 0;
        while(ptr<n){
            if(arr[ptr]==0){
                swap(arr,++neg,ptr);
            }
            ptr++;
        }
    }


    // 75. Sort Colors
    // time O(n) space O(1)
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p1 = -1, p2 = 0, p3 = n-1;
        while(p2<=p3){
            if(nums[p2] == 2){
                swap(nums,p2,p3--);
            }
            else if(nums[p2]==0){
                swap(nums,++p1,p2++);
            }
            else{
                p2++;
            }
        }
    }

    // https://practice.geeksforgeeks.org/problems/max-sum-in-the-configuration/1
    // brute force -> get all the rotations of the array calculate the max sum out of it.
    // time O(n^2) space O(n)
    // optimised
    // time O(n) space O(1)
    int max_sum(int A[], int n)
    {
    	// Your code here
    	int csum =0,totalSum=0,max=0,nsum=0;
    	for(int i=0;i<n;i++){
    	    totalSum += A[i];
    	}
    	for(int i=0;i<n;i++){
    	    csum += A[i]*i;
    	}
    	for(int i = 1;i<=n;i++){
    	    nsum = csum - totalSum + (n*A[i-1]);
    	    
    	    csum = nsum;
    	    max = Math.max(max,csum);
    	}
        return max;	
    }	

    // 11. Container With Most Water
    public int maxArea(int[] height) {
        int n = height.length, p1 = 0, p2 = n-1, maxArea = 0,length,width,area;
        
        while(p1<p2){
            length = p2-p1;
            width = Math.min(height[p1],height[p2]);
            area = length*width;
            maxArea = Math.max(maxArea,area);
            
            if(height[p1]<=height[p2]){
                p1++;
            }
            else{
                p2--;
            }
        }
        return maxArea;
    }

    // 3. Longest Substring Without Repeating Characters
    public int lengthOfLongestSubstring(String s) {
        int si = 0, n = s.length(), ei = 0,count = 0,len = 0;
        int[] freq = new int[128];
        // all the ascii characters
        while(ei<n){
            if(freq[s.charAt(ei)]==1){
                count++;
            }
            freq[s.charAt(ei)]++;
            ei++;
            while(count>0){
                if(freq[s.charAt(si)] > 1){
                    count--;
                }
                freq[s.charAt(si)]--;
                si++;
            }
            len = Math.max(len,ei-si);
        }
        return len;
    }

    //https://www.lintcode.com/problem/928
    // 928 · Longest Substring with At Most Two Distinct Characters 
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        // Write your code here
        int si = 0, ei = 0, n = s.length(), count = 0, len = 0;
        int[] freq = new int[128];
        while(ei<n){
            if(freq[s.charAt(ei)] == 0){
                count++;
            }
            freq[s.charAt(ei)]++;
            ei++;

            while(count>2){
                if(freq[s.charAt(si)] == 1){
                    count--;
                }
                freq[s.charAt(si)]--;
                si++;
            }
            len = Math.max(len,ei-si);
        }
        return len;
    }
    
    // https://www.lintcode.com/problem/386
    // 386 · Longest Substring with At Most K Distinct Characters
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
         int si = 0, ei = 0, n = s.length(), count = 0, len = 0;
        int[] freq = new int[128];
        while(ei<n){
            if(freq[s.charAt(ei)] == 0){
                count++;
            }
            freq[s.charAt(ei)]++;
            ei++;

            while(count>k){
                if(freq[s.charAt(si)] == 1){
                    count--;
                }
                freq[s.charAt(si)]--;
                si++;
            }
            len = Math.max(len,ei-si);
        }
        return len;
    }

    // Longest K unique characters substring 
    // https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1#
    public int longestkSubstr(String s, int k) {
        // code here
          int si = 0, ei = 0, n = s.length(), count = 0, len = -1;
        int[] freq = new int[128];
        while(ei<n){
            if(freq[s.charAt(ei)] == 0){
                count++;
            }
            freq[s.charAt(ei)]++;
            ei++;

            while(count>k){
                if(freq[s.charAt(si)] == 1){
                    count--;
                }
                freq[s.charAt(si)]--;
                si++;
            }
            if(count==k)
            len = Math.max(len,ei-si);
        }
        return len;
    }


    // 76. Minimum Window Substring

    public String minWindow(String s, String t) {
        int si = 0, ei = 0, n = s.length(), len = (int)1e9, gsi = 0, need=0;
        int[] requirements = new int[128];
        for(int i=0;i<t.length();i++){
            requirements[t.charAt(i)]++;
            need++;
        }
        
        while(ei<n){
            if(requirements[s.charAt(ei)] > 0){
                need--;
            }
            requirements[s.charAt(ei)]--;
            ei++;
            
            while(need == 0){
                if((ei-si)<len){
                gsi = si;
                len = ei-si;
                }
                if(requirements[s.charAt(si)]==0){
                    need++;
                }
                requirements[s.charAt(si)]++;
                si++;
            }
            
        }
        return len==(int)1e9?"":s.substring(gsi,gsi+len);
    }


    // 2 pending 

    // 1456




    // 992. Subarrays with K Different Integers
    public int subarraysWithAtmostKDistinct(int[] nums, int k){
        int si = 0 , ei = 0, count = 0, ans = 0, n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(ei<n){
            if(!map.containsKey(nums[ei])){
                count++;
            }
            map.put(nums[ei],map.getOrDefault(nums[ei],0)+1);
            ei++;
            
            while(count>k){
                if(map.get(nums[si]) == 1)
                {
                    count--;
                }
                map.put(nums[si],map.get(nums[si])-1);
                if(map.get(nums[si]) == 0)
                    map.remove(nums[si]);
                si++;
            }
            ans += ei-si;
        }
        return ans;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysWithAtmostKDistinct(nums, k) - subarraysWithAtmostKDistinct(nums, k - 1);  
    }



    // runtime faster but more space taken but still a better choice to use freq array than a HashMap
    public int subarraysWithAtmostKDistinct1(int[] nums, int k){
        int si = 0 , ei = 0, count = 0, ans = 0, n = nums.length;
        int[] freq = new int[20001];
        while(ei<n){
            if(freq[nums[ei]] == 0){
                count++;
            }
            freq[nums[ei]]++;
            ei++;
            
            while(count>k){
                if(freq[nums[si]] == 1)
                {
                    count--;
                }
                freq[nums[si]]--;
                si++;
            }
            ans += ei-si;
        }
        return ans;
    }
    public int subarraysWithKDistinct1(int[] nums, int k) {
        return subarraysWithAtmostKDistinct1(nums, k) - subarraysWithAtmostKDistinct1(nums, k - 1);  
    }


    // 1248. Count Number of Nice Subarrays
      public int subarraysWithAtmostKOdd(int[] nums, int k){
        int si = 0 , ei = 0, count = 0, ans = 0, n = nums.length;

        while(ei<n){
            if(nums[ei] % 2 != 0){
                count++;
            }
            ei++;
            
            while(count>k){
                if(nums[si] % 2 != 0)
                {
                    count--;
                }
                si++;
            }
            ans += ei-si;
        }
        return ans;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return subarraysWithAtmostKOdd(nums, k) - subarraysWithAtmostKOdd(nums, k - 1);
    }


    // 239. Sliding Window Maximum
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            return nums[b] - nums[a];
        });
        
        int idx = 0, n= nums.length;
        int[] ans = new int[n-k+1];
        
        for(int i=0;i<n;i++){
            while(pq.size()>0 && pq.peek()<=i-k){
                pq.remove();
            }
            
            pq.add(i);
            if(i>=k-1){
                ans[idx++] = nums[pq.peek()];
            }
        }
        return ans;
    }


        

        
    //     time O(n) space O(n)
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length, idx=0;
        Deque<Integer> dq = new ArrayDeque<>();
        
        int[] ans = new int[n-k+1];
        for(int i=0;i<n;i++){
    //             1.find the front is in range or not
            while(dq.size()>0 && dq.peek()<=i-k){
                dq.remove();
            }
            
    //             2.check whether the last ele is smaller than or equal to current ele
            while(dq.size()>0 && nums[dq.peekLast()]<=nums[i]){
                dq.removeLast();
            }
    //             3.add myself
            dq.add(i);
            
            if(i>=k-1){
                ans[idx++] = nums[dq.peek()];
            }
        }
        return ans;
    }























}