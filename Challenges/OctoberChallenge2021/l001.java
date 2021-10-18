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
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		solveSolution();
	}
}
