package com.coder.randomQ.solutions;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.Arrays;

/*
A left rotation operation on an array shifts each of the array's elements 1 unit to the left.
For example, if 2 left rotations are performed on array [1,2,3,4,5], then the array would become
[3,4,5,1,2].
Note that the lowest index item moves to the highest index in a rotation.
This is called a circular array.

Given an array a[] of n integers and a number, d, perform d left rotations on the array.
Return the updated array to be printed as a single line of space-separated integers.
 */
public class Left_Rotate_Array {
    static int[] rotLeft(int[] a, int d) {
        int aLength = a.length - 1;
        reverse(a,0,aLength);
        reverse(a,0,aLength - d);
        reverse(a,aLength - d + 1, aLength);
        return a;
    }

    static void reverse(int[] a, int left, int right){
        while(left < right){
            int tmp = a[right];
            a[right] = a[left];
            a[left] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args){
        int[] a = {1,2,3,4,5,6,7};
        int d= 3;
        System.out.println(Arrays.toString(rotLeft(a,d)));
    }

}
