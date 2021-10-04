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

		
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		solveSolution();
	}
}
