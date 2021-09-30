public class stack{
    private int[] arr;
    private int tos;
    private int NoOfElements;
    private int MaxCapacity;
    // private sirf class ke log hi access kar sakte hai
    // protected and public ko dusri class sai access kar sakte hai
    stack(int size){
        initialize(size);
    }
    stack(){
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
    public void push(){

    }
    public int peek(){

    }
    public int pop(){

    }
}