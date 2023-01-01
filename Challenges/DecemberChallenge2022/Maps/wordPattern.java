public class wordPattern {
    
    // 290. Word Pattern
// tc O(n) sc O(n)
//     Word pattern => If the key is already there then you have to check its value with the current string if it does not match return false
//     else => if the value is present already for a new key case then return false
//     Otherwise add it into the map
//    If everything goes well return true. 
public boolean wordPattern(String pattern, String s) {
    HashMap<Character,String> map = new HashMap<>();
    
    int n = pattern.length();
    String[] arr = s.split(" ");
    int m=arr.length;
    if(n!=m){
        return false;
    }
    for(int i=0;i<n;i++){
        char ch = pattern.charAt(i);
        if(map.containsKey(ch)){
            if(!map.get(ch).equals(arr[i])){
                return false;
            }
        }
        else{
            if(map.containsValue(arr[i])){
                return false;
            }
            map.put(ch,arr[i]);
        }
    }
    return true;
}
}
