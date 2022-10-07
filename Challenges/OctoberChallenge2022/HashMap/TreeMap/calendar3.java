public class calendar3 {
    
// 732. My Calendar III
//     tc O(n) sc O(n)
//     So put all the start and end points in a treemap , so they will be stored in sorted
//     format via keys which are points of start and end
//     Put in the map prevVal+1 when start comes that one more booking start from me
//     Put in the map prevVal-1 when end comes that one more booking end till me
//     Accordingly figure out the maximum booking point while traversing through all the values of the map created
//     in between you will get the common maximum booking, return that.
private TreeMap<Integer,Integer> map;
    
public MyCalendarThree() {
    map = new TreeMap<>();
}

public int book(int start, int end) {
    map.put(start,map.getOrDefault(start,0)+1);
    map.put(end,map.getOrDefault(end,0)-1);
    
    int maxBook = 0, ongoing = 0;
    for(int value:map.values()){
        maxBook = Math.max(maxBook,ongoing += value);
    }
    return maxBook;
}
}
