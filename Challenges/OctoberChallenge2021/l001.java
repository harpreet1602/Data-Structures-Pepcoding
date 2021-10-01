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

	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		solveSolution();
	}
}
