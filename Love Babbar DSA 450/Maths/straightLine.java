package Maths;

public class straightLine {
    class Solution {
        // 1232. Check If It Is a Straight Line
    // tc O(n) sc O(1)
    //     Slope is constant for a straight line
    //     just find the slope with first two points and compare with first point and all other points for slope then if any slope is different return false that it is not straight line
    //     m = (y2-y1)/(x2-x1)
    //     (y-y1)/(x-x1) = (y2-y1)/(x2-x1) => write it on copy
    //     we will get after cross multiplying
    //         ((y-y1)*(x2-x1))!=((y2-y1)*(x-x1))
        
        public boolean checkStraightLine(int[][] coordinates) {
            int n = coordinates.length;
            int x2 = coordinates[1][0];
            int x1 = coordinates[0][0];
            int y2 = coordinates[1][1];
            int y1 = coordinates[0][1];
            for(int i=2;i<n;i++){
                int x = coordinates[i][0];
                int y = coordinates[i][1];
                if(((y-y1)*(x2-x1))!=((y2-y1)*(x-x1))){
                    return false;
                }
            }
            return true;
        }
    }
}
