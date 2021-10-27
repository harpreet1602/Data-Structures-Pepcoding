import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
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
    public static void main(String[] args){

    }
}
