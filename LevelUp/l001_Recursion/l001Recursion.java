import java.util.ArrayList;
public class l001Recursion {
    public static void pppppp(int a) {
        System.out.println("I am Base case: " + a);
        return;
    }

    public static void ppppp(int a) {
        System.out.println("hi: " + a);
        pppppp(a + 1);
        System.out.println("Bye: " + a);
    }

    public static void pppp(int a) {
        System.out.println("hi: " + a);
        ppppp(a + 1);
        System.out.println("Bye: " + a);
    }

    public static void ppp(int a) {
        System.out.println("hi: " + a);
        pppp(a + 1);
        System.out.println("Bye: " + a);
    }

    public static void pp(int a) {
        System.out.println("hi: " + a);
        ppp(a + 1);
        System.out.println("Bye: " + a);
    }

    public static void p(int a) {
        System.out.println("hi: " + a);
        pp(a + 1);
        System.out.println("Bye: " + a);
    }

    public static void recursionPattern(int a, int b) {
        if (a == b) {
            System.out.println("I am Base case: " + a);
            return;
        }

        System.out.println("Hi" + a);
        recursionPattern(a + 1, b);
        System.out.println("Bye" + a);
    }

    public static void printIncreasing(int a, int b) {
        if(a==b)
        {
            System.out.println(a);
            return;
        }
        System.out.println(a);
        printIncreasing(a + 1, b);

    }

    public static void printDecreasing(int a, int b) {
        if(a==b)
        {
            System.out.println(a);
            return;
        }
        
        printDecreasing(a + 1, b);
        System.out.println(a);
    }

    public static void printIncreasingDecreasing(int a, int b) {
        if(a==b)
        {
            System.out.println(a);
            return;
        }
        System.out.println(a);
        printIncreasingDecreasing(a + 1, b);
        System.out.println(a);
    }

    public static void oddEven(int a, int b) {
        if(a>b)
        {
            return;
        }

        if(a%2!=0)
        System.out.println(a);
        oddEven(a + 1, b);
        
        if(a%2==0)
        System.out.println(a);
    }

    public static int factorial(int n) {
        if(n==0)
        {
        return 1;
        }
        int recAns = factorial(n-1); 
        return n*recAns;
    }

    public static int power(int a, int b) {
        if(b==0)
        {
            return 1;
        }

        int recAns = power(a,b-1);
        return recAns*a;
    }

    // O(logn)
    public static int powerBtr(int a, int b) {
        if(b==0)
        return 1;

        int recAns = powerBtr(a,b/2);
        recAns*=recAns;

        return b%2==0?recAns:recAns*a;
    }

    public static void printArray(int[] arr,int index) {
        if(index == arr.length)
        return;

        System.out.println(arr[index]);
        printArray(arr, index+1);
    }

    public static void printArrayReverse(int[] arr,int index) {
        if(index==arr.length)
        return;

        printArrayReverse(arr, index+1);
        System.out.println(arr[index]);
    }

    public static int maximum(int[] arr,int index) {
        if(index==arr.length)
        return -(int)1e9;

        int recAns = maximum(arr,index+1);
        return Math.max(recAns,arr[index]);
    }

    public static int minimum(int[] arr,int index) {
        if(index==arr.length)
        return (int)1e9;

        int recAns = maximum(arr,index+1);
        return Math.min(recAns,arr[index]);
    }

    public static boolean find(int[] arr, int data,int index) {
        if(index==arr.length)
        return false;

        if(arr[index] == data)
        return true;

        return find(arr, data, index+1);

    }

    public static int firstIndex(int[] arr, int data,int index) {
        if(index == arr.length)
        return -1;

        if(arr[index] == data)
        {
            return index;
        }
        return firstIndex(arr, data, index+1);
    }

