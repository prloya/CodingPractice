package com.coder.DCP;
/*
This problem was asked by Stripe.

Given an array of integers, find the first missing positive integer in linear time and constant space.
In other words, find the lowest positive integer that does not exist in the array.
The array can contain duplicates and negative numbers as well.

For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.

You can modify the input array in-place.
 */
public class Problem_4 {
    public static void main(String[] args) {
        //Sum of natural numbers from 1 to n is n*(n+1)/2
        int[] array = {3,4,-1,2,1,5,8,7};
        int count = 0, sum = 0;
        for(int i = 0;i < array.length ; i++){
            if(array[i] <= 0) continue;
            count++;
            sum += array[i];
        }
        count = count + 1;
        int _sum = (count) * (count + 1) / 2;
        System.out.println("Missing number = " + Math.abs(_sum - sum));
    }
}
