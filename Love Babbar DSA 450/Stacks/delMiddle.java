import java.util.Stack;
public class delMiddle{
     
    // Delete middle element of a stack 
    // tc O(n) sc O(1)
    // pop middle -1 elements and push it to the other stack and then pop the middle element
    // push back all the elements to the first stack again
    public void deleteMid(Stack<Integer>s,int sizeOfStack){
        // code here
        Stack<Integer> s1 = new Stack<>();
        int mid = (s.size()+1)/2;
        if(((s.size()+1)%2)==0)
        mid--;
        while(mid>0){
            s1.push(s.pop());
            mid--;
        }    
        s.pop();
        while(s1.size()!=0){
            s.push(s1.pop());
        }
    } 
}