package HashMap;

public class equalRowsCol {
    
    // 2352. Equal Row and Column Pairs
// tc O(m*n) sc O(m*n)
//     Brute can be check each row for each column
    
//     Optimised
//     store the row values in encoded format of string with its frequency in a hashmap
//     similarly for columns in other hashmap
//     after check if the value is common multiply both of their frequencies because that much combinations of equal rows and columns are made.
//     Dry run for [[13,13],[13,13]] answer comes out to be 2*2 = 4.
public int equalPairs1(int[][] grid) {
    HashMap<String,Integer> rowMap = new HashMap<>();
    HashMap<String,Integer> colMap = new HashMap<>();
    int n = grid.length, ans = 0;
    
    for(int i=0;i<n;i++){
        String key = "";
        for(int j=0;j<n;j++){
            key += grid[i][j];
            key += "_";
        }
        rowMap.put(key,rowMap.getOrDefault(key,0)+1);
    }
    for(int j=0;j<n;j++){
        String key = "";
        for(int i=0;i<n;i++){
            key += grid[i][j];
            key += "_";
        }
        colMap.put(key,colMap.getOrDefault(key,0)+1);
    }
    
    for(String key:rowMap.keySet()){
        if(colMap.containsKey(key))
        {
            ans += (rowMap.get(key)*colMap.get(key));
        }
    }
    return ans;
}

//     with string builder
public int equalPairs(int[][] grid) {
    HashMap<String,Integer> rowMap = new HashMap<>();
    HashMap<String,Integer> colMap = new HashMap<>();
    int n = grid.length, ans = 0;
    
    for(int i=0;i<n;i++){
        StringBuilder sb = new StringBuilder();
        for(int j=0;j<n;j++){
            sb.append(grid[i][j]).append("_");
        }
        rowMap.put(sb.toString(),rowMap.getOrDefault(sb.toString(),0)+1);
    }
    for(int j=0;j<n;j++){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(grid[i][j]).append("_");
        }
        colMap.put(sb.toString(),colMap.getOrDefault(sb.toString(),0)+1);
    }
    
    for(String key:rowMap.keySet()){
        if(colMap.containsKey(key))
        {
            ans += (rowMap.get(key)*colMap.get(key));
        }
    }
    return ans;
}
}
