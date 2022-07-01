import java.util.Arrays;
public class maximiseUnitTruck{
    
    // 1710. Maximum Units on a Truck
//     tc O(nlogn) sc O(1)
//     Sort in descending order of the units because that is what we want to maximize , 
//     keep a check on the trucksize while maintaining ans.
//     if the total no. of boxes can be accomadated so add the noOfBoxes*unitOfBoxes
//     trucksize the boxes can be deducted
//     else
//     add the remaining trucksize*UnitOfBoxes of the boxtype where size is exceeding the trucksize and break;
//     Return the ans;
    
public int maximumUnits(int[][] boxTypes, int truckSize) {
    Arrays.sort(boxTypes,(a,b)->{
       return b[1]-a[1]; 
    });
    int ans=0;
    for(int[] box:boxTypes){
        if(box[0]<=truckSize){
            ans = ans + (box[0]*box[1]);
            truckSize -= box[0];
        }
        else{
            ans = ans + truckSize*box[1];
            break;
        }
    }
    return ans;
}
}