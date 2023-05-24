public class maxSubScore {
    class Solution {
        // 2542. Maximum Subsequence Score
        // tc O(nlogn + nlogk)=>O(nlogn) sc O(n+k)=>O(n)
        //     simply make the pair of both the arrays then sort the second array in deascending order so that we can consider the values 
        //     where we consider the current min value and from all the pairs behind there must be greater nums1 values for that we are having min heap
        //     where greater k-1 values are maintained 
        //     dry run to understand this.
            
            private class pair {
                int first;
                int second;
                public pair(int first,int second){
                    this.first = first;
                    this.second = second;
                }
            }
            public long maxScore(int[] nums1, int[] nums2, int k) {
                int n = nums1.length;
                long ans = 0,currSum = 0;
                pair[] arr = new pair[n];
                
                for(int i=0;i<n;i++){
                    arr[i] = new pair(nums2[i],nums1[i]);
                }
                
                Arrays.sort(arr,(a,b)->{
                   return b.first-a.first; 
                });
                
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                
                for(int i=0;i<k-1;i++){
                    currSum += arr[i].second;
                    pq.add(arr[i].second);
                }
                
                for(int i=k-1;i<n;i++){
                    currSum += arr[i].second;
                    ans = Math.max(ans,currSum*arr[i].first);
                    if(pq.size()!=0 && pq.peek()<arr[i].second){
                        currSum -= pq.remove();
                        pq.add(arr[i].second);
                    }
                    else{
                        currSum -= arr[i].second;
                    }
                }
                return ans;
            }
        }
}
