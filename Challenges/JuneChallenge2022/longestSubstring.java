import java.util.HashMap;
public class longestSubstring {
    
    // 3. Longest Substring Without Repeating Characters.
//     tc O(n) sc O(n)
//     Two Pointers along with the use of hashmap to track I should only get the maximum
//     in case of no duplicacy i.e. from start to end every character's frequency must be 1 or 0
//     Accordingly we will move pointers and apply conditions that end is going to track 
//     at which character we have to take decision
//     if prevend != end this means end has come forward succesfully so increase the count of it in map
//     otherwise it is not able to change if prevend == end so don't increase the count of end in map
//     after that check if end's frequency is >1 then end has to wait here and start will increase and its count will be decreased in map.
//     otherwise end's frequency is 1 no duplicates are there so maintain max from this condition and move end 
public int lengthOfLongestSubstring(String s) {
    HashMap<Character,Integer> map = new HashMap<>();
    if(s.length()==0 || s.length()==1){
        return s.length();
    }
    int start = 0, end = 0,max=1,prevend=-1;
    while(start<=end && end<s.length()){
        char st = s.charAt(start);
        char en = s.charAt(end);
        if(prevend!=end)
        map.put(en,map.getOrDefault(en,0)+1);
        prevend = end;
        if(map.getOrDefault(en,0)>1){
            start++;
            map.put(st,map.get(st)-1);
        }
        else{
            max = Math.max(max,end-start+1);
            end++;
        }
    }
    return max;
}
// Egensia Interview
public static void main (String[] args) throws java.lang.Exception
{
    // your code goes here
// 		 a b c a b c e b b
// sc O(n) tc O(n)
    HashMap<Character,Integer> map = new HashMap<>();
    String str = "aa";
    int start=0,end=0,prevend=-1,max=0,n=str.length();
    
    while(start<=end && end<n){
        char ch = str.charAt(end);
        if(prevend!=end)
        map.put(ch,map.getOrDefault(ch,0)+1);
    
        prevend=end;
    
        if(map.getOrDefault(ch,0)!=1){
            max = Math.max(max,end-start);
            map.put(str.charAt(start),map.get(str.charAt(start))-1);
            start++;
        }   
        else{
            end++;
        }
        
    }
    max = Math.max(max,end-start);
    
    System.out.println(max);
    
}
}
