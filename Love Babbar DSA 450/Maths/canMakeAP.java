package Maths;

public class canMakeAP {
    class Solution {
        // 1502. Can Make Arithmetic Progression From Sequence
        //     tc O(nlogn) sc O(1)
        //     Sort the array because reordering gives us the hint that AP can only be formed while sorting in ascending or descending order
        //     after that we can check the difference of the terms
        //     a,b,c
        //     First formula b-a = c-b
        //     second formula 2*b = a+c
            public boolean canMakeArithmeticProgression1(int[] arr) {
                Arrays.sort(arr);
                
                int n = arr.length, diff = arr[1] - arr[0];
                for(int i=2;i<n;i++){
                    if(arr[i]-arr[i-1]!=diff){
                        return false;
                    }
                }
                return true;
            }
            public boolean canMakeArithmeticProgression(int[] arr) {
                Arrays.sort(arr);
                int n = arr.length;
                
                for(int i=1;i<n-1;i++){
                    if(2*arr[i]!=arr[i-1]+arr[i+1]){
                        return false;
                    }
                }
                return true;
            }
        }
}
