package com.coder.randomQ.solutions;
/*
Given a target value. Find the closest value in a BST.
Sample Input :
        10
    /       \
    5       13
   / \     /  \
 1    9   11   15

target : 7

Sample Output:  9
 */
public class FindClosestValueInBST {
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    public int findClosestValue_In_BST(int target, BST root){
        BST node = root;
        int closest = root.value;
        while(node != null){
            if(Math.abs(target - closest) > Math.abs(target - node.value))
                closest = node.value;
            if(target < node.value && node.left != null){
                node = node.left;
            }else if(target > node.value && node.right != null){
                node = node.right;
            }else{
                break;
            }
        }
        return closest;
    }
}
