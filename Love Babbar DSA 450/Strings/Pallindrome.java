public class Pallindrome {
    // https://practice.geeksforgeeks.org/problems/palindrome-string0817/1#
    // BRute foce
    // Make a new reverse string, compare it from the original one.
    // TC O(n) SC O(n)
    
    // Optimised one
    // TC O(n) sc O(1)
    // Two pointer approach.
    
    int isPalindrome(String S) {
        // code here
        int low = 0, high = S.length()-1;
        while(low<high){
            if(S.charAt(low)!=S.charAt(high)){
                return 0;
            }
            low++;
            high--;
        }
        return 1;
    }
}
