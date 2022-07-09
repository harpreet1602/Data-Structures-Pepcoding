public class jumpGame6{
    // 1696. Jump Game VI
//         tc O(nlogk) sc O(k)
//     
public int maxResult(int[] nums, int k) {
    // Score, Index
    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
       return b[0] - a[0]; 
    });
    int n = nums.length;
    pq.add(new int[]{nums[0],0});
    int maxScore=nums[0];
    for(int i=1;i<n;i++){
        while(!((i-pq.peek()[1])<=k)){
            pq.remove();
        }
        int[] rpair = pq.peek();
        maxScore = rpair[0]+nums[i];
        pq.add(new int[]{maxScore,i});
    }
    return maxScore;
}
}