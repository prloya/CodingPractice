package com.coder.randomQ.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DP_MaxSumIncreasingSequence {
    public static List<List<Integer>> maxSumIncreasingSubSequence(int[] array){
        int[] sequences = new int[array.length];
        Arrays.fill(sequences, -1);
        int[] sum = array.clone();
        int maxIndex = 0;

        for(int i = 0; i < array.length; i++){
            int curr = array[i];
            for(int j = 0; j < i; j++){
                int other = array[j];
                if(other < curr && sum[j] + curr >= sum[i]){
                    sum[i] = sum[j] + curr;
                    sequences[i] = j;
                }
            }
            if(sum[i] >= sum[maxIndex]){
                maxIndex = i;
            }
        }

        return buildSeq(array, sequences, maxIndex,sum[maxIndex]);
    }

    private static  List<List<Integer>> buildSeq(int[] arr, int[]seq, int curr, int maxSum){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        result.add(new ArrayList<Integer>());
        result.get(0).add(maxSum);
        while (curr != -1){
            result.get(1).add(0,arr[curr]);
            curr = seq[curr];
        }
        return result;
    }

    public static void main(String[] args){
        List<List<Integer>> result = maxSumIncreasingSubSequence(new int[]{10,70,20,30,50,11,30});
        System.out.print("["+result.get(0).get(0));
        for(int item: result.get(1)){
            System.out.print(","+item);
        }
        System.out.print("]");
    }
}
