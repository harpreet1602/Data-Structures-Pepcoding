import java.util.PriorityQueue;
public class questionsPriorityQueue {
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        //Your code here
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            return b-a;
        });
        for(int e:arr)
        {
        pq.add(e);
        if(pq.size()>k)
        {
            pq.remove();
        }
        }
        return pq.peek();
    } 


    //is ques mai row wise sorted matrix tha usse 1d array mai full sorted dena tha
    // brute force to yehi hai ki priority queue mai sab daal do and then sab nikal lo min type sai
    //but iski time: O((n*m)log(n*m)) 
    //optimised isme kaise karai ki 1d indexing store karvai priority queue mai and compare kara 
    //2 d indexing ke hisaab sai us priority queue mai and then sabse pehle 0th col ke saaare ele priority
    //queue mai daal lo and then jab nikaloge the eidx aayega 1d indexing ka usse 2d index banao and uski value 
    //array mai daal do aur c agar valid hai to aage bada ke priority queue mai 2d ki 1d indexing daal do
    public static void matrixInto1dSorted(int[][] arr)
    {
        int m=arr.length,n=arr[0].length;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            int r1=a/n,c1=a%n,r2=b/n,c2=b%n;
            return arr[r1][c1] - arr[r2][c2];
        });

        for(int i=0;i<m;i++)
        {
            pq.add(i*n + 0); //c=0
        }

        int[] ans=new int[m*n];
        int idx=0;
        while(pq.size()!=0)
        {
            int eidx=pq.remove(); //encoded 1d index
            int r=eidx/n,c=eidx%n;
            ans[idx++] = arr[r][c];

            c++;

            if(c<n)
            {
                pq.add(r*n+c);
            }
        }

        for(int ele:ans)
    {
        System.out.print(ele+" ");
    }

    }
    public static void main(String[] args)
    {
        int[][] arr={{3,7,8,9,9},{1,1,1,2,3},{0,0,0,1,2},{-8,-5,-3,-2,10},{6,8,8,8,9}};
        matrixInto1dSorted(arr);
    }
}
