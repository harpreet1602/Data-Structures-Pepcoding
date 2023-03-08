public class kokoBanana {
    
    // 875. Koko Eating Bananas
// tc O(n + logn)=> O(n) sc O(1)
//     Range based binary search will be applied between 1 and maximum value 
//     because max to max maximum value can be used as speed for taking the bananans from one pile
//     Accordingly we will check that is it possible to take the bananas with the particular speed.
//     If it is narrow the range by bring high to mid
//     otherwise increase the low to mid+1 if it is not possible to pick all bananas.
//     In the end low will reach the exact min speed with which bananas can be picked.
    
public int minEatingSpeed(int[] piles, int h) {
    int max = piles[0];
    for(int ele:piles){
        max = Math.max(max,ele);
    }
    int low = 1, high = max;
    while(low<high){
        int mid = low + (high-low)/2;
        int hours = calcHours(mid,piles);
        if(hours<=h){
            high = mid;
        }
        else{
            low = mid+1;
        }
    }
    return low;
}
private int calcHours(int mid,int[] piles){
    int hours = 0;
    for(int ele:piles){
        int val = ele/mid;
        hours += val;
        if(ele%mid != 0){
            hours += 1;
        }
    }
    return hours;
}
}
