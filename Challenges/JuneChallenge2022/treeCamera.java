public class treeCamera {

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
    // 968. Binary Tree Cameras
//     tc O(n) sc O(log n)
//     Just do a dry run to understand the scenarios like we have options like 
//     camera is not needed at this node, camera needed, has camera, covered by some camera
//     Accordingly if we reach null, then node is not present so no camera needed.
//     If root node so we need to get monitored by the camera so camera is needed.
//     Check for the left and right status
//      if any of the status needs camera then install the camera and return that this node has camera
//     if any of the node is receiving hasCamera this means they are getting monitored by the child's camera so this node is covered by camera
//     in the end all the cases where both the nodes below are covered or not needed the camera then return camera is needed for this node as it not getting covered by the camera. 
private int cameras=0;
private int notNeeded=0;
private int hasCamera=1;
private int covered=3;
private int needCamera=4;


public int minCameraCover(TreeNode root) {
    if(getCameraStatus(root) == needCamera){
        cameras++;
    }
    return cameras;
}

private int getCameraStatus(TreeNode root){
    if(root == null){
        return notNeeded;
    }
    
    if(root.left==null && root.right==null){
        return needCamera;
    }
    
    int leftStatus = getCameraStatus(root.left);
    int rightStatus = getCameraStatus(root.right);
    
    if(leftStatus == needCamera || rightStatus == needCamera){
        cameras++;
        return hasCamera;
    }
    
    if(leftStatus == hasCamera || rightStatus == hasCamera){
        return covered;
    }
    
    return needCamera;
    
}
}
