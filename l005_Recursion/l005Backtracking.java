import java.util.*;
public class l005Backtracking {
    public static Scanner scns=new Scanner(System.in);
    public static int mazePath(int sr,int sc,int er,int ec,String ans,int[][] dir,String[] dirS)
    {
        if(sr==er&&sc==ec)
        {
            System.out.println(ans);
            return 1;
        }
        int count=0;
        for(int d=0;d<dir.length;d++)
        {
            int r=sr+dir[d][0];
            int c=sc+dir[d][1];
            if(r>=0 && c>=0 && r<=er && c<=ec)
            {
                count+=mazePath(r,c,er,ec,ans+dirS[d],dir,dirS);
            }
        }
        return count;
    }   
        // asf -> answer so far
        public static void floodfill(int[][] maze, int sr, int sc, String asf,int[][] dir,String[] dirS) {
            int m=maze.length-1;
            int n=maze[0].length-1;
        if(sr==m && sc==n)
        {
            System.out.println(asf);
            return;
        }
        maze[sr][sc]=1;
        for(int d=0;d<4;d++)
        {
            int r=sr+dir[d][0];
            int c=sc+dir[d][1];
            if(r>=0 && c>=0 && r<=m && c<=n && maze[r][c]==0)
            {
                floodfill(maze,r,c,asf+dirS[d],dir,dirS);
            }
        }
        maze[sr][sc]=0;
        }
        public static int floodfill8(int[][] maze,int sr,int sc,String asf,int[][] dir8,String[] dirS8)
        {
            int m=maze.length-1;
            int n=maze[0].length-1;
        if(sr==m && sc==n)
        {
            System.out.println(asf);
            return 1;
        }
        maze[sr][sc]=1;
        int count=0;
        for(int d=0;d<dir8.length;d++)
        {
            int r=sr+dir8[d][0];
            int c=sc+dir8[d][1];
            if(r>=0 && c>=0 && r<=m && c<=n && maze[r][c]==0)
            {
                count+=floodfill8(maze,r,c,asf+dirS8[d],dir8,dirS8);
            }
        }
        maze[sr][sc]=0;
        return count;
        }
        public static int floodfill8withradius(int[][] maze,int sr,int sc,String asf,int rad,int[][] dir8,String[] dirS8)
        {
            int m=maze.length-1;
            int n=maze[0].length-1;
        if(sr==m && sc==n)
        {
            System.out.println(asf);
            return 1;
        }
        maze[sr][sc]=1;
        int count=0;
        for(int d=0;d<dir8.length;d++)
        {
            for(int radius=1;radius<=rad;radius++)
            {
            int r=sr+radius*dir8[d][0];
            int c=sc+radius*dir8[d][1];
            if(r>=0 && c>=0 && r<=m && c<=n)
            {
                if( maze[r][c]==0)
                count+=floodfill8withradius(maze,r,c,asf+dirS8[d],rad,dir8,dirS8);
            }
            else
            break;
        }
        }
        maze[sr][sc]=0;
        return count;
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

    //print only the first path from source to destination that can be any path but only one path
    public static boolean floodFill2(int[][] board,int sr,int sc,String ans,int[][] dir,String[] dirS)
    {
        int n=board.length;
        int m=board[0].length;
        if(sr==n-1 && sc==m-1)
        {
            System.out.println(ans);
            return true;
        }
        boolean res=false;
        board[sr][sc]=0;
        for(int d=0;d<dir.length;d++)
        {
            int r=sr+dir[d][0];
            int c=sc+dir[d][1];
            if(r>=0 && c>=0 && r<n && c<m && board[r][c]==1)
            {
                res=res||floodFill2(board, r, c, ans +dirS[d], dir, dirS);
            }
        }
        board[sr][sc]=1;
        return res;
    }

    //longest length path and shortest length path
    public static int floodFill_longestLen(int[][] board,int sr,int sc,int[][] dir)
    {
        int n=board.length;
        int m=board[0].length;
        if(sr==n-1 && sc==m-1)
        {
            return 0;
        }
        int longestLen=-1;
        board[sr][sc]=0;
        for(int d=0;d<dir.length;d++)
        {
            int r=sr+dir[d][0];
            int c=sc+dir[d][1];
            if(r>=0 && c>=0 && r<n && c<m && board[r][c]==1)
            {
                int res=floodFill_longestLen(board, r, c, dir);
                if(res!=-1  && res+1>longestLen)
                {
                    longestLen=res+1;
                }
            }
        }
        board[sr][sc]=1;
        return longestLen;
    }
    public static int floodFill_shortestLen(int[][] board,int sr,int sc,int[][] dir)
    {
        int n=board.length;
        int m=board[0].length;
        if(sr==n-1 && sc==m-1)
        {
            return 0;
        }
        int shortestLen=(int)1e9;
        board[sr][sc]=0;
        for(int d=0;d<dir.length;d++)
        {
            int r=sr+dir[d][0];
            int c=sc+dir[d][1];
            if(r>=0 && c>=0 && r<n && c<m && board[r][c]==1)
            {
                int res=floodFill_shortestLen(board, r, c, dir);
                if(res!=(int)1e9 && res+1<shortestLen)
                {
                    shortestLen=res+1;
                }
            }
        }
        board[sr][sc]=1;
        return shortestLen;
    }

    //knight tour gfg
    //
    public static boolean knightTour(int[][] board,int sr,int sc,int mov,int[] dirX,int[] dirY)
    {
        int n=board.length;
        int m=board[0].length;
        board[sr][sc]=mov;
        if(mov==n*m-1)
        {
            return true;
        }
        boolean res=false;
        for(int d=0;d<dirX.length;d++)
        {
            int r=sr+dirX[d];
            int c=sc+dirY[d];
            if(r>=0 && c>=0 && r<n && c<m && board[r][c]==-1)
            {
                res=res||knightTour(board, r, c, mov+1, dirX, dirY);
                if(res)
                {
                    return true;
                }
            }
        }
        board[sr][sc]=-1;
        return res;
    }
    public static void knightTour()
    {
        int n=8;
        int[][] board=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                board[i][j]=-1;
            }
        }
        int[] dirX = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int[] dirY = { 1, 2, 2, 1, -1, -2, -2, -1 };
        knightTour(board,0,0,0,dirX,dirY);
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args)
    {
        int[][] dir={{0,1},{1,1},{1,0}};
        String[] dirS={"H","D","V"};
        int[][] dir2={{-1,0},{0,-1},{1,0},{0,1}};
        String[] dirS2={"t","l","d","r"};
        int[][] dir8={{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
        String[] dirS8={"v","e","r","s","d","n","l","w"};
        int[][] dir3={{0,1},{1,0}};
        String[] dirS3={"R","D"};
       // System.out.println(mazePath(0,0,2,2,"",dir,dirS));
       int m=3,n=3;
      // int[][] maze=new int[m][n];
       //System.out.println(floodfill8(maze,0,0,"",dir8,dirS8));
    //    System.out.println(floodfill8withradius(maze,0,0,"",Math.max(m,n),dir8,dirS8));
    int[][] maze={{1,1,1},{1,1,1},{0,1,1}};
    int[][] maze1={ {2, 1, 0, 0},
         {3, 0, 0, 1},
         {0, 1, 0, 1},
          {0, 0, 0, 1}
        };
    int[][] maze2={ 
        {2, 1, 0, 0},
        {2, 0, 0, 1},
        {0, 1, 0, 1},
        {0, 0, 0, 1}
      };

    //System.out.println(floodFill3(maze1, 0, 0, "", dir3, dirS3));
    if(maze[0][0]==0 || maze[n-1][m-1]==0 || n==0 ||m==0)
    System.out.println("not possible");
    else
   //   System.out.println(floodFill2(maze, 0, 0, "", dir3, dirS3));
        // System.out.println(floodFill_longestLen(maze,0, 0, dir2));
        // System.out.println(floodFill_shortestLen(maze,0, 0, dir2));
        //knightTour();
    }
}
