import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
public class l001{

    public int binarySearch(int[] arr,int si,int ei,int data){
        while(si<=ei){
            int mid = (si + ei)/2;
            if(arr[mid] == data){
                return mid;
            }
            else if(data>arr[mid]){
                si = mid+1;
            }
            else{
                ei = mid-1;  
            }

        }
        return -1;
    }

    public int firstIndex(int[] arr,int data){
        int si = 0, ei = arr.length-1;
        while(si<=ei){
            int mid = (si+ei)/2;
            if(arr[mid]==data){
                if(mid-1>=0 && arr[mid-1]==data){
                    ei = mid-1;
                }else{
                    return mid;
                }
            }
            else if(data<arr[mid]){
                ei = mid-1;
            }
            else{
                si = mid+1;
            }
        }
        return -1;
    }
    
    public int lastIndex(int[] arr,int data){
        int si = 0, ei = arr.length-1;
        while(si<=ei){
            int mid = (si+ei)/2;
            if(arr[mid]==data){
                if(mid+1<arr.length && arr[mid+1]==data){
                    si = mid+1;
                }else{
                    return mid;
                }
            }
            else if(data<arr[mid]){
                ei = mid-1;
            }
            else{
                si = mid+1;
            }
        }
        return -1;
    }
    // 34. Find First and Last Position of Element in Sorted Array
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0) return new int[]{-1,-1};
        return new int[]{firstIndex(nums, target),lastIndex(nums, target)};
    }

    public int closestElement(int[] arr,int data){
        int si = 0, ei = arr.length-1;
        if(data<=arr[si]){
            return si;
        }
        if(data>=arr[ei]){
            return ei;
        }
        while(si<=ei){
            int mid = (si + ei)/2;
            if(arr[mid] == data){
                return mid;
            }
            else if(data>arr[mid]){
                si = mid+1;
            }
            else{
                ei = mid-1;  
            }
        }
        return data-arr[ei]<=arr[si]-data?ei:si;
    }
    public int preferedLocation(int[] arr,int data){
        int si = 0, ei = arr.length-1;
        while(si<ei){
            int mid = (si + ei)/2;
            
            if(data>=arr[mid]){
                si = mid+1;
            }
            else{
                ei = mid;  
            }

        }
        return si;
    }

    // https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1#
     // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long totalInversion(long[] arr,long[] sortedArray,int si,int mid, int ei){
        int i = si, j = mid+1, k = si;
        long count=0;
        while(i<=mid && j<=ei){
            if(arr[i] <= arr[j]){
                sortedArray[k++] = arr[i++];
            }
            else{
                sortedArray[k++] = arr[j++];
                count+=mid-i+1;
            }
        }
        while(i<=mid || j<=ei){
            sortedArray[k++] = i<=mid?arr[i++]:arr[j++];
        }
        while(si<=ei){
            arr[si] = sortedArray[si++];
        }
        return count;
    }
    
    static long inversionCount(long[] arr,long[] sortedArray,int si,int ei){
        if(si>=ei){
            return 0;
        }
        int mid = (si+ei)/2;
        long count=0;
        count+=inversionCount(arr,sortedArray,si,mid);
        count+=inversionCount(arr,sortedArray,mid+1,ei);
        
        count += totalInversion(arr,sortedArray,si,mid,ei);
        
        return count;
    }
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        if(N==0){
            return 0;
        }
        long[] sortedArray = new long[(int)N];
        return inversionCount(arr,sortedArray,0,(int)N-1);
    }

    // 658. Find K Closest Elements
    
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        List<Integer> list = new ArrayList<>();
        if(x<arr[0]){
            for(int i=0;i<k;i++){
                list.add(arr[i]);
            }
        }
        else if(x>arr[n-1]){
            for(int i=n-k;i<n;i++){
                list.add(arr[i]);
            }
        }
        else{
            int idx = preferedLocation(arr,x);
            int si = Math.max(0,idx-k);
            int ei = Math.min(n-1,idx+k);
            while(ei-si+1>k){
                if(x-arr[si] <= arr[ei]-x){
                    ei--;
                }
                else{
                    si++;
                }
            }
            for(int i=si;i<=ei;i++){
                list.add(arr[i]);
            }
        }
        return list;
    }

    // 1. Two Sum
    // brute -> tc O(n^2) sc O(1)
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++)
            {
                int sum = nums[i]+nums[j];
                if(sum == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
    // optimized => tc O(n) sc O(n)
    public int[] twoSum1(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }else{
                map.put(nums[i],i);
            }
        }
        return new int[]{-1,-1};
    }
    // https://practice.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1
    boolean hasArrayTwoCandidates(int nums[], int n, int target) {
        // code here
         HashSet<Integer> map = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(map.contains(target-nums[i])){
                return true;
            }else{
                map.add(nums[i]);
            }
        }
        return false;
    }
    // https://practice.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1#
    int getPairsCount(int[] nums, int n, int target) {
        // code here
         HashMap<Integer,Integer> map = new HashMap<>();
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                count+=map.get(target-nums[i]);
            }
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        return count;
    }
    // 167. Two Sum II - Input Array Is Sorted
    // optimized -> tc O(log n) sc O(1)
    public int[] twoSum2(int[] nums, int target) {
        int si = 0, ei = nums.length-1;
      while(si<ei){
          int currsum = nums[si] + nums[ei];
          
          if(currsum == target){
              return new int[]{si+1,ei+1};
          }else if(currsum<target){
              si++;
          }
          else{
              ei--;
          }
      }
      return new int[]{-1,-1};
  }

