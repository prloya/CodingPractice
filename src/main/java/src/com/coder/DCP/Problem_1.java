package com.coder.DCP;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
Problem 1
Given a list of numbers, return whether any two sums to k.
For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

Bonus: Can you do this in one pass?
 */
public class Problem_1 {
    public static void main(String[] args) {
        int[] array = {10, 15, 3, 7};
        int target = 17;
        System.out.println("Check two sums for array : " + Arrays.toString(array) + " target: " + target+ " = " + checkSums(array,target));
    }

    private static boolean checkSums(int[] array, int target) {
        Set<Integer> pairs = new HashSet<>();
        for(int num: array){
            if(pairs.contains(target - num)){
                return true;
            }
            pairs.add(num);
        }
        return false;
    }
}
