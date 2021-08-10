import java.util.*;

public class l004_questions {

    // 37. Sudoku Solver
    // In this question for solving the sudoku we are storing the spaces in an ArrayList of Pair
    // then we are traversing through these empty spaces and checking is it valid to place a number there
    // if it then we place the number and go to the next index for placing a number from 1-9
    // and then in backtracking place the . again to figure out the next possibility if we don't get the answer
    // in the end return false but if we got the answer then start returning true
    // when will we get the answer when all the empty spaces  will be filled by the numebers
    // in is valid to place function we will check for the same no. in row,col,submatrix if it is present already 
    // return false otherwise return true;
    
    // in the submatrix 
    
        // imp to figure out this , here the remainder will be finished by dividing and then by multiplying 
        // we can get the starting indices of the submatrix (5,3) => (5/3,3/3) => (1,1) =>(1*3,1*3) =>(3,3)
    public class Pair{
        int r;
        int c;
        Pair(int r, int c)
        {
            this.r = r;
            this.c = c;
        }
    }
    public boolean isValidToPlaceNumber(char[][] board,int r,int c,int num){
//         row
        for(int i = 0 ; i < board[0].length ; i++ )
        {
            if(board[r][i] - '0' == num)
            {
                return false;
            }
        }
//         col
        
        for(int i = 0 ; i < board.length ; i++ )
        {
            if(board[i][c] - '0' == num)
            {
                return false;
            }
        }
        
//         submatrix of 3X3

        // imp to figure out this , here the remainder will be finished by dividing and then by multiplying 
        // we can get the starting indices of the submatrix
        int row = (r/3) * 3;
        int col = (c/3) * 3;
        
        for(int i = 0 ; i < 3 ; i++)
        {
            for(int j = 0 ; j < 3 ; j++)
            {
                if(board[i+row][j+col] - '0' == num)
                {
                    return false;
                }
            }
        }
        return true;
        
    }
    
    
    
    
    
    public boolean solveSudoku(char[][] board, int idx, ArrayList<Pair> spaces)
    {
        if(idx==spaces.size())
        {
            return true;
        }
        Pair p = spaces.get(idx);
        int r = p.r;
        int c = p.c;
        
        for(int num = 1 ; num <= 9; num++)
        {
            if(isValidToPlaceNumber(board,r,c,num)){
                board[r][c] = (char)(num + '0');
                
                if(solveSudoku(board,idx+1,spaces))
                {
                    return true;
                }
                
                board[r][c] = '.';
            }
        }
        return false;
    }
    
    
    
    
    
    public void solveSudoku(char[][] board) {
        ArrayList<Pair> spaces = new ArrayList<>();
        for(int  i = 0 ; i < board.length; i++)
        {
            for(int j = 0 ; j < board[0].length ;j++)
            {
                if(board[i][j] == '.')
                {
                    spaces.add(new Pair(i,j));
                }
            }
        }
        solveSudoku(board,0,spaces);        
    }

    // 36. Valid Sudoku
    

    public int[] rows,cols;
    public int[][] mat;
    
    public boolean isValidSudoku(char[][] board) {
         ArrayList<Pair> spaces = new ArrayList<>();
         rows = new int[9];
         cols = new int[9];
         mat = new int[3][3];
        
        for(int  i = 0 ; i < board.length; i++)
        {
            for(int j = 0 ; j < board[0].length ;j++)
            {
                if(board[i][j] == '.')
                {
                    continue;
                }else{
                    int mask = (1<<(board[i][j] - '0'));
                    if((rows[i] & mask) == 0 && (cols[j] & mask) == 0 && (mat[i/3][j/3] & mask) ==0 ){
                    
                    rows[i] ^= mask;
                    cols[j] ^= mask;
                    mat[i/3][j/3] ^= mask;
            }
                    else
                    {
                        return false;
                    }
                    
                }
            }
        }
       return true;      
    }


    // 37. Sudoku Solver

 
    
    public boolean solveSudoku1(char[][] board, int idx, ArrayList<Pair> spaces)
    {
        if(idx==spaces.size())
        {
            return true;
        }
        Pair p = spaces.get(idx);
        int r = p.r;
        int c = p.c;
        
        for(int num = 1 ; num <= 9; num++)
        {
            int mask = (1 << num);
            if((rows[r] & mask) == 0 && (cols[c] & mask) == 0 && (mat[r/3][c/3] & mask) ==0 )
            {
                board[r][c] = (char)(num + '0');
                rows[r] ^= mask;
                cols[c] ^= mask;
                mat[r/3][c/3] ^= mask;
                if(solveSudoku1(board,idx+1,spaces))
                {
                    return true;
                }
                
                board[r][c] = '.';
                rows[r] ^= mask;
                cols[c] ^= mask;
                mat[r/3][c/3] ^= mask;
            }
        }
        return false;
    }
    
    
public void solveSudoku2(char[][] board) { 
         ArrayList<Pair> spaces = new ArrayList<>();
         rows = new int[9];
         cols = new int[9];
         mat = new int[3][3];
        
        for(int  i = 0 ; i < board.length; i++)
        {
            for(int j = 0 ; j < board[0].length ;j++)
            {
                if(board[i][j] == '.')
                {
                    spaces.add(new Pair(i,j));
                }else{
                    int mask = (1 << (board[i][j] - '0'));
                    rows[i] ^= mask;
                    cols[j] ^= mask;
                    mat[i/3][j/3] ^= mask;
                }
            }
        }
     solveSudoku1(board,0,spaces);      
    }
    
    

    // K Subsets With Equal Sum portal
public static ArrayList<ArrayList<ArrayList<Integer>>> res = new ArrayList<>();

public static void solution(int[] arr, int vidx,int[] subsetSum, ArrayList<ArrayList<Integer>> ans) {
    //write your code here
    
    if(vidx==arr.length)
    {
        int s = subsetSum[0];
        for(int ele:subsetSum)
        {
            if(ele!=s)
            return;
        }
        
        ArrayList<ArrayList<Integer>> sa = new ArrayList<>();
        
        for(ArrayList<Integer> a:ans){
             System.out.print(a+" ");
            sa.add(new ArrayList<>(a));
        }
        System.out.println();
        res.add(sa);
       
        return;
    }
    
    for(int k=0;k<subsetSum.length;k++)
    {
        ArrayList<Integer> list = ans.get(k);
        list.add(arr[vidx]);
        subsetSum[k]+=arr[vidx];
        solution(arr,vidx+1,subsetSum,ans);
        subsetSum[k]-=arr[vidx];
        list.remove(list.size()-1);
        
        if(list.size()==0)
        break;
    }
    
}


}
