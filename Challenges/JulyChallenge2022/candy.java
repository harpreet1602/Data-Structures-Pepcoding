import java.util.Arrays;

public class candy {
    
    // 135. Candy
//     tc O(2*n)=>O(n) sc O(n)
//     Greedy algorithm
//     First put all the positions of candies as 1
//     Then do a left to right scan update the current value based on previous smaller value
//     Then do a right to left scan and update the previous value based on current smaller value and also previous candies are less than or equal to current candies.
//     Maintain a sum here only and return it.
public int candy(int[] ratings) {
    int n = ratings.length,prev,next,sum=0;
    int[] candies = new int[n];
    
    Arrays.fill(candies,1);
    
    for(int i=1;i<n;i++){
       if(ratings[i]>ratings[i-1]){
           candies[i] = candies[i-1] + 1;
       }
    }
    
    for(int i=n-1;i>0;i--){
       if(ratings[i-1]>ratings[i] && candies[i-1]<=candies[i]){
           candies[i-1] = candies[i] + 1;
       }
        sum += candies[i];
    }
    sum += candies[0];
    // for(int ele:candies){
    //     // System.out.println(ele);
    //     sum += ele;
    // }
    
    return sum;
}
}
