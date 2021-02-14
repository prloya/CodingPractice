package com.coder.randomQ.solutions;

import java.util.Arrays;
import java.util.List;

/*
sample input:
arr[] = [1,2,3,4,5,6]
seq[] = [3,5]
output: true

arr[]=[12,45,3,67,-1,8]
seq[]=[45,-1,2,8]
output: false
 */
public class Validate_Subsequence {
    public static boolean isValidSubsequence(List<Integer> arr1, List<Integer> seq){
        int arr1_itr=0;
        int seq1_itr=0;
        while(arr1_itr < arr1.size() && seq1_itr < seq.size()){
            if(arr1.get(arr1_itr).equals(seq.get(seq1_itr)))
                seq1_itr++;
            arr1_itr++;
        }
        return seq.size()==seq1_itr;
    }
    public static void main(String[] args){
        List<Integer> array = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
        List<Integer> sequence = Arrays.asList(1, 6, 2, -1, 10);
        System.out.println(isValidSubsequence(array, sequence));
    }
}
