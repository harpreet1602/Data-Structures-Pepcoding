
public class search2d {
    
//     Brute force
//     Search blindlessly in the matrix and return the answer
//     tc O(n*m) sc O(1)
    
    
//     Better
//     first of all find the row number through linear search and then in that row
//     apply binary search and if the element would be present then you will get it otherwise return false
//    tc O(n + log (m)) => O(n) sc O(1) 
public boolean searchMatrix1(int[][] matrix, int target) {
    int row = 0,n=matrix.length,m = matrix[0].length;
    
    while(row<n){
        if(matrix[row][m-1]>=target){
//          apply binary search on this row
//   tc O(log (m-1)) 
            int l = 0, h = m-1;
            while(l<=h){
                int mid = (l+h)/2;
                if(target == matrix[row][mid]){
                    return true;
                }
                else if(target > matrix[row][mid]){
                    l = mid+1;
                }
                else{
                    h = mid-1;
                }
            }
            return false;
        }
        row++;       
    }
    return false;
}

//     Optimised
//    first of all find the row number through binary search and then in that row
//     mistake that is probable can be when you are applying binarty search remember when to do n-1 and when to do m-1? 
//     apply binary search and if the element would be present then you will get it otherwise return false
//     tc O(Math.max(log n, log m)) => O(log n) sc O(1)
 public boolean searchMatrix(int[][] matrix, int target) {
     int row = 0,n=matrix.length,m = matrix[0].length, low = 0, high = n-1;
     
     while(low<=high){
         int mid = (low+high)/2;
         
         if(matrix[mid][m-1] == target){
             return true;
         }
         
         else if(target < matrix[mid][m-1]){
             row = mid;
             high = mid-1;
         }
         
         else{
             low = mid+1;
         }
     }
     
     
     int l = 0, h = m-1;
            while(l<=h){
                int mid = (l+h)/2;
                if(target == matrix[row][mid]){
                    return true;
                }
                else if(target > matrix[row][mid]){
                    l = mid+1;
                }
                else{
                    h = mid-1;
                }
            }
            return false;

 }
}
