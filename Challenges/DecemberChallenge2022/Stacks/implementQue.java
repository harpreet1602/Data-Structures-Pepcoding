public class implementQue{
    class MyQueue {
// 232. Implement Queue using Stacks
// Push efficient
//     Just dry run with the two stacks to implement the functionality of queue.
    private LinkedList<Integer> st1;
    private LinkedList<Integer> st2;
    
    public MyQueue() {
        st1 = new LinkedList<>();
        st2 = new LinkedList<>();    
    }
    
    public void push(int x) {
        st1.addFirst(x);
    }
    
    public int pop() {
        if(empty()){
            return -1;
        }
        transfer(st1,st2);
        int ele = st1.removeFirst();
        transfer2(st2,st1);
        return ele;
    }
    
    public int peek() {
        if(empty()){
            return -1;
        }
        transfer(st1,st2);
        int ele = st1.getFirst();
        transfer2(st2,st1);
        return ele;
    }
    
    public boolean empty() {
        return st1.size()==0;
    }
    
    private void transfer(LinkedList<Integer> s1, LinkedList<Integer> s2){
        while(s1.size()!=1){
            s2.addFirst(s1.removeFirst());
        }
    }
    private void transfer2(LinkedList<Integer> s1, LinkedList<Integer> s2){
        while(s1.size()!=0){
            s2.addFirst(s1.removeFirst());
        }
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
}