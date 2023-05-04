public class dota2senate {
    class Solution {
        // 649. Dota2 Senate
    // tc O(n) sc O(n)
    //     It will be solved using greedy approach
    //     Two queues will be used one for r and one for d, we will store indexes where they have been seen in the string
    //     and then we will keep on going till one queue becomes empty 
    //     whichever have size greater than zero will be the winner
    //     in the middle we will see which have smaller index
    //     that will  eliminate the other one and will get added again with i+n as it will get another turn in future.
        public String predictPartyVictory(String senate) {
            LinkedList<Integer> rq = new LinkedList<>();
            LinkedList<Integer> dq = new LinkedList<>();
            int n = senate.length();
            
            for(int i=0;i<n;i++){
                char ch = senate.charAt(i);
                
                if(ch == 'R'){
                    rq.addLast(i);
                }
                else{
                    dq.addLast(i);
                }
            }
            
            while(rq.size()!=0 && dq.size()!=0){
                int i = rq.removeFirst();
                int j = dq.removeFirst();
                
                if(i<j){
                    rq.addLast(i+n);
                }
                else{
                    dq.addLast(j+n);
                }
            } 
            
            return rq.size()!=0?"Radiant":"Dire";
        }
    }
}
