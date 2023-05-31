package HashMap;

public class designUnderground {
    class UndergroundSystem {
        // 1396. Design Underground System
        // tc O(1) amotised sc O(2*n)=>O(n)
        //     we have to make two hashmaps for designing this problem
        //     one hashmap for integer to the pair1 of station and time when we are checking in we will add
        //     when we are checking out we will get the starting station as well as starting time
        //     current station and current time is also there for a particular id
        //     so we will have a second hashmap to store "startstation-endstation" to the pair of total time of the trip, total number of trips till now
            
        //     after maintaining this we will return the division of both to get the average of trips till now from start station to end station.
        //    ref:- https://www.youtube.com/watch?v=Fb4SKeu8zf4&ab_channel=AyushiSharma 
            
            private class pair1
            {
                String station;
                int time;
                public pair1(String station,int time){
                    this.station = station;
                    this.time = time;
                }
            }
            private class pair2
            {
                int totaltime;
                int totaltrip;
                public pair2(int totaltime,int totaltrip){
                    this.totaltime = totaltime;
                    this.totaltrip = totaltrip;
                }
            }
            
            HashMap<Integer,pair1> map1;
            HashMap<String,pair2> map2;
            
            public UndergroundSystem() {
                map1 = new HashMap<>();
                map2 = new HashMap<>();
            }
            
            public void checkIn(int id, String stationName, int t) {
                map1.put(id,new pair1(stationName,t));
            }
            
            public void checkOut(int id, String stationName, int t) {
                int diff = 0;
                pair1 p = map1.get(id);
                String s = p.station+"-"+stationName;
                if(map2.containsKey(s)){
                    pair2 p2 =map2.get(s);
                    p2.totaltime += (t-p.time);
                    p2.totaltrip += 1;
                    map2.put(s,p2);
                }
                else{
                   map2.put(s,new pair2(t-p.time,1)); 
                }
            }
            
            public double getAverageTime(String startStation, String endStation) {
                pair2 p2 = map2.get(startStation+"-"+endStation);
                return (double)p2.totaltime/p2.totaltrip;
            }
        }
        
        /**
         * Your UndergroundSystem object will be instantiated and called as such:
         * UndergroundSystem obj = new UndergroundSystem();
         * obj.checkIn(id,stationName,t);
         * obj.checkOut(id,stationName,t);
         * double param_3 = obj.getAverageTime(startStation,endStation);
         */
}
