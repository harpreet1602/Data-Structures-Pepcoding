public class utf8 {
    
    // 393. UTF-8 Validation
//     tc O(n) sc O(1)
//     traverse on each number and think of each and every scenario
//     first of all first byte should be any one of the below conditions
//     then check on other bytes depending on the remaining bytes left according to the byte where remaining byte was 0 
//     because bytes next to them should have 10 binary in the start
//     
public boolean validUtf8(int[] data) {
    int rbytes = 0;
    for(int val:data){
        if(rbytes == 0){
            if((val>>7) == 0b0){
                rbytes = 0;
            }
            else if((val>>5) == 0b110){
                rbytes = 1;
            }
            else if((val>>4) == 0b1110){
                rbytes = 2;
            }
            else if((val>>3) == 0b11110){
                rbytes = 3;
            }
            else{
                return false;
            }
        }
        else{
            if((val>>6) == 0b10){
                rbytes--;
            }
            else{
                return false;
            }
        }
    }
    if(rbytes == 0){
        return true;
    }
    else{
        return false;
    }
}
}
