public class matSum {
    
    // 1572. Matrix Diagonal Sum
// tc O(n^2) sc O(1)
//     Brute force
//     Run the loops and for the left diagonal elements => i == j
//     i+j == n-1, right diagonal elements i+j == n-1  
    
    public int diagonalSum(int[][] mat) {
        int sum = 0, n = mat.length;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j){
                    sum += mat[i][j];
                }
                else if(i+j == n-1){
                    sum += mat[i][j];
                }
            }
        }
        
        return sum;
    }
}
