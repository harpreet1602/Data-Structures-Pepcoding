public class similarString {
    class Solution {
        //    839. Similar String Groups
        // tc O() sc O(n) think about it
            
        //    As we have to find similar type of groupings on the basis of one operation of character swapping in the strings to make them similar.
            // Union find will be applied to find the components 
        //     Here map will be used for maintaing the parent thing
        //     String's parent will be other string.
        //     Similar thing => only 0 character or 2 characters difference
            
            
            private Map<String,String> par = new HashMap<>();
            
            public int numSimilarGroups(String[] strs) {
                int n = strs.length, comp=0;
        //         initially every string is its parent.
                for(String str:strs){
                    par.put(str,str);
                }
                
                for(int i=0;i<n;i++){
                    String absParI = getParent(strs[i]);
                    for(int j=i+1;j<n;j++){
                        
                        if(isSimilar(strs[i],strs[j])){
                            String absParJ = getParent(strs[j]);
                            if(absParI!=absParJ){
                                par.put(absParJ,absParI);
                            }
                        }
                    }
                }
                
                for(String str:par.keySet()){
                    String absParStr = getParent(str);
                    
                    if(str == absParStr){
                        comp++;
                    }
                }
                return comp;
            }
            
            private String getParent(String str){
                if(str.equals(par.get(str))){
                    return str;
                }
                
                par.put(str,getParent(par.get(str)));
                return par.get(str);
            }
            
            private boolean isSimilar(String str1,String str2){
                int diff = 0;
                
                for(int i=0;i<str1.length();i++){
                    if(str1.charAt(i)!=str2.charAt(i)){
                        diff++;
                    }
                    if(diff>2){
                        return false;
                    }
                }
                return diff == 0 || diff == 2;
            }
        }
}
