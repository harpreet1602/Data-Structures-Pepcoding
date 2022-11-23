public class ValidSudoku {
    
    // 36. Valid Sudoku
// tc O(9^2)=>O(9*9)=> O(1) sc O((9^2)*3)=>O(1)
// so we just have to check whether it is  a valid Suduko or not so simply take a hashset
// and then add all the cases like the number in a row, col and box and accodingly their string is made
// 0/3=0 , 4/3=1, 6/3=2 => Accordingly box indices are used.
// If we find anything again this means suduko is not valid.
public boolean isValidSudoku(char[][] board) {
    HashSet<String> seen = new HashSet<>();
    int n = board.length, m = board[0].length;
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            char number = board[i][j];
            if(number!='.'){
                if(seen.contains(number+"_R_"+i) ||
                    seen.contains(number+"_C_"+j) ||
                    seen.contains(number+"_B_"+i/3+"_"+j/3)){
                    return false;
                }
                else{
                    seen.add(number+"_R_"+i);
                    seen.add(number+"_C_"+j);
                    seen.add(number+"_B_"+i/3+"_"+j/3);
                }
            }
        }
    }
    return true;
}
}
