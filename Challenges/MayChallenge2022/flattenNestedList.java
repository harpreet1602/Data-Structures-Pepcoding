import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
public class flattenNestedList {
    /**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
// 341. Flatten Nested List Iterator
// tc O(n) sc O(n)
// First of all we need to know that NestedIterator is inbuilt in java 
// where there are functions like => isInteger, getInteger, getList.
// So flatten the nestedList into simple final ArrayList
// By traversing in the nestedList if the current NestedInteger is a number then
// add it into the final list otherwise call recursively with current list
// Son that this process can continue and the final list can be made
// Then with the help of iterator in the final list, next and hasNext can be implemented.

public class NestedIterator implements Iterator<Integer> {

    List<Integer> flist;
    Iterator<Integer> it;
  
    private void flattenning(List<NestedInteger> nestedList){
        for(NestedInteger curr:nestedList){
            if(curr.isInteger()){
                flist.add(curr.getInteger());
            }
            else{
                flattenning(curr.getList());
            }
        }
    }
    
    public NestedIterator(List<NestedInteger> nestedList) {
        flist = new ArrayList<>();
        flattenning(nestedList);
        it = flist.iterator();
    }

    
    @Override
    public Integer next() {
        if(it.hasNext()){
            return it.next();
        }    
        return null;
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
}
