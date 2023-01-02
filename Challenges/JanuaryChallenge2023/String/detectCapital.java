public class detectCapital{
    
    // 520. Detect Capital
// tc O(n) sc O(1)
//     Cases are like mL, g, Ml, Ms, MS
//     We have to handle all these by checking the substring from 1 saying that all substring is lower then return true because in this case we don't what is the first character
//     Second case is if all the word is upper case then return true
//   Other than that return false.  
    public boolean detectCapitalUse(String word) {
        String subStr = word.substring(1);
        
        return subStr.equals(subStr.toLowerCase()) || word.equals(word.toUpperCase());
        
    }
}