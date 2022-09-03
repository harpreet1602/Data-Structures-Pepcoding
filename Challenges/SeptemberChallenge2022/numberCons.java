public class numberCons{
    
//     967. Numbers With Same Consecutive Differences
    // tc O(2^n) sc O(2^n)
//     Apply dfs and see which all numbers match the criteria so we have to apply the dfs with backtracking here where we explore all the possibilities.
//     Because the n is not fixed so single loop cannot serve the purpose that is why bactracking.
public int[] numsSameConsecDiff(int n, int k) {
    List<Integer> list = new ArrayList<>();
    
    dfs(n,k,list,0);
    int size = list.size();
    int[] ans = new int[size];
    
    for(int i=0;i<size;i++)
    {
        ans[i] = list.get(i);
    }
    return ans;
}
private void dfs(int n,int k,List<Integer> list,int currNo){
    if(n<=0){
        list.add(currNo);
        return;
    }
    for(int i=0;i<10;i++){
        if(i == 0 && currNo == 0){ // skip the case of leading zero
            continue;
        }
        else if(i != 0 && currNo == 0){ // base case=> to start the number possibility from first digit
            dfs(n-1,k,list,i);
        }
        else if(Math.abs(currNo%10 - i) == k){ // Add the digit if it matches the absolute difference of previous digit with k 
            dfs(n-1,k,list,currNo*10 + i);
        }
    }
}
}