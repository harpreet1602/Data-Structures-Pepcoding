public class orderlyQueue {
    
    // 899. Orderly Queue
    // tc O(n) sc O(1)
    // K>1 you have the option of customizing the string according the first k characters
    // append it to the last to make the lexicographically smallest string
    // So by the virtue of this property we will always get the full sorted string.
    // K==1, find all the strings and get the smallest possible out of it and return
    //  ans.compareTo(reorderedStr) == 1 when ans > reorderedStr

    public String orderlyQueue(String s, int k) {
        if(k>1){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            return new String(arr);
        }
        else{
            String ans = s;
            for(int i=1;i<s.length();i++){
                String reorderedStr = s.substring(i) + s.substring(0,i);
                if(ans.compareTo(reorderedStr) > 0){
                    ans = reorderedStr;
                }
            }
            return ans;
        }
    }
}
