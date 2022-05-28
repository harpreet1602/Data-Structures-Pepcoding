
public class numberSteps0 {
    
    // 1342. Number of Steps to Reduce a Number to Zero
// tc O(number of steps) sc O(1)
//      do whatever was asked in the question and apply the simple conditions.
public int numberOfSteps1(int num) {
    int count = 0;
    while(num!=0){
        if(num%2==0){
            num = num/2;
        }
        else{
            num = num - 1;
        }
        count++;
    }
    return count;
}

// tc O(number of steps) sc O(number of steps)=> recursive space.
public int numberOfSteps(int num) {
    if(num==0){
        return 0;
    }
//         add 1 for the current step and go for the next computation.
    return 1 + (num%2==0?numberOfSteps(num/2):numberOfSteps(num-1));
}
}
