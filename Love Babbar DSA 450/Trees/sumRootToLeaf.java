public class sumRootToLeaf{
    
    private int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        sumNumbers(root,new StringBuilder());
        return sum;
    }
    private void sumNumbers(TreeNode root,StringBuilder number){
        if(root == null ){
            return;
        }
        
        number.append(root.val);
        if(root.left == null && root.right ==null){
            sum += Integer.parseInt(number.toString());
        }
        sumNumbers(root.left,number);
        sumNumbers(root.right,number);
        number.deleteCharAt(number.length()-1);
    }

}