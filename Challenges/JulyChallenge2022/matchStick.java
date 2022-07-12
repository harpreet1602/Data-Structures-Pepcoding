public class matchStick{
    
    // 473. Matchsticks to Square
// tc O(4^n) sc O(4^n) recursive space I think
//     Backtracking
//     So here we have matchsticks length, with whom 4 sides of square must be constructed.
//     So handle the edge cases by finding the perimeter.
//     if perimeter is divisible by 4 then only proceed and make sides array with elements as side,side,side,side
//     now these will be backtracked with every possibility out there through backtrakcing template for loop for the matchsticks array and sides are decreased to some points if the base condition mets where all sides gets satisfied then it is a square otherwise it is not.
//     Sorting and reversing to avoid TLE for some edge case => think for it.
public boolean makesquare(int[] matchsticks) {
    if(matchsticks.length<4){
        return false;
    }
    int perimeter = 0;
    for(int ele:matchsticks){
        perimeter += ele;
    }
    if(perimeter%4!=0){
        return false;
    }
    int side = perimeter / 4;
    int[] sides = new int[]{side,side,side,side};
    
    Arrays.sort(matchsticks);
    reverse(matchsticks);
    
    return checkSquare(matchsticks,0,sides);
}
private void reverse(int[] arr){
    int low=0,high=arr.length-1;
    while(low<high){
        swap(arr,low,high);
        low++;
        high--;
    }
}
private void swap(int[] arr,int i,int j){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

private boolean checkSquare(int[] arr,int i,int[] sides){
    if(i == arr.length){
        return sides[0] == 0 &&sides[1] == 0 &&sides[2] == 0 &&sides[3] == 0; 
    }
    
    for(int j=0;j<4;j++){
        if(arr[i]>sides[j]) continue;
        sides[j] -= arr[i];
        if(checkSquare(arr,i+1,sides)) return true;
        sides[j] += arr[i];
    }
    
    return false;
}

}