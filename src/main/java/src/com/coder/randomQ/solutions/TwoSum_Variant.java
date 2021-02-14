package com.coder.randomQ.solutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
Write function that takes in a non-empty array of distinct integers and
a target sum. If any two numbers in array sum up to target sum and return it in
a new array. If no such solution exists return empty array.

Note: Target sum has to be obtained by adding two different integers of the array

Sample Input :
array = [3,5,-4,8,11,-1,6]
target = 10

Sample Output:
[-1,11]
 */
public class TwoSum_Variant {
    public static int[] solution(int[] array, int target){
        Set<Integer> list = new HashSet<>();
        for(int num: array){
            int tmp = target - num;
            if(list.contains(tmp)){
                return new int[]{tmp, num};
            }
            list.add(num);
        }
        return new int[0];
    }
    public static void main(String[] args){
        int[] array = {3,5,-4,8,11,-1,6};
        int target = 10;
        int[] result = solution(array, target);
        System.out.println(Arrays.toString(result));
    }
}
