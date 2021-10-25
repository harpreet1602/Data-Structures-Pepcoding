public class client {
    public static void main(String[] args){
        hashmapConstruction map = new hashmapConstruction();
        map.put(1,10);
        map.put(2,20);
        // map.put(3,30);
        map.putIfAbsent(3,40);
       System.out.println(map.display());
       System.out.println(map.get(3));
       System.out.println(map.keySet());
    }
}
