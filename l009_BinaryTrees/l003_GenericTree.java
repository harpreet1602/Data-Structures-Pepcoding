import java.util.ArrayList;
public class l003_GenericTree {
    public static class Node{
        int data = 0;
        ArrayList<Node> children;

        Node(int data)
        {
            this.data=data;
            this.children = new ArrayList<>();
        }
    }
    //mere children ki maximum height mai +1 karke return kardo
    //root sai 0 aana chaiye height (edge based height)
  public static int height(Node node) {
    // write your code here
    int h=-1;
    for(Node child:node.children)
    {
        h=Math.max(h,height(child));
    }
    return h+1;
  }

    //apne children ka size utha ke le aata hu aur khud ka
    // +1 karke return kardeta hu 
    public static int size1(Node node){
        // write your code here
        int count=0;
        for(int i=0;i<node.children.size();i++){
            Node child=node.children.get(i);
            count+=size(child);
        }
        return count+1;
      }
      
      public static int size(Node node){
        int count = 0;
        for(Node child:node.children)
        {
            count+=size(child);
        }
        return count+1;
          
      }
    

      public static int max(Node node) {
        // write your code here
        int m=node.data;
        for(Node child:node.children)
        {
            m=Math.max(m,max(child));
        }
        return m;
      }

    public static int minimum(Node root)
    {
        int min=root.data;
        for(int i=0;i<root.children.size();i++)
        {
            Node child=root.children.get(i);
            min=Math.min(min,minimum(child));
        }
        return min;
    }
    //mai khud hu kya to return true nhi to children mai hai kya
    //agar hai to vhi sai true hote rahega by using or ya phir if bhi 
    //use kar sakte the
    //or vala milne pai aage recursion nhi lagaega
  public static boolean find(Node node, int data) {
    // write your code here
    if(node.data==data)
    return true;
    
    boolean res=false;
    for(Node child:node.children)
    {
        res=res||find(child,data);
    }
    return res;
  }
  //if vala milne pai break kardeta hai
  public static boolean find1(Node node, int data) {
  
    if(node.data==data)
    return true;
    boolean res=false;
    for(Node child:node.children)
    {
        if(find(child,data))
        {
            res=true;
            break;
        }
    }
    return res;
}
public static boolean nodeToRootPath(Node node,int data,ArrayList<Node> ans)
{
    if(node.data==data)
    {
        ans.add(node);
        return true;
    }
    boolean res=false;
    for(Node child:node.children)
    {
        res = res || nodeToRootPath(child, data, ans);
    }
    if(res)
    {
        ans.add(node);
    } 
    return res;
}
//mai hu data to nyi arraylist bana ke mujhe add karke return karva do root ki taraaf 
//backtrack karte hue
//ab hamesha nyi arraylist banti rahegi nhi hoga to empty hi return hoti rahegi
//aur jab piche sai milni shuru hogyi to break karke loop bahar aake us node ke parent ko add kardenge
//return kardenge list
public static ArrayList<Integer> nodeToRootPath(Node node, int data){
    // write your code here
    if(node.data==data)
    {
        ArrayList<Integer> base= new ArrayList<>();
        base.add(node.data);
        return base;
    }
    
    ArrayList<Integer> myAns=new ArrayList<>();
    for(Node child:node.children)
    {
        myAns=nodeToRootPath(child,data);
        if(myAns.size()!=0)
        break;
    }
    if(myAns.size()!=0)
    {
        myAns.add(node.data);
    }
    return myAns;
 }
 //DONO KI NODE TO ROOT PATH PATA KARLO AUR PHIR REVERSE SAI TRAVERSE KARO JAHA PAI UNEQUAL HONGE
 //USSE JUST PEHLE LCA STORED HI AAPKA LCA HOGA
 public static int lca(Node node, int d1, int d2) {
    // write your code here
    ArrayList<Integer> list1=nodeToRootPath(node,d1);
    ArrayList<Integer> list2=nodeToRootPath(node,d2);
    int lca=-1;
    int i= list1.size()-1;
    int j= list2.size()-1;
    while(i>=0 && j>=0)
    {
        if(list1.get(i)!=list2.get(j))
        break;
        lca=list1.get(i);
        i--;
        j--;
    }
    return lca;
  }
}