//   15. 3Sum
  List<List<Integer>> allPairs(int[] nums,int target,int si, int ei){
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    // int si = 0, ei = nums.length-1;
    while(si<ei){
        int currsum = nums[si] + nums[ei];
        if(currsum == target){
            List<Integer> smallAns = new ArrayList<>();
            smallAns.add(nums[si]);
            smallAns.add(nums[ei]);
            list.add(smallAns);
            // int first = nums[si];
            // int second = nums[ei];
            // while(si<ei && nums[si] == first) si++;
            // while(si<ei && nums[ei] == second) ei--;
            // list.add(Arrays.asList(new Integer[]{nums[si],nums[ei]}));
            si++;
            ei--;
            while(si<ei && nums[si] == nums[si-1]) si++;
            while(si<ei && nums[ei] == nums[ei+1]) ei--;
        }
        else if(currsum<target){
            si++;
        }
        else{
            ei--;
        }
    }
    return list;
}
public void makeAns(List<List<Integer>> list,List<List<Integer>> small,int fix){
    for(int i=0;i<small.size();i++){
        List<Integer> sm = small.get(i);
        System.out.println(sm);
        sm.add(fix);
        list.add(sm);
    }
    
}
public List<List<Integer>> threeSum(int[] nums,int target,int si,int ei)
{
    Arrays.sort(nums);
    List<List<Integer>> list = new ArrayList<>();
    int n = nums.length;
    for(int i=si;i<ei-1;){
        int fix = nums[i];
        List<List<Integer>> twoSumList = new ArrayList<>();
        twoSumList =  allPairs(nums,target-fix,i+1, ei);
        
        makeAns(list,twoSumList,fix);
        i++;
        while(i<ei-1 && nums[i]==nums[i-1]) i++;
    }
    return list;
}
public List<List<Integer>> threeSum(int[] nums) {
    return threeSum(nums,0,0,nums.length-1);
}

// 18. 4Sum
public List<List<Integer>> fourSum(int[] nums,int target,int si,int ei)
{
    Arrays.sort(nums);
    List<List<Integer>> list = new ArrayList<>();
    int n = nums.length;
    for(int i=si;i<ei-2;){
        int fix = nums[i];
        // List<List<Integer>> threeSumList = new ArrayList<>();
        List<List<Integer>> threeSumList =  threeSum(nums,target-fix,i+1, ei);
        
        makeAns(list,threeSumList,fix);
        i++;
        while(i<ei-1 && nums[i]==nums[i-1]) i++;
    }
    return list;
}
    public List<List<Integer>> fourSum(int[] nums, int target) {
         return fourSum(nums,target,0,nums.length-1);
    }
    
