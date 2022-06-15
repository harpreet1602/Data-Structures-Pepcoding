public class segregate01 {
     // https://practice.geeksforgeeks.org/problems/segregate-0s-and-1s5106/1/#
    // tc O(n) sc O(1)
    // one pointer in the start and one at the end and first one will go ahead when it is 0
    // second will come backwards if it is 1 and if counter case arises then swap both of them
    void segregate0and1p(int[] arr, int n) {
        // code here
        int low = 0, high = n-1;
        while(low<high){
            if(low<high && arr[low]==0){
                low++;
            }
            if(low<high && arr[high]==1){
                high--;
            }
            if(low<high && arr[low] == 1&& arr[high]==0){
                swap(arr,low,high);
            }
        }
    }
    // Two pointers from the starting
    // neg pointer => till this pointer, there will be zeroes
    // ptr will have 1's in the range from neg + 1 to ptr
    // in the ptr if will find 0 we will swap it with neg+1 and ptr.
     void segregate0and1(int[] arr, int n) {
        int neg = -1, ptr = 0;
        while(ptr<n){
            if(arr[ptr]==0)
            {
                swap(arr,++neg,ptr);
            }
            ptr++;
        }
         
     }
    
    void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