    public static int lastIndex(int[] arr, int data,int index) {
        if(index == arr.length)
        return -1;

        int recAns = lastIndex(arr, data, index+1);
        if(recAns != -1)
        return recAns;

        if(arr[index] == data)
        {
            return index;
        }else{
            return -1;
        }
    }
    public static boolean firstAndLastIndex(int[] arr,int data,int index,int[] ans,boolean res1)
    {
        if(index == arr.length)
        {
            return false;
        }

        if(res1!=true && arr[index] == data)
        {
            ans[0] = index;
            res1=true;
        }


        boolean res = firstAndLastIndex(arr, data, index+1, ans,res1);

        if(res)
        {
            return true;
        }

        if(arr[index] == data)
        {
            ans[1] = index;
            return true;
        }

        return false;
    }
    public static int[] allIndex(int[] arr, int data, int idx, int count)
    {
        if(idx==arr.length)
        {
            return new int[count];
        }

        if(arr[idx]==data)
        {
           count++;
        }

        int[] ans=allIndex(arr, data, idx+1, count);

        if(arr[idx]==data)
        {
            ans[count-1]=idx;
        }
        return ans;

    }

    public static ArrayList<String> subsequence(String str, int idx)
    {
        if(idx==str.length())
        {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        char ch = str.charAt(idx);
       ArrayList<String> recAns =  subsequence(str, idx+1);
        ArrayList<String> myAns = new ArrayList<>();
        for(String s : recAns)
        {
            myAns.add(s);
            myAns.add(ch+s);
        }
        return myAns;
    }
    public static int subsequence(String str, int idx, String asf,ArrayList<String> ans)
    {
        if(idx==str.length())
        {
            ans.add(asf);
            return 1;
        }

        char ch = str.charAt(idx);
        int count = 0;
        count += subsequence(str, idx+1, asf, ans);
        count += subsequence(str, idx+1, asf + ch, ans);
        return count;
    }


    public static String[] nokiaKeys = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

    public static int nokiaKeyPad(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return 1;
        }
        int count=0;
      return count;

    }

    // public static int stairPath(int n, String psf,ArrayList<String> ans) {

    // }

    // public static int boardPath(int n, String psf,ArrayList<String> ans) {

    // }

    // public static int boardPath(int[] arr, int n, String ans) {

    // }

        
    public static ArrayList<String> stairPath(int n) {
        if (n == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> myAns = new ArrayList<>();
        for (int jump = 1; jump <= 3 && n - jump >= 0; jump++) {
            ArrayList<String> smallAns = stairPath(n - jump);
            for (String s : smallAns) {
                myAns.add(jump + s);
            }
        }

        return myAns;
    }

    public static int stairPath(int n, String psf, ArrayList<String> ans) {
        if (n == 0) {
            ans.add(psf);
            return 1;
        }

        int count = 0;
        for (int jump = 1; jump <= 3 && n - jump >= 0; jump++) {
            count += stairPath(n - jump, psf + jump, ans);
        }

        return count;
    }

    public static int boardPath(int n, String psf, ArrayList<String> ans) {
        if (n == 0) {
            ans.add(psf);
            return 1;
        }

        int count = 0;
        for (int dice = 1; dice <= 6 && n - dice >= 0; dice++) {
            count += boardPath(n - dice, psf + dice, ans);
        }

        return count;
    }

    public static int boardPath(int[] arr, int n, String psf, ArrayList<String> ans) {
        if (n == 0) {
            ans.add(psf);
            return 1;
        }

        int count = 0;
        for (int i = 1; i < arr.length && n - arr[i] >= 0; i++) {
            count += boardPath(arr, n - arr[i], psf + arr[i], ans);
        }

        return count;
    }






    //https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1#
    public static int mazePath(int[][] m,int sr,int sc,int er,int ec,String psf,int[][] dir,String[] dirS,ArrayList<String> ans){
        if(sr == er && sc == ec)
        {
            ans.add(psf);
            return 1;
        }
        
        m[sr][sc] = 0;
        int count =0;
        for(int d = 0;d<dir.length;d++)
        {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            
            if(r>=0 && c>=0 && r<=er && c<=ec && m[r][c] == 1)
            {
                count+=  mazePath(m,r,c,er,ec,psf+dirS[d],dir,dirS,ans);
            }
        }
        m[sr][sc]=1;
        return count;
    }
    
    
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        int[][] dir = { {1,0},{0,-1},{0,1},{-1,0}};
        String[] dirS = { "D","L","R","U"};
        ArrayList<String> ans= new ArrayList<>();
        if(n== 0 || m[0][0] ==0 || m[n-1][n-1] ==0)
        return ans;
        
        mazePath(m,0,0,n-1,n-1,"",dir,dirS,ans);
        
        // Collections.sort(ans);
        return ans;
        
        
    }
    //https://practice.geeksforgeeks.org/problems/special-matrix4201/1#
    public static int mod = (int)1e9 +7;
    public static int mazePath(int[][] m,int sr,int sc,int er,int ec,int[][] dir){
        if(sr == er && sc == ec)
        {
            return 1;
        }
        
        int count =0;
        for(int d = 0;d<dir.length;d++)
        {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            
            if(r>=0 && c>=0 && r<=er && c<=ec && m[r][c] == 0)
            {
                count= count%mod  + mazePath(m,r,c,er,ec,dir)%mod;
            }
        }
        return count;
    }
    
    
    
    
    
    
    