public List<List<Integer>> kSum(int[] nums,int target,int k,int si,int ei)
{
    if(k==2){
        return allPairs(nums, target, si, ei);
    }
    List<List<Integer>> list = new ArrayList<>();
    int n = nums.length;
    for(int i=si;i<ei;){
        int fix = nums[i];
        // List<List<Integer>> threeSumList = new ArrayList<>();
        List<List<Integer>> SumList =  kSum(nums,target-fix,k-1,i+1, ei);
        
        makeAns(list,SumList,fix);
        i++;
        while(i<ei-1 && nums[i]==nums[i-1]) i++;
    }
    return list;
}

    public int countTwoSum(int[] arr1,int[] arr2, int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        int count=0;
        for(int i=0;i<arr1.length;i++){
            map.put(arr1[i],map.getOrDefault(arr1[i],0)+1);
        }
        for(int i=0;i<arr2.length;i++){
            int newtarget = target - arr2[i];
            if(map.containsKey(newtarget)){
                count+=map.get(newtarget);
            }
        }
        return count;
    }
    // 454. 4Sum II
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int e:nums1){
            for(int f:nums2){
                map.put(e+f,map.getOrDefault(e+f,0)+1);
            }
        }
        int count=0;
        for(int e:nums3){
            for(int f:nums4){
                if(map.containsKey(0-(e+f)))
                count+=map.get(0-(e+f));           
            }
        }
        return count;
    }

    // 33. Search in Rotated Sorted Array
    public int search(int[] nums, int target) {
        int si = 0;
        int ei = nums.length-1;
        while(si<=ei){
            int mid = (si+ei)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[si] <= nums[mid]){
                if(target>=nums[si] && target<=nums[mid]){
                    ei = mid-1;
                }
                else{
                    si = mid+1;
                }
            }
            else{
                if(target>=nums[mid] && target<=nums[ei]){
                    si = mid+1;
                }
                else{
                    ei = mid-1;
                }
            }
        }
        return -1;
    }
    // 81. Search in Rotated Sorted Array II
    public boolean search1(int[] nums, int target) {
        int si = 0,ei = nums.length-1;
        while(si<=ei){
            int mid = (si+ei)/2;
            if(nums[mid] == target || nums[si] == target){
                return true;
            }
            if(nums[si] < nums[mid]){
                if(target>nums[si] && target<nums[mid]){
                    ei = mid-1;
                }
                else{
                    si = mid+1;
                }
            }
            else if(nums[mid] < nums[ei]){
                if(target>nums[mid] && target<=nums[ei]){
                    si = mid+1;
                }
                else{
                    ei = mid-1;
                }
            }
            else{
                si++;
            }
        }
        return false;
    }

    // 153. Find Minimum in Rotated Sorted Array
    public int findMin(int[] nums) {
        int si = 0, ei = nums.length - 1;
        while(si<ei){
            int mid = (si + ei)/2;
            if(nums[mid] < nums[ei]){
                ei = mid;
            }else{
                si = mid+1;
            }
        }
        return nums[si];
    }
    // 154. Find Minimum in Rotated Sorted Array II
    public int findMin1(int[] nums) {
        int si = 0, ei = nums.length - 1;
       while(si<ei){
           int mid = (si + ei)/2;
           if(nums[mid] < nums[ei]){
               ei = mid;
           }else if(nums[mid]>nums[ei]){
               si = mid+1;
           }
           else{
               ei--;
           }
       }
       return nums[si];
   }
    //    875. Koko Eating Bananas
    public boolean isPossible(int[] piles,int h,int mid){
        int totalhours = 0;
        for(int e:piles){
            int time = e/mid;
            if(e%mid!=0){
                time++;
            }
            totalhours +=time;
        }
        if(totalhours>h) return false;
        return true;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int si = 1, ei = (int)1e9;
        while(si<ei){
            int mid = (si+ei)/2;
            if(!isPossible(piles,h,mid)){
                si = mid+1;
            }
            else{
                ei = mid;
            }
        }
        return si;
    }

    // one more thing we can do here is to make our ei the max val present in piles 
    public int minEatingSpeed1(int[] piles, int h) {
        int si = 1, ei;
        int max = -(int)1e9;
        for(int e:piles){
            max = Math.max(max,e);
        }
        ei = max;
        while(si<ei){
            int mid = (si+ei)/2;
            if(!isPossible(piles,h,mid)){
                si = mid+1;
            }
            else{
                ei = mid;
            }
        }
        return si;
    }
    
    // 1011. Capacity To Ship Packages Within D Days
    public boolean possible(int[] weights,int days,int capacity){
        int totaldays = 0;
        int sum = 0;
        for(int e:weights){
            sum+=e;
            if(e>capacity) return false;
            if(sum>capacity){
                totaldays++;
                sum = e;
            }
        }
        if(totaldays>days) return false;
        totaldays++;
        return totaldays<=days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int si =1,ei=0;
        for(int e:weights){
            ei+=e;
        }
        while(si<ei){
            int mid = (si+ei)/2;
            if(!possible(weights,days,mid)){
                si = mid+1;
            }
            else{
                ei = mid;
            }
        }
        return si;
    }

    // 4. Median of Two Sorted Arrays
    // O(n+m)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[] arr = new int[n+m];
        int i=0,j=0,k=0,size = arr.length;
        while(i<n && j<m){
            if(nums1[i]<=nums2[j]){
                arr[k++] = nums1[i++];
            }
            else{
                arr[k++] = nums2[j++];
            }
        }
        while(i<n){
                arr[k++] = nums1[i++];
        }
        while(j<m){
                arr[k++] = nums2[j++];
        }
    
        if(size%2!=0){
            return arr[size/2];
        }
        return (double)(arr[(size-1)/2] + arr[size/2] )/2;
    }
// O(log(min(n,m)))

// pending
// 2064
// pending





    public static void main(String[] args){

    }
}
