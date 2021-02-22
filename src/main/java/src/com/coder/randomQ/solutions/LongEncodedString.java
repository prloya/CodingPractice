package com.coder.randomQ.solutions;

import java.util.*;
import java.util.stream.*;

public class LongEncodedString{

    public static void main(String[] args){
        String encoded = "75(2)11#19#615#18#75(2)11#19#";
        String alphabet = "[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]";
        System.out.println(frequency(encoded).toString()+"\n"+alphabet);
    }

    public static List<Integer> frequency(String s) {

        int[] result = new int[26];
        Arrays.fill(result,0);
        int sLength = s.length();
        int curr = 0;
        if(s.length() == 0)
            return IntStream.of(result).boxed().collect(Collectors.toList());
        while(curr < sLength){
            int value = 0;
            if(curr+2 >= sLength || s.charAt(curr + 2) != '#'){
                value = s.charAt(curr) - '0';
                result[value - 1]++;
                curr++;
            }else if(s.charAt(curr + 2) == '#'){
                value = (s.charAt(curr) - '0') * 10 +
                        (s.charAt(curr + 1) - '0');
                result[value-1]++;
                curr = curr + 3;
            }
            if(curr < sLength){
                if(s.charAt(curr) == '('){
                    int frequency = 0;
                    curr++;
                    while(s.charAt(curr) != ')'){
                        frequency = frequency*10 + (s.charAt(curr)-'0');
                        curr++;
                    }
                    result[value-1] += frequency-1;
                    curr++;
                }
            }
        }
        return IntStream.of(result).boxed().collect(Collectors.toList());
    }
}