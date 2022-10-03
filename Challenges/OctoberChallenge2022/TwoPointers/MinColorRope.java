public class MinColorRope{   
    // 1578. Minimum Time to Make Rope Colorful
//     tc O(n) sc O(1)
//     Applying here two pointers to get the sum and max element of a group where characters are equal and in that segment we have to delete all the characters which take less time
   // that is why groupTotal-maxEle will give us the required less time to delete 
//     duplicate characters which are coming together.
//     Cummulative answer of all these segments will compile the whole answer.
public int minCost(String colors, int[] neededTime) {
    int start = 0, end = 0, totalAns=0, n = neededTime.length;
    
    while(start<n){
        int maxEle = 0;
        int groupTotal = 0;
        while(end<n && colors.charAt(start) == colors.charAt(end)){
            maxEle = Math.max(maxEle,neededTime[end]);
            groupTotal += neededTime[end];
            end++;
        }
        totalAns += (groupTotal-maxEle);
        start = end;
    }
    return totalAns;
}
}