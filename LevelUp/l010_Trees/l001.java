import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.HashMap;

public class l001{
    class Node {
        public int val;
        public List<Node> children;
    
        public Node() {}
    
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };


    // 589. N-ary Tree Preorder Traversal
    // before traversal we are doing some task and then we will go for its children recursively 
    public void preorder(Node root, List<Integer> ans){
        ans.add(root.val);
        for(Node child:root.children){
            preorder(child,ans);
        }
    }
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if(root!=null) 
        preorder(root,ans);
        return ans;
    }

    // 590. N-ary Tree Postorder Traversal
    // we first of all do the work for children then our own work in postorder traversal
    public void postorder(Node root,List<Integer> ans){
        for(Node child:root.children){
            postorder(child,ans);
        }
        ans.add(root.val);
    }
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if(root!=null){
            postorder(root,ans);
        }
        return ans;
    }

    // https://www.pepcoding.com/resources/online-java-foundation/generic-tree/are-trees-mirror-in-shape-official/ojquestion
    // shape wise is to be considered not ata values
    // so simple concept is to check the children's size and then check the left of the first tree to the right of
    // second tree.
    // the pattern will be like 0,n-1 and 1, n-2 and so on
    public static boolean areMirror(Node n1, Node n2) {
        // write your code here
        if(n1.children.size()!=n2.children.size()) return false;
        // if(n1.data!=n2.data) return false;
        
        int size = n1.children.size();
        for(int i=0;i<size;i++){
            if(!areMirror(n1.children.get(i),n2.children.get(size-i-1))) return false;
        }
        return true;
      }


      public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }
    //   236. Lowest Common Ancestor of a Binary Tree
    private boolean find(TreeNode root,TreeNode data){
        if(root == null || data == null) return false;

        if(root == data) return true;

        return find(root.left,data) || find(root.right,data);
    }


    //     time O(n) as in the worst i might be travelling the whole binary tree, space O(n) as in the case of 
//     skewed binary tree.
    public boolean nodeToRootPath(TreeNode root,TreeNode data, List<TreeNode> ntr){
        if(root == null || data == null) return false;
        
        if(root == data){
            ntr.add(root);
            return true;
        }
//      if  I am not data then ask for it from the left and right 
        boolean ans = nodeToRootPath(root.left,data,ntr) || nodeToRootPath(root.right,data,ntr);
        
        if(ans){
            ntr.add(root);
        }
        
        return ans;
    } 
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> ntr1 = new ArrayList<>();
        nodeToRootPath(root,p,ntr1);
        List<TreeNode> ntr2 = new ArrayList<>();
        nodeToRootPath(root,q,ntr2);
        
        int i = ntr1.size()-1;
        int j = ntr2.size()-1;
        while(i>=0 && j>=0 && ntr1.get(i) == ntr2.get(j)){
            i--;
            j--;
        }
        i++;
        return ntr1.get(i);
    }
    
    private TreeNode lca;
    private boolean find(TreeNode root,TreeNode p,TreeNode q){
        if(root==null){
             return false;
         }
         
         boolean left = find(root.left,p,q);
         boolean right = find(root.right,p,q);
         
         if(left && right){
             lca = root;
         }
         
         else if(root == p || root == q) {
             if(left || right){
                 lca = root;
             }
             return true;
         }
         
         return left || right;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         find(root,p,q);
         return lca;
     }

    //  k down in binary tree
    private void kdown(TreeNode root,List<Integer> ans,int k){
        if(root == null) return;
        if(k==0){
            ans.add(root.val);
            return;
        }
        kdown(root.left,ans,k-1);
        kdown(root.right,ans,k-1);
    }

    public List<Integer> kdown(TreeNode root,int k){
        List<Integer> ans = new ArrayList<>();
        kdown(root, ans, k);
        return ans;
    }


     // 863. All Nodes Distance K in Binary Tree
    // time O(n) space O(n)
    // For current node call kdown and then in the node to root path go k-1 down and k-2 down and so one by blocking
    // the latest one to get the whole list of answer
    private void kfill_down(TreeNode root,List<Integer> ans,int k,TreeNode blocker){
        if(root==null || k<0 || root == blocker){
            return;
        }
        if(k==0){
            ans.add(root.val);
            return;
        }
        kfill_down(root.left,ans,k-1,blocker);
        kfill_down(root.right,ans,k-1,blocker);
    }
    public List<Integer> distanceK1(TreeNode root, TreeNode target, int k) {
        List<TreeNode> ntr = new ArrayList<>();
        nodeToRootPath(root,target,ntr);
        
        TreeNode blocker = null;
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<ntr.size();i++){
            kfill_down(ntr.get(i),ans,k-i,blocker);
            blocker = ntr.get(i);
        }
        return ans;
    }


    // Optimized space
    // time O(n) space O(1)
