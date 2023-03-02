public class stringCompression {
    
    // 443. String Compression
// tc O(n) sc O(1)
//     String compression is being done 
//     On the same string the count of each variable will be tracked
//     Whenever we get the different character, we make changes to assign that character and its corresponding count that too if the count is large 
//     traverse on each of its digit to add in the chars array.
    
public int compress(char[] chars) {
    int n = chars.length,i=0;
    
    for(int j=1,count=1;j<=n;j++,count++){
        if(j == n || chars[j-1]!=chars[j]){
            chars[i++] = chars[j-1];
            if(count>=2){
            for(char ch:Integer.toString(count).toCharArray()){
                chars[i] = ch;
                i++;
            }
            }
            count=0;
        }
    }
    return i;
}
}
