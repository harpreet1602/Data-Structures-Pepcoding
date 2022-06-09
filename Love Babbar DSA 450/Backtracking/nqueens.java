import java.util.List;
import java.util.ArrayList;

public class nqueens {
    
//     51. N-Queens
//     tc O() sc O(n*n) 
//     time complexity to be done later.
//     This is very famous question of backtracking 
//     Where I have to call for the recursion one time for 0th row because the first queen has to be 
//     placed at any cost in the first row.

public List<List<String>> solveNQueens(int n) {
    boolean[][] vis = new boolean[n][n];
    List<List<String>> list = new ArrayList<>();
        
    recAns(list,vis,n,0);  
    return list;
}
// Convert the visited array into the required answer by making use of the stringbuilder in between

private void addAns(boolean[][] vis,List<List<String>> list,int n){
    List<String> smallAns = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(vis[i][j] == false){
                sb.append(".");
            }
            else{
                sb.append("Q");
            }
        }
        smallAns.add(sb.toString());
        sb = new StringBuilder();
    }
    list.add(smallAns);
}

private void recAns(List<List<String>> list,boolean[][] vis,int n,int r){
//     If I have come to the nth row with nth queen this means it is a sucessful case as n queens are already placed as r has come from 0 to n-1 for placing n queens
    if(r == n){
        addAns(vis,list,n);
        return;
    }
    
//       now at each row check the column for the particular row's queen
//       Try all the possibilities of column in a row to place the queen by checking from the isSafe function
//         Backtracking will also take place if we go to a wrong result.
    for(int c=0;c<n;c++){
            if(isSafe(r,c,vis)){
                vis[r][c] = true;
                recAns(list,vis,n,r+1);
                vis[r][c] = false;
            }       
    }
}
//     Check the two upper diagonals , horizontally backward and vertically backward.
private boolean isSafe(int i,int j,boolean[][] vis){
    int n = vis.length;
//         horizontally backward.
    for(int k=j-1;k>=0;k--){
        if(vis[i][k]){
            return false;
        }
    }
//    vertically backward     
    for(int k=i-1;k>=0;k--){
        if(vis[k][j]){
            return false;
        }
    }
// previous diagonal 
    for(int p=i-1,q=j-1;p>=0 && q>=0;p--,q--){
        if(vis[p][q]){
            return false;
        }
    }
//    next diagonal.
    for(int p=i-1,q=j+1;p>=0 && q<n;p--,q++){
        if(vis[p][q]){
            return false;
        }
    }
    return true;
}
}
