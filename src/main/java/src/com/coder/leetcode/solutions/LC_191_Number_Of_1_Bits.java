package com.coder.leetcode.solutions;

public class LC_191_Number_Of_1_Bits {
    public static int hammingWeight(int n) {
        int bits = 0;
        while( n != 0){
            n = n & (n-1);
            bits++;
        }
        return bits;
    }

    public static void main(String[] args){
        System.out.println("5 : " + hammingWeight(5));
        System.out.println("2 : " + hammingWeight(2));
        System.out.println("18 : " + hammingWeight(18));
        System.out.println("-2 : " + hammingWeight(15));
    }

}
