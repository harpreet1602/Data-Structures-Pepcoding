import java.util.*;
public class questions {
    //leetcode 46
    public void permute(int[] nums,int count, List<List<Integer>> res,List<Integer> ans)
    {
        if(count==nums.length)
        {
            List<Integer> base=new ArrayList<>(ans);
            //for(ele:ans) base.add(ele);
            res.add(base);
        }
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>=-10 && nums[i]<=10)
            {
            int value=nums[i];
            nums[i]=-11;
            ans.add(value);
            //recursive call
            permute(nums,count+1,res,ans);
            ans.remove(ans.size()-1);
            nums[i]=value;
            }
        }
    }
        public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        permute(nums,0,res,ans);
        return res;
    }
      //47 leetcode
      public void permuteUnique(int[] nums,int count,List<List<Integer>> res,List<Integer> ans)
      {
          if(count==nums.length)
          {
              // if(res.contains(ans)==false)
              // {
              List<Integer> base=new ArrayList<>();
              for(int ele:ans) base.add(ele);
              res.add(base);
              //}
              return;
          }
          for(int i=0;i<nums.length;i++)
          {
              if(nums[i]>=-10 && nums[i]<=10)
              {
                  if(i>0)
                  {
                      if(nums[i-1]==nums[i])
                      {
                          continue;
                      }
                  }
                  int value=nums[i];
                  nums[i]=-11;
                  ans.add(value);
                  permuteUnique(nums,count+1,res,ans);
                  nums[i]=value;
                  ans.remove(ans.size()-1);
              }
          }
      }
      public List<List<Integer>> permuteUnique(int[] nums) {
          List<List<Integer>> res=new ArrayList<>();
          List<Integer> ans=new ArrayList<>();
          Arrays.sort(nums);
          permuteUnique(nums,0,res,ans);
          return res;
      }
  
   }
  
      // GFG  Rat Maze
    //1.https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1#
    public static int floodFill(int[][] arr,int sr,int sc,String ans,int[][] dir,String[] dirS,ArrayList<String> res)
    {
        int n=arr.length;
        int m=arr[0].length;
        if(sr==n-1 && sc==m-1)
        {
            res.add(ans);
            return 1;
        }
        int count=0;
        arr[sr][sc]=0;
        for(int d=0;d<dir.length;d++)
        {
            int r=sr+dir[d][0];
            int c=sc+dir[d][1];
            if(r>=0 && c>=0 && r<n && c<m && arr[r][c]==1)
            {
                count+=floodFill(arr,r,c,ans+dirS[d],dir,dirS,res);
            }
        }
        arr[sr][sc]=1;
        return count;
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
    int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
    String[] dirS={"U","D","L","R"};
    ArrayList<String> res=new ArrayList<>();
    if(n==0 || m[0][0]==0 || m[n-1][n-1]==0)
    return res;
    floodFill(m,0,0,"",dir,dirS,res);
    Collections.sort(res);
    return res;
    }

    //2. https://practice.geeksforgeeks.org/problems/special-matrix4201/1# 
    //TLE is coming so that will be resolved with DP
    public static int mod=(int)1e9+7;
    public static int floodFill(int[][] arr,int sr,int sc,int[][] dir)
    {
        int n=arr.length;
        int m=arr[0].length;
        if(sr==n-1 && sc==m-1)
        {
            return 1;
        }
        int count=0;
        arr[sr][sc]=1;
        for(int d=0;d<dir.length;d++)
        {
            int r=sr+dir[d][0];
            int c=sc+dir[d][1];
            if(r>=0 && c>=0 && r<n && c<m && arr[r][c]==0)
            {
                count=(count%mod + floodFill(arr,r,c,dir)%mod)%mod;
            }
        }
        arr[sr][sc]=0;
        return count;
    }
    public int FindWays(int n, int m, int[][] blocked_cells)
    {
        // Code here
        int[][] dir={{0,1},{1,0}};
        int[][] arr=new int[n][m];
        for(int[] cell:blocked_cells)
        {
            int i=cell[0]-1;
            int j=cell[1]-1;
            arr[i][j]=1;
        }
        if(arr[0][0]==1 || arr[n-1][m-1]==1)
        {
            return 0;
        }
        return floodFill(arr,0,0,dir);
    }
    //3. Rat in a Maze with multiple steps or jump allowed
    //https://www.geeksforgeeks.org/rat-in-a-maze-with-multiple-steps-jump-allowed/
    public static int floodFill3(int[][] arr,int sr,int sc,String ans,int[][] dir,String[] dirS)
    {
        int n=arr.length;
        int m=arr[0].length;
        if(sr==n-1 && sc==m-1)
        {
            System.out.println(ans);
            return 1;
        }
        int count=0;
        int value=arr[sr][sc];
        arr[sr][sc]=0;
        for(int d=0;d<dir.length;d++)
        {
            for(int i=1;i<=value;i++)
            {
            int r=sr+i*dir[d][0];
            int c=sc+i*dir[d][1];
            if(r>=0 && c>=0 && r<n && c<m)
            {
                    if(arr[r][c]!=0)
                    count+=floodFill3(arr, r, c, ans+dirS[d] , dir, dirS);
            }
            else
            break;
            }
        }
        arr[sr][sc]=value;
        return count;
    }
}