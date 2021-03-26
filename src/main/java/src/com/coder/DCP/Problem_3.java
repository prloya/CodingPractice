package com.coder.DCP;
/*
Problem 3
This problem was asked by Google.

Given the root to a binary tree, implement serialize(root),
which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree.
Example:
serialize(treenode) = [5,4,7,3,null,2,null,-1,null,9]

deserialize(string)
            5
          /   \
         4     7
        /     /
       3     2
      /     /
    -1     9
 */

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.value = val;
    }
}
public class Problem_3 {
    public String serialize(TreeNode root){
        StringBuffer sb = new StringBuffer();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                if(curr == null) {
                    sb.append("null,");
                } else {
                    sb.append(curr.value + ",");
                    queue.add(curr.left);
                    queue.add(curr.right);
                }
            }
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data){
        String[] node = data.split(",");
        if (node[0].equals("null") || node[0].isEmpty()) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(node[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1; i < node.length; i++) {
            TreeNode parent = queue.poll();
            if (!node[i].equals("null")) {
                parent.left = new TreeNode(Integer.parseInt(node[i]));
                queue.add(parent.left);
            }
            ++i;
            if (i < node.length && !node[i].equals("null")) {
                parent.right = new TreeNode(Integer.parseInt(node[i]));
                queue.add(parent.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Problem_3 ser = new Problem_3();
        Problem_3 deser = new Problem_3();
        String data = "";
        TreeNode ans = deser.deserialize(data);
        String result = ser.serialize(ans);
        System.out.println(result);
    }
}
 //   Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
