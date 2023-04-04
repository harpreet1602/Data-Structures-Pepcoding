public class boatsSave {
    class Solution {    
        // 881. Boats to Save People
    // ṭc O(nlogn + n/2) => O(nlogn) sc O(1)
    //     Sort the array and apply the two pointers approach and 
    //     in that consider the sum of the lightest and heaviest otherwise heaviest person in the boat
        public int numRescueBoats(int[] people, int limit) {
            Arrays.sort(people);
            
            int low = 0, high = people.length-1, boats=0;
            while(low<high){
                int sum = people[low] + people[high];
                if(sum <= limit){
                    low++;
                    high--;
                }
                else {
                    high--;
                }
            
                boats++;
            }
            return low == high ? boats+1:boats;
        }
    }
}
