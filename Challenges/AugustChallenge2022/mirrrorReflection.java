public class mirrrorReflection {
     // 858. Mirror Reflection
//     tc O(logn) sc O(1) I think
//     analyse the pattern to get the answer
//     laws of reflection => how to see?
//     if it is crossing the box make another box over it till it meets any receptor 
//     on meeting the receptor overlap with the previous boxes to know which receptor it is
//     we have to remove the common factor of 2 between both of them till the time atleast one of them becomes odd.
//     then analyse three cases corresponding to the receptors
//     1. p=3,q=2 |  p=6,q=4 =>0
//     2. p = 4, q=3 | p=2,q=1 => 2
//     3.p=1,q=1| p=3,q=1  => 1
public int mirrorReflection(int p, int q) {
    while(p%2 == 0 && q%2 == 0){
        p /= 2;
        q /= 2;
    }
    if(p%2!=0 && q%2==0){
        return 0;
    }
    if(p%2==0 && q%2!=0){
        return 2;
    }
    if(p%2!=0 && q%2!=0){
        return 1;
    }
    return -1;
}
}
