import java.util.*;

public class l001 {

    public static boolean pallindromecheck(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void solution(String str) {
        // write your code here
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {

                if (pallindromecheck(str, i, j)) {
                    String s = str.substring(i, j + 1);
                    System.out.println(s);
                }

            }
        }

    }

    // string compression 1
    public static String compression1(String str) {
        int n = str.length();
        if (n == 0)
            return null;
        String ans = str.charAt(0) + "";
        int i = 1;
        while (i < n) {
            while (i < n && ans.charAt(ans.length() - 1) == str.charAt(i)) {
                i++;
            }
            if (i < n)
                ans += str.charAt(i);
            i++;
        }
        return ans;

    }

    public static String compression2(String str) {
        int n = str.length(), count = 1;
        if (n == 0)
            return null;
        String ans = str.charAt(0) + "";
        int i = 1;
        while (i < n) {
            count = 1;
            while (i < n && ans.charAt(ans.length() - 1) == str.charAt(i)) {
                i++;
                count++;
            }
            if (count > 1)
                ans += count;
            if (i < n)
                ans += str.charAt(i);
            i++;
        }
        return ans;

    }

    // count hi in a string
    public int countHi(String str) {
        int count = 0, i = 0;
        while (i < str.length() - 1) {
            if (str.charAt(i) == 'h' && str.charAt(i + 1) == 'i') {
                count++;
                i += 2;
            } else {
                i++;
            }
        }
        return count;
    }

    // countOfHiWithoutHit
    public static int countOfHiWithoutHit(String str) {
        int count = 0, i = 0;
        while (i < str.length() - 1) {
            if ((i + 2) < str.length() && str.charAt(i) == 'h' && str.charAt(i + 1) == 'i'
                    && str.charAt(i + 2) == 't') {
                i += 3;
            } else if (str.charAt(i) == 'h' && str.charAt(i + 1) == 'i') {
                count++;
                i += 2;
            } else
                i++;
        }
        return count;
    }

    public static void removehiwithouthit(String str) {
        StringBuilder str1 = new StringBuilder();
        int n = str.length(), i = 0;
        while (i < n) {
            if (i + 2 < n && str.charAt(i) == 'h' && str.charAt(i + 1) == 'i' && str.charAt(i + 2) == 't') {
                str1.append(str.charAt(i)).append(str.charAt(i + 1)).append(str.charAt(i + 2));
                i += 3;
            } else if (i + 1 < n && str.charAt(i) == 'h' && str.charAt(i + 1) == 'i') {
                i += 2;
            } else {
                str1.append(str.charAt(i));
                i++;
            }
        }
        System.out.println(str1.toString());
    }

    // String immutable test
    public static void stringImmutableTest() { // 3.825 sec for 100000 characters to be added
        String str = ""; // 16 minutes sec for 1000000 characters to be added
        for (int i = 0; i <= (int) 1e5; i++) {
            str += i;
        }
        System.out.println(str);
    }

    // String mutable test
    public static void stringMutableTest() { // 0.05 sec for 100000 characters to be added
        StringBuilder sb = new StringBuilder(); // 0.2 sec for 1000000 characters to be added
        for (int i = 0; i <= (int) 1e6; i++) {
            sb.append(i);
        }
        System.out.println(sb.toString());
    }
    // String Builder

    public static void stringBuilderBasicFunction() {
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        sb.append("bcd"); // O(m) where m is the length of the string which I want to append
        System.out.println(sb.toString());
        sb.setCharAt(2, 'e'); // O(1)
        System.out.println(sb.toString());// O(n)
        sb.deleteCharAt(2);// O(n)
        System.out.println(sb.toString());
    }

    // toggle case
    public static String toggleCase(String str) {
        // write your code here
        StringBuilder str1 = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                str1.append((char) (str.charAt(i) - 'A' + 'a'));
            } else {
                str1.append((char) (str.charAt(i) - 'a' + 'A'));
            }
        }
        return str1.toString();
    }

    // difference of two consecutive characters
    public static String solution1(String str) {
        // write your code here
        StringBuilder str1 = new StringBuilder();
        str1.append(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            str1.append(str.charAt(i) - str.charAt(i - 1));
            str1.append(str.charAt(i));
        }
        return str1.toString();
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
         String str = scn.next();
        // solution(str);
        // System.out.println(countOfHiWithoutHit(str));
        // stringImmutableTest();
        // stringBuilderBasicFunction();
        // long start = System.currentTimeMillis();
        // stringMutableTest();
        // long finish = System.currentTimeMillis();
        // long timeElapsed = finish - start;
        // System.out.println(timeElapsed);
        removehiwithouthit(str);
    }

}