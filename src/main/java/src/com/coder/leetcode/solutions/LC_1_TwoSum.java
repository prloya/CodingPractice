package com.coder.leetcode.solutions;
/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]

Constraints:
2 <= nums.length <= 103
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC_1_TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i< nums.length;i++){
            int tmp = target - nums[i];
            if(map.containsKey(tmp)){
                return new int[] {map.get(tmp),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No Two Sum available for target number");
    }

    public static void main(String[] args){
        int[] nums = {4,7,2,15};
        int target = 9;
        int[] result = twoSum(nums,target);
        Arrays.stream(result).forEach(num -> System.out.print(num+","));
    }
}
