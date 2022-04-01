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
}