public class dailyTemp{
    
    // 739. Daily Temperatures
// tc O(n^2) sc O(n)
//     Monotonic Stack
//     Dry run to understand how we can use a stack here.
//    By only storing the indexes of the elements in the stack we can find its next greater element
//     then accordingly we can place the number at the right place.
public int[] dailyTemperatures(int[] temperatures) {
    LinkedList<Integer> st = new LinkedList<>();
    int n = temperatures.length;
    int[] ans = new int[n];
    
    for(int i=0;i<n;i++){
        while(st.size()!=0 && temperatures[st.getFirst()]<temperatures[i]){
            ans[st.getFirst()] = i- st.removeFirst();
        }
        st.addFirst(i);
    }
    return ans;
}
}