package com.coder.randomQ.solutions;

import java.util.Arrays;

/*
It is New Year's Day and people are in line for the Wonderland rollercoaster ride.
Each person wears a sticker indicating their initial position in the queue from 1 to n.
Any person can bribe the person directly in front of them to swap positions,
but they still wear their original sticker. One person can bribe at most two others.

Determine the minimum number of bribes that took place to get to a given queue order.
Print the number of bribes, or, if anyone has bribed more than two people, print Too chaotic.

Example
q[] = 5 1 2 3 7 8 6 4
"Too chaotic"

q[] =1 2 5 3 7 8 6 4
7
 */
public class NewYear_Chaos {
    public static void main(String[] args){
        int[] q1 = {5,1,2,3,7,8,6,4};
        int[] q2 = {1,2,5,3,7,8,6,4};
        System.out.println(Arrays.toString(q1) + " : " );
        minimumBribes(q1);
        System.out.println(Arrays.toString(q2) + " : " );
        minimumBribes(q2);
    }

    static void minimumBribes(int[] q){
        int bribes = 0;
        for(int idx= q.length -1; idx >= 0 ;idx--){
            if(q[idx] - (idx+1) > 2){
                System.out.println("Too chaotic");
                return;
            }
            //Either the person's position didn't change or
            //he would have moved to a position smaller than his actual position
            //Person cannot bribe more than 2 times
            //Keep track of the person's bribes
            for(int position = Math.max(0,q[idx]-2); position < idx ; position++){
                if(q[position] > q[idx])
                    bribes++;
            }
        }
        System.out.println("Minimum Bribes = " + bribes);
    }

}
