public class DuplicateElement {
    
    // 287. Find the Duplicate Number
//     Brute force
//     1.sort then check nums[i] and nums[i-1] when they will be equal return
//    tc O(nlogn) sc O(logn) [quick sort internal space complexity]
    
//     2. HashSet 
//     store the elements whichever will come for the second time return that
//     tc O(n) sc O(n)
    
    
//     Optimized one => Cycle Detection algorithm.
//     tc O(n) sc O(1)
//     Take two pointers slow and fast now they will start from nums[0]
//     till the time they are not equal run the do while loop so that atleast one time the loop runs without checking the condition.
//     slow will move with next value as nums[slow]
//     fast will move with the next value as nums[nums[fast]]
//     As there is atleast one number which will be a duplicate so cycle will formed with full gurantee
//     so that is why this cycle detection algorithm can be used 
// Now after the first traversal assign one of the pointer like fast on nums[0]
//     slow will be there at the point of first collision
    //     traverse both the pointers slow as nums[slow] and fast as nums[fast] one by one
//     So now when they will meet that will be the duplicate element which will be stored in slow and fast pointer.
//    return any pointer in this case we returned slow pointer i.e. the duplicate element present. 
public int findDuplicate(int[] nums) {
        
    int slow=nums[0],fast=nums[0];
     do{
         slow = nums[slow];
         fast = nums[nums[fast]];
     }while(slow!=fast);
     
     fast = nums[0];
     
     while(slow!=fast){
         slow = nums[slow];
         fast = nums[fast];
     }
     
     return slow;
 }
}
