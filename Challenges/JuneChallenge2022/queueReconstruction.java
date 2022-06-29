import java.util.Arrays;
import java.util.ArrayList;
public class queueReconstruction{
    
    // 406. Queue Reconstruction by Height
//     tc O(nlogn) sc O(1)
//  person with a particular height will be at the current place and before that person[1] number of people greater or equal must be there.
//     So to acheive this purpose, we will sort the people array on the basis of decreasing height (descending order of height) and in the case of same height preceedance will be given to the person with less k (ascending order of k)
//     After this arraylist of int[] will be made where the person array will be inserted at person[1] place so that person[1] people greater than or equal to it will be before it as they have got the chance to be added earlier.
public int[][] reconstructQueue(int[][] people) {
    Arrays.sort(people,(a,b)->{
        if(a[0] == b[0]){
            return a[1]-b[1];
        }
        else{
            return b[0]-a[0];
        }
    });
    ArrayList<int[]> list = new ArrayList<>();
    for(int[] person:people){
        list.add(person[1],person);
    }
    return list.toArray(new int[list.size()][2]);
}
}