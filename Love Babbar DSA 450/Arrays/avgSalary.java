public class avgSalary{
    class Solution {
        // 1491. Average Salary Excluding the Minimum and Maximum Salary
    // tc O(n) sc O(1)
    //     just calculate the sum and track the min and max in one loop and
    //     then calculate the sum - min - max and divide it by length of the array - 2 
    //     that will be the answer.
        public double average(int[] salary) {
            double sum = 0,max=0,min=(int)1e6;
            for(int ele:salary){
                sum += ele;
                max = Math.max(max,ele);
                min = Math.min(min,ele);
            }
            return (sum-max-min)/(salary.length-2);
        }
    }
}