import java.util.PriorityQueue;

public class targetMultipleSums {
    
//     1354. Construct Target Array With Multiple Sums
//     tc O(nlogn) sc O(n)
//     lee explanation
//     The total sum always bigger than all elements.
// We can decompose the biggest number.
// Each round we get the current maximum value,
// delete it by the sum of other elements.

// Time O(N) to build up the priority queue.
// Time O(logMaxAlogN)) for the reducing value part.
// We have O(maxA) loops, which is similar to gcd
// Space O(N)

// % operation is totally much more important than using heap.
// If brute force solution is accepted,
// then the solutions without % are right and good.

// But the truth is that, solution without % should be TLE.
// So I afraid that, without % is wrong to me.
    
//     Start from the original array first and then go towards making all 1s in the array
//     So basically reversal of the question is done in order to solve it
//     Make  use of priority queue i.e. also max heap
//     First of all totalsum is calculated and all the original ele are added into pq.
//     Till the time pq becomes empty keep on going
//     ṛemove the max ele from pq, get the remaining sum
//     check if any of the maxele or remaining sum is 1 means every ele in the array becomes 1 so return true in this case.
//     if remaining sum is coming out to be 0 or our maxelebecomes less than the remaining sum this means the false condition all the 1s cannot be obtained.
//     calculate the next ele to be placed in place of maxele that will be previous maxele%remainingsum ( could be maxele-remaining sum  but tle will come because this will several times so do this instead)
//     if the new maxele come out to be 0 return false.
//     add the new maxele in pq 
//     maintain the totalsum of all the ele which are present in pq for the next step
//     return true outside.
public boolean isPossible(int[] target) {
    //         Max heap
            long totalSum = 0;
            int maxEle=0;
            PriorityQueue<Integer> pq =new PriorityQueue<>((a,b)->{
                return b-a;
            });
            
            for(int ele:target){
                totalSum += ele;
                pq.add(ele);
            }
    
            while(pq.size()!=0){
                maxEle = pq.remove();
                long remainingSum = totalSum-maxEle;
                
                if(maxEle == 1||remainingSum == 1){
                    return true;
                }
                if(remainingSum == 0||maxEle<remainingSum){
                    return false;
                }
                
                maxEle = (int)(maxEle%remainingSum);
                
                if(maxEle == 0)
                    return false;
                
                pq.add(maxEle);
                totalSum = maxEle + remainingSum;
            }
            return true;
        }
}
