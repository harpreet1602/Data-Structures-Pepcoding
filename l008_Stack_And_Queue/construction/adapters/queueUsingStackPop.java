package adapters;
import java.util.LinkedList;
public class queueUsingStackPop {
        /** Initialize your data structure here. */
        
            LinkedList<Integer> st1=new LinkedList<>();
            LinkedList<Integer> st2=new LinkedList<>();
        
        /** Push element x to the back of queue. */
        //O(n)
        private void transfer(LinkedList<Integer> st1,LinkedList<Integer> st2)
        {
            while(st2.size()!=0)
            {
                st1.addFirst(st2.removeFirst());
            }
        }
        //O(n)
        public void push(int x) {
            transfer(st1,st2);
            st1.addFirst(x);
            transfer(st2,st1);
        }
        
        /** Removes the element from in front of queue and returns that element. */
        // 0(1)
        public int pop() {
            
            return st2.removeFirst();
        }
        //O(1)
        /** Get the front element. */
        public int peek() {
            return st2.getFirst();
        }
        
        /** Returns whether the queue is empty. */
        public boolean empty() {
            return st2.size()==0;
        }
    }
    
    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */  
