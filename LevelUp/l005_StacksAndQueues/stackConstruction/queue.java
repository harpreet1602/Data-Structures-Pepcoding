public class queue {
        private int[] arr;
        private int front;
        private int rear;
        private int NoOfElements;
        private int MaxCapacity;
        // private sirf class ke log hi access kar sakte hai
        // protected and public ko dusri class sai access kar sakte hai
        queue(int size){
            initialize(size);
        }
        queue(){
            this(15);
            // this is constructor chaining -> constructor ke andar constructor ko call
            // ye constructor ko call kar rhe hai to usse pehle kuch change nhi kar sakte 
            // isliye pehli call constructor ki hi hogi
        }
    
        protected void initialize(int size){
            // this mai essi function ki baat karta hu
            // issi object sai value leke
            this.NoOfElements = 0;
            this.MaxCapacity = size;
            this.arr = new int[this.MaxCapacity];
            this.tos = -1;
        }
        // code ko reuse karna hai and exception throw karna hai
        // this is oops.
    
        private void overflowException() throws Exception{
            if(this.NoOfElements == this.MaxCapacity)
            throw new Exception("StackIsOverflow");
        }
        private void underflowException() throws Exception{
            if(this.NoOfElements == 0){
                throw new Exception("StackIsUnderflow");
            }
        }
        // upar private valo koi change nhi kar sakta
        public int size(){
            return this.NoOfElements;
        }
        public int MaxCapacity(){
            return this.MaxCapacity;
        }
        public void push(int ele) throws Exception{
            overflowException();
            this.arr[++this.tos] = ele;
            this.NoOfElements++;
        }
        public int peek() throws Exception{
                underflowException();
                return this.arr[this.tos];
        }
        public int pop() throws Exception{
            underflowException();
            this.NoOfElements--;
            return arr[tos--];
        }
        public void displayStack(){
            for(int i=this.tos;i>=0;i--){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    
    
}
