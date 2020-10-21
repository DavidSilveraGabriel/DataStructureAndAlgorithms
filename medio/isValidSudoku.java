/*Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

A partially filled sudoku which is valid.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

Example 1:

Input:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: true
Example 2:

Input:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being 
    modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
The given board contain only digits 1-9 and the character '.'.
The given board size is always 9x9.*/

//thanks to heisenbergknocks
/*class Solution {
   public boolean isValidSudoku(char[][] board) {
        List<boolean[]> subBoxCheckList = fillBooleanList(3);
        List<boolean[]> colmsCheckList = fillBooleanList(9);
        boolean[] row;
        for(int i = 0; i < board.length; i++){
            row = new boolean[10];
            for(int j = 0; j < board.length; j++){
                if(board[i][j] != '.') {
                    if(row[board[i][j] - 48]) {return false;}
                    else row[board[i][j] - 48] = true;
                    if(colmsCheckList.get(j)[board[i][j] - 48]) {return false;}
                    else colmsCheckList.get(j)[board[i][j] - 48] = true;
                    int subBoxIndex = (j / 3);
                    if(subBoxCheckList.get(subBoxIndex)[board[i][j] - 48]) {return false;}
                    else {subBoxCheckList.get(subBoxIndex)[board[i][j] - 48] = true;}
                }
            }
            if((i + 1) % 3 == 0) subBoxCheckList = fillBooleanList(3);
        }
        return true;
    }
    private List<boolean[]> fillBooleanList(int size){
        List<boolean[]> list = new ArrayList<>();
        while(size != 0){
            list.add(new boolean[10]);
            size--;
        }
        return list;
    }
}*/

//hash map thanks to sharb
class Solution {
    public boolean isValidSudoku(char[][] board) {
        // possible rows[],cols[],boxes[]
        // data intialization
        HashMap<Integer,Integer> rows[]=new HashMap[9];
        HashMap<Integer,Integer> cols[]=new HashMap[9];
        HashMap<Integer,Integer> boxes[]=new HashMap[9];
        for(int i=0;i<9;i++){
            rows[i]=new HashMap();
            cols[i]=new HashMap();
            boxes[i]=new HashMap();
        }
        // we have totatl 9 boxes so to iterate over each induivdual box  we have -> box=(i/3)*3+j/3
        // validate on each box if there is multiple entries for sma enumber then return false;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char num=board[i][j];
                if(num!='.'){
                    int n=(int)num;
                    int box_index=(i/3)*3+(j/3);
                    // keep the track of current cell value i.e. n
                    rows[i].put(n,rows[i].getOrDefault(n,0)+1);
                    cols[j].put(n,cols[j].getOrDefault(n,0)+1);
                    boxes[box_index].put(n,boxes[box_index].getOrDefault(n,0)+1);  
                    if(rows[i].get(n)>1||cols[j].get(n)>1||boxes[box_index].get(n)>1)
                        return false;
                }
            }
        }
        return true;
    }
}