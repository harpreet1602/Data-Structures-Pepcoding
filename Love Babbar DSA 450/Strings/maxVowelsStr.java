public class maxVowelsStr {
    
//     1456. Maximum Number of Vowels in a Substring of Given Length
// tc O(n) sc O(1)
//     sliding window technique will be used 
//     do the dry run and accordingly apply the logic
// here like si and  ei will be used to maintain the window and accordingly the maxcount can be tracked
public int maxVowels1(String s, int k) {
    int si = 0, ei = 0, n = s.length(), len = 0, maxCount = 0, count=0;
    
    while(ei<n){
        boolean iseVowel = checkVowel(s.charAt(ei));
        if(iseVowel){
            count++;
        }
        if(ei-si==k){
            boolean issVowel = checkVowel(s.charAt(si));
            if(issVowel){
                count--;
            }
            si++;
        }
        ei++;
        maxCount = Math.max(maxCount,count);
    }
    return maxCount;
}

private boolean checkVowel(char ch){
    return ch == 'a' || ch == 'e' || ch == 'i' || ch=='o' || ch == 'u';
}

//     Easier 
// tc O(n) sc O(1)
//     
public int maxVowels(String s, int k) {
    Set<Character> set = Set.of('a','e','i','o','u');
    
    int n = s.length(), answer = 0, count = 0;
//         first of all build the window initially
    for(int i=0;i<k;i++){
        count += set.contains(s.charAt(i))?1:0;
    }
    
    answer = count;
//         now just move the window and update the maxcount of vowels.
//         ei will be at i and si will be at i-k
    for(int i=k;i<n;i++){
        count += set.contains(s.charAt(i))?1:0;
        count -= set.contains(s.charAt(i-k))?1:0;
        answer = Math.max(answer,count);
    }
    return answer;
}

}
