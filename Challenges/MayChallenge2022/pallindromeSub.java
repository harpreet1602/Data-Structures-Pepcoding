public class pallindromeSub {
    // 647. Palindromic Substrings
//     Brute force
//     Find all the substrings and find which one is pallindrome.
//  tc O(n^2*n) => O(n^3) sc O(1)   
//     n^2 for substrings and n for pallindrome.
    
//     tc O(2*(n)^2) => O(n^2) sc O(1)
//     Iteration and find all the pallindromic substring from the current index by 
//     expanding it in both directions.
//     special case of abba where (i,i+1) is sent to consider even length substring
    
    
private int getPallindromeCount(int start,int end,String s){
    int total = 0;
    
    while(start>=0 && end<s.length() && s.charAt(start) == s.charAt(end)){
        start--;
        end++;
        total++;
    }
    return total;
}
public int countSubstrings(String s) {
    int totSubstring = 0;
    
    for(int i=0;i<s.length();i++){
        totSubstring += getPallindromeCount(i,i,s); 
        //aba
        
        totSubstring += getPallindromeCount(i,i+1,s); //abba
    }
    
    return totSubstring;
}
}
