package adapters;
import java.util.*;
public class queueUsingStackPush {
    LinkedList<Integer> st1=new LinkedList<>();
    LinkedList<Integer> st2=new LinkedList<>();


/** Push element x to the back of queue. */
//O(n)

int peekEle=0;
private void transfer(LinkedList<Integer> st1,LinkedList<Integer> st2)
{
    while(st2.size()!=0)
    {
        st1.addFirst(st2.removeFirst());
    }
}
//O(n)
public void push(int x) {
    
    st1.addFirst(x);
    
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
