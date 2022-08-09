public class binaryTreeFactor{
    
    // 823. Binary Trees With Factors
//     tc O(n^2) sc O(n)
//     Caculating how many trees can be made from a particular number
//     storing the (root, no of possibilities) mapping in hashmap
//     If arr[i] is completely divisible by arr[j] as well as arr[i]/arr[j] exists in map i.e. it has been encountered before
//    then only we can say that arr[i] can be made by arr[j] * arr[i]/arr[j] 
//     then add the (map.get(arr[i]/arr[j])*map.get(arr[j])) in val to put in hashmap
//     also become the part of final answer all the possibilities by taking each and every element as root.
public int numFactoredBinaryTrees(int[] arr) {
    HashMap<Integer,Long> map = new HashMap<>();
    int n = arr.length, mod = (int)1e9+7;
    long val = 1,ans=0;
    Arrays.sort(arr);      //tc O(nlogn)
    for(int i=0;i<n;i++){  //tc O(n^2)
        val = 1;
        for(int j=0;j<i;j++){
            if(arr[i]%arr[j]==0 && map.containsKey(arr[i]/arr[j])){
                    val = val + (map.get(arr[i]/arr[j])*map.get(arr[j]));
            }
        }
        map.put(arr[i],val);
        ans = ans + val;
    }
    return (int)(ans%mod);
}
}