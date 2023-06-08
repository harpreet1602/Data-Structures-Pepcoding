public class countNegSort {
        // 1351. Count Negative Numbers in a Sorted Matrix
// tc (nlogm) sc O(1)
//     for the n rows we are applying binary search to find the first negative number
//     in that there can be case that all are negative numbers then our index will point to 0 and if all are positive numbers then our ind will point to m so m-m will become 0
//     Accordingly when correct first negative ele is found at index ind
//    maintain the count with m-index of first negative element.  
public int countNegatives(int[][] grid) {
    int n = grid.length, count=0, m = grid[0].length;
    
    for(int i=0;i<n;i++){
        int ind = binSearch(i,grid);
        count += (m-ind);
    }
    return count;
}
private int binSearch(int i,int[][] grid){
    int m=grid[0].length, low = 0, high = m-1;
    
    while(low<=high){
        int mid = (low+(high-low)/2);
        
        if(grid[i][mid] < 0){
            high = mid-1;
        }
        else{
            low = mid+1;
        }
    }
    return low;
}
}
