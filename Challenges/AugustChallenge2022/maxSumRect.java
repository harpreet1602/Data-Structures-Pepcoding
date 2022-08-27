import java.util.TreeSet;

public class maxSumRect{
    
// 363. Max Sum of Rectangle No Larger Than K
//     tc O(r^2*clogc) sc O(c)
//     For all the column wise traversing we are making the full row array of prefix sum
//     that is passed to get the maximum closest answer to the k
//     Through the algo written to get the closest answer to the target in 1 d array through this logic
//     which is rote learned for the time being
//     get the full understanding and intuition behind this later on
public int maxSumSubmatrix(int[][] matrix, int k) {
    int n = matrix.length, m = matrix[0].length,res=-(int)1e9;
    
    for(int i=0;i<n;i++){
        int[] arr = new int[m];
        for(int j=i;j<n;j++){
            for(int c=0;c<m;c++){
                arr[c] += matrix[j][c]; 
            }
            res = Math.max(res,getClose(arr,k));
        }
    }
    return res;
}

private int getClose(int[] arr,int k){
    int n = arr.length, prefix = 0, res = -(int)1e9;
    TreeSet<Integer> set = new TreeSet<>();
    set.add(0);
    for(int i=0;i<n;i++){
        prefix += arr[i];
        
        Integer target = set.ceiling(prefix - k);
        if(target!=null){
            res = Math.max(res,prefix-target);
        }
        set.add(prefix);
    }
    return res;
}
}