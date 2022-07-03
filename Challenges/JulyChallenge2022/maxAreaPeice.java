import java.util.Arrays;

public class maxAreaPeice {

    // 1465. Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts
//     Brute => tc O(h*v) sc O(1) 
//     compare all the differences of the first array with the second array.
//    Doubtful => if this will be successfull or not. 
//  min and max will make problem.   
    
//     Optimized
    //     tc O(hlogh + vlogv) h => horizontalCuts.length, v=>verticalCuts.length
    // sc O(1)
// Sort both the arrays, get the consecutive differences from the array
//     Because this will give us the maximum width and maximum height to get maximum area.
//     Also consider the two explicit cases=>
//     1. horizontalCuts[0] - 0, verticalCuts[0] - 0
//     2. h-horizontalCuts[n-1], w-verticalCuts[m-1]
//  In the end convert these interger to long by multiplying with one long unit
//     Return it modulo 1e9+7 typecast into int.
    
public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
    Arrays.sort(horizontalCuts);
    Arrays.sort(verticalCuts);
    
    int diff1 = horizontalCuts[0], diff2 = verticalCuts[0], n = horizontalCuts.length, m = verticalCuts.length,mod=(int)1e9+7;
    
    for(int i=0;i<n-1;i++){
        diff1 = Math.max(diff1,horizontalCuts[i+1]-horizontalCuts[i]);
    }
    diff1 = Math.max(h-horizontalCuts[n-1],diff1);
    
    for(int i=0;i<m-1;i++){
        diff2 = Math.max(diff2,verticalCuts[i+1]-verticalCuts[i]);
    }
    diff2 = Math.max(w-verticalCuts[m-1],diff2);
    long conv = 1;
    long ans = conv*diff1 * diff2;
//         long ans = 1L*diff1 * diff2;
    return (int)(ans%mod);
}
}
