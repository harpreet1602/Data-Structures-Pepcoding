package Stack;

public class sumSubarrayMin {
    
    // 907. Sum of Subarray Minimums
// tc O(3*n)=>O(n) sc O(3*n)=>O(n)
// will be done later again
// more analysis can be done
// Monotonic stack is used
// leftmin and right min array are made do a dry run to understand how it works
// for the current number if it is less than the stack top then change the element at the stack top
// as current index in the min array => simple.

// then when you get that one element is minimum for this much length in left and right 
// you mulitply and add it in the answer.
// arr[i] * leftlen *rightlen
public int sumSubarrayMins(int[] arr) {
    int mod = (int)1e9 + 7, n = arr.length;

    LinkedList<Integer> st = new LinkedList<>();
    int[] leftmin = new int[n];
    Arrays.fill(leftmin,-1);
    int[] rightmin = new int[n];
    Arrays.fill(rightmin,n);
    for(int i=0;i<n;i++){
        while(st.size()!=0 &&  arr[i] <= arr[st.getFirst()]){
            int idx = st.removeFirst();
            rightmin[idx] = i;
        }
        st.addFirst(i);
    }
    
    for(int i=n-1;i>=0;i--){
        while(st.size()!=0 &&  arr[i] < arr[st.getFirst()]){
            int idx = st.removeFirst();
            leftmin[idx] = i;
        }
        st.addFirst(i);
    }
    long ans = 0;
    for(int i=0;i<n;i++){
        int leftlen = i-leftmin[i];
        int rightlen = rightmin[i] - i;

        ans = (ans + ((long)arr[i] * leftlen *rightlen)%mod)%mod;
    }
    return (int)ans;
    
}
}
