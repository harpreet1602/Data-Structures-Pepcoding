import java.util.*;
public class hashmapConstruction {
    // in one group we need to assign the other things
    // so we can use arrayList or linkedlist
    private class Node{
        Integer key = 0;
        Integer value = 0;
        Node next = null;

        Node(Integer key,Integer value){
            this.key = key;
            this.value = value;
        }
    }
    private class linkedlist{
    private Node head = null;
    private Node tail = null;
    private int NoOfElements = 0;

    public void addLast(Node node){
        if(head == null){
            head = tail = node;
        }
        else{
            this.tail.next = node;
            this.tail = node;
        }
        NoOfElements++;
    }
    public int size(){
        return NoOfElements;
    }
    public int getFirst(){
        return this.head.key;
    }
    public Node removeFirst(){
        Node node = this.head;
        if(this.NoOfElements == 0){
            this.head = this.tail = null;
        }
        else{
        this.head = this.head.next;
        node.next=null;
        }
        NoOfElements--;
        return node;
        }
    }

    private linkedlist[] containers;
    private int sizeOfHM = 0;

    public void assignValues(int size){
        containers = new linkedlist[size];
        for(int i = 0; i < size; i++){
            containers[i] = new linkedlist();
        }
    }
    hashmapConstruction(){
        assignValues(10);
    }

    public String display(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int count = 0;
        for(int i =0;i<this.containers.length;i++){
            linkedlist group = group(i);
            int size = group.size();
            while(size-->0){
                Node node = group.removeFirst();
                sb.append("("+node.key+"="+node.value+")");
                count++;
                if(count!=this.sizeOfHM){
                    sb.append(",");
                }
                group.addLast(node);
        }
    }
    sb.append("]");
    return sb.toString();
    }

    private void rehash(){
        linkedlist[] backup = this.containers;
        assignValues(2*this.containers.length);
        for(int i =0;i<backup.length;i++){
            linkedlist group = group(i);
            int size = group.size();
            while(size-->0){
                Node node = group.removeFirst();
                put(node.key,node.value);
            }
        }
    }
    public void put(Integer key, Integer value){
        boolean isKey = containsKey(key);
        linkedlist group = group(key);
        if(isKey){
            group.head.value = value; 
        }else{
            group.addLast(new Node(key,value));
        }
        this.sizeOfHM++;

        double lambda = group.size() / this.containers.length * 1.0;
        if(lambda > 0.745){
            rehash();
        }
    }
    public void putIfAbsent(Integer key, Integer value){
        boolean isKey = containsKey(key);
        if(!isKey){
            put(key,value);
        }
        
    }

    public ArrayList<Integer> keySet(){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<this.containers.length;i++){
            linkedlist group = group(i);
            int size = group.size();
            while(size-->0){
                Node node = group.removeFirst();
                list.add(node.key);
                group.addLast(node);
            }
        }
        return list;
    }

    public Integer remove(Integer key){
        boolean isKey = containsKey(key);
        linkedlist group = group(key);
        if(!isKey){
            return null;
        }
        Node node = group.removeFirst();
        this.sizeOfHM--;
        return node.key;
    }

    public Integer getOrDefault(Integer key, Integer defaultValue){
        Integer value = get(key);
        return value!=null?value:defaultValue;    
    }

    public Integer get(Integer key){
        boolean isKey = containsKey(key);
        linkedlist group = group(key);
        return isKey?group.head.value:null;
    }

    public boolean containsKey(Integer key){
        linkedlist grp = group(key);
        int size = grp.size();
        while(size-->0){
            if(grp.head.key == key){
                return true;
            }
            grp.addLast(grp.removeFirst());
        }        
        return false;
    }

    private linkedlist group(Integer key){
        int code = hashCode(key);
        return this.containers[code];
    }

    private int hashCode(Integer key){
        int value = key.hashCode();
        return value % containers.length;
    }
}
