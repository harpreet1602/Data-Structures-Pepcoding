package Challenges.JanuaryChallenge2023.Arrays;

public class gasStation {
    
    // 134. Gas Station
// tc O(n) sc O(1)
//     Greedy approach => n time
//     if total cost is greater than total gas then return -1
//     otherwise the solution will exist gurranteed.
//     traverse and see if the remainingGas + (gas[i]-cost[i])
//     if remainingGas <0  then reset the things starting index as si + 1
//     rg as 0
//     return the si
public int canCompleteCircuit(int[] gas, int[] cost) {
    int totalGas = 0, totalCost = 0, remainingGas=0, si = 0, n = gas.length;
    for(int i=0;i<n;i++){
        totalGas += gas[i];
        totalCost += cost[i];
    }
    
    if(totalCost>totalGas){
        return -1;
    }
    
    for(int i=0;i<n;i++){
        remainingGas = remainingGas + (gas[i]-cost[i]);
        
        if(remainingGas<0){
            remainingGas = 0;
            si = i+1;
        }
    }
    return si;
}
}
