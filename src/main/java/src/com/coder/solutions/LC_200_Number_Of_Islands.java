package com.coder.solutions;
/*
Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

Example 1:
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3

Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
 */

public class LC_200_Number_Of_Islands {
    char[][] matrix;
    private final char LAND = '1';
    private final char WATER = '0';
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;
        matrix = grid;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == LAND){
                    islands++;
                    checkIslands(i,j);
                }
            }
        }
        return islands;
    }

    private void checkIslands(int row, int col){
        //check out of bounds for row & col
        if(row < 0 || row > matrix.length-1) return;
        if(col < 0 || col > matrix[0].length-1) return;
        //check if current cell is water
        if(matrix[row][col]== WATER) return;
        //check if current cell is land and checkIsland in all 4 directions
        //mark the cell as completed by flipping the val
        matrix[row][col] = WATER;
        //traverse all 4 directions top,bottom, right, left
        checkIslands(row+1, col);
        checkIslands(row-1, col);
        checkIslands(row,col+1);
        checkIslands(row, col-1);
    }
}
