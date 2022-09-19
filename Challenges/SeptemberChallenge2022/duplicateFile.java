public class duplicateFile{
    
    // 609. Find Duplicate File in System
//     tc O(n*x) sc O(n*x)
//     we will make hashmap of content,list of path
//     then when we will be traversing through each path then first of all split on " "
//     so that everything gets separated and gets stored in arrray like [root/a,1.txt(abcd), 2.txt(efgh)]
//     Then manipulate the string accordingly.
public List<List<String>> findDuplicate(String[] paths) {
    //         content,List<Path>
            HashMap<String,List<String>> map = new HashMap<>();
            List<List<String>> ans = new ArrayList<>();
            
            // "root/a 1.txt(abcd) 2.txt(efgh)"
    //         [root/a,1.txt(abcd), 2.txt(efgh)]
            for(String path:paths){
                String[] dir = path.split(" ");
    //             root/a
                String root = dir[0];
    //             1.txt(abcd)
                for(int i=1;i<dir.length;i++){
                    // abcd
                    String content = dir[i].substring(dir[i].indexOf("(")+1,dir[i].indexOf(")"));
                    if(!map.containsKey(content)){
                        map.put(content,new ArrayList<>());
                    }
                    map.get(content).add(root+"/"+dir[i].substring(0,dir[i].indexOf("(")));
                }
                
            }
    //         add the duplicate content's list in the answer.
            for(String content:map.keySet()){
                List<String> list = map.get(content);
                if(list.size()>1){
                    ans.add(list);
                }
            }
            return ans;
        }
}