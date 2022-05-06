import java.util.LinkedList;
import javafx.util.Pair;
public class removeAllAdjacents2{
    
    // 1209. Remove All Adjacent Duplicates in String II
//     tc O(n) sc O(n)
//     Store the the linkedlist with the pair<character,integer> 
//     accordingly add the pairs into the stack =>
//     Whenever the stack is empty or the top of the stack don't match with current ch
//     then add like this st.addFirst(new Pair<>(ch,1));
// If it is not the case then store the pair with increment in the value
// Also,  remove from the stack whenever freq reaches k of the pair.
//     In the end make the string in the reverse order while popping out from the
//     stack.
    
public String removeDuplicates(String s, int k) {
    LinkedList<Pair<Character,Integer>> st = new LinkedList<>();
    String str = "";
    for(int i = 0;i<s.length();i++){
        char ch = s.charAt(i);
        if(st.size()==0 || st.getFirst().getKey() !=ch){
            st.addFirst(new Pair<>(ch,1));
        }
        else{
            Pair<Character,Integer> rp = st.removeFirst();
            
            st.addFirst(new Pair<>(rp.getKey(),rp.getValue()+1));
            
            if(st.getFirst().getValue() == k){
            st.removeFirst();
            }
        }
    }
    while(st.size()!=0){
        Pair<Character,Integer> rp = st.removeFirst();
        int size = rp.getValue();
        while(size-->0)
        str = rp.getKey() + str;
    }
    return str;
}
}