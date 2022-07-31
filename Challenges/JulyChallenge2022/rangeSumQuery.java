public class rangeSumQuery{
    class NumArray {
        // 307. Range Sum Query - Mutable
        
        //     naive => simple array => update O(1) sum O(n)
        //     prefix sum array => update tc O(n) query sum O(1)
            
        //     optimised
        //     update => O(logn) query sum => O(log n) 
        //     we are using segment trees.
        //     build tree, update tree and get the query sum from start to end
            private class SegmentTreeNode{
                private int start;
                private int end;
                private SegmentTreeNode left;
                private SegmentTreeNode right;
                private int sum;
                
                public SegmentTreeNode(int start,int end){
                    this.start = start;
                    this.end = end;
                    this.left = null;
                    this.right = null;
                    this.sum = 0;
                }
            }
        //     global root node of the segment tree.
            SegmentTreeNode root = null;
            // tc O(n) => this will be made only one time
            public NumArray(int[] nums) {
                root = buildTree(nums,0,nums.length-1);
            }
        //     make the node and then get the sum on the leaf nodes then come back from left and right to get the sum on the parent nodes. => preorder traversal
            private SegmentTreeNode buildTree(int[] nums,int start,int end){
                if(start>end){
                    return null;
                }    
                else{
                    SegmentTreeNode ret = new SegmentTreeNode(start,end);
                    if(start == end){
                        ret.sum = nums[start];
                    }
                    else{
                    int mid = start + (end-start)/2;
                    ret.left = buildTree(nums,start,mid);
                    ret.right = buildTree(nums,mid+1,end);
                    ret.sum = ret.left.sum + ret.right.sum;
                    }
                    return ret;
                }
            }
            // tc O(logn)
            public void update(int index, int val) {
                update(root,index,val);
            }
        
            private void update(SegmentTreeNode root,int pos,int val){
                if(root.start == root.end){
        // found leaf node to be updated and update it with the new val
                    root.sum = val;
                }
                else{
        //             encountering the parents that will get updated.
                    int mid = root.start + (root.end-root.start)/2;
                    if(pos<=mid){
        //                 element is in left
                        update(root.left,pos,val);
                    }
                    else{
        //                 element to be updated is in right
                        update(root.right,pos,val);
                    }
        //             while coming back recursively towards root and update all the sums that fall in place from left and right child's sum
                    root.sum = root.left.sum + root.right.sum;
                }
            }
        //     tc O(logn)
            public int sumRange(int left, int right) {
                return sumRange(root,left,right);
            }
            
            private int sumRange(SegmentTreeNode root,int start,int end)
            {
        //         exact node where the sum is contained so return it.
                if(start == root.start && end == root.end){
                    return root.sum;
                }
                else{
        //             otherwise find mid and see in which direction to go
                    int mid = root.start + (root.end-root.start)/2;
        //             go in left with the start to end range
                    if(end<=mid){
                        return sumRange(root.left,start,end);
                    }
        //              go in right with the start to end range
                    else if(start>mid){
                        return sumRange(root.right,start,end);
                    }
                    else{
        // go in both the directions with split range from start to mid in left and mid +1 to end in right                
                        return sumRange(root.left,start,mid) + sumRange(root.right,mid+1,end);
                    }
                }
            }
        }
        
        /**
         * Your NumArray object will be instantiated and called as such:
         * NumArray obj = new NumArray(nums);
         * obj.update(index,val);
         * int param_2 = obj.sumRange(left,right);
         */
}