package com.coder.randomQ.solutions;

import java.util.Arrays;

/*
Write function that takes in two non-empty array of integers, finds the pair of
numbers (one from each array) whose absolute difference is closest to zero,
and returns an array containing these two numbers, with the number from the
first array in the first position.
Sample Input:
{"arrayOne": [-1, 5, 10, 20, 28, 3], "arrayTwo": [26, 134, 135, 15, 17]}

Sample Output:
[28,26]
 */
public class Smallest_Difference {
    public static void main(String[] args){
        System.out.println(
                Arrays.toString(
                        smallestDifference(new int[] {-1, 5, 10, 20, 28, 3},
                                new int[] {26, 134, 135, 15, 17})));

    }

    public static int[] smallestDifference(int[] array1, int[] array2){
        Arrays.sort(array1);
        Arrays.sort(array2);
        int itr1 = 0, itr2 = 0;
        int smallestDiff = Integer.MAX_VALUE;
        int currDiff;
        int[] smallestPair = new int[2];
        while(itr1 < array1.length && itr2 < array2.length){
            int num1 = array1[itr1];
            int num2 = array2[itr2];
            if(num1 < num2){
                itr1++;
                currDiff = num2 - num1;
            }else if(num1 > num2){
                itr2++;
                currDiff = num1 - num2;
            }else{
                return new int[] {num1, num2};
            }
            if(smallestDiff > currDiff){
                smallestDiff = currDiff;
                smallestPair = new int[] {num1, num2};
            }
        }
        return smallestPair;
    }
}
