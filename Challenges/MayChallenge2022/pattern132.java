import java.util.LinkedList;
public class pattern132{
    
    

    // 456. 132 Pattern
//     tc O(n) sc O(n)
//     Find maximum in between the array and towards its right we should have second maximum (sm) 
//     towards its left we need lowest element to make the '132 subsequence'
//     So we are using monotonic stack, traversing the array from back
//     Accordingly we are adding big numbers into the stack and maintaining the second maximum as well
//     By the time if current ele of an array comes out to be less than sm, return true.
//     This is because sm is obtained the value when there is some value bigger than it
//     Suppose that is the middle element
//     Then if a element is less than the sm. this means '132 pattern is formed'
//     left ele is current ele, middle ele is in the stack, right ele is the sm
//     In the end if the condition doesn't match, return false.
public boolean find132pattern(int[] nums) {
    int sm = -(int)1e9;
    LinkedList<Integer> st = new LinkedList<>();
    
    for(int i=nums.length-1;i>=0;i--){
        if(nums[i]<sm){
                return true;
        }
        while(st.size()!=0 && st.getFirst()<nums[i]){
                sm = Math.max(sm,st.removeFirst());
                
        }
        st.addFirst(nums[i]);
    }
    return false;
}
}