import java.util.List;
import java.util.ArrayList;


public class pascalTriangle {
    
    // 118. Pascal's Triangle
//     tc O(n^2) sc O(1)
//     So with the help of previous list, current list can be obtained, 
//     current and previous value sum can help us do that with some conditions which goes out list.
//    So do a dry run and then simply code it. 
     
public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> s = new ArrayList<>();
    s.add(1);
    ans.add(s);
    for(int i=1;i<numRows;i++){
        List<Integer> prevRow = ans.get(i-1);
        List<Integer> smallAns = new ArrayList<>();
        
        for(int j=0;j<=i;j++){
            int prevEntry = j>0?prevRow.get(j-1):0;
            int nextEntry = j<i?prevRow.get(j):0;
            
            smallAns.add(prevEntry+nextEntry);
        }
        ans.add(smallAns);
    }
    return ans;
}
}
