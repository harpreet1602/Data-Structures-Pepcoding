public class reverseVowels{
     // 345. Reverse Vowels of a String
    // tc O(n) sc O(1)
    // Ṭwo pointer approach to swap the vowels seen from start and end
    public String reverseVowels(String s) {
        int low = 0, high = s.length()-1;
        StringBuilder sb = new StringBuilder(s);

        while(low<high){
            char lch = sb.charAt(low);
            char hch = sb.charAt(high);
            if(isVowel(lch) && isVowel(hch)){
                sb.setCharAt(low,hch);
                sb.setCharAt(high,lch);
                low++;
                high--;
            }
            else if(!isVowel(lch)){
                low++;
            }
            else if(!isVowel(hch)){
                high--;
            }
        }
        return sb.toString();
    }
    private boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' ||ch == 'i' ||ch == 'o' ||ch == 'u' || ch == 'A' ||ch == 'E' ||ch == 'I' ||ch == 'O' ||ch == 'U';
    }
}