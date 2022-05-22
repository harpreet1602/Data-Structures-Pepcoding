
public class minMax {
    
    static class pair  
    {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
    } 

// https://practice.geeksforgeeks.org/problems/find-minimum-and-maximum-element-in-an-array4428/1/#
    // Brute force => sort the array then first ele is minimum and the last element is maximum.
    // tc O(nlogn) sc O(1)
    
    // Optimised
    // traverse the array and find the minimum and maximum in the loop of elements.
    // tc O(n) sc O(1)
    static pair getMinMax(long a[], long n)  
    {
        //Write your code here
        long min1 = (long)1e13 ,max1 = -(long)1e13; 
        for(int i=0;i<a.length;i++){
            if(a[i]<min1){
                min1 = a[i];
            }
            if(a[i]>max1){
                max1 = a[i];
            }
        }
        return new pair(min1,max1);
    }
}
