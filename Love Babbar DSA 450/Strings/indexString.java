public class indexString{
    
    // 28. Find the Index of the First Occurrence in a String

//     So brute force could be to find all substrings and then check 

    
//     optimised
    // tc O(n) sc O(1)
//     Two pointers approach will be used
//     that if the characters are matching so if all match then return the starting index
//     else return -1.
public int strStr(String haystack, String needle) {
    int i=0,j=0,n1=haystack.length(),n2=needle.length(),start;

    if(n1<n2){
        return -1;
    }
    
    for(i=0;i<n1-n2+1;i++){
        start = i;
        while(haystack.charAt(i) == needle.charAt(j)){
            if(i-start+1 == n2){
            return start;
            }
            i++;
            j++;
        }
        
        i = start;
        j=0;
    }
    return -1;
}
}