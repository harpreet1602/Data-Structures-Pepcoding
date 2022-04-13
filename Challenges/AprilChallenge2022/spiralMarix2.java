public class spiralMarix2 {
   
//     59. Spiral Matrix II
//     time O(n^2) space O(1)
//     so do a dry run by taking four pointers startrow, startcol,endrow,endcol
//     accordingly the pointers will change to make the spiral matrix.
    // traverse in 4 directions differently to properly make the answer by changing pointers
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int sr = 0, sc =0, er=n-1,ec=n-1;
        int count = 1;
        while(sr<=er && sc<=ec){
//             move right
            for(int j=sc;j<=ec;j++){
                ans[sr][j] = count++;
            }
            sr++;
            
//             move bottom
            for(int i=sr;i<=er;i++){
                ans[i][ec] = count++;
            }
            ec--;
            
//             move left
            if(sr<=er){
                for(int j=ec;j>=sc;j--){
                    ans[er][j] = count++;
                }
                er--;
            }
        
//             move top
            if(sc<=ec){
            for(int i =er;i>=sr;i--){
                ans[i][sc] = count++;   
            }
                sc++;
            }
       
        }
         return ans;
    } 
}
