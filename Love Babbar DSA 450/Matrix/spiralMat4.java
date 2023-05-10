public class spiralMat4 {
    class Solution {
        // 59. Spiral Matrix II
    // tc O(n*m) sc O(1)
    //     Just do spiral traversal and keep on increasing pointer and put in the matrix 2d
    //     with 4 pointers
        public int[][] generateMatrix(int n) {
            int[][] mat = new int[n][n];
            int rs = 0, re = n-1, cs = 0, ce = n-1,num=1;
            
            while(rs<=re && cs<=ce){
                for(int j=cs;j<=ce;j++){
                    mat[rs][j] = num++;
                }
                rs++;
                if(rs>re){
                    break;
                }
                
                for(int i=rs;i<=re;i++){
                    mat[i][ce] = num++;
                }
                ce--;
                if(cs>ce){
                    break;
                }
                
                for(int j=ce;j>=cs;j--){
                    mat[re][j] = num++;
                }
                re--;
                if(rs>re){
                    break;
                }
                
                for(int i=re;i>=rs;i--){
                    mat[i][cs] = num++;
                }
                cs++;
                if(cs>ce){
                    break;
                }   
            }
            return mat;
        }
    }
}
