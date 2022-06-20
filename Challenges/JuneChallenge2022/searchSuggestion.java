import java.util.TreeMap;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class searchSuggestion {
    
    // 1268. Search Suggestions System
//     tc O(n logn) sc O(n)
//  not sure but approx.  
    
//     Optimized => tries will be done later.

//     First of all sort the products array as lexigraphically 3 smaller strings that matches the substring should be stored at the substring's last added character place.
//     Make a treemap which will contain the string to index mapping in order
//     will give us the benifit of using ceiling and floor properties 
//     ceil is the starting string and floor is the ending string that matches with the substring 
//     make a list of products array to use sublist method later on.
//     particular character will be added to the key string and accordingly ceiling and floor will be found then if any of the one is not present in the map then break and add all the empty lists in the ans.
//     If everything is ok then from the ceiling index , ending index will be the Math.min(map.get(ceiling)+3,map.get(floor)+1)) => extra 1's are added because the ending index in sublist in excluded. Also do a dry run to understand this in the start first condition will give the minimum index and then in the end second one will give the minimum index.
//     this sublist will get added to the ans.
    
    
public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    //         O(n logn)
            Arrays.sort(products);
            List<List<String>> ans = new ArrayList<>();
            // <Products string,integer value in sorted array>
            TreeMap<String,Integer> map = new TreeMap<>();
            List<String> productsList = Arrays.asList(products);
            for(int i=0;i<products.length;i++){
                map.put(products[i],i);
            }
            String key = "";
    //         O(len*log n)
            for(char c:searchWord.toCharArray()){
                key += c;
    //             O(log n)
                String ceiling = map.ceilingKey(key);
                String floor = map.floorKey(key+"{");
                
                if(ceiling == null || floor == null){
                    break;
                }
     
    //             some operation 
                ans.add(productsList.subList(map.get(ceiling),Math.min(map.get(ceiling)+3,map.get(floor)+1)));
            }
    //         O(n)
            while(ans.size()<searchWord.length()){
                ans.add(new ArrayList<>());
            }
            
            return ans;
            
        }
}
