public class flipString {
    
    // 926. Flip String to Monotone Increasing
// tc O(n) sc O(1)
//     This is solution where the simple intuition is to calculate the minimum number of flips needed till current state.
//     so we will keep on incresing the flip on seeing 0 and oneCount on seeing one
//     But in the end at the current state, we take the minimum of both in the flip variable
//     In the end return flip because it stores minimum number of flips needed to make the string monotone increasing.
public int minFlipsMonoIncr(String s) {
    int n = s.length(), i = 0, flip=0, oneCount=0;
    
    while(i<n && s.charAt(i) == '0'){
        i++;
    }
    
    for(;i<n;i++){
        char ch = s.charAt(i);
        if(ch == '0'){
            flip++;
        }
        else{
            oneCount++;
        }
        flip = Math.min(flip,oneCount);
    }
    
    return flip;
}
}
