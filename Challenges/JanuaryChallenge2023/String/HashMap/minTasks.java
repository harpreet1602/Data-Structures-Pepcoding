package Challenges.JanuaryChallenge2023.String.HashMap;

public class minTasks {
    // 2244. Minimum Rounds to Complete All Tasks
// tc O(n) sc O(n)
//     HashMap is used to store the each difficulty level's count
//     Then according to the dry run we need to figure out that how can we optimally divide the frequency with the help of 3 and 2
//     So for this purpose what we can do is first of all get the freq
//     then divide it by 3 and store it in val.
//     calculate the remaining frequency as freq - (val* 3)
//     then till the time remaining frequency is not divisible by 2 keep on decreasing the val
//     and remaining frequency as freq - (val*3)
//     when we will come out of this thing add val into the ans and remainingfreq/2 into the answer.
public int minimumRounds1(int[] tasks) {
    HashMap<Integer,Integer> map = new HashMap<>();
    int n = tasks.length,ans=0;
    
    for(int i=0;i<n;i++){
        map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
    }
    
    for(Integer key:map.keySet()){
        int freq = map.get(key);
        if(freq == 1){
            return -1;
        }
        int val = freq/3;
        int remFreq = freq-(val*3);
        while(remFreq%2!=0){
            val--;
            remFreq = freq-(val*3);
        }
        ans += val;
        ans += (remFreq/2);
    }
    return ans;
}
//     TC O(n) SC O(n)
//     Here we are using the direct formula in three cases
//     Natural number can be of three forms 3p, 3p+1, 3p+2
//     when the frequency is divisible by 3 ans is freq/3
//    when the freq is of 3p+1 like 4,7,10,13 => then distribution of 13 is like 3*3 + 2*2 so it is nothing but freq/3 + 1
//    when the freq is of 3p+2 like 5,8,11,14 => then distribution of 14 is like 3*4 + 2*1 so it is nothing but freq/3 + 1

public int minimumRounds(int[] tasks) {
    HashMap<Integer,Integer> map = new HashMap<>();
    int n = tasks.length,ans=0;
    
    for(int i=0;i<n;i++){
        map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
    }
    
    for(Integer key:map.keySet()){
        int freq = map.get(key);
        if(freq == 1){
            return -1;
        }
        ans += freq/3;
        
        if(freq%3!=0) {
            ans+=1;
        }
    }
    return ans;
}
}
