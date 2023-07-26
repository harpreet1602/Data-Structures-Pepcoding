public class minSpeedArrive {
    
    // 1870. Minimum Speed to Arrive on Time
// tc O(logn * n) => O(nlogn) sc O(1)
//     if the hours limit <= length - 1 then there is no way we could find the answer as minimum this much time is required
//     apply the binary search on the range 1 to 10^7, lower bound and upper bound is there, we can apply the linear search on that but that will be brute so optimised is to apply binary search in this range
    // Then for each mid, check the condition is it can be a valid speed 
//     in the condition, run for loop from 0 to n-2 elements along with its ceal 
    // for the last element take proper double time.
//     then accordingly move your search range
public int minSpeedOnTime(int[] dist, double hour) {
    int n = dist.length;
    if(hour<=n-1){
        return -1;
    }
    int low = 1, high = (int)1e7;
    
    while(low<=high){
        int mid = low + (high-low)/2;
        
        if(isSpeed(dist,hour,mid)){
            high = mid-1;
        }
        else{
            low = mid+1;
        }
    }
    return low;
}

private boolean isSpeed(int[] dist, double hour,int speed){
    int n = dist.length;
    double time = 0;
    
    for(int i=0;i<n-1;i++){
        time += dist[i]/speed;
        time += (dist[i]%speed == 0)?0:1; 
    }
    time += (dist[n-1]*1.0/speed);
    
    return time<=hour;
}
}
