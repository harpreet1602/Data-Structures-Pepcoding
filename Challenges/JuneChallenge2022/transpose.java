public class transpose{
    
    // 867. Transpose Matrix
    
//     tc O(n*m) => for traversing the matrix
    // sc O(1) => space taken that was asked so no extra space is taken.
//     Brute force
//     make another array of size m and n of the matrix of size n and m
//     as we have to take transpose so traverse the matrix and put ans[j][i] as matrix[i][j]
//     This thing will transpose the whole matrix because this is the logic of transposing i.e. exchange the values by inverting their indexes 
//     Matrix is flipped over its diagonal, switching the matrix's row and column indices.
public int[][] transpose1(int[][] matrix) {
    int n = matrix.length, m = matrix[0].length;
    int[][] ans = new int[m][n];
    
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            ans[j][i] = matrix[i][j];
        }
    }
    return ans;
}

}