//     -1 will be taken to show that this cannot be the part of answer. if i have reached
//     the node which is target then call kdown and after that return 1 because for the upper 
//    level it will be k-1 down . For blocking we can see that where the answer is coming 
//     either it is from left or right so block that respectively and return to the upper level
//     the respective distance +1 like k-2 down and so on.
    private int distanceKOpt(TreeNode root, TreeNode target, int k,List<Integer> ans){
        if(root == null) return -1;
        
        if(root == target){
            kfill_down(root,ans,k,null);
            return 1;
        }
        
        int leftDist = distanceKOpt(root.left,target,k,ans);
        int rightDist = distanceKOpt(root.right,target,k,ans);
        
        if(leftDist>=0){
            kfill_down(root,ans,k-leftDist,root.left);
            return leftDist+1;
        }
        
        if(rightDist>=0){
            kfill_down(root,ans,k-rightDist,root.right);
            return rightDist+1;
        }
        
        return -1;
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        distanceKOpt(root,target,k,ans);
        return ans;
    }    


    // https://www.geeksforgeeks.org/burn-the-binary-tree-starting-from-the-target-node/
    // moving downwards and burning the nodes
    // once I get a node here with the initial distance whenever required add the arraylist for next level
    // according to distance add that into arraylist and go down to children with dis + 1
    public static void getBurnNodes(TreeNode root, List<List<Integer>> ans, int dis, TreeNode blocker){
        if(root == null || root == blocker) return;

        if(dis == ans.size()){
            ans.add(new ArrayList<>());
        }
        ans.get(dis).add(root.val);
        // going down so +1 for both the children
            getBurnNodes(root.left,ans,dis+1,blocker);
            getBurnNodes(root.right,ans,dis+1,blocker);
    }
 
    // till the time you don't get data node return -1 and when you will find it then call for its children to get
    // added in list and then calling the children as well till the time we are not finding the target node
    // when at the upper level we will get dist from any children then block that child and get the nodes of children
    // always retun dist + 1 at upper level 

    public static int burningTree(TreeNode root,TreeNode data,List<List<Integer>> ans){
        if(root == null){
            return -1;
        }
        if(root == data){
            // get the below nodes when matched
            getBurnNodes(root,ans,0,null);
            return 1;
        }
        int leftDis = burningTree(root.left, data, ans);
        int rightDis = burningTree(root.right, data, ans);

        if(leftDis>=0){
            // get nodes below it and block the left node
            getBurnNodes(root,ans,leftDis,root.left);
            return leftDis+1;
        }
        
        if(rightDis>=0){
            // get nodes below it and block the right node
            getBurnNodes(root,ans,rightDis,root.right);
            return rightDis+1;
        }
        return -1;
    }
    public static void burningTree(TreeNode root, TreeNode data){
        List<List<Integer>> ans = new ArrayList<>();
        burningTree(root,data,ans);
    }

    // burning tree with water nodes===================================

    // moving downwards and burning the nodes
    // once I get a node here with the initial distance whenever required add the arraylist for next level
    // according to distance add that into arraylist and go down to children with dis + 1
    public static void getBurnNodes(TreeNode root, List<List<Integer>> ans, int dis, TreeNode blocker, HashSet<TreeNode> water){
        if(root == null || root == blocker || water.contains(root)) return;

        if(dis == ans.size()){
            ans.add(new ArrayList<>());
        }
        ans.get(dis).add(root.val);
        // going down so +1 for both the children
            getBurnNodes(root.left,ans,dis+1,blocker);
            getBurnNodes(root.right,ans,dis+1,blocker);
    }
 
    // till the time you don't get data node return -1 and when you will find it then call for its children to get
    // added in list and then calling the children as well till the time we are not finding the target node
    // when at the upper level we will get dist from any children then block that child and get the nodes of children
    // always retun dist + 1 at upper level 

    public static int burningTreeWater(TreeNode root,TreeNode data,List<List<Integer>> ans, HashSet<TreeNode> water){
        if(root == null){
            return -1;
        }
        if(root == data){
            // get the below nodes when matched
            getBurnNodes(root,ans,0,null,water);
            return 1;
        }
        int leftDis = burningTreeWater(root.left, data, ans, water);
        int rightDis = burningTreeWater(root.right, data, ans,water);

        if(leftDis>=0){
            // get nodes below it and block the left node
            getBurnNodes(root,ans,leftDis,root.left,water);
            return leftDis+1;
        }
        
        if(rightDis>=0){
            // get nodes below it and block the right node
            getBurnNodes(root,ans,rightDis,root.right,water);
            return rightDis+1;
        }
        return -1;
    }

    // water nodes are the ones where the nodes can't burn and below that also we cannot reach so they will also not burn.
    public static void burningTreeWater(TreeNode root, TreeNode data, List<TreeNode> waterNodes){
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<TreeNode> water = new HashSet<>();
        for(TreeNode w:waterNodes){
            water.add(w);
        }
        burningTreeWater(root,data,ans,water);
    }

    

    //  18-01-22
        
