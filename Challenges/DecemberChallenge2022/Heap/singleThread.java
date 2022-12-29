public class singleThread {
    
    // 1834. Single-Threaded CPU
// tc O(n^2 * logn) sc O(n)
//     We will store the process in this way 
public int[] getOrder(int[][] tasks) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
       if(a[2] == b[2]){
           return a[0] - b[0];
       }
       return a[2] - b[2]; 
    });
    int n = tasks.length;
//         (index,available time, processing time)
    int[][] allTasks = new int[n][3];
    for(int i=0;i<n;i++){
        allTasks[i][0] = i;
        allTasks[i][1] = tasks[i][0];
        allTasks[i][2] = tasks[i][1];
    }
//         Sort on the basis of available time => Accordingly it will be considered.
    Arrays.sort(allTasks,(a,b)->{
       return a[1]-b[1]; 
    });
    int i=0,idx=0,currTime=0;
    int[] res = new int[n];
   
//         Now here we will process the processes
    while(i<n){
//             Add all the processes in the pq which are available, currTime keeps track of the time till the current process will end.
        while(i<n && allTasks[i][1] <= currTime){
            pq.add(allTasks[i++]);
        }
//             for the first time, add the available time in the currtime
        if(pq.size() == 0){
            currTime = allTasks[i][1];
        }
//             Take out the tasks from the heap and process it.
//             Update the current Time with ending time of the task
        if(pq.size()!=0){
            int[] rarr = pq.remove();
            res[idx++] = rarr[0];
            currTime += rarr[2];
        }
    }        
//         There is a chance heap will not get empty even after traversing the n length
//         So process these tasks also one by one.
    while(pq.size()!=0){
        int[] rarr = pq.remove();
        res[idx++] = rarr[0];
    }
    return res;
}
}
