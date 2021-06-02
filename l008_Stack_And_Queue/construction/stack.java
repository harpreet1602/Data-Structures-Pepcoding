public class stack{
    private int[] arr;
    private int tos;
    private int size;
    private int maxsize;
   
    private void initialize(int len)
    {
        this.arr=new int[len];
        this.tos=-1;
        this.size=0;
        this.maxsize=len;
    }
    public stack()
    {
        initialize(5);
    }
    public stack(int size)
    {
        initialize(size);
    }
    private void stackIsEmptyException() throws Exception{
        if(this.size==0)
        {
            throw new Exception("stackIsEmptyException: -1");
        }
    }
    private void stackIsOverflowException() throws Exception{
        if(this.size==this.maxsize)
        {
            throw new Exception("stackIsOverflowException: -1");
        }
    }
    public int size()
    {
        return this.size;
    }
    public boolean isEmpty()
    {
        return this.size==0;
    }
    private void push_(int data)
    {
        this.arr[++this.tos]=data;
        this.size++;
    }
    public void push(int data) throws Exception
    {
        stackIsOverflowException();
        push_(data);
    }
    public int top() throws Exception
    {
        stackIsEmptyException();
        return this.arr[tos];
    }
    private int pop_()
    {
        int data=this.arr[tos];
        this.arr[tos]=0;
        this.tos--;
        this.size--;
        return data;
    }
    public int pop() throws Exception{
        stackIsEmptyException();
        return pop_();
    }
}