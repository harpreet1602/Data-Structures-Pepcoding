public class tallestBillboard {
    
//     956. Tallest Billboard
// tc O(21*2*5001)=> O(rodsLen*n) sc O(rodsLen*n)
//     Recursion is first of all for three options whether the current rod will go in left support or right support or it will go to none.
//     Now it can have three changing variables index, leftsum, right sum but it will result into memory limit exceeded.
//     so maintain index, difference of left support - right support
//     as diff can range from -5000 to 5000 so make the size as 2*5001 and also add 5001 in the memoization because negative values will be converted into positive ones and already postive ones will also get included in other range.
//     in the left support we have added the rod value and then ask for the value as the base case is only returning 0 in true case but we need support sum till that value that is why it got added one time in left support only
//     for the right support we were subtracting -rods val that is not added 
//     maximum of the three options value will be returned.
private int[][] dp = new int[21][2*5001];
public int tallestBillboard(int[] rods) {
    for(int[] arr:dp){
        Arrays.fill(arr,-1);
    }
    
    return solveTallest(rods,0,0);
}

private int solveTallest(int[] rods,int idx,int diff){
    if(idx == rods.length){
        return diff == 0? diff: -(int)1e4;
    }
    
    if(dp[idx][diff+5001]!=-1){
        return dp[idx][diff+5001];
    }
//         three operations
    int op1,op2,op3;
//         left support
    op1 = rods[idx] + solveTallest(rods,idx+1,diff+rods[idx]);
    // right support
    op2 = solveTallest(rods,idx+1,diff-rods[idx]);
//         none
    op3 = solveTallest(rods,idx+1,diff);
    
    return dp[idx][diff+5001] = Math.max(op1,Math.max(op2,op3));
}   
}
