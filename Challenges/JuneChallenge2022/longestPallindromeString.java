public class longestPallindromeString {
    
    // 5. Longest Palindromic Substring
//     DP will be done later
    
    
//     Brute => tc O(n^3) sc O(1)
//     Generate all substrings and check for each is it pallindrome or not?
    // Substrings are made by simple two nested for loops
        
//     Optimized
//     tc O(n^2) sc O(1)
//     Generating only those substrings which can be pallindrome 
//     time complexity gets reduced "a" will be checked after that "bab" can be check in case of odd length
//     "bb" can be checked then "abba" can be checked in case of even length
private int maxLPS=0,startPt=0;
public String longestPalindrome(String s) {
    int n = s.length();
    for(int i=0;i<n;i++){
        checkForPallindrome(s,i,i); //odd length pallindrome
        checkForPallindrome(s,i,i+1); //even length pallindrome
    }
    return s.substring(startPt,startPt+maxLPS);
}

private void checkForPallindrome(String s,int left,int right){
    while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
        left--;
        right++;
    }
    if(maxLPS<right-left-1){
        maxLPS = right-left-1;
        startPt = left+1;
    }
}
}
