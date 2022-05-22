
public class reverseArray {

    // 344. Reverse String
    // tc O(n) sc O(1)
    // just have two pointers one in the start and one in the end swap until they meet.
    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public void reverseString(char[] s) {
        int low = 0, high = s.length - 1;
        while (low < high) {
            swap(s, low, high);
            low++;
            high--;
        }
    }

    // Reverse a String gfg
    // https://practice.geeksforgeeks.org/problems/reverse-a-string/1#
    // tc O(n) sc O(n)
    // do a dry run to reverse the string character by character.
    public static String reverseWord1(String str) {
        // Reverse the string str
        String newStr = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            newStr = ch + newStr;
        }
        return newStr;
    }

    // two pointer approach using stringbuilder.
    // tc O(n) sc O(n)
    private static void swap(StringBuilder sb, int i, int j) {
        char temp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, temp);
    }

    public static String reverseWord(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        int low = 0, high = str.length() - 1;

        while (low < high) {
            swap(sb, low, high);
            low++;
            high--;
        }
        return sb.toString();
    }
}