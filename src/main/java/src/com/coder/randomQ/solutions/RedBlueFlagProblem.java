package com.coder.randomQ.solutions;

import java.util.Arrays;

/*
You are given an array of integers and an integer. Write a function that moves
all instances of that integer in the array to the end of the array and return it.

No extra space, mutate the input array.

Sample Input:
array = [1,2,1,2,2,2,3,4,2,2]
toMove = 2

Sample Output:
array = [1,1,3,4,2,2,2,2,2,2]

 */
public class RedBlueFlagProblem {
    public static void main(String[] args){
        int[] array = new int[] {1,2,1,2,2,2,3,4,2,2};
        int toMove = 2;
        System.out.println(Arrays.toString(moveElementToEnd(array, toMove)));
    }

    public static int[] moveElementToEnd(int[] array, int toMove){
        int left = 0;
        int right = array.length -1 ;
        while(left < right){
            while(left < right && array[right] == toMove)
                right--;
            if(left < right && array[left] == toMove){
                int tmp = array[right];
                array[right] = array[left];
                array[left] = tmp;
            }
            left++;
        }
        return array;
    }
}
