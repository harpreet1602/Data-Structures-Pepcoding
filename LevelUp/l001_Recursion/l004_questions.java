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




}
