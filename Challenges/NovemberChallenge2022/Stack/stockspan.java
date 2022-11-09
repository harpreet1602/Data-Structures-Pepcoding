package Stack;

public class stockspan {
    class StockSpanner {
        // 901. Online Stock Span
        // tc O(n) sc O(n)
        // So stack will be used here
        // it is the modification of next greater element question.
        // So we will be storing price,how many element were less than it as an array in stack
        // Then while quering, we will keep on adding the answers together whosever elements are less than the current price
        // pop all the arrays that come in between
            public LinkedList<int[]> st;
            public StockSpanner() {
                st = new LinkedList<>();
            }
            
            public int next(int price) {
                int ans = 1;
                while(st.size()!=0 && st.getFirst()[0]<=price){
                    int[] rarr = st.removeFirst();
                    ans += rarr[1];
                }   
                st.addFirst(new int[]{price,ans});
                return ans;
            }
        }
        
        /**
         * Your StockSpanner object will be instantiated and called as such:
         * StockSpanner obj = new StockSpanner();
         * int param_1 = obj.next(price);
         */
}
