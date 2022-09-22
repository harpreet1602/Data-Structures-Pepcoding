public class reverseWord{
    
    // 557. Reverse Words in a String III
//     tc O(n+n)=>O(n) sc O(1)
//     Two pointer approach for reversing the characters of a string when we find a space or the string ends.
//   Keep lastSpaceIdx to store the last space character seen and when we 
//     encounter space in strIdx then we can quickly set the startIdx = lastSpaceIdx+1
//    and lastIdx = strIdx-1 and we can reverse the characters in between start and end.
//     In the end return the string of all the characters 
public String reverseWords(String s) {
    char[] chArr = s.toCharArray();
    int lastSpaceIdx = -1,n=s.length(),startIdx,lastIdx;
    for(int strIdx = 0;strIdx<=n;strIdx++){
        if(strIdx == n || chArr[strIdx] == ' '){
            startIdx = lastSpaceIdx + 1;
            lastIdx = strIdx - 1;
            while(startIdx<lastIdx){
                char temp = chArr[startIdx];
                chArr[startIdx] = chArr[lastIdx];
                chArr[lastIdx] = temp;
                startIdx++;
                lastIdx--;
            }
            lastSpaceIdx = strIdx;
        }
    }
    return new String(chArr);
}
}