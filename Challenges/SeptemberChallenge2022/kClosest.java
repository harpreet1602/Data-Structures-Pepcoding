import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class kClosest{
        // 658. Find K Closest Elements
//     tc O(nlogn) sc O(n)
//     Brute force => think of a data structure which can store the data in such a way
//     that we can remove on basis of maximum difference and then maximum element
//     So we will use MaxHeap 
//     Accordingly, add and then delete when the size overgoes k remove
//     and then sort the elements of the list.
public List<Integer> findClosestElements(int[] arr, int k, int x) {
    PriorityQueue<int[]> pq =new PriorityQueue<>((a,b)->{
        if(a[0] == b[0]){
            return a[1]-b[1];
        }
        return a[0]-b[0];
    });
    
    List<Integer> list = new ArrayList<>();
    for(int i=0;i<arr.length;i++){
        pq.add(new int[]{Math.abs(arr[i]-x),arr[i]});    
    }
    while(pq.size()!=0)
    {
        if(list.size()==k){
            break;
        }
        list.add(pq.remove()[1]);
    }
    Collections.sort(list);
    return list;
}
  public List<Integer> findClosestElements12(int[] arr, int k, int x) {
    PriorityQueue<int[]> pq =new PriorityQueue<>((a,b)->{
        if(a[0] == b[0]){
            return b[1]-a[1];
        }
        return b[0]-a[0];
    });
    
    List<Integer> list = new ArrayList<>();
    for(int i=0;i<arr.length;i++){
        pq.add(new int[]{Math.abs(arr[i]-x),arr[i]});    
        if(pq.size()>k){
            pq.remove();
        }
    }
    while(pq.size()!=0)
    {
        list.add(pq.remove()[1]);
    }
    Collections.sort(list);
    return list;
}

// 658. Find K Closest Elements
//     tc O(n) sc O(1)
//     We will use normal two pointers algorithm here to find the start and end indices 
//     Binary search just to find the preferred location.
//     Edge cases for the beginning and ending indexes 
//     and then si and ei properly where our k closest elements lie.
public List<Integer> findClosestElements1(int[] arr, int k, int x) {
    int n = arr.length;
    List<Integer> ans = new ArrayList<>();
//         O(n)
    if(x<arr[0]){
        for(int i=0;i<k;i++){
            ans.add(arr[i]);        
        }
    }
//         O(n)
    else if(x>arr[n-1]){
        for(int i=n-k;i<n;i++){
            ans.add(arr[i]);        
        }
    }
//         O(n)
    else{
//             O(logn)
        int idx = preferedLocation(arr,x);
        int si = Math.max(0,idx-k);
        int ei = Math.min(n-1,idx+k);
//             O(n)
        while(ei-si+1>k){
            if(Math.abs(arr[si]-x) <= Math.abs(arr[ei]-x)){
                ei--;
            }
            else{
                si++;
            }
        }
        for(int i=si;i<=ei;i++){
            ans.add(arr[i]);
        }
    }
    return ans;
}
//     O(logn)
private int preferedLocation(int[] arr,int x){
    int low = 0, high =arr.length-1,mid;
    while(low<high){
        mid = (low+high)/2;
        if(arr[mid] == x) return mid;
        else if(x<arr[mid])  high = mid;
        else low = mid+1;
    }
    return low;
}
}