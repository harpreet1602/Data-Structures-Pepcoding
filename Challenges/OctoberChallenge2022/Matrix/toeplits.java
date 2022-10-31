public class toeplits{
    
    // 766. Toeplitz Matrix
//     tc O(n*m) sc O(1)
//     just keep on traversing in the normal fashion and check the previous diagonal element
//     if any unmatched thing comes return false
//     otherwise after traversing the whole matrix as true.
public boolean isToeplitzMatrix(int[][] matrix) {
    int n = matrix.length, m = matrix[0].length;
    for(int i=1;i<n;i++){
        for(int j=1;j<m;j++){
            if(matrix[i-1][j-1]!=matrix[i][j]){
                return false;
            }
        }
    }
    return true;
}
}