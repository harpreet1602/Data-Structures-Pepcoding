package adapters;
import java.util.*;
public class queueUsingStackPush {
    public static LinkedList<Character> st=new LinkedList<>();
    public static Scanner scn=new Scanner(System.in);
    public static boolean balancedBrackets(String str)
    {
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            if(ch=='[' || ch=='{' || ch=='(')
            {
                st.addFirst(ch);
            }
            else if(ch==']' || ch=='}' || ch==')')
            {
                if(st.size()==0) return false;
                else if(ch==']' && st.getFirst()!='[')
                return false;
                else if(ch=='}' && st.getFirst()!='{')
                return false;
                else if(ch==')' && st.getFirst()!='(')
                return false;
                else
                {
                    st.removeFirst();
                }
            }
        }
        return st.size()==0;
        
    }
    public static void main(String[] args) throws Exception {
    System.out.println(balancedBrackets(scn.nextLine()));
    }
}
