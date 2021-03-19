package com.coder.randomQ.solutions;
/*
    Catlans number
    If we want to find number of valid parenthesis formed of length 6 then the following are the combinations
    ((()))
    ()()()
    (())()
    ()(())
    (()())
    It has 3 open brackets, 3 closed brackets. So in 6 places we can keep three open brackets in 6C3 combinations
    but those 6C3 combinations will also have invalid combinations. So how to remove the invalid combinations
                  /\
          /\     /  \
     /\  /  \   /    \
    /__\/____\/_______\_
    1. Every Open bracket should have a corresponding closing bracket
    2. The sum can never be negative at any given point
    Consider '(' as +1, and ')' as -1
    +1 +1 +1 -1 -1 -1
    (  (  (  )  )  )

    +1 -1 +1 -1 +1 -1
    (  )  (  )  (  )

    +1 +1 -1 -1 +1 -1
    (  (  )  )  (  )

    +1 -1 +1 +1 -1 -1
    (  )  (  (  )  )

    +1 +1 -1 +1 -1 -1
    (  (  )  (  )  )

    Similar Problems,
    -> N people standing in a circle how many combinations of handshakes possible
    -> Non intersecting Triangles formed using N+2 gons (n= 3 -> pentagon, n=4 -> hexagon etc)
    -> Paths possible in a square matrix where staring point is (0,0), reach the point (n,n) using only up and right directions
        that are above the diagonal
 */
public class NumberOfValidParanthesis {

    public static void main(String[] args){
        System.out.println("Valid paranthesis of length 5: " + validParanthesis(5));
        System.out.println("Valid paranthesis of length 2: " + validParanthesis(2));
        System.out.println("Valid paranthesis of length 4: " + validParanthesis(4));
        System.out.println("Valid paranthesis of length 6: " + validParanthesis(6));
        System.out.println("Valid paranthesis of length 8: " + validParanthesis(8));
        System.out.println("Valid paranthesis of length 10: " + validParanthesis(10));
    }

    static int validParanthesis(int n){
        //if n is odd, there is no such combination because valid parenthesis exists in pairs.
        if(n%2 == 1) return -1;
        else{
            return formValidPairs(n/2);
        }
    }

    static int formValidPairs(int pair){
        // Valid parenthesis of length n, i.e., k - pairs  = nCk/(k+1)
        int combinations = combinations(2*pair, pair);
        return combinations/(pair + 1);
    }

    static int combinations(int n, int k){
        //nCk = (n-k)!/k!
        int numenator = 1, denominator = 1;
        for(int i = n ; i > n-k; i--){
            numenator *= i;
        }
        for(int i = k ; i >= 1; i--){
            denominator *=i;
        }
        return numenator/denominator;
    }
}
