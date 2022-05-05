import java.util.LinkedList;

public class StackUsingQueue {
    class MyStack {
        //     Stacks using two queues
        //     Push efficient 
            // Push,empty => O(1) and pop, top => O(n)
        //     Dry run to know how to use two  queues to get the functionality of the stack
        //     
            LinkedList<Integer> que1,que2;
            
            public MyStack() {
                que1 = new LinkedList<>();
                que2 = new LinkedList<>();
            }
            private void transferEle(LinkedList<Integer> q1, LinkedList<Integer> q2){
                 while(q1.size()>1){
                    q2.addLast(q1.removeFirst());
                }
            }
            public void push(int x) {
                que1.addLast(x);
            }
            
            public int pop() {
                transferEle(que1,que2);
                int ele = que1.removeFirst();
                transferEle(que2,que1);
                if(que2.size()!=0)
                que1.addLast(que2.removeFirst());
                return ele;
            }
            
            public int top() {
                transferEle(que1,que2);
                int ele = que1.getFirst();
                que2.addLast(que1.removeFirst());
                transferEle(que2,que1);
                if(que2.size()!=0)
                que1.addLast(que2.removeFirst());
                return ele;
            }
            
            public boolean empty() {
                return que1.size()==0;
            }
        }

        class MyStack1 {
            //     Optimised sol using only one queue.
            // tc O(n) sc O(n) 
            //     Pop Efficient
                LinkedList<Integer> que;
                public MyStack1() {
                    que = new LinkedList<>();
                }
            //     O(n)
                public void push(int x) {
                    que.add(x);
                    int size = que.size()-1;
                    while(size-->0){
                        que.addLast(que.removeFirst());
                    }
                }
            //     O(1)
                public int pop() {
                    return que.removeFirst();
                }
            //     O(1)
                public int top() {
                    return que.getFirst();
                }
            //     O(1)
                public boolean empty() {
                    return que.size()==0;
                }
            }

}
