import java.util.PriorityQueue;
import java.util.Arrays;

public class courseSchedule3{
    
    // 630. Course Schedule III
//     tc O(nlogn) sc O(n)
//     Greedy.
//     First of all sort in the ascending order of the deadline of the courses
//     because the smaller deadline will be considered first for seeing whether the course can be completed in the deadline or not.
//     After that we have to use the priority queue for course duration
//     Whatever course has less duration we will consider that in the case when the course deadline condition is not getting satisfied
//     If the course is larger also and also cannot be completed within deadline, reject that simply.
//     timeelapsed variable will usefull for checking the capacity of the courses duration we have reached so far which helps in checking whether the new course will be completed within the deadline or not
//     in the end size of priority queue will be the no. of courses completed optimally.
public int scheduleCourse(int[][] courses) {
    Arrays.sort(courses,(a,b)->{
       return a[1]-b[1]; 
    }); //nlogn time
//         for course duration
    PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
       return b-a; 
    });
    int timeElapsed = 0;
    // nlogn
    for(int[] course:courses){ //n
        if(timeElapsed + course[0]<=course[1]){
            pq.add(course[0]); //logn
            timeElapsed += course[0];
        }
        else if(pq.size()!=0 && pq.peek()>course[0]){
            timeElapsed -= pq.remove();
            pq.add(course[0]);
            timeElapsed += course[0];
        }
        else{
//                 reject the course because it is not even satisfying the course deadline as well as it is bigger than all other courses selected
        }
    }
    return pq.size();
    
}
}