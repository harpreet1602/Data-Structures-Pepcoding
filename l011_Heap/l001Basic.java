import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.ArrayList;
public class l001Basic{
    public static Scanner scn=new Scanner(System.in);

    public static void Int_minPQ(){
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //by default in java min Priority Queue and in c++ by default max priority queue
        for(int i=10;i>=1;i--)
        {
            pq.add(i * 10);
        }
        while(pq.size()!=0)
        {
            System.out.println(pq.remove());
        }
    }
    public static void Int_maxPQ(){
        //this - other , default behaviour
        //ohter - this, reverse of default behaviour
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            return b-a;
        });
        for(int i=10;i>=1;i--)
        {
            pq.add(i * 10);
        }
        while(pq.size()!=0)
        {
            System.out.println(pq.remove());
        }
    }
    public static void matrixPQ()
    {
        int[][] arr={{2,6,11,3},{8,5,16,4},{9,7,11,13},{8,3,12,11}};

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return a[1]-b[1];
        });
        for(int[] a:arr)
        {
            pq.add(a);
        }
        while(pq.size()!=0)
        {
            int[] a=pq.remove();
            for(int ele:a)
            {
            System.out.print(ele+" ");
            }
            System.out.println();
        }

    }

    public static class mobilePhone{
        String Company="";
        String Model="";
        int Ram=0;
        int Storage=0;
        int BatteryBackup=0;

        mobilePhone(String Company, String Model, int Ram, int Storage, int BatteryBackup){
            this.Company=Company;
            this.Model= Model;
            this.Ram=Ram;
            this.Storage=Storage;
            this.BatteryBackup=BatteryBackup;
        }
        mobilePhone(){

        }
        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder();
            
            sb.append("Company: " + this.Company + "\n");
            sb.append("Model: " + this.Model + "\n");
            sb.append("Ram: " + this.Ram + "\n");
            sb.append("Storage: " + this.Storage + "\n");
            sb.append("BatteryBackup: " + this.BatteryBackup + "\n");
            
            return sb.toString();
        }
    }
    public static void mobilePhoneDetails() {
        int n=scn.nextInt();
        PriorityQueue<mobilePhone> pq = new PriorityQueue<>((a,b)->{
            if(a.Ram!=b.Ram) 
            return b.Ram-a.Ram;
            else if(a.Storage!=b.Storage)
            return b.Storage-a.Storage;
            else 
            return b.BatteryBackup-a.BatteryBackup;
        });
        for(int i=0;i<n;i++)
        {
            pq.add(new mobilePhone(scn.next(),scn.next(),scn.nextInt(),scn.nextInt(),scn.nextInt()));
        }
        while(pq.size()!=0)
        {
            System.out.println(pq.remove());
        }
    }

    //brute force solution time: O(nlogn) space: O(n)
    //thoda sa ulta vala hai ye largest sai kth largest tak print karega
    public static void solve(int n,int[] arr,int k){
        //Write your code here
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
          return b-a;  
        });
        for(int ele:arr)
        {
            pq.add(ele);
        }
        while(pq.size()!=0)
        {
               if(pq.size()==n-k)
               break;
            System.out.print(pq.remove()+" ");
        }
        
   }

    //brute force solution time: O(nlogn) space: O(n)
    //ye sahi vala hai,ye kth largest sai largest tak print karega

   public static void kLargestElements(int[] arr,int k)
   {
       PriorityQueue<Integer> pq=new PriorityQueue<>();
       for(int e:arr)
       {
           pq.add(e);
       }
       while(pq.size()!=0)
       {
           if(pq.size()==k)
           break;
           pq.remove();
       }
       while(pq.size()!=0)
       {
           System.out.println(pq.remove());
       }
   }

   //optimised sol time:O(nlogk) space: O(k)
    //ye sahi vala hai,ye kth largest sai largest tak print karega

   public static void kLargestElementsOptimised(int[] arr,int k)
    {
    PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int e:arr)
        {
            pq.add(e);
            
            if(pq.size()>k)
            {
                pq.remove();
            }
        }
        while(pq.size()!=0)
        {
            System.out.println(pq.remove());
        }
        
    }

    
   //optimised sol time:O(nlogk) space: O(k)
    //thoda sa ulta vala hai ye largest sai kth largest tak print karega

    public static void solve1(int n,int[] arr,int k){
        PriorityQueue<Integer> pq=new PriorityQueue<>();
           for(int e:arr)
           {
               pq.add(e);
               
               if(pq.size()>k)
               {
                   pq.remove();
               }
           }
           ArrayList<Integer> list=new ArrayList<>();
           while(pq.size()!=0)
           {
               list.add(pq.remove());
           }
           for(int i=list.size()-1;i>=0;i--)
           {
               System.out.print(list.get(i)+" ");
           }
           
       }
       



    public static void main(String[] args)
    {
        // Int_minPQ();
        // Int_maxPQ();

        mobilePhone ph = new mobilePhone();
        // System.out.println(ph);
        // mobilePhoneDetails();
        matrixPQ();
    }

}