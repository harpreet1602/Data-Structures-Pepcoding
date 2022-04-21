import java.util.List;
import java.util.ArrayList;
public class hashset {
    // tc O(1) sc O(n)
    // It is taking uneccessary space which is not even getting used

    boolean[] arr;
    public hashset() {
        arr = new boolean[(int)1e6+1];
    }
    
    public void add(int key) {
        arr[key] = true;
    }
    
    public void remove(int key) {
        arr[key] = false;
    }
    
    public boolean contains(int key) {
        return arr[key] == true;
    } 

    class MyHashSet {
        //     tc O(n) sc O(n)
        //     Space is optimised as earlier it was taking unecessary space in array 
        //     but here only limited space will be taken and with the helo og hashIndex
        //     we will assign each key in the list present at set[hashInd].
        //     So this is the basic idea of HashSet designing.
        //     The array of List is created to handle the designing og HashSet
        //     with size capacity as getHashInd is returning key%capacity.
            public List<Integer>[] set;
            public int capacity=0;
            public MyHashSet() {
                capacity = 1500;
                set = new List[capacity];
            }
            public int getKeyHash(int key){
                return key%capacity;
            }
            public void add(int key) {
                int hashInd = getKeyHash(key);
                if(set[hashInd] == null){
                    set[hashInd] = new ArrayList<>();
                }
                if(!contains(key)){
                    set[hashInd].add(key);
                }
            }
            
            public void remove(int key) {
                if(contains(key)){
                   int hashInd = getKeyHash(key);
                   set[hashInd].remove(set[hashInd].indexOf(key)); 
                }
            }
            
            public boolean contains(int key) {
                int hashInd = getKeyHash(key);
                if(set[hashInd]==null){
                    return false;
                }
                return set[hashInd].contains(key);
            }
        }
}


