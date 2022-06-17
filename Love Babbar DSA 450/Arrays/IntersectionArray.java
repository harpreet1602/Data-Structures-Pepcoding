public class IntersectionArray {
    
//     349. Intersection of Two Arrays
//     tc O(n+m+duplicates)=>O(n+m) sc O(n+duplicates)=> O(n)
//     maintain two hashsets one for storing all the elements of first array
//     go in second array and look for the duplicates there and put it in the other set so that duplicates are added one time only.
//     After that take out the elements from the set and put it in the array.
    
public int[] intersection(int[] nums1, int[] nums2) {
    HashSet<Integer> set = new HashSet<>();
    HashSet<Integer> tempSet = new HashSet<>();
    int n = nums1.length, m = nums2.length,count=0,start=0;
    
    for(int i=0;i<n;i++){
        set.add(nums1[i]);
    }
    
    for(int i=0;i<m;i++){
        if(set.contains(nums2[i])){
            tempSet.add(nums2[i]);
        }
    }
    int[] temp = new int[tempSet.size()];
    
    for(Integer key:tempSet){
        temp[start++] = key;
    }
    return temp;
}
}
