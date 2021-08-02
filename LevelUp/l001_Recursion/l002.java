import java.util.*;
public class l002 {
   
    public static int infiPermutation(int[] coins, int tar,String asf)
    {
        if(tar==0)
        {
            System.out.println(asf);
            return 1;
        }

        int count = 0;

        for(int  i = 0 ;i<coins.length;i++)
        {
            if(tar - coins[i] >= 0)
            {
                count+=infiPermutation(coins, tar - coins[i], asf+coins[i]);
            }
        }
        return count;
    }
    public static int singlePermutation(int[] coins, int tar,String asf,boolean[] vis)
    {
        if(tar==0)
        {
            System.out.println(asf);
            return 1;
        }

        int count = 0;

        for(int  i = 0 ;i<coins.length;i++)
        {
            if(tar - coins[i] >= 0 && vis[i]==false)
            {
                vis[i]=true;
                count+=singlePermutation(coins, tar - coins[i], asf+coins[i],vis);
                vis[i]=false;
            }
        }
        return count;
    }
    public static int singlePermutation1(int[] coins, int tar,String asf)
    {
        if(tar==0)
        {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        
        for(int  i = 0 ;i<coins.length;i++)
        {
            if(tar - coins[i] >= 0 && coins[i]>0)
            {
                int val = coins[i];
                coins[i] = -coins[i];
                count+=singlePermutation1(coins, tar - val, asf+val);
                coins[i] = -coins[i];
            }
        }
        return count;
    }

    public static int infiCombinations(int[] coins,int tar,int idx,String asf)
    {
        if(tar==0)
        {
            System.out.println(asf);
            return 1;
        }

        int count = 0;

        for(int  i = idx ;i<coins.length;i++)
        {
            if(tar - coins[i] >= 0)
            {
                count+=infiCombinations(coins, tar - coins[i],i, asf+coins[i]);
            }
        }
        return count;
    }

    public static int singleCombinations(int[] coins,int tar,int idx,String asf)
    {
        if(tar==0)
        {
            System.out.println(asf);
            return 1;
        }

        int count = 0;

        for(int  i = idx ;i<coins.length;i++)
        {
            if(tar - coins[i] >= 0)
            {
                count+=singleCombinations(coins, tar - coins[i],i+1, asf+coins[i]);
            }
        }
        return count;
    }


     //leetcode 39  Combination Sum 
    public void combinations(int[] candidates,int target, int idx, List<Integer> smallAns,List<List<Integer>> ans)
    {
        if(target == 0)
        {
            List<Integer> base = new ArrayList<>(smallAns); //deep copy  (values)
            ans.add(base); //shallow copy (address)
            return;
        }
        
        for(int i = idx;i<candidates.length;i++)
        {
            if(target - candidates[i] >= 0 )
            {
                smallAns.add(candidates[i]);
                combinations(candidates,target-candidates[i],i,smallAns,ans);
                smallAns.remove(smallAns.size()-1);
            }
        }
        
    }
    
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<Integer> smallAns = new ArrayList<>();
            List<List<Integer>> ans = new ArrayList<>();
            
            combinations(candidates,target,0,smallAns,ans);
        return ans;
    }
    //leetcode 40

    
    
    public void combinations2(int[] candidates,int target, int idx, List<Integer> smallAns,List<List<Integer>> ans)
    {
        int prev=-1;
        if(target == 0)
        {
            List<Integer> base = new ArrayList<>(smallAns); //deep copy  (values)
            ans.add(base); //shallow copy (address)
            return;
        }
        
        for(int i = idx;i<candidates.length;i++)
        {
            if(target - candidates[i] >= 0 )
            {
                if(prev!=candidates[i])
                {
                smallAns.add(candidates[i]);
                combinations2(candidates,target-candidates[i],i+1,smallAns,ans);
                smallAns.remove(smallAns.size()-1);                
                }
                prev=candidates[i];
            }
        }
        
    }
    
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
         List<Integer> smallAns = new ArrayList<>();
            List<List<Integer>> ans = new ArrayList<>();
            
