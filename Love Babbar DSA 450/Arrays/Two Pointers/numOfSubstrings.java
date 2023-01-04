public class numOfSubstrings{
    
    // 1358. Number of Substrings Containing All Three Characters

//     Brute force can be to find all the substrings and then check if every character a,b,c occurance is there in it or not

    // tc O(n) sc O(1)
//     Optimised
//     Two pointers approach => simple track of the window with start and end pointers
//     so kindly check with the end pointer add its frequency
//     if every character is present then add n-currindex into the count
//     till the time every character is present keep on adding n-currindex into the count and also increment the start pointer
//   decrease its frequency  
    
public int numberOfSubstrings(String s) {
    int n = s.length(), st = 0, en = 0, count=0;
    int[] freq = new int[3];
    while(en<n){
        char ch = s.charAt(en);
        
        freq[ch-'a']++;
        while(freq[0]>=1 && freq[1]>=1 && freq[2]>=1){
            count += n-en;
            char chst = s.charAt(st);
            freq[chst-'a']--;
            st++;
        }
        en++;
    }
    return count;
}

    

}