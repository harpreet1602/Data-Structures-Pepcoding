public class user {
    // ab isme protected vali cheez access hojaegi same folder sai
    public static void main(String[] args) throws Exception{
        // stack st = new stack(3);
        DynamicStack st = new DynamicStack(2);
        st.push(10);
        st.push(20);
        st.push(30);
        System.out.println(st.pop());
        st.displayStack();
        System.out.println(st.peek());
    }
}
