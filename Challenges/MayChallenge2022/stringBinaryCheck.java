import java.util.HashSet;
public class stringBinaryCheck{
    
    // 1461. Check If a String Contains All Binary Codes of Size K
//     tc O((n-k)*k) sc O(2^k)
    
//     time => n-k for traversing in each traversal to cut the substiring of length k
//     then adding it to hashset
//     space => 2^k substrings are added into the hashset si duplicacy will be removed and 
//     to see whether all codes have come or not check the size of the hashset equal to 2^k
    
    
public boolean hasAllCodes(String s, int k) {
    if(s.length()<k){
        return false;
    }
    
    HashSet<String> set = new HashSet<>();
    
    for(int i=0;i<=s.length()-k;i++){
        set.add(s.substring(i,i+k));
    }
    
    return set.size() == Math.pow(2,k);
}
}