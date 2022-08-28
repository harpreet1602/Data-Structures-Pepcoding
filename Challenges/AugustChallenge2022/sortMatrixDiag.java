public class sortMatrixDiag {
    
//     tc O( n*m logD) D=min(m,n) int the diagonal
//     sc O(n*m)
//     We haave to store the data of diagonal while traversing the matrix in a data structure 
//    through which we can sort the elements of diagonal and put it back in the updated matrix
//     So for this purpose we are using map of integer, priorityQueue which will be mapping of i-j to the min heap of all the elements of i-j id
//     i-j id is the identifier for diagonals
//     so by this sorted elements will come out from the priority queue
public int[][] diagonalSort(int[][] mat) {
    Map<Integer,PriorityQueue<Integer>> map = new HashMap<>();
    int n = mat.length, m =mat[0].length;
    int[][] ansMat = new int[n][m];
    
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(!map.containsKey(i-j))
            map.put(i-j,new PriorityQueue<>());
            
            map.get(i-j).add(mat[i][j]);
        }
    }
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            ansMat[i][j] = map.get(i-j).remove();
        }
    }
    return ansMat;
}
}
