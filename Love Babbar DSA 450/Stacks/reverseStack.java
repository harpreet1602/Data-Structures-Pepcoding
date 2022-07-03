import java.util.ArrayList;
public class reverseStack {
    
    // https://practice.geeksforgeeks.org/problems/reverse-a-stack/1/#
    // Reverse a Stack
    // tc O(n) sc O(n)
    // Reversing the stack just for the sack of question otherwise it is simple to implement using iteration.
    // Make a list and pass it to the helper function there if the size of stack becomes 0
    // then return from the function
    // otherwise keep on deleting the element of the stack and add it to the arraylist
    // and call for the recursion.
    
    static ArrayList<Integer> reverse(Stack<Integer> s)
    {
        // add your code here
        ArrayList<Integer> ans = new ArrayList<>();
        helperReverse(ans,s);
        return ans;
    }
    static void helperReverse(ArrayList<Integer> ans,Stack<Integer> s){
        if(s.size()==0){
            return;
        }
        ans.add(s.pop());
        helperReverse(ans,s);
    }
}
