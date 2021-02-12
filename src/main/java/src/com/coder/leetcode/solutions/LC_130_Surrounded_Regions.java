package com.coder.leetcode.solutions;
/*
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:
X X X X
X O O X
X X O X
X O X X

After running your function, the board should be:
X X X X
X X X X
X X X X
X O X X

Explanation:
Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are
not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border
will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */
public class LC_130_Surrounded_Regions {
    private final char x = 'X';
    private final char o = 'O';
    private final char m = 'M';
    private char[][] arr;
    public void solve(char[][] board) {
        // check if board is empty
        if(board == null || board.length == 0) return;
        int rows = board.length;
        int cols = board[0].length;
        arr = board;
        for(int i = 0 ;i < cols; i++){
            if(board[0][i] == o){
                dfs(0,i);
            }
            if(board[rows-1][i] == o){
                dfs(rows-1,i);
            }
        }
        for(int i = 0 ;i < cols; i++){
            if(board[i][0] == o){
                dfs(i,0);
            }
            if(board[i][cols-1] == o){
                dfs(i,cols-1);
            }
        }
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == o)
                    board[i][j] = x;
                if(board[i][j] == m)
                    board[i][j] = o;
            }
        }
    }
    private void dfs(int row, int col){
        //check out of bound for row, col
        if(row < 0 || row >= arr.length) return;
        if(col < 0 || col >= arr[0].length) return;
        //check if the current cell value is x or m then do nothing
        if(arr[row][col] == x || arr[row][col] == m) return;
        //mark the cell value to m as its adjacent to border 'O'
        arr[row][col] = m;
        //traverse depth-first-search in all directions
        dfs(row-1, col);
        dfs(row+1, col);
        dfs(row, col-1);
        dfs(row, col+1);
    }
}
