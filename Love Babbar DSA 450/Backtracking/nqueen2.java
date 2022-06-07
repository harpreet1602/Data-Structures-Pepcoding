public class nqueen2{
       // 52. N-Queens II
    // tc O() sc O()
//     maintain a global count of the number of ways available for placing n queens.
//     rest is same as 51. N-Queens questions
    
private int count = 0;
    
public int totalNQueens1(int n) {
    boolean[][] vis = new boolean[n][n];
    
    recFill(vis,n,0);
    return count;
}
//     r will be used in recursion 
private void recFill(boolean[][] vis,int n,int r){
    if(r == n){
        count++;
        return;
    }
    
    for(int c=0;c<n;c++){
        if(isSafeToPlace(vis,r,c)){
            vis[r][c] = true;
            recFill(vis,n,r+1);
            vis[r][c] = false;
        }
    }
}

private boolean isSafeToPlace(boolean[][] vis,int r,int c){
//         4 checks
    int n = vis.length;
    for(int j=c-1;j>=0;j--){
        if(vis[r][j]){
            return false;
        }
    }
    for(int i=r-1;i>=0;i--){
        if(vis[i][c]){
            return false;
        }
    }
    for(int i=r-1,j=c-1;i>=0 && j>=0;i--,j--){
        if(vis[i][j]){
            return false;
        }
    }
    for(int i=r-1,j=c+1;i>=0 && j<n;i--,j++){
        if(vis[i][j]){
            return false;
        }
    }
    
    return true;
}



//     Further optimization => isSafe to place will be optimized by taking three boolean arrays of diag,adiag and col
//     diag is from right to left (front) and adiag is from left to right. (back)
//     So this will serve the purpose of one boolean array visited as well is we don't have to run 3 loops everytime to check the column, diag and adiag
//     So if the col, diag and adiag is available so in boolean it will be marked false otherwise if not available it will be marked as true which signifies there is already a queen placed 
//     So you can't place the another queen in the same column, diagonal and anti diagonal
public int totalNQueens(int n) {
    int m = n;
    boolean[] col = new boolean[m];
    boolean[] diag = new boolean[m+n-1];
    boolean[] adiag = new boolean[m+n-1];
    
    return recQueenFill(col,diag,adiag,n,m,0);
}

//     Maintain the count as 0 in the recursion before every column search 
//     return 1 in the succesful case, in all the unsucessful case count will remain as 0
//     The total number will be found through recursion and backtracking.
private int recQueenFill(boolean[] col,boolean[] diag,boolean[] adiag,int n,int m,int r){
    if(r == n){
       return 1; 
    }
    
    int count = 0;
    for(int c=0;c<m;c++){
        if(!col[c] && !diag[r+c] && !adiag[r-c+m-1]){
            col[c] = diag[r+c] = adiag[r-c+m-1] = true;
            count += recQueenFill(col,diag,adiag,n,m,r+1);
            col[c] = diag[r+c] = adiag[r-c+m-1] = false;
        }
    }
    return count;
}
}