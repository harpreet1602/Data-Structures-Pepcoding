import java.util.*;
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
  // formula for finding the distance between the nodes 
  //nodeToRoot path1 + nodeToRootPath2 - 2*lca will give the distance in terms of edge.

  public static ArrayList<Integer> nodeToRootPath1(Node node, int data) {
    if (node.data == data) {
      ArrayList<Integer> path = new ArrayList<>();
      path.add(node.data);
      return path;
    }

    for (Node child : node.children) {
      ArrayList<Integer> ptc = nodeToRootPath1(child, data);
      if (ptc.size() > 0) {
        ptc.add(node.data);
        return ptc;
      }
    }

    return new ArrayList<>();
  }

  public static int countLca(Node node, int d1, int d2) {
    ArrayList<Integer> p1 = nodeToRootPath1(node, d1);
    ArrayList<Integer> p2 = nodeToRootPath1(node, d2);

    int i = p1.size() - 1;
    int j = p2.size() - 1;

    int count=0;
    while(i >= 0 && j >= 0 && p1.get(i) == p2.get(j)){
      i--;
      j--;
      count++;
    }

    return count;
  }

  public static int distanceBetweenNodes(Node node, int d1, int d2){
    // write your code here
    ArrayList<Integer> list1=nodeToRootPath1(node,d1);
    ArrayList<Integer> list2=nodeToRootPath1(node,d2);
    int x=list1.size();
    int y=list2.size();
    int l=countLca(node,d1,d2);
    return x+y-2*l;
  }

  //similar gerneric tree 
  //kya mere children ke size equal hai , agar hai to chidren ke individually children ka size equal hai
  //jaha pai nhi hai to false return karenge aur and operator sai ek baar false hoga to and ke aagge
  //condition nhi chalegi aur jab ek baar false return hota hai kisi child sai to vo children ka loop 
  //pura hote hi bahar nikal jaaata hai main ke pass aage ke liye calls nhi lagti
  public static boolean areSimilar(Node n1, Node n2) {
    // write your code here
    if(n1.children.size()!=n2.children.size())
    {
        return false;
    }
    boolean res=true;
    for(int i=0;i<n1.children.size();i++)
    {
        Node node1=n1.children.get(i);
        Node node2=n2.children.get(i);
        
        res=res && areSimilar(node1,node2);
    }
    return res;
  }
    //isme ek side sai ek and parli side sai dusre ke children check karenge baaki same as areSimilar
    //karenge kyuki mirror mai shape palat jati hai na isliye 
    public static boolean areMirror(Node n1, Node n2) {
        // write your code here
        if(n1.children.size()!=n2.children.size())
        return false;
        
        boolean res=true;
        int n=n1.children.size();
        for(int i=0;i<n;i++)
        {
            Node c1=n1.children.get(i);
            Node c2=n2.children.get(n-i-1);
            res=res&&areMirror(c1,c2);
        }
        return res;
      }
      //data should also match
      public static boolean areMirrorData(Node n1, Node n2) {
        // write your code here
        if(n1.children.size()!=n2.children.size() || n1.data!=n2.data)
        return false;
        
        boolean res=true;
        int n=n1.children.size();
        for(int i=0;i<n;i++)
        {
            Node c1=n1.children.get(i);
            Node c2=n2.children.get(n-i-1);
            res=res&&areMirror(c1,c2);
        }
        return res;
      }
      //is symmetric 
      //tree khud sai khud mirror image ho to symetric hoga
      public static boolean IsSymmetric(Node node) {
        // write your code here
        return areMirror(node,node);
      }
      //ceil and floor
      //HUM CEIL AND FLOOR DEKH KE CHALENGE
        
  static int ceil;
  static int floor;
  
  public static void ceilAndFloor_(Node node, int data) {
    if(node.data<data)
    {
        floor=Math.max(floor,node.data);
    }
    if(node.data>data)
    {
        ceil=Math.min(ceil,node.data);
    }
    for(Node child:node.children)
    {
        ceilAndFloor_(child,data);
    }
  }
  public static void ceilAndFloor(Node node, int data) {
    // Write your code here
  //2147483647
  ceil=Integer.MAX_VALUE;
  floor=Integer.MIN_VALUE;
    ceilAndFloor_(node,data);
  }

  // kth largest
  //har baari traverse karke upperbound sai kam mai sai maximum nikal ke late raho aur k baari traaverse
  //karne ke baad upperbound hi kth larggest hojaega

  public static int floor(Node node,int ub)
  {
      int maxAns=-(int)1e9;
      for(Node child:node.children)
      {
          int recAns=floor(child,ub);
          maxAns=Math.max(maxAns,recAns);
      }
      return node.data<ub ? Math.max(node.data,maxAns):maxAns;
  }
public static int kthLargest(Node node, int k){
  // write your code here
  int upperbound=(int)1e9;
  for(int i=0;i<k;i++)
  {
      upperbound=floor(node,upperbound);
  }
  return upperbound;
  
}
    //faith ye hai ki niche vale khud ko linearize karke aagye hai
    //ab mai apne children ke aakhir sai loop run karunga aur 2nd element tak chalunga
    //aur jispe hu usse pichle kki tail i.e. leaf node utha ke launga and uske arraylist mai children
    // ke element ko 
    //dal dunga and current node ke arraylist mai sai us child ko delete kardunga 
  public static Node getTail(Node node)
    {
        while(node.children.size()!=0)
        {
            node=node.children.get(0);
        }
        return node;
    }
  public static void linearize(Node node){
    // write your code here
    for(Node child:node.children)
    linearize(child);
    
    for(int i=node.children.size()-1;i>0;i--)
    {
        Node tail=getTail(node.children.get(i-1));
        tail.children.add(node.children.get(i));
        node.children.remove(node.children.get(i));
    }
  }

  

}
