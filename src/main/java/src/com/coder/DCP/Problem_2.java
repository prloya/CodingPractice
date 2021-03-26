package com.coder.DCP;

import java.util.Arrays;

/*
Problem 2
This problem was asked by Uber.

Given an array of integers, return a new array such that each element at index i of the new array is the product of all
the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be
[120, 60, 40, 30, 24].
If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division?
 */
public class Problem_2 {
    public static void main(String[] args) {
        int arr1[] = {1, 2, 3, 4, 5};
        int arr2[] = {3, 2, 1};

        System.out.println(Arrays.toString(productsAll(arr1)));
        System.out.println(Arrays.toString(productsAll(arr2)));
    }

    private static int[] productsAll(int[] array) {
        int[] products = new int[array.length];
        int product = 1;
        for(int i= 0; i < array.length; i++){
            products[i] = product;
            product *= array[i];
        }
        System.out.println("array length = " + array.length);
        product = 1;
        for(int i = array.length-1; i >= 0; i--){
            products[i] *= product;
            product *= array[i];
        }
        return products;
    }
}
