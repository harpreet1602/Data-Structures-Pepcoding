import java.util.Arrays;
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

    public static void main(String[] args){

    }
}
