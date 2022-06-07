public class mergeSortedArray{
    
    // 88. Merge Sorted Array
//     tc O(m+n) sc O(1)
//     
public void merge1(int[] nums1, int m, int[] nums2, int n) {
    int e1 = m-1,e2 = m+n-1,e3 = n-1;
    if(m==0){
        for(int i=0;i<n;i++){
            nums1[i] = nums2[i];
        }
    }
    while(e1>=0 && e3>=0){
        if(nums1[e1]>=nums2[e3]){
            nums1[e2] = nums1[e1--]; 
        }
        else{
            nums1[e2] = nums2[e3--];
        }
        e2--;
    }
    while(e1>=0 && e2>=0){
        nums1[e2--] = nums1[e1--];
    }
    while(e3>=0 && e2>=0){
        nums1[e2--] = nums2[e3--];
    }
}

//     Code quality improved.
//     tc O(m+n) sc O(1)
//     Just have three pointers => one at the end of big array e1, one at the end of first array in big array p1, one at the end of second array
//     Now as both small arrays are sorted so place the maximum of both to the end of big array and manage three pointers.
//     If one of the small array is completely traversed then take its value as MINIMUM value so that the other value can be assigned to the end of the array.
public void merge(int[] nums1, int m, int[] nums2, int n) {
    int p1 = m-1;
    int p2 = n-1;
    int e1 = nums1.length-1;
    
    while(e1>=0){
        int firstEle = p1>=0?nums1[p1]:Integer.MIN_VALUE;
        int secondEle = p2>=0?nums2[p2]:Integer.MIN_VALUE;
        
        if(firstEle>=secondEle){
            nums1[e1] = firstEle;
            p1--;
        }
        else{
            nums1[e1] = secondEle;
            p2--;
        }
        e1--;
    }
}
}