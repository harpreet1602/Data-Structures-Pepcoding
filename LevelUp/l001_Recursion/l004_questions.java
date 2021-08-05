import java.util.*;

public class l004_questions {

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




}
