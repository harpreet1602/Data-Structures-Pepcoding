public class maxBagCap {
    
        // 2279. Maximum Bags With Full Capacity of Rocks
// tc O(nlogn + n)=> O(nlogn)  sc O(n)
//    What we can do here is we can store the diferrence of cap and rock in a diff array and then accordingly we will sort the array and we will
//     get the positions that can be acknowleged first and increment the answer when the condition gets satisfied.
public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
    int n = capacity.length, ans=0;
    int[] diff = new int[n];
    for(int i=0;i<n;i++){
        diff[i] = capacity[i]-rocks[i];
    }
    Arrays.sort(diff);
    
    for(int i=0;i<n;i++){
        if((additionalRocks - diff[i]) >= 0){
            ans++;
            additionalRocks -= diff[i];
        }
        else{
            break;
        }
    }
    return ans;
}
}
