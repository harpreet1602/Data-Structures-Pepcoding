import java.util.*;
public class l003NQueenSet {
    
    //ek direction mai har ek radius pai ceck karke aa kahi queen present hai to bhai 
    //not safe to place a queen and jaha radius out of bound ho vhi sai break kardo
    //radius ko us direction mai and proceed to next direction
    public static boolean isSafeToPlace(boolean[][] box,int sr,int sc)
    {
        int[][] dir={{0,-1},{-1,-1},{-1,0},{-1,1}};
        int n=box.length,m=box[0].length;
        for(int d=0;d<dir.length;d++)
        {
            for(int rad=1;rad<n;rad++)
            {
                int r = sr + rad*dir[d][0];
                int c = sc + rad*dir[d][1];
                if(r>=0 && c>=0 && r<n && c<m)
                {
                    if(box[r][c])
                    return false;
                }
                else
                break;
            }
        }
        return true;
    }

    public static boolean isSafeToPlacePermute(boolean[][] box,int sr,int sc)
    {
        int[][] dir={{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};
        int n=box.length,m=box[0].length;
        for(int d=0;d<dir.length;d++)
        {
            for(int rad=1;rad<n;rad++)
            {
                int r = sr + rad*dir[d][0];
                int c = sc + rad*dir[d][1];
                if(r>=0 && c>=0 && r<n && c<m)
                {
                    if(box[r][c])
                    return false;
                }
                else
                break;
            }
        }
        return true;
    }

    //combinations
    public static int nQueen_01(boolean[][] box,int bno,int tnq,String asf)
    {
        if(tnq==0)
        {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        int n = box.length,m=box[0].length;
        for(int b = bno;b<n*m;b++)
        {
            int r = b/m;
            int c = b%m;
            if(isSafeToPlace(box,r,c))   //queens placed far mai chota sa addition
            {
                box[r][c]=true;
                count+=nQueen_01(box, b+1, tnq-1, asf+"("+r+","+c+") ");
                box[r][c]=false;
            }
        }
        return count;
    }


    //permutations
    public static int nQueen_02Permute(boolean[][] box,int bno,int tnq,String asf,boolean[][] vis)
    {
        if(tnq==0)
        {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        int n = box.length,m=box[0].length;
        for(int b = 0;b<n*m;b++)
        {
            int r = b/m;
            int c = b%m;
            if(!vis[r][c])
            {
                vis[r][c]=true;
            if(isSafeToPlacePermute(box,r,c))
            {
                box[r][c]=true;
                count+=nQueen_02Permute(box, b+1, tnq-1, asf+"("+r+","+c+") ",vis);
                box[r][c]=false;
            }
            vis[r][c]=false;
            }
        }
        return count;
    }

    static boolean[] row,col,diag,adiag;
    public static int nqueen_03Optimize(int n,int m,int bno,int tnq,String asf)
    {
        if(tnq==0)
        {
            System.out.println(asf);
            return 1;

        }
        int count=0;
        
        for(int b=bno;b<n*m;b++)
        {
            int r = b/m;
            int c = b%m;
            if(!row[r] && !col[c] && !diag[r+c] && !adiag[r-c+m-1])
            {
                row[r] = col[c] = diag[r+c] = adiag[r-c+m-1] = true;
                count+=nqueen_03Optimize(n,m,b+1,tnq-1,asf+"("+r+","+c+") ");
                row[r] = col[c] = diag[r+c] = adiag[r-c+m-1] = false;   
            }
        }
        return count;
    }

    public static int nqueen_03OptimizeCombination(int n,int m,int bno,int tnq,String asf)
    {
        if(tnq==0)
        {
            System.out.println(asf);
            return 1;

        }
        int count=0;
        
        for(int b=bno;b<n*m;b++)
        {
            int r = b/m;
            int c = b%m;
            if(!row[r] && !col[c] && !diag[r+c] && !adiag[r-c+m-1])
            {
                row[r] = col[c] = diag[r+c] = adiag[r-c+m-1] = true;
                count+=nqueen_03OptimizeCombination(n,m,b+1,tnq-1,asf+"("+r+","+c+") ");
                row[r] = col[c] = diag[r+c] = adiag[r-c+m-1] = false;   
            }
        }
        return count;
    }

    public static int nqueen_03OptimizePermutation(int n,int m,int tnq,String asf)
    {
        if(tnq==0)
        {
            System.out.println(asf);
            return 1;

        }
        int count=0;
        
        for(int b=0;b<n*m;b++)
        {
            int r = b/m;
            int c = b%m;
            if(!row[r] && !col[c] && !diag[r+c] && !adiag[r-c+m-1])
            {
                row[r] = col[c] = diag[r+c] = adiag[r-c+m-1] = true;
                count+=nqueen_03OptimizePermutation(n,m,tnq-1,asf+"("+r+","+c+") ");
                row[r] = col[c] = diag[r+c] = adiag[r-c+m-1] = false;   
            }
        }
        return count;
    }
    public static int nqueen_03OptimizeCombinationFirst(int n,int m,int bno,int tnq,String asf)
    {
        if(tnq==0)
        {
            System.out.println(asf);
            return 1;

        }
        int count=0;
        
        for(int b=bno;b<n*m;b++)
        {
            int r = b/m;
            int c = b%m;
            if(!row[r] && !col[c] && !diag[r+c] && !adiag[r-c+m-1])
            {
                row[r] = col[c] = diag[r+c] = adiag[r-c+m-1] = true;
                count+=nqueen_03OptimizeCombinationFirst(n,m,b+1,tnq-1,asf+"("+r+","+c+") ");
                row[r] = col[c] = diag[r+c] = adiag[r-c+m-1] = false;   
            }
            if(count==1)
            return count;
        }
        return count;
    }



    
    public static int nqueen_04FurtherOptimizeCombination(int n,int m,int floor,int tnq,String asf)
    {
        if(tnq==0)
        {
            System.out.println(asf);
            return 1;

        }
        int count=0;
        //ek floor pai ek queen hi assigned hai 
        //it will reduce the no. of calls
        for(int room=0;room<m;room++)
        {
            int r = floor;
            int c = room;
            if( !col[c] && !diag[r+c] && !adiag[r-c+m-1])
            {
                col[c] = diag[r+c] = adiag[r-c+m-1] = true;
                count+=nqueen_04FurtherOptimizeCombination(n,m,floor+1,tnq-1,asf+"("+r+","+c+") ");
                col[c] = diag[r+c] = adiag[r-c+m-1] = false;   
            }
        }
        return count;
    }

    public static int nqueen_04FurtherOptimizePermutation(int n,int m,int floor,int tnq,String asf)
    {
        if(tnq==0 || floor>=n)
        {
            if(tnq==0)
            {
            System.out.println(asf);
            return 1;
            }
            return 0;
        }
        int count=0;
        //ek floor pai ek queen hi assigned hai 
        //it will reduce the no. of calls
        for(int room=0;room<m;room++)
        {
            int r = floor;
            int c = room;
            if(!row[r]&& !col[c] && !diag[r+c] && !adiag[r-c+m-1])
            {
                row[r] = col[c] = diag[r+c] = adiag[r-c+m-1] = true;
                count+=nqueen_04FurtherOptimizePermutation(n,m,0,tnq-1,asf+"("+r+","+c+") ");
                row[r] = col[c] = diag[r+c] = adiag[r-c+m-1] = false;   
            }
        }

        count+=nqueen_04FurtherOptimizePermutation(n,m,floor+1,tnq,asf);
        return count;
    }
    

    //leetcode 52 N-Queens II

    public static int nqueen_04FurtherOptimizeCombination(int n,int m,int floor,int tnq)
  {
      if(tnq==0)
      {
          return 1;

      }
      int count=0;
      //ek floor pai ek queen hi assigned hai 
      //it will reduce the no. of calls
      for(int room=0;room<m;room++)
      {
          int r = floor;
          int c = room;
          if( !col[c] && !diag[r+c] && !adiag[r-c+m-1])
          {
              col[c] = diag[r+c] = adiag[r-c+m-1] = true;
              count+=nqueen_04FurtherOptimizeCombination(n,m,floor+1,tnq-1);
              col[c] = diag[r+c] = adiag[r-c+m-1] = false;   
          }
      }
      return count;
  }
  
  
  
  
  
  public int totalNQueens(int n) {
      int m=n,tnq=n,floor=0;
       row = new boolean[n]; 
      col = new boolean[m];
      diag = new boolean[m+n-1];
      adiag = new boolean[m+n-1];
         return  nqueen_04FurtherOptimizeCombination(n,m,floor,tnq);
  }

  //leetcode 51  N-Queens

  








    public static void nqueen()
    {
        int n=4,m=4;
        // boolean[][] box = new boolean[n][n];
        // boolean[][] vis = new boolean[n][n];
    //   System.out.println(nQueen_01(box, 0, n, ""));
    // System.out.println(nQueen_02Permute(box, 0, n, "",vis));

    row = new boolean[n]; 
    col = new boolean[m];
    diag = new boolean[m+n-1];
    adiag = new boolean[m+n-1];
    int tnq=4,floor=0;
    String asf="";
//    System.out.println(nqueen_03OptimizeCombination(n, m, 0, 4, ""));
    // System.out.println(nqueen_03OptimizePermutation(n, m, 4, ""));
    // System.out.println(nqueen_03OptimizeCombinationFirst(n, m, 0, 4, ""));
    // System.out.println(nqueen_04FurtherOptimizeCombination(n, m, 0, tnq, ""));
    System.out.println(nqueen_04FurtherOptimizePermutation(n, m, floor, tnq, asf));
    }
    public static void main(String[] args)
    {
        nqueen();
    }


}
