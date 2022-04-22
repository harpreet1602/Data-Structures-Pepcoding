public class hashmapQues {
    
//     brute force
//     time O(1) space O((int)1e6+1)
public int[] map;
public MyHashMap() {
    map = new int[(int)1e6+1];
    Arrays.fill(map,-1);
}

public void put(int key, int value) {
    map[key] = value;//O(1)
}

public int get(int key) {
    return map[key];//O(1)
}

public void remove(int key) {
    map[key] = -1;//O(1)
}
//     Optimised 
//     LinkedList
//     pending
}
