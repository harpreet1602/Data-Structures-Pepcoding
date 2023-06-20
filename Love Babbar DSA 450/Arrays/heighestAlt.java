public class heighestAlt {
    
    // 1732. Find the Highest Altitude
// tc O(n) sc O(1)
//     So it is just a prefix sum question and that also, we just have to maintain it in a variable starting from 0, keep on updating the max at every step.
//     and return maximum height which is gained at any point.
public int largestAltitude(int[] gain) {
    int max = 0, prefixSum = 0;
    
    for(int i=0;i<gain.length;i++){
        prefixSum += gain[i];
        max = Math.max(max,prefixSum);
    }
    return max;
}
}