    public int FindWays(int n, int m, int[][] blocked_cells)
    {
        // Code here
        int[][] arr = new int[n][m];
        for(int[] cell : blocked_cells)
        {
            int i  = cell[0] - 1;
            int j =cell[1] - 1;
            arr[i][j] = 1;
        }
        
        if(n==0 || m==0 || arr[0][0] == 1 || arr[n-1][m-1] ==1)
        return 0;
        
        int[][] dir ={{0,1},{1,0}};
        return mazePath(arr,0,0,n-1,m-1,dir);
    }




    public static int mazePath_HVD_multi(int[][] m,int sr, int sc, int er, int ec,  String psf,int[][] dir,String[] dirS,ArrayList<String> ans) {
        if(sr == er && sc == ec)
        {
            ans.add(psf);
            return 1;
        }
        
        m[sr][sc] = 0;
        int count =0;
        for(int d = 0;d<dir.length;d++)
        {
            for(int radius=0; radius<=Math.max(er,ec);radius++)
            {
            int r = sr + radius*dir[d][0];
            int c = sc + radius*dir[d][1];
            
            if(r>=0 && c>=0 && r<=er && c<=ec && m[r][c] == 1)
            {
                count+=  mazePath_HVD_multi(m,r,c,er,ec,psf+dirS[d],dir,dirS,ans);
            }
            }
        }
        m[sr][sc]=1;
        return count;

    }


    // https://www.geeksforgeeks.org/a-variation-of-rat-in-a-maze-multiple-steps-or-jumps-allowed/?ref=rp
// ISE BHI KARNA KABHI


    //gold mine 2
    //isme sabka sum banana hota hai component ka 
    static int max = 0;
	
	public static void travelAndCollect(int[][] arr,int sr ,int sc,int[][] dir,boolean[][] vis,ArrayList<Integer> bag){
        for(int d = 0;d<dir.length;d++)
        {
            int r = sr+dir[d][0];
            int c = sc + dir[d][1];
            if(r>=0 && c>=0 && r<arr.length && c<arr[0].length && arr[r][c]!=0 && vis[r][c] == false)
            {
                vis[r][c] = true;
                bag.add(arr[r][c]);
                travelAndCollect(arr, r , c , dir, vis,bag);
            }
        }
	}
	public static void getMaxGold(int[][] arr){
		//write your code here
		int[][] dir = {{0,-1},{0,1},{-1,0},{1,0}};
		boolean[][] vis = new boolean[arr.length][arr[0].length];
		for(int  i = 0 ;i <arr.length; i++)
		{
		    for(int j = 0;j <arr[0].length;j++)
		    {
		         ArrayList<Integer> bag = new ArrayList<>();
		        if(arr[i][j]!= 0 && vis[i][j] == false)
		        {
		           
		            travelAndCollect(arr, i , j , dir, vis, bag);
		        }
		        int sum =0 ;
		        for(int val : bag)
		        {
		            sum+=val;
		        }
		        if(sum>max)
		        max=sum;
		    }
		}	
	}


