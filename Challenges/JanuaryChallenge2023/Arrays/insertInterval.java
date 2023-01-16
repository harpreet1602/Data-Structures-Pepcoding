public class insertInterval{
    class Solution {
        // 57. Insert Interval
    // tc O(n) sc O(n)
    //     Simple array question, manipulation of merging the intervals will be done
    //     just keep on adding the intervals which can't be merged
    //     Keep on changing the new interval array for merging purpose.
    //     if the start index of current interval is less than or equal to new interval end index
    //     then merging happens as min of both starting points as the start and max of both the ending points as the end.
        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<int[]> ans = new ArrayList<>();
            
            int i = 0, n = intervals.length;
    //         safe intervals before merging.
            while(i<n && intervals[i][1]<newInterval[0]){
                ans.add(intervals[i]);
                i++;
            }
            
    //         merging
            while(i<n && intervals[i][0]<=newInterval[1]){
                newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
                i++;
            }
            ans.add(newInterval);
            
    //         after merging the rest of the intervals left
            while(i<n){
                ans.add(intervals[i]);
                i++;
            }
            int m = ans.size(),j=0;
            int[][] res = new int[m][2];
            
            while(j<m){
                res[j] = ans.get(j);
                j++;
            }
            return res;
        }
    }
}