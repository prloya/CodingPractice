package com.coder.randomQ.solutions;

import java.util.Arrays;

/*
Given an array representing values of coins in possession, write
a function to return the minimum amount of change that you cannot create.

Sample Input:
coins = [5,7,1,1,2,3,22]

Output: 20

 */
public class Non_Constructible_Change {
    public static int nonConstructibleChange(int[] coins) {
        int change = 0;
        Arrays.sort(coins);
        for (int curr : coins) {
            if (curr > change + 1)
                return change + 1;
            change += curr;
        }
        return change + 1;
    }

    public static void main(String[] args){
        int[] input = new int[] {5, 7, 1, 1, 2, 3, 22};
        System.out.println("Minimum Non-constructible change: " + nonConstructibleChange(input));
    }
}
