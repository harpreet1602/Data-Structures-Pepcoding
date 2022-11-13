public class reverseWord {
    
    // 151. Reverse Words in a String
    // ṭc O(n) sc O(n)
    // Getting the word from the character array and then inserting it always in the start of the stringbuilder
    // THen triming the unecessary space that is getting added in the last 
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int i=0,n = s.length();
        char[] arr = s.toCharArray();
        while(i<n){
            while(i<n && arr[i]==' '){
                i++;
            }
            StringBuilder small = new StringBuilder();
            while(i<n && arr[i]!=' '){
                small.append(arr[i]);
                i++;
            }
            sb.insert(0," "+small);
        }
        return sb.toString().trim();
    }
}
