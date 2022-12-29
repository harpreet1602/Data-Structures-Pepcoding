public class subarrayMin {
    
//     907. Sum of Subarray Minimums
// tc O(3*n) => O(n) sc O(3*n)=>O(n)
//     What we have to do here is to get the minimum from each subarray of the array and then return its sum
//     Brute can be to find all the subarrays and find minimum from it => O(n^3) time
    
//     Better approach => time O(n^2) => find the next smaller element in left and right of each index  and you will get the answer at each index that for how many subarrays I am the minimum.
    
//     Optimised => Monotonic stack to find the next smaller element on the left and the right.
//     For finding it, whenever we get a smaller element from the stack top then we pop and change its next smaller element.
//     For finding the next smaller on right, move from start to end.
//     For finding the next smaller on left, move from end to start 
//     Then in the end, for the current arr[i]*elements on the left which are greater than curr * elements on the right are greater than curr.
public int sumSubarrayMins(int[] arr) {
    LinkedList<Integer> st = new LinkedList<>();
    int n = arr.length, mod = (int)1e9+7;
    long ans = 0;
    int[] nsl = new int[n];
    int[] nsr = new int[n];
    
    Arrays.fill(nsl,-1);
    Arrays.fill(nsr,n);
    
    for(int i=0;i<n;i++){
        while(st.size()!=0 && arr[st.getFirst()] >= arr[i]){
            nsr[st.removeFirst()] = i;
        }
        st.addFirst(i);
    }
    st = new LinkedList<>();
    for(int i=n-1;i>=0;i--){
        while(st.size()!=0 && arr[st.getFirst()] > arr[i]){
            nsl[st.removeFirst()] = i;
        }
        st.addFirst(i);
    }
    
    for(int i=0;i<n;i++){
        int left = nsr[i]-i;
        int right = i-nsl[i];
        ans = (ans + (((long)arr[i]*left*right)%mod))%mod;
    }
    return (int)ans;
}
}
