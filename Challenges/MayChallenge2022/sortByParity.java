public class sortByParity {
    
//     tc O(2*n)= O(n) sc O(n) Brute force
//     run two loops to put the elements
public int[] sortArrayByParity1(int[] nums) {
    int idx = 0;
    int[] arr = new int[nums.length];
    for(int ele:nums){
        if(ele%2==0)
        arr[idx++] = ele;
    }
    for(int ele:nums){
        if(ele%2!=0)
        arr[idx++] = ele;
    }
    return arr;
}
// .Better
//     tc O(n) sc O(n) 
//     run a single loop but with the help of two pointers one at start and one at end.

public int[] sortArrayByParity(int[] nums){
    int n = nums.length, low = 0, high = n-1;
    int[] sortedArr = new int[n];
    for(int ele:nums){
        if(ele%2==0){
            sortedArr[low++] = ele;
        }
        else{
            sortedArr[high--] = ele;
        }
    }
    return sortedArr;
}

//     tc O(n) sc O(1) => in place
//     Optimised
//     Two pointers but using swaping in between whenever required
public void swap(int[] arr,int i,int j){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}
public int[] sortArrayByParity2(int[] nums) {
    int n = nums.length, low = 0, high = n-1;
    while(low<high){
        if(nums[low]%2==0){
            low++;
        }
        else if(nums[high]%2!=0){
            high--;
        }
        else{
            swap(nums,low,high);
        }
    }
    return nums;
}
}
