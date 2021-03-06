package com.coder.randomQ.solutions;

/*
Given non-negative array where each element represents the height of a pillar of
width 1. Imagine water being poured over all the pillars, write a function that
returns the surface area of the water trapped between pillars
Sample input:
heights = {0,8,0,0,5,0,0,10,0,0,1,1,0,3}
Sample output:
48
*/
//Visual representation
//       |
//       |
// |.....|
// |.....|
// |.....|
// |..|..|
// |..|..|
// |..|..|.....|
// |..|..|.....|
//_|..|..|..||.|
public class WaterSurfaceArea {
    public static void main(String[] args){
        int[] heights = {0,8,0,0,5,0,0,10,0,0,1,1,0,3};
        System.out.println(waterSurfaceArea(heights));
    }
    public static int waterSurfaceArea(int[] heights){
        int[] maxes = new int[heights.length];
        int leftMax = 0;
        for(int i = 0; i < heights.length; i++){
            maxes[i] = leftMax;
            leftMax = Math.max(leftMax, heights[i]);
        }
        int rightMax = 0;
        int surfaceArea = 0;
        for(int i = heights.length-1; i >=0; i--){
            int minHeight = Math.min(maxes[i], rightMax);
            if(heights[i] < minHeight){
                surfaceArea += (minHeight - heights[i]);
            }
            rightMax = Math.max(heights[i], rightMax);
        }
        return surfaceArea;
    }
}
