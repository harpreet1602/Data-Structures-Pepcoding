public class moveZeroes {
    
    // 283. Move Zeroes
//     tc O(n) sc O(1)
//     two pass solution
//     when we get non zero ele we put in the start and whatever are left put 0 there
public void moveZeroes1(int[] nums) {
    int n=nums.length,start=0;
  
    for(int i=0;i<n;i++){
        if(nums[i]!=0){
            nums[start++] = nums[i];
        }
    }
    for(int i=start;i<n;i++){
        nums[i] = 0;
    }
}

//     Optimised
//     Tc O(n) sc O(1)
//     One pass solution 
//     We will have the last non zero position track and we should swap the non zero there with the non zero position.
//      
public void moveZeroes(int[] nums) {
    int n=nums.length,lastNonZeroPos=0;
    
    for(int curr=0;curr<n;curr++){
        if(nums[curr]!=0){
            swap(nums,lastNonZeroPos++,curr);
        }
    }
}
private void swap(int[] nums,int i,int j){
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}


    // Move all negative elements to end 
    // https://practice.geeksforgeeks.org/problems/move-all-negative-elements-to-end1813/1
    // tc o(3N) => O(n) sc O(n)
    // Make a temp array and put all the positive ones first and then the negative ones
    // Then copy the temp array into the original one.
    public void segregateElements(int arr[], int n)
    {
        // Your code goes here
        int[] temp = new int[n];
        int start=0;
        for(int i=0;i<n;i++){
            if(arr[i]>0){
                temp[start++] = arr[i];
            }
        }
        for(int i=0;i<n;i++){
            if(arr[i]<0){
                temp[start++] = arr[i];
            }
        }
        
        for(int i=0;i<n;i++){
            arr[i] = temp[i];
        }
        
    }
}
