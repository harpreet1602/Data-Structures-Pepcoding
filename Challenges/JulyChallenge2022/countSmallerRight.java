public class countSmallerRight {
    
    // 315. Count of Smaller Numbers After Self
//     tc O() sc O() => will be studied of Segment tree.
    //https://www.youtube.com/watch?v=dw-tlJYjzco
    public class SegmentTreeNode{
        public SegmentTreeNode left;
        public SegmentTreeNode right;
        
        public int start;
        public int end;
        public int sum;
        
        public SegmentTreeNode(int start,int end){
            this.start = start;
            this.end = end;
            sum = 0;
        }
    }
    
    public SegmentTreeNode buildTree(int start,int end)
    {
        if(start>end){
            return null;
        }
        
        SegmentTreeNode node = new SegmentTreeNode(start,end);
        
        if(start == end){
            return node;
        }
        
        int mid = start + (end-start)/2;
        node.left = buildTree(start,mid);
        node.right = buildTree(mid+1,end);
        
        return node;
    }
    
    public void update(SegmentTreeNode node, int index){
        if(node == null){
            return;
        }
        
        if(node.start == index && node.end == index){
            node.sum+=1;
            return;
        } 
        int mid = node.start + (node.end-node.start)/2;
        if(index<=mid){
            update(node.left,index);
        }
        else{
            update(node.right,index);
        }
        node.sum = node.left.sum + node.right.sum;
    }
    
    public int sumRange(SegmentTreeNode root, int start, int end){
        if(root == null || start>end){
            return 0;
        }
        
        if(root.start == start && root.end == end){
            return root.sum;
        }
        int mid = root.start + (root.end-root.start)/2;
        if(end<=mid){
            return sumRange(root.left,start,end);
        }else if(start>mid){
            return sumRange(root.right,start,end);
        }
        return sumRange(root.left,start,mid) + sumRange(root.right,mid+1,end);
    }
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] counts = new int[n];
        int min =(int)1e9;
        int max =-(int)1e9;
        
        for(int ele:nums){
            max = Math.max(max,ele);
            min = Math.min(min,ele);
        }
        SegmentTreeNode root = buildTree(min,max);
        
        for(int i=n-1;i>=0;i--){
            update(root,nums[i]);
            counts[i] = sumRange(root,min,nums[i]-1);
        }
        
        List<Integer> ans = new ArrayList<>();
        for(int ele:counts){
            ans.add(ele);
        }
        return ans;
    }
}
