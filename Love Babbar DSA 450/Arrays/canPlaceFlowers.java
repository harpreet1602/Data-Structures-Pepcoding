public class canPlaceFlowers {
    class Solution {
        // 605. Can Place Flowers
    // tc O(n) sc O(1)
    //     just keep a check on the current ele and one previous and one next within limit of the array
    //     update n and array accordingly and in the end see if all the flowers can be potted or not.
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int len = flowerbed.length;
            for(int i=0;i<len;i++){
                if(flowerbed[i]==0){
                    int prev = i==0?0:flowerbed[i-1];
                    int next = i==len-1?0:flowerbed[i+1];
    
                    if(prev==0 && next==0){
                        n--;
                        flowerbed[i] = 1;
                    }
                }
        }
        return n<=0;
        }
    }
}
