//import java.util.ArrayList;
import java.util.*;
public class l002_ArrayList {
    public static Scanner scn=new Scanner(System.in);
    public static void basicFunction(){
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(10);
        arr.add(20);
        arr.add(30);
        System.out.println(arr);
        for(Integer ele:arr)
        {
            System.out.println(ele);
        }
        System.out.println(arr.size());
        System.out.println(arr.get(1));
        arr.remove(1);
        System.out.println(arr);
    }
    //remove data from array list
    public static void swap(ArrayList<Integer> arr,int i,int j)
    {
        Integer temp=arr.get(i);
        arr.set(i,arr.get(j));
        arr.set(j,temp);
    }
    public static void removedata()
    {
        ArrayList<Integer> arr=new ArrayList<>();
        int n=scn.nextInt();
        for(int i=0;i<n;i++)
        {
            arr.add(scn.nextInt());
        }
        int data=scn.nextInt();
        int i=arr.size()-1;
        while(i>=0)
        {
            if(data==arr.get(i))
            {
                swap(arr,i,arr.size()-1);
                arr.remove(arr.size()-1);
            }
            i--;
        }
        System.out.println(arr);
    }

    //remove primes
    public static boolean isPrime(Integer ele)
    {
        for(int i=2;i*i<=ele;i++)
        {
            if(ele%i==0)
            {
                return false;
            }
        }
        return true;
    }
    //time O(n^2) space O(1)
	public static void solution(ArrayList<Integer> al){
		// write your code here
		int i=0;
		while(i<al.size())
		{
		    if(isPrime(al.get(i)))
		    {
		       al.remove(i);
		    }
		    else
		    i++;
		}
		
	}
    //time O(n) space O(n)
    public static void solution1(ArrayList<Integer> al){
        ArrayList<Integer> arr=new ArrayList<>(); 
        //for(int i=0;i<al.size();i++)
            for(Integer ele:al)
            {
                if(!isPrime(ele))
                {
                   arr.add(ele);
                }
            }
            al.clear();        //O(n)
            for(Integer ele:arr)
            {
                al.add(ele);
            }
        }
        public static void main(String[] args)
        {
            //basicFunction();
            removedata();
        }
}
