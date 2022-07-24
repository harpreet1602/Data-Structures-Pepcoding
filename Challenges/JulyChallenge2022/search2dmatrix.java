public class search2dmatrix{
    //   240. Search a 2D Matrix II

//     tc O(row + col) => we are traversing the rows and  column simultaneously.
    // sc O(1)
//     starting from the leftmost ending, then going towards 0th row and from col 0 to m th col
//     simply see if the current ele is greater than the target then we can't find the target in the entire row.
//     so decrement row pointer and if it is smaller than the target then increment col pointer.
//     if found the target return true
//     if not found using this traversal then return false
public boolean searchMatrix(int[][] matrix, int target) {
    int n = matrix.length, m = matrix[0].length, row = n-1, col = 0;
    
    while(row>=0 && col<m){
        if(matrix[row][col]==target){
            return true;
        }
        else if(matrix[row][col]>target){
            row--;
        }
        else{
            col++;
        }
    }
    return false;
}
}