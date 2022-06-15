public class sortColors {
    
//     tc O(n) sc O(1)
//     Regions will be made according to the pointers
//     till neg => there will n be zeroes
//     from neg + 1 to ptr-1 => there will be ones
//     from ptr to end => there is unexplored section
//     from end+1 to n-1 => there will be twos
//     Now the loop runs till unexplored section finishes i.e. till ptr<=end
//     if nums[ptr] = 0 then swap it with ++neg and increment ptr later on 
//     else if nums[ptr] = 1 increment ptr
//     else if nums[end] = 2 decrement end
//     else swap ptr and end where after swapping 2 will come at end and 1 or 0 will come at ptr and that will be handled in the next iteration.
public void sortColors(int[] nums) {
    int n=nums.length,neg = -1, ptr = 0, end = n-1;
    while(ptr<=end){
        if(nums[ptr]==0){
            swap(nums,++neg,ptr);
            ptr++;
        }
        else if(nums[ptr]==1){
            ptr++;
        }
        else if(nums[end]==2){
            end--;
        }
        else{
            swap(nums,ptr,end);
        }
    }
}
private void swap(int[] nums,int i,int j){
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}
}
