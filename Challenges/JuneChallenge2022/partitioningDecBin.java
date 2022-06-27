public class partitioningDecBin {
    // 1689. Partitioning Into Minimum Number Of Deci-Binary Numbers
//     tc O(len(n)) sc O(1)
//     suppose 32 => 11
//             21 => 11
//             10 => 10 
//              0
//     In total 3 numbers are needed to make this number completely 0
//     which is the maximum of the digits present in the string.
//     Remember for 32 two digit number, the max no. which could be considered is 11
//     Similarly for all the numbers this logic applies and the number of steps required in reducing the maximum digit of the string to 0 is the answer i.e. minimum no. of deci binary numbers to make n.
public int minPartitions(String n) {
    int max = 0;
    for(char c:n.toCharArray()){
        max = Math.max(max,c-'0');
    }
    return max;
}
}