            combinations2(candidates,target,0,smallAns,ans);
        return ans;
    }

    //https://www.interviewbit.com/problems/subset/
    public void getSubsets(ArrayList<Integer> A,ArrayList<Integer> smallAns,ArrayList<ArrayList<Integer>> ans,int idx)
    {      
            ans.add(new ArrayList<>(smallAns));
            for(int i =idx;i<A.size();i++)
            {
                smallAns.add(A.get(i));
                
                getSubsets( A, smallAns, ans, i+1);
                smallAns.remove(smallAns.size()-1);

            }
    }
    
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> smallAns = new ArrayList<>();
        Collections.sort(A);
        getSubsets(A,smallAns,ans,0);
        return ans;
    }

    public static int singleCombination_subseq(int[] coins,int tar,int idx,String asf)
    {
        if(tar==0 || idx>=coins.length)
        {
            if(tar==0)
            {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count=0;
        if(tar-coins[idx]>=0)
        count+=singleCombination_subseq(coins,tar-coins[idx],idx+1,asf+coins[idx]);
        count+=singleCombination_subseq(coins,tar,idx+1,asf);

        return count;

    }

    public static int infiCombination_subseq(int[] coins,int tar,int idx,String asf)
    {
        if(tar==0 || idx>=coins.length)
        {
            if(tar==0)
            {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count=0;
        if(tar-coins[idx]>=0)
        count+=infiCombination_subseq(coins,tar-coins[idx],idx,asf+coins[idx]);
        count+=infiCombination_subseq(coins,tar,idx+1,asf);

        return count;

    }
    public static int infiPermutation_subseq(int[] coins,int tar,int idx,String asf)
    {
        if(tar==0 || idx>=coins.length)
        {
            if(tar==0)
            {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count=0;
        if(tar-coins[idx]>=0)
        count+= infiPermutation_subseq(coins,tar-coins[idx],0,asf+coins[idx]);
        count+= infiPermutation_subseq(coins,tar,idx+1,asf);

        return count;

    }

    
    public static int singlePermutation_subseq(int[] coins,int tar,int idx,String asf,boolean[] vis)
    {
        if(tar==0 || idx>=coins.length)
        {
            if(tar==0)
            {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count=0;
        if(tar-coins[idx]>=0 && !vis[idx])
        {
            vis[idx]=true;
        count+= singlePermutation_subseq(coins,tar-coins[idx],0,asf+coins[idx],vis);
            vis[idx]=false;
    }
        count+= singlePermutation_subseq(coins,tar,idx+1,asf,vis);

        return count;

    }
    //Queen set =========
    //tnb= total no of bpxes, bno= box no,tnq : total no of queen, qpsf: queen placed
   // so far
   
   public static int queenCombination1D(int tnb,int bno, int tnq,int qpsf,String asf)
   {
        if(qpsf>tnq)
        {
            System.out.println(asf);
            return 1;
        }
        int count = 0;
        for(int b = bno;b<=tnb;b++)
        {
            count+= queenCombination1D(tnb, b + 1, tnq, qpsf + 1, asf + "b"+b+"q"+qpsf+" "); 
        }
        return count;
   }

   public static int queenCombination1d_sub(int tnb,int bno,int tnq,int qpsf,String asf)
   {
        //idhar do case dekhne padenge box ka and queen ka
        if(qpsf>tnq || bno>tnb){
            if(qpsf>tnq)
            {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }


        int count=0;
        
        count+=queenCombination1d_sub(tnb, bno+1, tnq, qpsf+1, asf+"b"+bno+"q"+qpsf+" ");
        count+=queenCombination1d_sub(tnb, bno+1, tnq, qpsf, asf);
        
        return count;
   }

   public static int queenPermutation1D(int tnb,int bno, int tnq,int qpsf,String asf,boolean[] vis)
   {
    if(qpsf>tnq)
    {
        System.out.println(asf);
        return 1;
    }
    int count = 0;
    for(int b = bno;b<=tnb;b++)
    {
        if(!vis[b])
        {
            vis[b] = true;
            count+= queenPermutation1D(tnb, 1, tnq, qpsf + 1, asf + "b"+b+"q"+qpsf+" ",vis); 
            vis[b]=false;
    }
    }
    return count;
   }

   public static int queenPermutations1d_sub(int tnb,int bno,int tnq,int qpsf,String asf,boolean[] vis)
   {
        //idhar do case dekhne padenge box ka and queen ka
        if(qpsf>tnq || bno>tnb){
            if(qpsf>tnq)
            {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }


        int count=0;
        
        if(!vis[bno])
        {
            vis[bno]=true;
        count+=queenPermutations1d_sub(tnb, 1, tnq, qpsf+1, asf+"b"+bno+"q"+qpsf+" ",vis);
        vis[bno]=false;
    }
        count+=queenPermutations1d_sub(tnb, bno+1, tnq, qpsf, asf,vis);
        
        return count;
   }

   // k value can be decreased at every call whenever it reaches zero means we have got
   // the combination of size k we can return from there after adding the answer in the list
    // in the end we will get the answer 
   public int combinations(int n, int k, int val, List<Integer> smallAns, List<List<Integer>> ans )
   {
       if(k==0)
       {
           List<Integer> base = new ArrayList<Integer>(smallAns);
           ans.add(base);
           return 1;
       }
       int count = 0;
       for(int  i = val; i<=n;i++)
       {
           smallAns.add(i);
        count+=combinations(n, k-1, i+1, smallAns,ans);
           smallAns.remove(smallAns.size()-1);
       }
       return count;
       
   }
   
   public List<List<Integer>> combine(int n, int k) {
       List<List<Integer>> ans = new ArrayList<>();
       List<Integer> smallAns = new ArrayList<>();
       combinations(n,k,1,smallAns,ans);
       return ans;
   }



//    216. Combination Sum III
// here both the things need to be fulfiled one is target and one is length
// so it will be managed like this
   public int combinationsum3(int k , int n , int idx, List<Integer> smallAns, List<List<Integer>> ans)
   {
       if(n==0 || k==0){
           if(n==0 && k==0)
           {
           List<Integer> base = new ArrayList<>(smallAns);
           ans.add(base);
           return 1;
           }
           return 0;
       }
       int count=0;
       for(int i = idx ; i <= 9 ; i++)
       {
           smallAns.add(i);
           count+=combinationsum3(k-1 , n - i , i+1, smallAns, ans);
           smallAns.remove(smallAns.size()-1);
       }
       return count;
       
       
   }
       public List<List<Integer>> combinationSum3(int k, int n) {
       List<List<Integer>> ans = new ArrayList<>();
       List<Integer> smallAns = new ArrayList<>();
    combinationsum3(k ,  n , 1 , smallAns,  ans);
           return ans;
   }

//    322. Coin Change
//     tle for recursion
//     will be done by dp
    
public int min = (int)1e9;
public int combinationCoinChange(int[] coins , int amount , int idx, List<Integer> smallAns, List<List<Integer>> ans)
{
 if(amount==0){
     List<Integer> base = new ArrayList<>(smallAns);
     if(base.size()<min)
         min=base.size();
     ans.add(base);
     return 1;
 }
 int count=0;
 for(int i = idx ; i < coins.length ; i++)
 {
     if(amount-coins[i]>=0)
     {
     smallAns.add(coins[i]);
     count+=combinationCoinChange(coins , amount - coins[i] , i, smallAns, ans);
     smallAns.remove(smallAns.size()-1);
     }
 }
 return count;
 
 
}




public int coinChange(int[] coins, int amount) {
 if(amount==0)
     return 0;
 List<List<Integer>> ans = new ArrayList<>();
 List<Integer> smallAns = new ArrayList<>();
 combinationCoinChange(coins,amount,0,smallAns,ans);
 return min==(int)1e9?-1:min;
}




   //2d reh gye hw vale
   //1365
    
   public static int queenCombination2D(boolean[][] vis,int bno, int tnq,String asf)
   {
        if(tnq==0)
        {
            System.out.println(asf);
            return 1;
        }
        int count = 0;
        int n=vis.length,m=vis[0].length;
        for(int b = bno;b<n*m;b++)
        {
            int r=b/m;
            int c=b%m;
            count+= queenCombination2D(vis, b + 1, tnq-1, asf + "("+r+","+c+") "); 
        }
        return count;
   }
   //43680
   public static int queenPermutations2D(boolean[][] box, int tnq,String asf,boolean[][] vis)
   {
        if(tnq==0)
        {
            System.out.println(asf);
            return 1;
        }
        int count = 0;
        int n=box.length,m=box[0].length;
        for(int b = 0;b<n*m;b++)
        {
            int r=b/m;
            int c=b%m;
            if(!vis[r][c])
            {
                vis[r][c]=true;
            if(!box[r][c])
            {
                box[r][c]=true;
            count+= queenPermutations2D(box, tnq-1, asf + "("+r+","+c+") ",vis); 
                box[r][c]=false;
            }
            vis[r][c]=false;
            }
        }
        return count;
   }


   public static int queenCombination2Dsub(boolean[][] box,int bno,int tnq,String asf)
   {
        int n = box.length,m=box[0].length;
        if(tnq==0 || bno>=n*m)
        {
            if(tnq==0)
            {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }
         
        int count=0;

        int r = bno/m;
        int c = bno%m;
        
        if(r>=0 && c>=0 && r<n && c<m){
        if(!box[r][c])
        {
            box[r][c]=true;
        count+=queenCombination2Dsub(box, bno+1, tnq-1, asf+"("+r+","+c+") ");
            box[r][c]=false;
        }
        }   
        count+=queenCombination2Dsub(box, bno+1, tnq, asf);

        return count;
   }

   public static int queenPermutation2Dsub(boolean[][] box,int bno,int tnq,String asf)
   {
       int n = box.length,m=box[0].length;

        if(tnq==0 || bno>=n*m)
        {
            if(tnq==0)
            {
                System.out.println(asf);
                return 1;
            }            
            return 0;
        }
        
       int count=0;
       
       int r =bno/m;
       int c = bno%m;
       if(r>=0 && c>=0 && r<n && c<m)
       {
           if(!box[r][c])
           {
                box[r][c] =true;
                count+=queenPermutation2Dsub(box, 0, tnq-1, asf+"("+r+","+c+") ");
                box[r][c] =false;
           }
       }
       count+=queenPermutation2Dsub(box, bno+1, tnq, asf);
       return count;
   }

   public static void queen2D(){
       int tnq=4;
       boolean[][] box = new boolean[4][4];
       boolean[][] vis = new boolean[4][4];
    //    System.out.println(queenCombination2D(box, 0, tnq, ""));
        // System.out.println(queenCombination2Dsub(box, 0, tnq, ""));  
    // System.out.println(queenPermutations2D(box, tnq, "",vis));
    System.out.println(queenPermutation2Dsub(box, 0, tnq, ""));
   }
   







public static void queen(){
    int tnb = 7,tnq=4;
    boolean[] vis = new boolean[tnb+1];
    System.out.println(queenCombination1D(tnb, 1, tnq, 1, ""));
    // System.out.println(queenCombination1d_sub(tnb, 1, tnq, 1, ""));
}


    public static void main(String[] args)
    {
        int[] coins={2,3,5,7};
        boolean[] vis = new boolean[coins.length];
    //   System.out.println(infiPermutation(coins,10,""));
    // System.out.println(infiCombinations(coins,10,0,""));
    // System.out.println(singleCombinations(coins,10,0,""));
    
    // System.out.println(singlePermutation(coins,10,"",vis));
    // System.out.println(singlePermutation1(coins,10,""));
    // System.out.println(singlePermutation_subseq(coins,10,0,"",vis));
        // queen();
        queen2D();
}
}
