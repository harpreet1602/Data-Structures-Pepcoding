public class l001 {
    

    // NGOR
    public int[] NGOR(int[] arr){
        int n = arr.length;
        int[] ans =new int[n];
        Arrays.fill(ans,n);
        LinkedList<Integer> st = new LinkedList<>();
        st.addd(-1);
        for(int i=0;i<n;i++){
            while(st.getFirst()!=-1 && arr[st.getFirst()] < arr[i]){
                ans[st.removeFirst()] = i;
            }

            st.addFirst(i);
        }
        return ans;
    }

    public int[] NSOR(int[] arr){
        int n = arr.length;
        int[] ans =new int[n];
        Arrays.fill(ans,n);
        LinkedList<Integer> st = new LinkedList<>();
        st.addd(-1);
        for(int i=0;i<n;i++){
            while(st.getFirst()!=-1 && arr[st.getFirst()] > arr[i]){
                ans[st.removeFirst()] = i;
            }

            st.addFirst(i);
        }
        return ans;
    }

    public int[] NGOL(int[] arr){
        int n = arr.length;
        int[] ans =new int[n];
        Arrays.fill(ans,n);
        LinkedList<Integer> st = new LinkedList<>();
        st.addd(-1);
        for(int i=n-1;i>=0;i--){
            while(st.getFirst()!=-1 && arr[st.getFirst()] < arr[i]){
                ans[st.removeFirst()] = i;
            }

            st.addFirst(i);
        }
        return ans;
    }
    public int[] NSOL(int[] arr){
        int n = arr.length;
        int[] ans =new int[n];
        Arrays.fill(ans,n);
        LinkedList<Integer> st = new LinkedList<>();
        st.addd(-1);
        for(int i=n-1;i>=0;i--){
            while(st.getFirst()!=-1 && arr[st.getFirst()] > arr[i]){
                ans[st.removeFirst()] = i;
            }

            st.addFirst(i);
        }
        return ans;
    }

    // 503. Next Greater Element II

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
       int[] ans =new int[n];
       Arrays.fill(ans,-1);
       LinkedList<Integer> st = new LinkedList<>();
       st.add(-1);
       for(int i=0;i< 2*n;i++){
           while(st.getFirst()!=-1 && nums[st.getFirst()] < nums[i%n]){
               ans[st.removeFirst()] = nums[i%n];
           }

           st.addFirst(i%n);
       }
       return ans;
   }

   

}
