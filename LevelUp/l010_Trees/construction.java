public class construction {

    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode() {}
             TreeNode(int val) { this.val = val; }
             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
             }
         }
    // 105. Construct Binary Tree from Preorder and Inorder Traversal
    public TreeNode construct(int[] pre,int psi,int pei,int[] in,int isi,int iei){
        if(psi>pei){
            return null;
        }
        
        TreeNode root = new TreeNode(pre[psi]);
        
        int idx = isi;
        int find_ele = pre[psi];
        while(in[idx]!=find_ele){
            idx++;
        }
        
        int leftDis = idx-isi;
        root.left = construct(pre,psi+1,psi+leftDis,in,isi,idx-1);
        root.right = construct(pre,psi+leftDis+1,pei,in,idx+1,iei);
        
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    return construct(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    // 106. Construct Binary Tree from Inorder and Postorder Traversal
    public TreeNode construct1(int[] post,int psi,int pei,int[] in,int isi,int iei){
        if(psi>pei){
            return null;
        }
        
        TreeNode root = new TreeNode(post[pei]);
        
        int idx = isi;
        int find_ele = post[pei];
        while(in[idx]!=find_ele){
            idx++;
        }
        
        int leftDis = idx-isi;
        root.left = construct1(post,psi,psi+leftDis-1,in,isi,idx-1);
        
        root.right = construct1(post,psi+leftDis,pei-1,in,idx+1,iei);
        return root;
    }
    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        return construct1(postorder,0,postorder.length-1,inorder,0,inorder.length-1);
    }

    // 108. Convert Sorted Array to Binary Search Tree
    public TreeNode construct2(int[] nums,int si,int ei){
        if(si>ei){
            return null;
        }
        int mid = (si+ei)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = construct2(nums,si,mid-1);
        root.right = construct2(nums,mid+1,ei);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return construct2(nums,0,nums.length-1);
    }

    // 02/01/22
    // half class questions and understanding pending
    // 1008. Construct Binary Search Tree from Preorder Traversal


    // 449. Serialize and Deserialize BST

//     297. Serialize and Deserialize Binary Tree


    // A lot of pending classes


    





}
