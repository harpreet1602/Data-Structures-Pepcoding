import java.util.ArrayList;
public class heap{
    private ArrayList<Integer> arr;

    public heap(){
        this.arr = new ArrayList<>();
    }

    // O(n) + O(nlog n)  -> O(n) => proof will be there
    public heap(int[] arr){
        this();
        for(int i=0;i<arr.length;i++){
            this.arr.add(arr[i]);
        }
        for(int i=this.arr.size()-1;i>=0;i--){
            downHeapify(i);
        }
    }
// O(1)
    public boolean compareTo(int x,int y){
        return this.arr.get(x) > this.arr.get(y);
    }
// O(1)
    private void swap(int x, int y){
        int v1 = this.arr.get(x);
        int v2 = this.arr.get(y);

        this.arr.set(x,v2);
        this.arr.set(y,v1);
    }
// O(log(n))
    private void downHeapify(int pi){
        int lci = 2*pi +1;
        int rci = 2*pi + 2;
        int maxidx = pi;

        if(lci<arr.size() && compareTo(lci, maxidx)){
            maxidx = lci;
        }
        
        if(rci<arr.size() && compareTo(rci, maxidx)){
            maxidx = rci;
        }

        if(pi!=maxidx){
            swap(pi,maxidx);
            downHeapify(maxidx);
        }
    }
// O(log n)
    private void upHeapify(int ci){
        int pi = (ci - 1)/2;
        if(pi>=0 && compareTo(ci, pi)){
            swap(ci,pi);
            upHeapify(pi);
        }
    }
    public int size(){
        return this.arr.size();
    }

    // O(log n)
    public int remove(){
        int re = this.arr.get(this.arr.size()-1);
        swap(0,this.arr.size()-1);
        this.arr.remove(this.arr.size()-1);
        downHeapify(0);
        return re;
    }
// O(log n)
    public void add(int data){
        this.arr.add(data);
        upHeapify(this.arr.size()-1);
    }
// O(1)
    public int peek(){
        return this.arr.get(0);
    }
}