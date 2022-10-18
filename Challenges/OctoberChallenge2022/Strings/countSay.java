public class countSay{
    
    // 38. Count and Say
//     tc O(n*length(s)) sc O(length(s))
//     So we just have to apply the count and say iteratively on the strings received by the previous call with one number less
//     Logic says make a stringbuilder 
//     take out the previous character and see if it is equal with the curr one then inc the count otherwise addition of count, previous in stringbuilder takes place
//     then set the previous to curr and reset count to 1 for next iteration.
    
public String countAndSay(int n) {
    String s = "1";
    for(int i=1;i<n;i++){
        s = countSay(s);
    }
    return s;
}
public String countSay(String s){
    StringBuilder sb = new StringBuilder();
    char previous = s.charAt(0);
    int count=1;
    for(int i=1;i<s.length();i++){
        char ch = s.charAt(i);
        
        if(ch == previous){
            count++;
        }
        else{
        sb.append(count);
        sb.append(previous);
        previous = ch;
        count = 1;
        }
    }
    
    sb.append(count);
    sb.append(previous);
    return sb.toString();
}
}