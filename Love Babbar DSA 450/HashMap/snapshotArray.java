package HashMap;

public class snapshotArray {
    class SnapshotArray {
        // 1146. Snapshot Array
        // tc O(n) sc O(n*snaps) I think
        //     Google favorite question
        //     More optimised binary search to be done later
        
        //  We have used array of hashmaps here.
        //     Instead of storing array again and again for each snap that is brute and will take a lot of space 25*10^8 that is memory limit exceeded.
        //     SO instead of that we can store at each index a hashmap to store snap vs value on that index.
        //     maintain that accoriding to the snap number going on
        //     in the get function find till you get the snap id in the hashmap on that index through which you can return the value.
        //     because this is the case that the value is not updated on the particular snap so its previous snap value needs to be used.
        //     DRY run to understand better.
            HashMap<Integer,Integer>[] arr;
            int snap = 0;
            public SnapshotArray(int length) {
                arr = new HashMap[length];
                for(int i=0;i<length;i++){
                    arr[i] = new HashMap<>();
                }
            }
            
            public void set(int index, int val) {
                arr[index].put(snap,val);
            }
            
            public int snap() {
                return snap++;
            }
            
            public int get(int index, int snap_id) {
                while(snap_id>=0 && !arr[index].containsKey(snap_id)){
                    snap_id--;
                    if(snap_id == -1){
                        return 0;
                    }
                }
                return arr[index].get(snap_id);
            }
        }
        
        /**
         * Your SnapshotArray object will be instantiated and called as such:
         * SnapshotArray obj = new SnapshotArray(length);
         * obj.set(index,val);
         * int param_2 = obj.snap();
         * int param_3 = obj.get(index,snap_id);
         */
}
