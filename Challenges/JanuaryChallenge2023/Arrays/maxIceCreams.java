package Challenges.JanuaryChallenge2023.Arrays;

public class maxIceCreams {
    
    // 1833. Maximum Ice Cream Bars
// tc O(nlogn + n)=> O(nlogn) sc O(1)
//     Sort the array and see how many starting icecreams can be bought.
    
public int maxIceCream(int[] costs, int coins) {
    Arrays.sort(costs);
    int n = costs.length, ans = 0;
    
    for(int i=0;i<n;i++){
        ans += costs[i];
        if(ans>coins){
            return i;
        }
    }
    return n;
}
}
