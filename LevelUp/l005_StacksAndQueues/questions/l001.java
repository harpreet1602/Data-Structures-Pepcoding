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


//    735. Asteroid Collision
public int[] asteroidCollision(int[] asteroids) {
    LinkedList<Integer> st = new LinkedList<>();

    for(int ele:asteroids){
        if(ele>0){
            st.addFirst(ele);
            continue;
        }
        while(st.size()!=0 && st.getFirst()>0 && st.getFirst()<-ele){
            st.removeFirst();
        }
        if(st.size()!=0 && st.getFirst()>0 && st.getFirst() == -ele){
            st.removeFirst();
        }
        else if(st.size() == 0 || st.getFirst()<0){
            st.addFirst(ele);
        }
        else{
            // do nothing
        }
    }

    int[] ans = new int[st.size()];
    int ind = ans.length-1;
    while(st.size()!=0){
        ans[ind--] = st.removeFirst();
    }
    return ans;


}
       
     // 946. Validate Stack Sequences
     public boolean validateStackSequences(int[] pushed, int[] popped) {
        LinkedList<Integer> st = new LinkedList<>();
        int idx=0;
        for(int ele:pushed){
            st.addFirst(ele);
            while(st.size()!=0 && st.getFirst() == popped[idx]){
                idx++;
                st.removeFirst();
            }
        }
        return idx==popped.length;      //st.size()==0
}

    // 856. Score of Parentheses
    public int scoreOfParentheses(String s) {
        LinkedList<Integer> st = new LinkedList<>();
        st.addFirst(0);
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '(')
            st.addFirst(0);
            else{
                int a = st.removeFirst();
                int b = st.removeFirst();
                int val = b + Math.max(2*a,1);
                st.addFirst(val);
            }
        }
        return st.removeFirst();
    }

}
