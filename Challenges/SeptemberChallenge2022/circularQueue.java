import java.util.Arrays;
public class circularQueue {
    class MyCircularQueue {
        // 622. Design Circular Queue
        //     Simple one with size variable
        //     tc O(1) sc O(n)
            private int[] que;
            private int front = 0, rear = -1, n,size=0;
            public MyCircularQueue(int k) {
                que = new int[k];
                n=k;
            }
            
            public boolean enQueue(int value) {
                if(!isFull()){
                    rear = (rear+1)%n;
                    que[rear] = value;
                    size++;
                    return true;
                }
                return false;
            }
            
            public boolean deQueue() {
                if(!isEmpty()){
                    front = (front+1)%n;
                    size--;
                    return true;
                }
                return false;
            }
            
            public int Front() {
                return isEmpty()?-1:que[front];
            }
            
            public int Rear() {
                return isEmpty()?-1:que[rear];
            }
            
            public boolean isEmpty() {
                return size==0?true:false;
            }
            
            public boolean isFull() {
                return size == n?true:false;
            }
        }
        
class MyCircularQueue1 {
    // 622. Design Circular Queue
    //     Complex one without size variable
    //     tc O(n) sc O(n)
        private int[] que;
        private int front = -1, rear = -1, n;
        public MyCircularQueue1(int k) {
            que = new int[k];
            n=k;
            Arrays.fill(que,-1);
        }
        
        public boolean enQueue(int value) {
            if(!isFull()){
                rear = (rear+1)%n;
                que[rear] = value;
                return true;
            }
            return false;
        }
        
        public boolean deQueue() {
            if(!isEmpty()){
                front = (front+1)%n;
                que[front] = -1;
                return true;
            }
            return false;
        }
        
        public int Front() {
            if(isEmpty()){
                return -1;
            }
            return que[(front+1)%n];
        }
        
        public int Rear() {
            if(isEmpty()){
                return -1;
            }
            return que[rear];
        }
        
        public boolean isEmpty() {
            if(que[(front+1)%n]!=-1){
                return false;
            }
            return true;
        }
        
        public boolean isFull() {
            if(que[(rear+1)%n]!=-1 && (front+1)%n==(rear+1)%n){
                return true;
            }
            return false;
        }
    }

}
