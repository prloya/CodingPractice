package com.coder.leetcode.solutions;
/*
Given an integer n, your task is to count how many strings of length n can be formed under the following rules:

Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
Each vowel 'a' may only be followed by an 'e'.
Each vowel 'e' may only be followed by an 'a' or an 'i'.
Each vowel 'i' may not be followed by another 'i'.
Each vowel 'o' may only be followed by an 'i' or a 'u'.
Each vowel 'u' may only be followed by an 'a'.
Since the answer may be too large, return it modulo 10^9 + 7.
Example 1:
Input: n = 1
Output: 5
Explanation: All possible strings are: "a", "e", "i" , "o" and "u".

Example 2:
Input: n = 2
Output: 10
Explanation: All possible strings are: "ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" and "ua".
 */
public class LC_1220_Count_Vowels_Permutation {
    public static int countVowelPermutation(int n){
        /*
         a -> e
         e -> a, i
         i -> a, e, o, u
         o -> i, u
         u -> a

         implies vowels are preceded like below
        0 a -> e, i, u
        1 e -> a, i
        2 i -> e, o
        3 o -> i
        4 u -> i, o
         */
        if(n == 1) return 5;
        int mod = 1000000007;
        long[] currCombo = new long[5];
        for(int i = 0; i < 5; i++){
            currCombo[i] = 1;
        }
        for( int i = 2 ; i < n+1; i++){
            long[] newCombo = new long[5];
            newCombo[0] = (currCombo[1] + currCombo[2] + currCombo[4]) % mod;
            newCombo[1] = (currCombo[0] + currCombo[2]) % mod;
            newCombo[2] = (currCombo[1] + currCombo[3]) % mod;
            newCombo[3] = currCombo[2];
            newCombo[4] = (currCombo[2] + currCombo[3]) % mod;
            currCombo = newCombo;
        }

        long combinations = 0;
        for(int i = 0; i< 5; i++){
            combinations = (combinations + currCombo[i]) % mod;
        }
        return (int)combinations;
    }

    public static void main(String[] args){
        System.out.println("n = 2\n" + countVowelPermutation(2));
        System.out.println("n = 144\n" + countVowelPermutation(144));
    }
}
