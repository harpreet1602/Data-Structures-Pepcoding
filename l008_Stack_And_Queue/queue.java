public class queue {
   private int[] arr;
   private int maxSize;
   private int size;
   private int front;
   private int rear;
   private void initialize(int len)
   {
        this.arr=new int[len];
        this.maxSize=len;
        this.size=0;
        this.front=-1;
        this.rear=-1;
   }
   public queue(){
    initialize(5);
   } 
   public queue(int size){
    initialize(size);
   }
   private void queueIsEmptyException()throws Exception{
       if(this.size==0)
        throw new Exception("queueIsEmptyException: -1");
   }
   private void queueIsOverflowException() throws Exception{
       if(this.size==this.maxsize)
       throw new Exception("queueIsOverflowException: -1");
   }
    
   public int size(){
    return this.size;
   }
   public boolean isEmpty(){
    return this.size==0;
   }
   private void add_(int data)
   {
    this.arr[++this.rear]=data;
    this.size++;
   }
   public void add(int data) throws Exception{
    queueIsOverflowException();
    add_(data);
   }
   public int peek()throws Exception{
    queueIsEmptyException();
    return this.arr[this.rear];
   }
   private int remove_()
   {
       int data=this.arr[this.front];
       this.arr[this.front]=0;
       this.front++;
       this.size--;
   }
   public int remove(){
    queueIsEmptyException();
    return remove_();
   }
}
