public class maxPoint {
    
    // 149. Max Points on a Line
// tc O(n^2) sc O(n^2)
//     y=mx+c
//     for c thing , we are taking base as every point and finding the slopes.
//     HashMap will be used here because we will check the frequencies
//     Running n^2 solution 
//     If the same array is not there
//     then find the slope y = (x2-x1)/(y2-y1)
//     if x1 = x2 then it is vertical line
//     in that case taking the out of range value as the slope
//     otherwise normal slope as value 
//     store slopes vs number of points
//     whichever is the maximum that tells us the max number of points lying on a line return maxfreq + 1 for the base point itself.
    
public int maxPoints(int[][] points) {
    HashMap<Double,Integer> map = new HashMap<>();
    int n = points.length, m = points[0].length, maxFreq = 0;
    
    for(int[] point1:points){
        map = new HashMap<>();
        for(int[] point2:points){
            if(!Arrays.equals(point1,point2)){
                int y = point2[1]-point1[1];
                int x = point2[0]-point1[0];
//                     vertical line when x1 = x2
                double slope = 0;
                if(x!=0){
                    slope = ((double)y)/x;
                }
                else{
                    slope = (int)1e4+1;
                }
                map.put(slope,map.getOrDefault(slope,0)+1);
                maxFreq = Math.max(maxFreq,map.get(slope));
            }
        }
    }
    return maxFreq+1;
}
}
