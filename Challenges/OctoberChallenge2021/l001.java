/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class l001
{
    public static Scanner scn =new Scanner(System.in);
    // https://www.codechef.com/OCT21C/problems/MIXTURE
    public static void solveSolution(){
        int t=scn.nextInt();
		while(t-->0)
	    {
	        int a =scn.nextInt(), b =scn.nextInt();
	        if(a==0){
	            System.out.println("Liquid");
	        }
	        else if(b==0){
	            
	            System.out.println("Solid");
	        }
	        else if(a>0 && b>0){
	            
	            System.out.println("Solution");
	        }
	    }
    }



    // https://www.codechef.com/OCT21C/problems/THREEBOX
    public static void solveBoxes(){
        int t=scn.nextInt();
		while(t-->0)
	    {
	     
	     int a=scn.nextInt(),b=scn.nextInt(),c=scn.nextInt(),d=scn.nextInt();
            int sum = a+b+c;
            // ye comment vala chala nhi

    //         int ans=sum/d;
    //         if(sum%d==0)
	   //  System.out.println(ans);
	   //  else
	   //  System.out.println(ans+1);
	   if(sum<=d){
	       System.out.println(1);
	    }

	    else if(a+b<=d){
	        System.out.println(2);
	    }
	    else{
	        System.out.println(3);
	    }
    }
    }

	// https://www.codechef.com/OCT21C/problems/ANDSUBAR
	
    // O(n^2) and got tle
    public static void solveArray(){
        int t=scn.nextInt();
		while(t-->0)
	    {
	     
	     int n=scn.nextInt();
	     int[] arr =new int[n];
	     for(int i=1;i<=n;i++){
	         arr[i-1]=i;
	     }
	     int maxlength=0;
	     for(int i =0 ;i<n;i++){
	         int ans=arr[i];
	         for(int j =i+1;j<n;j++){
	             ans = (ans&arr[j]);
	             if(ans>0){
	                 maxlength= Math.max(maxlength,j-i+1);
	             }
	         }
	     }
	     if(maxlength!=0)
	     System.out.println(maxlength);
	     else
	     System.out.println(maxlength+1);
	    }
    }
    public static void solveAnd(){
       
        int t=scn.nextInt();
		while(t-->0)
	    {
	     
	     int n=scn.nextInt();
	     if(n==1)
	     {
	         System.out.println(1);
	         continue;
	     }
	     int ans=1;
	     while(ans*2<=n){
	         ans = ans*2;
	     }
	     int res = n-ans+1;
	     
	     System.out.println(Math.max(ans/2,res));
	    }
        
    }


	    // got correct answer on sample cases but got TLE
		public static void solveMexOr(){
			int t=scn.nextInt();
			while(t-->0)
			{
			 int a=scn.nextInt();
			 int res = 0;
			 boolean flag=false;
		   //  ArrayList<Integer> arr = new ArrayList<>();
			 for(int i=0;i<=a;i++){
				 if((res | i )>a){
					 System.out.println(i);
					flag=true;
					 break;
				   //  arr.add(i);
				 }
				 
					 res = (res | i);
			 }
			 if(flag==false){
				 System.out.println(a+1);
			 }
			 
		   //  for(int i=0;i<=(int)1e9;i++){
		   //      if(!arr.contains(i)){
		   //          System.out.println(i);
		   //          break;
		   //      }
		   //  }
			}
		}
		
		public static void solveMexOrOpt(){
			int t=scn.nextInt();
			while(t-->0)
			{
			 int x=scn.nextInt();
			 if(x==0){
				 System.out.println(1);
				 
			 }
			 else if(x==1){
				 System.out.println(2);
				 
			 }
			 else{
				 int ans = 1;
				 while(2*ans<=x){
					 ans = ans*2;
				 }
				 if(x == ((2*ans)-1))
				 {
					 System.out.println(x+1);
				 }
				 else{
					 System.out.println(ans);
				 }
			 }
			}
		}

		public static void solveDigit(){
			int t=scn.nextInt();
			while(t-->0)
			{
			 int n=scn.nextInt();
			 int d = scn.nextInt();
			 boolean flag=false;
			 String str = Integer.toString(n);
			 StringBuilder num = new StringBuilder(str);
			 int len = str.length();
			 
			 if(d==0){
			 int ind2 = len;
			 for(int i=0;i<len;i++){
			  if(num.charAt(i)=='0'){
				  num.setCharAt(i,'1');
				  ind2=i;
				  break;
			  }
			 }
			 for(int j=ind2+1;j<len;j++){
				 num.setCharAt(j,'1');
			 }
			 }
			 else if(d==9){
				 if(num.charAt(0) == '9'){
					 for(int i =0;i<len;i++){
						 num.setCharAt(i,'0');
					 }
					 num.insert(0,'1');
				 }
				 else{
					 int ind3=len;
					 for(int i=0;i<len;i++){
						 flag=false;
						 if(num.charAt(i) == '9')
						 {
							 for(int j=i-1;j>=0;j--){
							   //  System.out.println(num.charAt(j));
								 if(num.charAt(j)<='7'){
								   //  System.out.println((char)(num.charAt(j)+1));
									 num.setCharAt(j,(char)(num.charAt(j)+1));
									 ind3 = j;
									 for(int k=j+1;k<len;k++){
										 num.setCharAt(k,'0');
									 }
									 flag=true;
									 break;
								 }
							  }
								if(!flag){
									
								   for(int p =0;p<len;p++){
									num.setCharAt(p,'0');
									}
									num.insert(0,'1');
									
									 }
									 break;
						 }
					 }
				 }
			 }
			 else{
			   //  1<=d<=8
			   boolean check=false;
			   int ind3 =len;
				 for(int i=0;i<len;i++){
				   //  System.out.println((int)num.charAt(i)-48);
					if((int)num.charAt(i) - 48 == d){
					   // (char)(Character.getNumericValue(num.charAt(i)) + 1)
					num.setCharAt(i,(char)(num.charAt(i)+1));
					ind3=i;
					check=true;
					break;
					}
				 }
				 if(check){
				 for(int j =ind3+1;j<len;j++){
					 num.setCharAt(j,'0');
				 }
				 }
			 }
			 String s =num.toString();
			 int res = Integer.parseInt(s);
			 System.out.println(res - n);
			}
		}



// 12
// 21 5
// 8 8
// 100 0
// 5925 9
// 434356 3
// 98 9
// 1001 0
// 758 5
// 9456 9
// 27997 9
// 88997 9
// 836 8



//   Definition for a binary tree node.
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
 


// 993. Cousins in Binary Tree
class Solution {
    TreeNode xparent = null;
    TreeNode yparent = null;
    int xdepth = 0;
    int ydepth = 0;
    public boolean isCousins(TreeNode root, int x, int y) {
        getDepthAndParent(root,x,y,0,null);
        return xdepth == ydepth && xparent!=yparent;
    }
    public void getDepthAndParent(TreeNode root, int x, int y, int depth, TreeNode parent){
        if(root == null){
            return;
        }
        if(root.val == x){
            xdepth = depth;
            xparent = parent;
        }
        
        if(root.val == y){
            ydepth = depth;
            yparent = parent;
        }
        getDepthAndParent(root.left,x,y,depth+1,root);
        getDepthAndParent(root.right,x,y,depth+1,root);
    }
	//     bfs
	public boolean isCousins1(TreeNode root, int x, int y) {
        LinkedList<TreeNode> que = new LinkedList<>();
         que.add(root);
         while(que.size()!=0){
             int size = que.size();
             boolean aexist = false;
             boolean bexist = false;
             while(size-->0){
                 TreeNode curr = que.removeFirst();
                 if(curr.val == x) aexist = true;
                 if(curr.val == y) bexist = true;
                 if(curr.left != null && curr.right != null){
                     if(curr.left.val == x && curr.right.val == y){
                         return false;
                     }
                     if(curr.left.val == y && curr.right.val == x){
                         return false;
                     }
                 }
                 if(curr.left!=null)
                     que.addLast(curr.left);
                 
                 if(curr.right!=null)
                     que.addLast(curr.right);
             }
             if(aexist == true && bexist == true)
                 return true;
         }
         return false;
         
     }
}
// 496. Next Greater Element I
public int[] nextGreaterElement(int[] nums1, int[] nums2) {
	HashMap<Integer,Integer> map = new HashMap<>();
	LinkedList<Integer> st = new LinkedList<>();
	
	for(int num:nums2){
		while(st.size()!=0 && st.getFirst()<num){
			map.put(st.removeFirst(),num);
		}
		st.addFirst(num);
	}
	int[] ans = new int[nums1.length];
	int i = 0;
	for(int ele:nums1){
		ans[i++] = map.getOrDefault(ele,-1);
	}
	return ans;
}

// 380. Insert Delete GetRandom O(1)
class RandomizedSet {
    HashMap<Integer,Integer> map;
    List<Integer> list;
    Random r;
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        r = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;
        list.add(val);
        map.put(val,list.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        int ridx = map.get(val);
        if(ridx!=list.size()-1){
            list.set(ridx,list.get(list.size()-1));
            map.put(list.get(ridx),ridx);
        }
        list.remove(list.size()-1);    
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        int randomIdx = r.nextInt(list.size());
        return list.get(randomIdx);
    }



}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

public String frequencySort(String s) {
	HashMap<Character,Integer> map = new HashMap<>();
	PriorityQueue<Character> pq = new PriorityQueue<>((a,b)->{
		return map.get(b) - map.get(a);
	});
	int n=s.length();
	for(int i=0;i<n;i++){
		char ch = s.charAt(i);
		map.put(ch,map.getOrDefault(ch,0)+1);
	}
	for(char key:map.keySet()){
		pq.add(key);
	}
	StringBuilder sb  = new StringBuilder();
	while(pq.size()!=0){
		char remEle = pq.remove();
		 // while(map.get(remEle)!=0)
		// {
		//     sb.append(remEle);
		//     map.put(remEle,map.getOrDefault(remEle,1)-1);
		// }
		int freq = map.get(remEle);
		for(int i =0;i<freq;i++){
			sb.append(remEle);
		}
	}
	return sb.toString(); 
}
	// 153. Find Minimum in Rotated Sorted Array
	// tc: O(log n)
	// sc: O(1)
	public int findMin(int[] nums) {
		int n=nums.length,low = 0,high=n-1;
		while(low<high){
			int mid = (low+high)/2;
			if(nums[mid]>nums[high]){
				low=mid+1;
			}
			else if(nums[mid]<nums[high]){
				high = mid;
			}
		}
		return nums[low];
	}

	// 154. Find Minimum in Rotated Sorted Array II
	// tc: O(n)
	// sc: O(1)
	public int findMinDup(int[] nums) {
		int n=nums.length,low = 0,high=n-1;
			while(low<high){
				int mid = (low+high)/2;
				if(nums[mid]>nums[high]){
					low=mid+1;
				}
				else if(nums[mid]<nums[high]){
					high = mid;
				}
				else if(nums[mid] == nums[high]){
					high=high-1;
				}
			}
			return nums[low];
		}
		// 222. Count Complete Tree Nodes
//     tc : O((log n)^2) for finding height at every point in the height in the worst case
//     sc: O(log n)    => for finding height
public int findLeftHeight(TreeNode root){
	if(root==null)
		return 0;
	return findLeftHeight(root.left) + 1;
}

public int findRightHeight(TreeNode root){
	if(root==null)
		return 0;
	return findRightHeight(root.right) + 1;
}
public int countNodes(TreeNode root) {
	if(root==null){
		return 0;
	}
	
	int lh = findLeftHeight(root);
	int rh = findRightHeight(root);
	if(lh == rh){
		// return (int)Math.pow(2,lh) - 1;
		return (((1<<lh)) - 1);
	}
	int leftans = countNodes(root.left);
	int rightans = countNodes(root.right);
	return leftans+rightans+1;
	
}

// 15. 3Sum
// First of all sort the array then fix the first number and then take indices on the particular position and find the triplet accordingly and also put the conditions because we need not to have the duplicates so we will be skipping that.

public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n-2;i++){
            if(i==0 || nums[i]!=nums[i-1]){
            int j=i+1;
            int k=n-1;
            while(j<k){
            int sum = nums[i]+nums[j]+nums[k];
            if(sum == 0){
                List<Integer> smallList = new ArrayList<>();
                smallList.add(nums[i]); 
                smallList.add(nums[j]); 
                smallList.add(nums[k]);
                list.add(smallList);
                while(j<n-1 && nums[j]==nums[j+1]) j++;
                while(k>=1 && nums[k]==nums[k-1]) k--;
                j++;
                k--;
            }
            else if(sum<0){
                j++;
            }
            else k--;
            }
            }
        }
        return list;
    }
	// 994. Rotting Oranges
	public int orangesRotting(int[][] grid) {
        LinkedList<int[]> que = new LinkedList<>();
        int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
        int count=0,time=-1,m=grid.length,n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    que.add(new int[]{i,j});
                }
                else if(grid[i][j] ==1)
                    count++;
            }
        }
        if(count==0)
            return 0;
        while(que.size()!=0){
            time++;
            int size= que.size();
            while(size-->0){
                int[] val = que.remove();
                for(int[] d:dir){
                    int r = val[0] + d[0];
                    int c = val[1] + d[1];
                    if(r>=0 && c>=0 && r<m && c<n && grid[r][c] ==1){
                        count--;
                        grid[r][c]=0;
                        que.add(new int[]{r,c});
                    }
                }
            }
        }
        
        if(count==0)
            return time;
        return -1;
        
    }
	// 430. Flatten a Multilevel Doubly Linked List
	 public Node flatten(Node head) {
        if(head == null){
            return head;
        }
        Node node = head;
        while(node!=null){
            if(node.child!=null){
                Node nextnode = node.next;
//                 it returns the head of the child
                node.next = flatten(node.child);
                node.next.prev = node;
                node.child = null;
//                 move to last 
                while(node.next!=null){
                    node = node.next;
                }
                
//                 stich
                if(nextnode!=null){
                node.next = nextnode;
                nextnode.prev = node;
                }
            }
            node = node.next;
        }
        return head;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		solveSolution();
	}
}
