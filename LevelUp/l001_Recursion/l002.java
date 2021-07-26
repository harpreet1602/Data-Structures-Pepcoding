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

    public static void main(String[] args)
    {
        int[] coins={2,3,5,7};
        boolean[] vis = new boolean[coins.length];
    //   System.out.println(infiPermutation(coins,10,""));
    // System.out.println(infiCombinations(coins,10,0,""));
    // System.out.println(singleCombinations(coins,10,0,""));
    
    System.out.println(singlePermutation(coins,10,"",vis));
   }
}
