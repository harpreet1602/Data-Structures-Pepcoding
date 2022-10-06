import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class timeBasedKey {
    class TimeMap {
        // 981. Time Based Key-Value Store
        //     tc O() sc O()
        //     Idea is to store these details in a DS where we can have hashmap in which corresponding to keys
        //     there is a treemap which will contain timestamp/version as the key and accordingly we will get value
        //     So first find the treemap present on a key then see the floor version and then return the value
            
        //     key , <timestamp,value>
            private Map<String,TreeMap<Integer,String>> store;
            public TimeMap() {
                store = new HashMap<>();
            }
        //     i think tc O(logn) sc O(n)
        //     Here see if a key value pair is present in the hashmap already, if not then add key-Treemap 
        //     and put version, value in it
        //     If already present take out the already existing treemap and then add <version,value> in it.
            public void set(String key, String value, int timestamp) {
                store.computeIfAbsent(key,x->new TreeMap<>()).put(timestamp,value);
            }
            //     So first find the treemap present on a key then see the floor version and then return the value
            public String get(String key, int timestamp) {
                Integer version = store.containsKey(key)?store.get(key).floorKey(timestamp):null;
                return version!=null? store.get(key).get(version):"";
            }
        }
        
        /**
         * Your TimeMap object will be instantiated and called as such:
         * TimeMap obj = new TimeMap();
         * obj.set(key,value,timestamp);
         * String param_2 = obj.get(key,timestamp);
         */
}
