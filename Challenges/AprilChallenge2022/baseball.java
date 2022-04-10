import java.util.LinkedList;
public class baseball {
    
    // 682. Baseball Game
//     Time O(n) space O(n)
//     Just do the operations according to the simulation of the question and use stack to solve it.
public int calPoints(String[] ops) {
    LinkedList<Integer> st = new LinkedList<>();
    
    for(int i=0;i<ops.length;i++){
        String ch = ops[i];
        if(ch.equals("+")){
            int ch1 = st.removeFirst();
            int ch2 = st.getFirst();
            int num = ch1 + ch2;
            st.addFirst(ch1);
            st.addFirst(num);
        }
        else if(ch.equals("D")){
            int num = st.getFirst();
            st.addFirst(2*num);
        }
        else if(ch.equals("C")){
            st.removeFirst();
        }
        else{
            st.addFirst(Integer.valueOf(ch));
        }
    }
    
    int sum = 0;
    while(st.size()!=0){
        sum += st.removeFirst();
    }
    
    return sum;
    
    
}
}
