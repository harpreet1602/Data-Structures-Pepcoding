public class numWaysReorderBST {
    
    // 1569. Number of Ways to Reorder Array to Get Same BST
// tc O(n^2) sc O(n^2)
//    Combination formula will be used here in the recursion
//     so first element will always be root
    
//     now all the other elements which are less than the root, their relative ordering should be maintained 
//     If we will be able to place left subtree elements properly then right subtree elements will also be placed in the spaces left.
//     So we have to place n-1 elements in leftsubtree size places
// That is nothing but combination formula (n-1)C(leftSubTreeSize)
    
//     For finding the combination we will use pascal triangle that is an easy way of getting the combination C[n][k]
//     where table[i][j] = (table[i-1][j] + table[i-1][j-1])%mod;
    
//     Now all this work needs to be done in recursion as in the left sub tree also there will be more left subtrees and right subtrees
//     we need to consider them as well.
//     return (((table[n-1][leftlength] * leftans)%mod) *rightans)%mod from the current stage.
    
private long mod = (long)1e9+7;
private long[][] table;

public int numOfWays(int[] nums) {
    int n = nums.length;
    List<Integer> numsList = new ArrayList<>();
    table = new long[n][n];
    
    for(int i=0;i<n;i++){
        table[i][0] = table[i][i] = 1;
    }
    
    for(int i=2;i<n;i++){
        for(int j=1;j<n;j++){
            table[i][j] = (table[i-1][j] + table[i-1][j-1])%mod;
        }
    }
    
    
    for(int ele:nums){
        numsList.add(ele);
    }
    
    return (int)((dfs(numsList)-1)%mod);
}

private long dfs(List<Integer> nums){
    int n = nums.size();
    if(n<=2){
        return 1;
    }
    
    List<Integer> left = new ArrayList<>();
    List<Integer> right = new ArrayList<>();
    
    for(int i=1;i<n;i++){
        if(nums.get(i)<nums.get(0)){
            left.add(nums.get(i));
        }
        else{
            right.add(nums.get(i));
        }
    }
    
    long leftans = dfs(left)%mod;
    long rightans = dfs(right)%mod;
    int leftlength = left.size();
    
    return (((table[n-1][leftlength] * leftans)%mod) *rightans)%mod;
              
}
}
