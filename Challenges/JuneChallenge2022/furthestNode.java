public class furthestNode {
    
//     1642. Furthest Building You Can Reach
//     tc O(nlogn) => iterate for n elements and for each operation if priority queue operation is used it takes logn time 
    // sc O(ladders) => ladders space is taken in priority queue 
//     
//     In this question, greedy approach is used with the help of min priority queue 
//     We will be storing the differences which we have to cover through ladders in pq and when it exceeds ladders length
//     we will pop out the difference that will be checked can it be covered with bricks if yes keep on going otherwise if not then stop and return the farthest index it has reached
//     In the end if we don't meet the return condition this means we have reached till last so heights.length-1 will be the ans.
public int furthestBuilding(int[] heights, int bricks, int ladders) {
    //         min heap
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int n = heights.length,diff=0,reqBricks=0;
            for(int i=0;i<n-1;i++){
                diff = heights[i+1]-heights[i];
                if(diff>0){
                    pq.add(diff);
                    if(pq.size()>ladders){
                        reqBricks = pq.remove();
                        bricks -= reqBricks;
                        if(bricks<0){
                            return i;
                        }
                    }
                }
            }
            return n-1;
        }
}
