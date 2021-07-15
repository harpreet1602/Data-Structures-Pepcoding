import java.util.LinkedList;
public class HashMap {
    
    private class Node {
        Integer key = null;
        Integer value = null;

        Node(Integer key, Integer value)
        {
            this.key = key;
            this.value = value;
        }
    }
//Data Members ===============================
    
    private LinkedList<Node>[] Buckets;
    private int totalNoOfNodes = 0;
    private int bucketLen = 0;

    //Constructor ===========================

    private void initialize(int size)
    {
        bucketLen = size;
        Buckets = new LinkedList[size];
        for(int i = 0; i<size;i++)
        {
            Buckets[i] = new LinkedList<>();
        } 
        totalNoOfNodes = 0;
    }
    public HashMap(){
        initialize(10);
    }
    //Basic Functions======================

    public int size(){
        return this.totalNoOfNodes;
    }

    public boolean isEmpty(){
            return this.totalNoOfNodes==0;
    }


    //Ds Functions
public void put(Integer key,Integer value)
{
    boolean res = containsKey(key);
    LinkedList<Node> group = getGroup(key);
    if(res)
    {
        group.getFirst().key = value;
    }
    else
    {
    group.addLast(new Node(key,value));
    totalNoOfNodes++;
    }
}
public Integer get(Integer key)
{
    // LinkedList<Node> group = getGroup(key);
    // int gs = group.size();
    // Integer val = null;
    // while(gs-- > 0)
    // {
    //     if(group.getFirst().key.equals(key))
    //     {
    //         val = group.getFirst().value;
    //         break;
    //     }

    //     group.addLast(group.removeFirst());
    // }
    // return val;


    // another method
    boolean res = containsKey(key);
    LinkedList<Node> group = getGroup(key);

    return res==true?group.getFirst().value:null;
}
public Integer getOrDefault(Integer key, Integer DefaultValue)
{
    // LinkedList<Node> group = getGroup(key);
    // int gs = group.size();
    // Integer val = DefaultValue;
    // while(gs-- > 0)
    // {
    //     if(group.getFirst().key == key)
    //     {
    //         val = group.getFirst().value;
    //         break;
    //     }

    //     group.addLast(group.removeFirst());
    // }
    // return val;

    boolean res = containsKey(key);
    LinkedList<Node> group = getGroup(key);
    if(res)
    {
        totalNoOfNodes++;
       return group.getFirst().value;
    }
    return DefaultValue;
}
public Integer remove(Integer key)
{
    // LinkedList<Node> group = getGroup(key);
    // int gs = group.size();
    // Node node = null;
    // while(gs-- > 0)
    // {
    //     if(group.getFirst().key == key)
    //     {
    //         node = group.removeFirst();
    //         break;
    //     }

    //     group.addLast(group.removeFirst());

    
    // }
    // return node.value;

        //another method
        boolean res = containsKey(key);
        LinkedList<Node> group = getGroup(key);
        return res==true?group.removeFirst().value:null;        
}
public boolean containsKey(Integer key)
{
    LinkedList<Node> group = getGroup(key);
    int gs = group.size();
    boolean res = false;
    while(gs-- > 0)
    {
        if(group.getFirst().key.equals(key))
        {
            res = true;
            break;
        }
        group.addLast(group.removeFirst());
    }
    return res;
}

private LinkedList<Node> getGroup(Integer key)
{
    int hc = getHashCode(key);
    return Buckets[hc];
}

private int getHashCode(Integer key)
{
    return Math.abs(key.hashCode()) % bucketLen;
}
 }
