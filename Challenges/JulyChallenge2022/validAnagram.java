import java.util.Arrays;

public class validAnagram{
    
    // 242. Valid Anagram
//     Brute force > sorting then checking the strings
//     tc O(nlogn) sc O(1)
public boolean isAnagram(String s, String t) {
    char[] sarr = s.toCharArray();
    char[] tarr = t.toCharArray();
    
    Arrays.sort(sarr);
    Arrays.sort(tarr);
    
    return new String(sarr).equals(new String(tarr));
}

//     tc O(3*n)=>O(n) sc O(26)=>O(1)
//     Hash table Optimised solution
public boolean isAnagram1(String s, String t) {
   int[] freq = new int[26];
   int n = s.length(),m = t.length();
   
   for(int i=0;i<n;i++){
       int ind = s.charAt(i) - 'a';
       freq[ind]++;
   }
   
   for(int i=0;i<m;i++){
       int ind = t.charAt(i) - 'a';
       freq[ind]--;
   }
   
   for(int i=0;i<26;i++){
       if(freq[i]!=0){
           return false;
       }
   }
   return true;
}
}