    //leetcode 1219 Path with Maximum Gold
    public int getMaxGold(int[][] grid,int sr,int sc,int[][] dir)
    {
        int maxGold = 0,n=grid.length,m=grid[0].length;
        grid[sr][sc] = -grid[sr][sc];
        for(int d=0;d<dir.length;d++)
        {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            if(r>=0 && c >=0 && r<n && c<m && grid[r][c]>0)
            {
                int recGold = getMaxGold(grid,r,c,dir);
                if(recGold>maxGold)
                    maxGold = recGold;
            }
        }
        grid[sr][sc] = -grid[sr][sc];
     return maxGold + grid[sr][sc];
    }

    
    public int getMaximumGold(int[][] grid) {
           int maxGold = 0,n=grid.length,m=grid[0].length;
        int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
        for(int i = 0 ; i < n; i++)
        {
            for(int j = 0 ; j< m;j++)
            {
                maxGold = Math.max(maxGold,getMaxGold(grid,i,j,dir));
            }
        }
        return maxGold;
    }
//gfg
//https://practice.geeksforgeeks.org/problems/gold-mine-problem2608/1#
static int maxGold(int n, int m, int grid[][])
{
    // code here
    int maxGold = 0;
    int[][] dir = {{-1,1},{0,1},{1,1}};
    for(int i = 0 ; i < n; i++)
    {
        // for(int j = 0 ; j< m;j++)
        // {
            maxGold = Math.max(maxGold,getMaxGold1(grid,i,0,dir));
        // }
    }
    return maxGold;
}

   
static int getMaxGold1(int[][] grid,int sr,int sc,int[][] dir)
{
    int maxGold = 0,n=grid.length,m=grid[0].length;
    grid[sr][sc] = -grid[sr][sc];
    for(int d=0;d<dir.length;d++)
    {
        int r = sr + dir[d][0];
        int c = sc + dir[d][1];
        if(r>=0 && c >=0 && r<n && c<m && grid[r][c]>0)
        {
            int recGold = getMaxGold1(grid,r,c,dir);
            if(recGold>maxGold)
                maxGold = recGold;
        }
    }
    grid[sr][sc] = -grid[sr][sc];
 return maxGold + grid[sr][sc];
}

// Friends Pairing - 2
static int counter = 1;

public static void solution(int i, int n, boolean[] used, String asf) {
  // write your code here
  if(i==n+1)
  {
      System.out.println(counter++ + "." + asf);
      return;
  }
  
  int fup = 1; //first unused person
  while(fup<=n && used[fup])
  fup++;
  used[fup]=true;
  solution(i+1,n,used, asf+ "(" + fup +") ");
  
  for(int pp = fup+1;pp<=n;pp++)
  {
      if(!used[pp])
      {
          used[pp]=true;
          solution(i+2,n,used,asf+"("+fup+","+pp+") ");
          used[pp]=false;
      }
  }
  used[fup]=false;
  
}
    

    


    public static void main(String[] args) {
        // recursionPattern(1, 6);
        // int[] arr = {1,2,3,4,5,1};
        // int a=2,b=3,data=1,index=0,n=5,count=0;
    //     printIncreasing(a, b);
    //     System.out.println();
    //     printDecreasing(a, b);
    //     System.out.println();
    //     printIncreasingDecreasing(a, b);
    //     System.out.println();
    //     oddEven(a, b);
    //     System.out.println();
    //    System.out.println(power(a, b));
    //    System.out.println();
    //   System.out.println(factorial(n));
    //   System.out.println();
    //     printArray(arr, index);
    //     System.out.println();
    //     printArrayReverse(arr, index);
    //     System.out.println();
    //   System.out.println(find(arr, data, index));
    //   System.out.println();
    //   System.out.println(firstIndex(arr, data, index));
    //   System.out.println(); 
    //   System.out.println(lastIndex(arr, data, index));
    //   System.out.println(); 
    //   System.out.println(powerBtr(a, b));
    //   System.out.println();
    //   System.out.println(maximum(arr, index));
    //   System.out.println(); 
    //   System.out.println(minimum(arr, index));
    // int[] ans = new int[2];
    //     System.out.println(firstAndLastIndex(arr,data,0,ans,false));
    //     for(int  i = 0;i<ans.length;i++)
    //     System.out.println(ans[i]);
    // int[] ans = allIndex(arr, data, index, count);
    // for(int i =0 ;i <ans.length ; i++)
    // System.out.println(ans[i]);
    
    
//  System.out.println(subsequence("abc", 0));
    // ArrayList<String> ans = new ArrayList<>();
    // subsequence("abc", 0, "", ans);
    // System.out.println(ans);



    // mazePath_HVD_multi(m,0, 0,2, 2, "",dir, dirS, ans);




}
}