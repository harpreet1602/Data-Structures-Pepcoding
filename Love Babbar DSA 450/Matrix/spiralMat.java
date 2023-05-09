public class spiralMat {
    class Solution {
        // 54. Spiral Matrix
    // tc O(n*m) sc O(1)
    //     This question can be done through four pointers row start, row end and column start and column end
    //    though it can be done through two pointers as well with a boolean array 
        
    //     Now in this we are going in the spiral fashion till the time rs does not exceed re and cs does not exceed ce at every loop traversal 
    //     and in the outer check as well so wherever this condition happen break out of the loop
    //     rest do the dry run to understand this more.
        public List<Integer> spiralOrder(int[][] matrix) {
            int n = matrix.length, m = matrix[0].length, rs = 0, re = n-1, cs = 0, ce = m-1;
            List<Integer> list = new ArrayList<>();
            
            while(rs<=re && cs<=ce){
    //             start row
                for(int j=cs;j<=ce;j++){
                    list.add(matrix[rs][j]);
                }
                rs++;
                if(rs>re){
                    break;
                }
    //             end column
                for(int i=rs;i<=re;i++){
                    list.add(matrix[i][ce]);
                }
                ce--;
                
                if(cs>ce){
                    break;
                }
    //             end row
                for(int j=ce;j>=cs;j--){
                    list.add(matrix[re][j]);
                }
                re--;
                if(rs>re){
                    break;
                }
    //             start column
                for(int i=re;i>=rs;i--){
                    list.add(matrix[i][cs]);
                }
                cs++;
                if(cs>ce){
                    break;
                }
            }
            return list;
        }
    }
}
