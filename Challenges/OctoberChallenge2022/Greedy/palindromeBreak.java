public class palindromeBreak {
    
    // 1328. Break a Palindrome
//     tc O(n/2)=> O(n) sc O(1)
//     Change the first non a character to a and return 
//     but in the case where there are all a's till middle then we have to change the last character to b
//     
public String breakPalindrome(String palindrome) {
    char[] arr = palindrome.toCharArray();
    int n = palindrome.length();
    if(n<2){
        return "";
    }
    for(int i=0;i<n/2;i++){
        if(arr[i]!='a'){
            arr[i] = 'a';
            return new String(arr);
        }
    }
//         all a's
    arr[n-1] = 'b';
    return new String(arr);
}
}
