public class asteroidCollision {
    
    // 735. Asteroid Collision
// tc O(n) sc O(n)
//     Stack will be used here because if we see the explosion case then we can observe some kind of next greater element comes in the opposite direction so that will Destroy the other one.
//     Similarly other cases should be handled that if the positive comes it will be added direclty.
//    while positive is there in the stack and is less than the size of negative one coming then remove it from the stack
//     if postive is there in the stack and we are coming with the negative of same size then explosion will take place
//     Else if the size of the stack is empty or negative is placed already in the stack so negative ele will get added into the stack
//     Move the result of the stack into an array and return it.
public int[] asteroidCollision(int[] asteroids) {
    LinkedList<Integer> st = new LinkedList<>();
    int n = asteroids.length;
    
    for(int i=0;i<n;i++){
        if(asteroids[i]>0){
            st.addFirst(i);
        }    
        else{
            
            while(st.size()!=0 && asteroids[st.getFirst()] >0 && asteroids[st.getFirst()]<-asteroids[i]){
                st.removeFirst();
            }
            if(st.size()!=0 && asteroids[st.getFirst()] >0 && asteroids[st.getFirst()]==-asteroids[i]){
                st.removeFirst();
            }
            else{
            if(st.size() == 0 || asteroids[st.getFirst()]<0){
                st.addFirst(i);
            }
            }
        }
    }
    int[] ans = new int[st.size()];
    for(int i=ans.length-1;i>=0;i--){
        ans[i] = asteroids[st.removeFirst()];
    }
    return ans;
}
}
