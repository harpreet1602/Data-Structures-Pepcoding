package Love Babbar DSA 450.HashMap;

public class playerLoss {
    
    // 2225. Find Players With Zero or One Losses
// tc O(n*m) sc O(n*m)
//     So simply make the hashmap with the player,loses
//     so for winners if they are not present then add them with 0 loss
//     for losers add them or update them with freq present or 0 + 1
//     In the end traverse the treemap to make our customized list for zero and one loses player
//     and return it.
public List<List<Integer>> findWinners(int[][] matches) {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    List<Integer> zeroLoss = new ArrayList<>();
    List<Integer> oneLoss = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    
    int freq=0;
    for(int[] match:matches){
        if(!map.containsKey(match[0])){
            map.put(match[0],0);
        }
        map.put(match[1],map.getOrDefault(match[1],0)+1);
    }
    
    for(int key:map.keySet()){
        freq = map.get(key);
        if(freq==0){
            zeroLoss.add(key);
        }
        else if(freq==1){
            oneLoss.add(key);
        }    
    }
    
    ans.add(zeroLoss);
    ans.add(oneLoss);
    return ans;
}
}
