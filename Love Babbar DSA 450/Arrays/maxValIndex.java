public class maxValIndex {
    
    // 1802. Maximum Value at a Given Index in a Bounded Array
// tc O(log n) sc O(1)
    
//     Search can be applied from 1 to maxSum that which element will be suited for num[index] so that we can get the maximum value at nums[index] and also the sum of elements is less than or equal to maxSum
    
//     for optimising binary search will be applied to find the maximised number from 1 to maxSum
//     l is number of elements on lhs and r is the number of elements on the rhs
//     we can start assigning the numbers from m = mid-1 to the rest of the elements 
//     that means we can assign 1 to m to the rest of the elements 
//     let us consider rhs if r<=m so 1 to m sum can be calculated as (m*(m+1)/2) minus 
//     the sum from 1 to m-r that can be calculated as ((m-r)*(m-r+1)/2)
//     otherwise if r>m so we have to add extra 1s also
//     for that rs = (m*(m+1)/2) + 1*(r-m)
//     Same will be applied on the lhs 
//     make the sum with ls and rs and apply binary search
//     Do dry run to understand it.
    
public int maxValue(int n, int index, int maxSum) {
    long low = 1, high=maxSum, ls=0, rs=0, l=0, r=0, mid=0, m=0, sum=0, ans=0;
    r = n-index-1;
    l = index;
    while(low<=high){
        mid = low + (high-low)/2;
        m = mid-1;
        sum = mid;
        
        if(r<=m){
            rs = (m*(m+1)/2) - ((m-r)*(m-r+1)/2);
        }
        else{
            rs = (m*(m+1)/2) + 1*(r-m);
        }
        
        if(l<=m){
            ls = (m*(m+1)/2) - ((m-l)*(m-l+1)/2);
        }
        else{
            ls = (m*(m+1)/2) + 1*(l-m);
        }
        
        sum += ls+rs;
        
        if(sum<=maxSum){
            ans = mid;
            low = mid+1;
        }
        else{
            high = mid-1;
        }
    }
    return (int)ans;
}
}
