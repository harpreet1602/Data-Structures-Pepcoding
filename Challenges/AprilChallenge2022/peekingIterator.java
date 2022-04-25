import java.util.Iterator;
public class peekingIterator {
    // Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    //     TC O(n) SC O(n)
    //     Implement the inbuilt Iterator of java and just maintain a variable 
    //     to implement peek, next and hasNext functionality
    //     Like nextEl will be pointing to the current ele that can returned by
    //     calling peek().
    //     next() will take the current ele to return in another valueToReturn variable
    //     and it will point the nextEl to it.next() and return valueToReturn
    //     in case there are no ele ahead so put nextEl = null.
    //     hasNext() function will return nextEl!=null?true:false.
        Iterator<Integer> it;
        Integer nextEl = null;
        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            this.it = iterator;
            nextEl = it.next();
        }
        
        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return nextEl;
        }
        
        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            Integer valueToReturn = nextEl;
            if(it.hasNext()){
                this.nextEl = it.next();
            }
            else{
                this.nextEl = null;
            }
            return valueToReturn;
        }
        
        @Override
        public boolean hasNext() {
            return nextEl!=null;
        }
    }
}
