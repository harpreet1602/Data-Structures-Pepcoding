public class minNumberRefill {
    
    // 871. Minimum Number of Refueling Stops
//     tc O(nlogn) sc O(n)
//     Greedy approach => Use Priority queue i.e. max heap to store the fuel through which we can move distance
//     Accordingly add all the avaible fuels of the gas station which comes in the journey in the pq so that they can be used later on
//    At any place if all the fuel is empty in between return -1
//    Otherwise keep on following the process to cover the distance till next gas station
// In the end corner case where the added fuel in the pq will help us to reach the destination and there also if pq becomes empty before reaching target then return -1.  
public int minRefuelStops(int target, int startFuel, int[][] stations) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
        return b-a;
    });
    int currentX = startFuel;
    int noStops = 0;
    
    for(int[] station:stations){
        int nextStationX = station[0];
        int fuelAtStation = station[1];
        
        while(currentX < nextStationX){
            if(pq.size()==0){
                return -1;
            }
            int maxFuel = pq.remove();
            currentX = currentX + maxFuel;
            noStops++;
        }
        pq.add(fuelAtStation);
    }
    while(currentX < target){
            if(pq.size()==0){
                return -1;
            }
            int maxFuel = pq.remove();
            currentX = currentX + maxFuel;
            noStops++;
    }
    return noStops;
}
}
