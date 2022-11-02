public class minGenetic {
    
//     433. Minimum Genetic Mutation 
// tc O(n) sc O(n)
//     Apply BFS on the string from the start to end
//     from one level to another level by just changing the string each index with the options of 'A,C,T,G'
//     whichever string is not visited earlier and is in the bank that will be in our next level
//     we will return the level when end string comes in the bfs 
//     -1 if it doesn't
public int minMutation(String start, String end, String[] bank) {
    LinkedList<String> que = new LinkedList<>();
    Set<String> vis = new HashSet<>();
    Set<String> bankcheck = new HashSet<>();
    for(String str:bank){
        bankcheck.add(str);
    }
    int level=0;
    que.addLast(start);
    vis.add(start);
    
    while(que.size()!=0){
        int size = que.size();
        while(size-->0){
            String rstr = que.removeFirst();
            
            if(rstr.equals(end)){
                return level;
            }
            StringBuilder sb = new StringBuilder(rstr);
            for(char ch:"ACGT".toCharArray()){
                for(int i=0;i<sb.length();i++){
                    sb = new StringBuilder(rstr);
                    sb.setCharAt(i,ch);
                    String check = sb.toString();
                    if(!vis.contains(check) && bankcheck.contains(check)){
                        vis.add(check);
                        que.addLast(check);
                    }
                }
            }
            
        }
        level++;
    }
    return -1;
}
}
