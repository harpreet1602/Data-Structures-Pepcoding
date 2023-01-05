package Challenges.JanuaryChallenge2023.PriorityQueue;

public class minNumBalloons {
    
   
    // 452. Minimum Number of Arrows to Burst Balloons
// tc O(nlogn) sc O(n)
//     PriorityQueue is used inside which we will get the shortest starting index element first
//     int array point is stored in the priority queue.
//     Point is added it in the priority queue.
//     After that we will keep on running the priority queue till the size is not 1
//     Two arrays are removed, and then check the condition of merging and make the compact merging
    // and add it into the priority queue 
//     else => add the answer + 1, add the second array back into the priority queue.
//     return ans+1 in the end because one pair will be left in the priority queue
    
public int findMinArrowShots1(int[][] points) {
    int ans = 0;
    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
        if(a[0]==b[0]){
            return Integer.compare(a[1],b[1]);
        }
        return Integer.compare(a[0],b[0]);
    });
    
    for(int[] point:points){
        pq.add(point);
    }
    
    while(pq.size()!=1){
        int[] arr1 = pq.remove();
        int[] arr2 = pq.remove();
        
        if(arr1[1]>=arr2[0]){
            int si = Math.max(arr1[0],arr2[0]);
            int ei = Math.min(arr1[1],arr2[1]);
            pq.add(new int[]{si,ei});
        }
        else{
            ans++;
            pq.add(arr2);
        }
    }
    return ans+1;
}
//     tc O(nlogn) sc O(1)
//     Optimized 
//     Sorting it on the basis of ending index.
//     Take a reach variable and whenver any point starting index not come in  reach we increment the answer and increase the reach to its ending point.
public int findMinArrowShots(int[][] points) {
    
    Arrays.sort(points,(a,b)->{
       return Integer.compare(a[1],b[1]); 
    });
    int ans = 1, reach = points[0][1];
    for(int[] point:points)
    {
        if(point[0]>reach){
            ans++;
            reach = point[1];
        }
    }
    return ans;
}
}
