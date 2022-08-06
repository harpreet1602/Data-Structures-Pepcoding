public class poorPigs {
    // 458. Poor Pigs
//     tc O() sc O(1)
//     not fully understandable
//     not a good question to do.
public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
    if(buckets-- == 1){
        return 0;
    }
    int base = (minutesToTest/minutesToDie) + 1;
    int res = 0;
    while(buckets > 0){
        buckets = buckets / base;
        res += 1;
    }
    return res;
}
}