// 173. Binary Search Tree Iterator
// tc (h) sc O(h) 
// In this question for inorder traversal we are going to use  a stack whenever
// next is called then return top of the stack but add its right subtree's all
// values till left is not null that will be its inorder succesors in order.
class BSTIterator {
    
    LinkedList<TreeNode> st;
    
    public BSTIterator(TreeNode root) {
        st = new LinkedList<>();
        addAllLeft(root);
    }
    
    public void addAllLeft(TreeNode node){
        while(node!=null){
            st.addFirst(node);
            node = node.left;
        }
    }
    public int next() {
        TreeNode top = st.removeFirst();
        addAllLeft(top.right);
        return top.val;
    }
    
    public boolean hasNext() {
        return st.size()!=0;
    }
}


    // 652. Find Duplicate Subtrees
    // In this question we can take every subtree and check in the 
    // whole tree for duplicate this is brute of n^2 time
    
    // optimised
    // we can encrypt and decrypt the strings and whenever in the map
    // the same string exists then add the string in the answer
    // 
 //     It is taking each stringbuilder as new it is not able to recognise.
    
    public String dfs(TreeNode root,HashMap<String,Integer> map,List<TreeNode> ans){
        if(root == null){
            return "#";
        }
        
        String left_ser = new String(dfs(root.left,map,ans));
        String right_ser = new String(dfs(root.right,map,ans));
        
        String root_ser = "("+ left_ser + "," + root.val + "," + right_ser  +")";
        
        if(map.containsKey(root_ser)){
                // System.out.println(root_ser);
            if(map.get(root_ser)==1){
                // System.out.println(root_ser);
                ans.add(root);
            }
        }
        
                // System.out.println(root_ser);
        map.put(root_ser,map.getOrDefault(root_ser,0)+1);
        
        return root_ser;
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String,Integer> map = new HashMap<>();
        List<TreeNode> ans = new ArrayList<>();
        dfs(root,map,ans);
        return ans;
    }
    
    
    class Node1 {
        public int val;
        public Node1 left;
        public Node1 right;
        public Node1 next;
    
        public Node1() {}
        
        public Node1(int _val) {
            val = _val;
        }
    
        public Node1(int _val, Node1 _left, Node1 _right, Node1 _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    // 116. Populating Next Right Pointers in Each Node
//     So what we are doing here is to apply the bfs using null technique 
    // not size technique, we can use that as well, and we are attaching two 
//     main links of lower level while staying at the upper level to 
//     make the next pointer work.
    
    public Node1 connect(Node1 root) {
        if(root==null){
            return root;
        }
        LinkedList<Node1> que = new LinkedList<>();
        que.addLast(root);
        que.addLast(null);
        while(que.size()>1){
            Node1 top = que.removeFirst();
            if(top == null){
                que.addLast(null);
            }
            else{
                if(top.left!=null){
                    top.left.next = top.right;
                    
                    if(que.getFirst()!=null){
                        top.right.next = que.getFirst().left;
                    }

                    que.addLast(top.left);
                    que.addLast(top.right);
                }
            }
        }
        return root;
    }


    
//     tc O(n) sc O(1)
//     we are going to the first ele of the level then making connections of the next level
//     we are simulating the working of bfs with constant space
    public Node1 connect1(Node1 root) {
        if(root==null){
            return root;
        }
        
        Node1 top = root,curr;
        while(top.left!=null){
            curr = top;
            while(curr!=null){
                curr.left.next = curr.right;
                if(curr.next!=null){
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            top = top.left;
        }
        return root;
    }


    
    // 968. Binary Tree Cameras
// tc O(n) sc O(1) 
//     -1 => don't need camera, I am already monitored
//     0 => I am the camera
//     1 => install the camera, I need to get monitored.
    private int cameras=0;
    public int findCameras(TreeNode root){
        if(root == null){
            return -1;
        }
        
        int left_req = findCameras(root.left);
        int right_req = findCameras(root.right);
        
        if(left_req == 1 || right_req ==1){
            cameras++;
            return 0; // I am the camera
        }
        
        if(left_req == 0 || right_req == 0){
            return -1;//I don't need the camera as I am already monitored
        }
        
        return 1; //Otherwise I need the camera 
        
        
    }
    public int minCameraCover(TreeNode root) {
        
        if(findCameras(root)==1)
        {
            cameras++;   
        }
        return cameras;
    }

    // do like this => 1 size array

    
    
    public int findCameras(TreeNode root,int[] cameras){
        if(root == null){
            return -1;
        }
        
        int left_req = findCameras(root.left,cameras);
        int right_req = findCameras(root.right,cameras);
        
        if(left_req == 1 || right_req ==1){
            cameras[0]++;
            return 0; // I am the camera
        }
        
        if(left_req == 0 || right_req == 0){
            return -1;//I don't need the camera as I am already monitored
        }
        
        return 1; //Otherwise I need the camera 
        
        
    }
    
    public int minCameraCover1(TreeNode root) {
        int[] cameras = new int[1];
        if(findCameras(root,cameras)==1)
        {
            cameras[0]++;   
        }
        return cameras[0];
    }

    
//     979. Distribute Coins in Binary Tree
//     tc O(n) sc O(1)
//     Ṣo for requirement we ask for negative
//     if we have surplus then we can return positive
//     moves can be calculated like this whatever it is negative
//     or positive take their absolute values for total no of moves
//     one size array for a global variable moves 
// moves[0] = moves[0] + Math.abs(left_req) + Math.abs(right_req);
// return left_req + right_req + root.val - 1;
// so this will be the current value which we can send upward
//     all the work will be done in  postorder fashion because according to 
//     the faith I ask for the requirement from both the subtrees then 
//     calculate the current value that can be returned
   
    public int findMoves(TreeNode root, int[] moves){
        if(root == null){
            return 0;
        }
        
        int left_req = findMoves(root.left,moves);
        int right_req = findMoves(root.right,moves);
        
        moves[0] = moves[0] + Math.abs(left_req) + Math.abs(right_req);
        
        return left_req + right_req + root.val - 1;
    }
    public int distributeCoins(TreeNode root) {
        int[] moves = new int[1];
        findMoves(root,moves);
        return moves[0];
    }

    
    // 1373. Maximum Sum BST in Binary Tree
//     tc O(n) sc O(1)
//     So if I get to know that my left and right subtrees are BST
//     then I can find the maxSum and one size array is working as a global
//     variable and I can return the [min, max, sum] from every point
//     min and max needs to get calculated as we can get null case as well
//     so we handled it like this
//     rest do dry run
    // {min,max,sum}
    public int[] isBST(TreeNode root, int[] maxSum){
        if(root == null){
            return new int[]{(int)1e9,-(int)1e9,0};
        }
        
        int[] leftTree = isBST(root.left,maxSum);
        int[] rightTree = isBST(root.right,maxSum);
        
        
//         isBST and if it is not then return null
        if(!(leftTree!=null && rightTree!=null && leftTree[1]<root.val && rightTree[0]>root.val)){
            return null;
        }
        
//         if it has reached here then it is a BST so do calculations
        int sum = leftTree[2] + rightTree[2] + root.val;
        maxSum[0] = Math.max(maxSum[0],sum);
        
        int min = Math.min(leftTree[0],root.val);
        int max = Math.max(rightTree[1],root.val);
        
        return new int[]{min,max,sum};
        
    }
    public int maxSumBST(TreeNode root) {
        int[] maxSum = new int[1];
        isBST(root,maxSum);
        return maxSum[0];
    }





}