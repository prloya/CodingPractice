package com.coder.randomQ.solutions;

import java.util.Arrays;

/*
Given array that contains consecutive integers find minimum swaps such that the array is in ascending order
1<= i < n
1 <= arr[i] < n

Sample Input:
arr[] = {7,1,3,2,4,5,6}
Output: 5
 */
public class Minimum_Swaps_Consecutive_integers {
    public static void main(String[] args){
        int[] arr = {7,1,3,2,4,5,6};
        System.out.println(Arrays.toString(arr) + " \n" +
                "Minimum swaps = " + mininumSwaps(arr));
        int[] arr1 = {4,3,1,2};
        System.out.println(Arrays.toString(arr1) + " \n" +
                "Minimum swaps = " + mininumSwaps(arr1));
    }
    static int mininumSwaps(int[] arr){
        int swaps = 0;
        int length = arr.length;
        int idx = 0;
        while(idx < length){
            if(arr[idx] != (idx + 1)){
                int actualIdx = arr[idx] - 1;
                swap(arr, idx, actualIdx);
                swaps++;
            }else{
                idx++;
            }
        }
        return swaps;
    }
    static void swap(int[] arr, int left, int right){
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}
