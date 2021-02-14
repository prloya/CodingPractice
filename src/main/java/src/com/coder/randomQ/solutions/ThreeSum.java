package com.coder.randomQ.solutions;

import java.util.ArrayList;
import java.util.Arrays;

/*
Write function that takes non-empty array of distinct integers and a target
sum. The function should find all triplets in the array that sum up to the
target value.

If no such value exists return empty array.
 */
public class ThreeSum {
    public static void main(String[] args){
        ArrayList<Integer[]> result = threeNumberSum(new int[] {12, 3, 1, 2, -6, 5, -8, 6}, 0);
        for(Integer[] list : result)
            System.out.print(Arrays.toString(list));
    }

    public static ArrayList<Integer[]> threeNumberSum(int[] array, int target){
        ArrayList<Integer[]> result = new ArrayList<>();
        Arrays.sort(array);
        for(int i = 0; i< array.length - 2; i++){
            int left = i + 1;
            int right = array.length - 1;
            while(left < right){
                int currSum = array[i] + array[left] + array[right];
                if(target == currSum){
                    result.add(new Integer[] {array[i], array[left], array[right]});
                    left++;
                    right--;
                }else if(currSum < target)
                    left++;
                else
                    right--;
            }
        }
        return result;
    }
}
