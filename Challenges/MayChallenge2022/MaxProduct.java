public class MaxProduct {
    
    // 318. Maximum Product of Word Lengths
//     Brute => tc O(n*n*len1*len2) sc O(1)
//     evaluate for each case and maitain the answer
//     if the characters don't match in two strings so take product and get max product
    
    
// tc O(n^2) sc O(n)
//     Optimised
//    bit manipulation
//     bits are 32 and alphabets are 26
//     so we can map the alphabets on a number with 32 bits
//     So basically we can store each string's character in the form of bits in a separate state array.
    
//     after that we can traverse and see if there any two states where there & becomes 0 this means they have no character in common in both the strings so maitain the max product by considering the product of both the lengths of string.
public int maxProduct(String[] words) {
    int maxpro = 0,n=words.length;
    int[] state = new int[n];
    
    for(int i=0;i<n;i++){
        state[i] = getStateFromString(words[i]);
    }
    
    
    for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
            if((state[i]&state[j])==0){
                maxpro = Math.max(maxpro,words[i].length()*words[j].length());
            }
        }
    }
    
    return maxpro;
    
}

private int getStateFromString(String str){
    int state = 0;
    for(char c:str.toCharArray()){
        int index = c-'0';
        state = state | (1<<index);
    }
    return state;
}
}
