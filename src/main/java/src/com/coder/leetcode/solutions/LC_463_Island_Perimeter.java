package com.coder.leetcode.solutions;
/*
463. Island Perimeter
You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water,
and there is exactly one island (i.e., one or more connected land cells).
The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island.
One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100.
Determine the perimeter of the island.

Example 1:
Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
Output: 16

Example 2:
Input: grid = [[1]]
Output: 4

Example 3:
Input: grid = [[1,0]]
Output: 4

Constraints:
row == grid.length
col == grid[i].length
1 <= row, col <= 100
grid[i][j] is 0 or 1.
 */
public class LC_463_Island_Perimeter {
    int[][] arr;
    public int islandPerimeter(int[][] grid){
        int perimeter = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        arr = grid;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols;j++){
                if(grid[i][j] == 1){
                    perimeter += checkLeft(i,j)+checkRight(i,j)+checkTop(i,j)+checkBottom(i,j);
                }
            }
        }
        return perimeter;
    }

    private int checkLeft(int row, int col){
        if(row <= 0) return 1;
        return arr[row-1][col] == 1 ? 0 : 1;
    }
    private int checkRight(int row, int col){
        if(row >= arr.length-1) return 1;
        return arr[row+1][col] == 1 ? 0 : 1;
    }
    private int checkTop(int row, int col){
        if(col <= 0) return 1;
        return arr[row][col-1] == 1 ? 0 : 1;
    }
    private int checkBottom(int row, int col){
        if(col >= arr[0].length-1) return 1;
        return arr[row][col+1] == 1 ? 0 : 1;
    }

}
