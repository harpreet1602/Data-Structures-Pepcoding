public class divideIntegers{
    
    // 29. Divide Two Integers
//     tc O(log^2(d/n)) sc O(1)
//     how to calculate the time of  this recursion => will be done later.
   
//     Handle all the edge cases here, do all the computation in long so that max and min thing can be done.
//     have a neg variable for negative edge case and convert it to absolute for normal solution.
public int divide(int dividend, int divisor) {
    long count = 1;
    boolean neg = false;
//         if one is +ve and other is -ve so ans is -ve
//         otherwise positive.
    if((dividend<0 && divisor>0) || (dividend>0 && divisor<0)){
        neg = true;
    }
    
    long ldividend = Math.abs((long)dividend);
    long ldivisor = Math.abs((long)divisor);
    
    if(ldivisor == 0 || (ldividend<ldivisor)){
        return 0;
    }
    
    count = longDivide(ldividend,ldivisor);
    
    if(count>Integer.MAX_VALUE){
        if(neg){
            return Integer.MIN_VALUE;
        }
        else{
            return Integer.MAX_VALUE;
        }
    }
    else{
        if(neg){
            return -(int)count;
        }
        else{
            return (int)count;
        }
    }
    
    
}

//     Basic logic to go by doubling up the number till we get a number's double less than dividend 
//     and add it and again call for dividend-sum as ldividend recursively till we get the answer
//     Dry run to understand it. It is binary search kind of thing as we are doubling the quotient in each step.
//     log n steps will required log n steps ahead => O(log^2 (n)) {maybe not sure}


private long longDivide(long ldividend, long ldivisor){
    if(ldividend<ldivisor){
        return 0;
    }
    long count=1;
    long sum = ldivisor;
    
    while((sum+sum)<=ldividend){
        sum = sum + sum;
        count = count+count;
    }

    return count + longDivide(ldividend-sum,ldivisor);
}
}