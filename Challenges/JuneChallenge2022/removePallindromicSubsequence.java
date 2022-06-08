public class removePallindromicSubsequence{
    
    // 1332. Remove Palindromic Subsequences
//     tc O(n) sc O(1)
// Two Pointers    
//     2 cases here as the string only consists of two characters so either in one
//     go only we will get the whole string as pallindrome then we can return 1 
//     In between if we find that the whole string is not pallindrome return 2
//     because it can delete all a's and then b's or vice versa because all a's will be pallindromic subsequence and similarly for all b's
    
public int removePalindromeSub(String s) {
    int low = 0, high = s.length()-1;
    
    while(low<high){
        char ch1 = s.charAt(low);
        char ch2 = s.charAt(high);
        if(ch1 != ch2){
            return 2;
        }
        low++;
        high--;
    }
    return 1;
}
}