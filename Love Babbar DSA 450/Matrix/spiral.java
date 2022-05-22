import java.util.List;
import java.util.ArrayList;

public class spiral{
    
//     54. Spiral Matrix
//     tc O(n*m) sc O(n*m)
//     Have two pointers row and col, also maintain the visited array which will
//     serve an important purpose of which cell to visit or not.
//     Outer loop condition => if I am in the boundary and I am not visited then
//     run all the four loops which will traverse in the boundary fashion
//     When the outer loop will run again and again it will make the traversal spiral
//     In inner loop go from left to right then top to bottom then right to left
//     then bottom to top and if the next condition will be valid from outer loop
//    then again repeat the process
//     When I am not at a valid position then outer loop will check automatically
//     if I am outside the boundary or I am visited .
    
public List<Integer> spiralOrder(int[][] matrix) {
    int n = matrix.length, m = matrix[0].length;
    boolean[][] vis = new boolean[n][m];
    int row = 0, col = 0;
    List<Integer> ans = new ArrayList<>();
    
    while(row>=0 && col>=0 && row<n && col<m && vis[row][col] == false){
    
//         left to right
       while(col<m &&vis[row][col]==false){
            vis[row][col] = true;
            ans.add(matrix[row][col]); 
            col++;
        }
        row++;
        col--;
//             top to bottom
       while(row<n && vis[row][col]==false){
            vis[row][col] = true;
            ans.add(matrix[row][col]);
            row++;
        }
        col--;
        row--;
//             right to left
       while(col>=0 && vis[row][col]==false){
            vis[row][col] = true;
            ans.add(matrix[row][col]);
            col--;
        }
        row--;
        col++;
//             bottom to top
        while(row>=0 && vis[row][col]==false){
            vis[row][col] = true;
            ans.add(matrix[row][col]);
            row--;
        }
        col++;
        row++;
      
    }
    return ans;
    
}
}