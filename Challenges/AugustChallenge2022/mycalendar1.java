public class myCalendar1{
    // 729. My Calendar I
//     tc O(logn) sc O(n)
//     sorted on the basis of key i.e. in this case will be start time
//    sorting on the basis of start time in the map 
private TreeMap<Integer,Integer> calendar = null;
public MyCalendar() {
    calendar = new TreeMap<>(); 
}

public boolean book(int start, int end) {
//         condition around the start time
    // start < lower entry end time
    if(calendar.floorEntry(start)!=null && start < calendar.floorEntry(start).getValue()){
        return false;
    }
//         condition around the end time
    // end > higher entry start time
    if(calendar.ceilingEntry(start)!=null && end > calendar.ceilingEntry(start).getKey()){
        return false;
    }
    calendar.put(start,end);
    return true;
}
}