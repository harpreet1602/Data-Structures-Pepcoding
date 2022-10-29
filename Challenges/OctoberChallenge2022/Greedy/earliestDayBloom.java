public class earliestDayBloom {
    
    // 2136. Earliest Possible Day of Full Bloom
//     tc O(nlogn) sc O(n)
//     Make a class of two members plantTime and growTime
//     Make its arraylist and sort it on the basis of decreasing growTime
//     because it allows us to plant seeds in the ongoing growTime.
//     Do a dry run to understand that other case like decreasing plantTime types of case
//     will not work here.
//     After that traverse in the list and accordingly see the maximum of prevmax or
//     time taken till now + current seed's growtime where time taken till now is plant time till now.
public int earliestFullBloom(int[] plantTime, int[] growTime) {
    List<Seed> list = new ArrayList<>();
    for(int i=0;i<growTime.length;i++){
        list.add(new Seed(plantTime[i],growTime[i]));
    }
//         Sort on the basis of growTime in descending order 
//         this is the only way to bloom all seeds in less time
    Collections.sort(list,(a,b)->{
       return b.growTime - a.growTime; 
    });
    int time = 0;
    int max = 0;
    for(Seed seed:list){
        time += seed.plantTime;
        max = Math.max(max,time + seed.growTime);
    }
    return max;
}
private class Seed{
    int plantTime;
    int growTime;
    
    public Seed(int plantTime,int growTime){
        this.plantTime = plantTime;
        this.growTime = growTime;
    }
}
}
