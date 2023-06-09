public class smallGreterTarget {
    
    // 744. Find Smallest Letter Greater Than Target
// tc O(log n) sc O(1)
    
//     Basic Idea of Binary Search
//     Binary search is appplied because the array is sorted we just have to find a character which is just bigger than the given target in the array
//     With this method also we will be able to find the answer
//     like if target is greater or equal so it cannot be the answer so move on to the right hand side
//     otherwise if target is less than the current character so there is a probability that it can be an answer or we can find better answer in left hand side
    
//     Approach 1
//     so setting high on mid
//     moving the loop till low<high
//     when it is coming out we see that if it has come out of the loop with character less than or equal to target we return first character otherwise that character coming out of the loop
public char nextGreatestLetter1(char[] letters, char target) {
    int n = letters.length, low = 0, high = n-1;
    
    while(low<high){
        int mid = low + (high-low)/2;
        
        if(target>=letters[mid]){
            low = mid+1;
        }
        else{
            high = mid;
        }
    }
    return letters[low]<=target?letters[0]:letters[low];
}

//     2nd approach
//     keep the track of the capable answer with ans intially starting from 0
//     then setting high on mid-1 to see in lhs
//     run loop here till low<=high
//     in the end if none of the time ans variable got changed first ele will be returned automatically otherwise the coorect character just greater than target will be returned.
public char nextGreatestLetter(char[] letters, char target) {
    int n = letters.length, low = 0, high = n-1, ans=0;
    
    while(low<=high){
        int mid = low + (high-low)/2;
        
        if(target>=letters[mid]){
            low = mid+1;
        }
        else{
            high = mid-1;
            ans = mid;
        }
    }
    return letters[ans];
}
}
