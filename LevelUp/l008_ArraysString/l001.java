public class l001{
    
// Right Rotate Array by k
//  negative case of k is also handled

public void swap(int[] nums,int i,int j){
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}
public void reverse(int[] nums,int si,int ei){
    int i = si, j =ei;
    while(i<j){
        swap(nums,i++,j--);
    }
}
public void rotate1(int[] nums, int k) {
    int size = nums.length;
//         both cases handled for positive as well as negative
    k = ((k%size) + size) % size;
    reverse(nums,0,k-1);
    reverse(nums,k,size-1);
    reverse(nums,0,size-1);
}
    // 189. Rotate Array
    // time O(n) space O(1)
    public void rotate(int[] nums, int k) {
        int size = nums.length;
    //         both cases handled for positive as well as negative
        k = ((k%size) + size) % size;
        reverse(nums,0,size-1);
        reverse(nums,0,k-1);
        reverse(nums,k,size-1);
        
    }

    // segregate positive and negative
    void segregateposandneg(int[] arr, int n) {
        // code here
        int neg =-1, ptr = 0;
        while(ptr<n){
            if(arr[ptr]<0){
                swap(arr,++neg,ptr);
            }
            ptr++;
        }
    }
    // https://practice.geeksforgeeks.org/problems/segregate-0s-and-1s5106/1
    void segregate0and1(int[] arr, int n) {
        // code here
        int neg =-1, ptr = 0;
        while(ptr<n){
            if(arr[ptr]==0){
                swap(arr,++neg,ptr);
            }
            ptr++;
        }
    }


    // 75. Sort Colors
    // time O(n) space O(1)
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p1 = -1, p2 = 0, p3 = n-1;
        while(p2<=p3){
            if(nums[p2] == 2){
                swap(nums,p2,p3--);
            }
            else if(nums[p2]==0){
                swap(nums,++p1,p2++);
            }
            else{
                p2++;
            }
        }
    }

    // https://practice.geeksforgeeks.org/problems/max-sum-in-the-configuration/1
    // brute force -> get all the rotations of the array calculate the max sum out of it.
    // time O(n^2) space O(n)
    // optimised
    // time O(n) space O(1)
    int max_sum(int A[], int n)
    {
    	// Your code here
    	int csum =0,totalSum=0,max=0,nsum=0;
    	for(int i=0;i<n;i++){
    	    totalSum += A[i];
    	}
    	for(int i=0;i<n;i++){
    	    csum += A[i]*i;
    	}
    	for(int i = 1;i<=n;i++){
    	    nsum = csum - totalSum + (n*A[i-1]);
    	    
    	    csum = nsum;
    	    max = Math.max(max,csum);
    	}
        return max;	
    }	

    // 11. Container With Most Water
    public int maxArea(int[] height) {
        int n = height.length, p1 = 0, p2 = n-1, maxArea = 0,length,width,area;
        
        while(p1<p2){
            length = p2-p1;
            width = Math.min(height[p1],height[p2]);
            area = length*width;
            maxArea = Math.max(maxArea,area);
            
            if(height[p1]<=height[p2]){
                p1++;
            }
            else{
                p2--;
            }
        }
        return maxArea;
    }

    
}