public class arrayHalf{
    
    // 1338. Reduce Array Size to The Half
//     tc O(nlogn) sc O(n)
//     Put the frequencies in hashmap and then put all the values in the arraylist and then sort in descending order
//     then check by deleting how many numbers from the list will make the array size less than or equal to half
public int minSetSize(int[] arr) {
    HashMap<Integer,Integer> map = new HashMap<>();
    for(int num:arr){
        map.put(num,map.getOrDefault(num,0)+1);
    }
    List<Integer> list = new ArrayList<>(map.values());
    Collections.sort(list,Collections.reverseOrder());
    int n= arr.length,size = n;
    int count = 0;
    while(size>n/2){
        size -= list.get(count);
        count++;
    }        
    return count;
}
}