import java.util.PriorityQueue;

public class kSmallestMatrix {
    
//     378. Kth Smallest Element in a Sorted Matrix
//     tc O(n^2logk) sc O(logk)
//     adding elements of size k in priorty queue i.e. maxheap here.
public int kthSmallest1(int[][] matrix, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
        return b-a;
    });
    int n = matrix.length;
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            pq.add(matrix[i][j]);
            if(pq.size()>k){
                pq.remove();
            }
        }
    }
    return pq.peek();
}
//     tc O((log n)*n) sc O(1)
//     binary search on values of the matrix 
public int kthSmallest(int[][] matrix, int k) {
    int n= matrix.length, low = matrix[0][0], high = matrix[n-1][n-1];
    
    while(low<high){
        int mid = low + (high-low)/2;
        
        int count = getSmaller(matrix,mid);
        if(count<k){
            low = mid+1;
        }
        else{
            high = mid;
        }
    }
    return low;
}
//     get number of elements smaller than current target\
// start from top right or bottom left because of the given property.
private int getSmaller(int[][] matrix,int target){
    int n = matrix.length,i = n-1,j = 0, count=0;
    while(i>=0 && j<n){
        if(matrix[i][j]>target){
            i--;
        }
        else{
            count = count + 1 + i;
            j++;
        }
    }
    return count;
}
}
