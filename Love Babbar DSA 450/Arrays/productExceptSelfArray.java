public class productExceptSelfArray {
    
    // 238. Product of Array Except Self
//     tc O(3*n)=O(n) 
    // sc O(2*n)=O(n) [n size array was asked as well so that is why space is not O(3*n)]
    
//  Constraint is do it in O(n) time and without using the division operation.
// 1.So that is why brute force of multiplying everything and then at the index just divide by it will not help => tc O(n) sc O(1) but division is used which is not allowed
//   2.For every index keep on multiplying the other numbers of the array tc O(n^2) sc O(1), this will also not help as we need tc of O(n).
    
//     Solution.
//     Analyse the situation of the answer array from the input array
//     Scenerio from the previous approaches 
//     So we can use prefix product logic here. How?
//     Keep left prefix product and right prefix product arrays
//     and then at the current index answer will be left[i-1] * right[i+1] and current index will not come in the product rest of them come
//     so our purpose is done.
//     But handle the edge cases of i=0 for left[i-1] as left prefix will be 1
//     and i== n-1 for right[i+1] as it will be 1
    
   
public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] left = new int[n];
    int[] right = new int[n];
    int[] ans = new int[n];
    int leftProd = 1, rightProd = 1;
    
    for(int i=0;i<n;i++){
        leftProd *= nums[i];
        left[i] = leftProd;
    }
    
    for(int i=n-1;i>=0;i--){
        rightProd *= nums[i];
        right[i] = rightProd;
    }
    
    for(int i=0;i<n;i++){
        leftProd = i>0?left[i-1]:1;
        rightProd = i<n-1?right[i+1]:1;
        ans[i] = leftProd*rightProd;
    }
    return ans;
    
}
}
