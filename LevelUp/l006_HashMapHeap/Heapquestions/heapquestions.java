import java.util.*;
public class heapquestions {
    // https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1
    // O(nlog k)
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        //Your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
          return b-a;  
        });
        // n
        while(l<=r){
            pq.add(arr[l]);              //log k
            if(pq.size()>k){
                pq.remove();
            }
            l++;
        }
        return pq.peek();
    } 
    // kth smallest nikalna hai to max heap and kth largest then min heap 

    // optimised solution
    //  N + Klog n
    // make a heap then send k times the first ele at last in min heap

// O(1)
private static void swap(int[] arr,int x, int y){
    int temp = arr[x];
    arr[x] = arr[y];
    arr[y] = temp;
}
// O(log(n))
private static void downHeapify(int pi,int n,int[] arr){
    int lci = 2*pi +1;
    int rci = 2*pi + 2;
    int maxidx = pi;

    if(lci<=n && (arr[lci] < arr[maxidx])){
        maxidx = lci;
    }
    
    if(rci<=n && (arr[rci] < arr[maxidx])){
        maxidx = rci;
    }

    if(pi!=maxidx){
        swap(arr,pi,maxidx);
        downHeapify(maxidx,n,arr);
    }
}
public static void display(int[] arr){
    for(int ele:arr)
    System.out.print(ele+" ");
    System.out.println();
}
//     5
// 7 10 4 20 15
// 4

// 6
// 7 10 4 3 20 15
// 3


// 8
// 73 188 894 915 940 616 900 548
// 7
public static int kthSmallest1(int[] arr, int l, int r, int k) 
{ 
    //Your code here
    int n=arr.length,K = k;
    // boolean isIncreasing = false;
    for(int i=n-1;i>=0;i--){
        downHeapify(i,r,arr);
    }
    // display(arr);
    while(r>0 && k-->0){
    swap(arr,0,r--);
    downHeapify(0,r,arr);
    }
    // display(arr);
    return arr[n-K];
} 


    // 703. Kth Largest Element in a Stream
    class KthLargest {

        //     by default heap is minheap in java and maxheap in c++.
            PriorityQueue<Integer> pq ;
            int K;
            public KthLargest(int k, int[] nums) {
                pq = new PriorityQueue<>();
                K = k;
                for(int ele:nums){
                    pq.add(ele);
                    if(pq.size()>k){
                        pq.remove();
                    }
                }
            }
            
            public int add(int val) {
              pq.add(val);
                if(pq.size()>K){
                        pq.remove();
                }
                return pq.peek();
            }
        }
        
        /**
         * Your KthLargest object will be instantiated and called as such:
         * KthLargest obj = new KthLargest(k, nums);
         * int param_1 = obj.add(val);
         */
        // 2 question pending








        // 973. K Closest Points to Origin
        public int[][] kClosest(int[][] points, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
                int d1 = points[a][0]*points[a][0] + points[a][1]*points[a][1];
                int d2 = points[b][0]*points[b][0] + points[b][1]*points[b][1]; 
                return d2-d1;
    //             other - this => maxheap
            });
            
            for(int i=0;i<points.length;i++){
                pq.add(i);
                if(pq.size()>k) pq.remove();
            }
            
            int i=0;
            int[][] ans = new int[k][];
            while(pq.size()!=0){
                int idx = pq.remove();
                ans[i++] = points[idx];
            }
            return ans;
        }

        // 692. Top K Frequent Words
        
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        for(String s:words) map.put(s,map.getOrDefault(s,0)+1);
        
        PriorityQueue<String> pq = new PriorityQueue<>((a,b)->{
           if(map.get(a) == map.get(b)){
               return b.compareTo(a);       //we need the lexicographic higher value at the top
            } 
            return map.get(a)-map.get(b);
        });
        
        for(String s:map.keySet()){
            pq.add(s);
            if(pq.size()>k) pq.remove();
        }
        
        List<String> list = new LinkedList<>();
        while(pq.size()!=0){
            list.add(0,pq.remove());
        }
        return list;   
    }

    // 778. Swim in Rising Water
    public int swimInWater(int[][] grid) {
        //         bfs for traversing the four directions 
        //         priority queue we need the minimum amount of time in the journey and maximum of this
        //         minimum amount of time journey will be the answer.
                int n = grid.length, m= grid[0].length;
                int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
                PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
                    int i1 = a/m, j1 = a%m;
                    int i2 = b/m, j2 = b%m;
                    return grid[i1][j1] - grid[i2][j2];
                });
                boolean[][] vis = new boolean[n][m];
                
        //         minheap to access the smallest values present in pq first
                int minheight=0;
                pq.add(0);
                vis[0][0] =true;
                while(pq.size()!=0)
                {    
                    int index = pq.remove();
                    int row = index/m;
                    int col = index%m;
                    int height = grid[row][col];
                    minheight = Math.max(minheight,height);
                    
                    if(row==n-1 && col == m-1){
                    break;
                    }
        
                    for(int[] d:dir){
                            int r = row + d[0];
                            int c = col + d[1];
                            if(r>=0 && c>=0 && r<n && c<m && !vis[r][c]){
                                vis[r][c] = true;
                                pq.add(r*m+c);
                            }
                        }
                }
                return minheight;
            }





    

}
