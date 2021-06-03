public class client {
    public static void stackFunctioning() throws Exception
    {
        stack s1=new stack(3);
        s1.push(10);
        s1.push(20);
        s1.push(30);
        // s1.push(40);
        System.out.println(s1);
        while(!s1.isEmpty()){
            System.out.println(s1.pop());
        }
        //System.out.println(s1.top());
    }
    public static void queueFunctioning()throws Exception{
        queue que=new queue(3);
        que.add(10);
        que.add(20);
        que.add(30);
        System.out.println(que);
        while(!que.isEmpty())
        {
            System.out.println(que.remove());    
        }
    }

    public static void main(String[] args) throws Exception
    {
        // stackFunctioning();
        queueFunctioning();
    }
}
