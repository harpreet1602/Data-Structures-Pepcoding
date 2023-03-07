public class minTime {
    
    // 2187. Minimum Time to Complete Trips
// tc O(nlogn) sc O(1)
//     Range based binary search will be applied from 1 to min of array * total trips
//     In between the minimum time will be there where total trips can be completed.
    
//     Accordingly binary search will be applied and for every mid we check how many trips can be covered with this mid time.
public long minimumTime(int[] time, int totalTrips) {
    long low = 1, n = time.length,min=time[0],high;
    for(int i=0;i<n;i++){
        min = Math.min(min,time[i]);
    }
    high = min*totalTrips;
    while(low<high){
        long mid = low + ((high-low)/2);
        long trips = 0;
        for(int i=0;i<n;i++){
            trips = trips + ((long)mid/time[i]);
        }
        if(trips<totalTrips){
            low = mid+1;
        }
        else{
            high = mid;
        }
    }
    return low;
}
}
