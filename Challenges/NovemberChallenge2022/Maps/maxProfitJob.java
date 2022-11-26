package Maps;

public class maxProfitJob {
    
    // 1235. Maximum Profit in Job Scheduling
// ṭc O(nlogn) sc O(n) I think
// storing starttime,endtime,profit as a job in a arraylist which is sorted on the basis of endtime
// Why? because it will help us build the algorithm
// Treemap stores time,max profit till now 
// Accordingly we traverse through the jobs and check for the floor entry from the start time
// to have maximum previous time available and prev max profit
// now check max of ans, or prevprofit + curr profit
// adding the endtime, ans in the map.
private class Job{
    int startTime;
    int endTime;
    int profit;

    public Job(int startTime,int endTime,int profit){
        this.startTime = startTime;
        this.endTime = endTime;
        this.profit = profit;
    }
}
public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
    List<Job> jobs = new ArrayList<>();
    int n = startTime.length;
    // time,max profit till now 
    TreeMap<Integer,Integer> map = new TreeMap<>();
    for(int i=0;i<n;i++){
        jobs.add(new Job(startTime[i],endTime[i],profit[i]));
    }

    Collections.sort(jobs, (a,b)->{
        return a.endTime - b.endTime;
    });

    int ans = 0;

    for(Job job:jobs){
        Integer entryTillStartTime = map.floorKey(job.startTime);
        int maxProfitTillStartTime = entryTillStartTime == null?0:map.get(entryTillStartTime);
        ans = Math.max(ans,maxProfitTillStartTime + job.profit);
        map.put(job.endTime,ans);
    }
    return ans;
}
}
