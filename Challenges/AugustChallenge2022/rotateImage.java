public class rotateImage {
    
    // 48. Rotate Image
//     tc O(n^2+n^2)=> O(n^2) sc O(1)
//     take the transpose of matrix that is diagonal as a mirror and interchange across the diagonal
   // then take the reverse of every row in the matrix 
   // 90 degree angle rotated matrix will be obtained. 
   public void rotate(int[][] matrix) {
    transpose(matrix);
    reverse(matrix);
}
private void transpose(int[][] matrix){
    for(int i=0;i<matrix.length;i++){
        for(int j =i;j<matrix[0].length;j++){
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }
    }
}
 private void reverse(int[][] matrix){
    for(int i=0;i<matrix.length;i++){
        for(int j =0;j<matrix[0].length/2;j++){
            int temp = matrix[i][j];
            matrix[i][j] = matrix[i][matrix[0].length-1-j];
            matrix[i][matrix[0].length-1-j] = temp;
        }
    }
}
}
