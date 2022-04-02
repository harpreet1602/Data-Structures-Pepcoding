class Solution {
    // 344. Reverse String
//     tc O(n) sc O(1)
//     just take two pointers one at start and the other at the end 
//     just keep on coming close and swap  the two until they meet.
//     Woho! the string is reversed.
    public void swap(char[] s,int i, int j){
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
    public void reverseString(char[] s) {
        int low = 0, high = s.length-1;
        while(low<high){
            swap(s,low++,high--);
        }
    }


    
//     tc O(n) sc O(1)
//     Just check the pallindrome and handle the deletion case by calling both the scenarios 
//     i with j-1 or i+1 with j-1 and there on also check the same conditions from them onwards
//     if you get true with any of the scenario then the ans is true otherwise false.
    public boolean checkPal(String s,int i,int j){
         while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false; 
            }
            i++;
            j--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return checkPal(s,i,j-1) || checkPal(s,i+1,j); 
            }
            i++;
            j--;
        }
        return true;
    }
}