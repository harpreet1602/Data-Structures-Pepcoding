public class pseudoPallindrome{
    
    // 1457. Pseudo-Palindromic Paths in a Binary Tree
//     tc O(n) sc O(n*10)=> O(n)
    // simply traverse the dfs and keep the track of frequency once you reach the leaf node
//     then check there can only be one number with odd frequeny to be pseudo pallindromic 
//     In odd length => one with odd freq
    // .in even length => everyone with even freq. for pseudo pallindromic 
    
    private int ans=0;
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] freq = new int[10];
        dfs(root,freq);
        return ans;
    }
    private void dfs(TreeNode root,int[] freq){
        if(root == null){
            return;
        }
        freq[root.val]++;
        if(root.left == null && root.right == null){
            ans += checkFreq(freq);
        }
        dfs(root.left,freq);
        dfs(root.right,freq);
        freq[root.val]--;
    }
    private int checkFreq(int[] freq){
        boolean firstOdd = false;
        for(int key=0;key<freq.length;key++){
            if(freq[key]%2!=0){
                if(firstOdd){
                    return 0;
                }
                firstOdd = true;
            }
        }
        return 1;
    }
}