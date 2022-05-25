public class Reverse {
    //    344. Reverse String
//     tc O(n) sc O(1)
    // just have two pointers one in the start and one in the end 
    // swap until they meet.
    private void swap(char[] s,int i,int j){
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
    public void reverseString(char[] s) {
        int low = 0, high = s.length-1;
        while(low<high){
            swap(s,low,high);
            low++;
            high--;
        }
    }
}
