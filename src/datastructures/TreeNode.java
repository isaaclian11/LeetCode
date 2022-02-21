package datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(3, new TreeNode(1), new TreeNode(6));
        TreeNode right = new TreeNode(10, null, new TreeNode(14));
        TreeNode root = new TreeNode(8, left, right);

        ArrayList<Integer> result = new ArrayList<>();
        System.out.println(recursivelyCollectList(root, result));
    }

    public static List<Integer> recursivelyCollectList(TreeNode root, List<Integer> result) {
        if(root.left == null) {
            result.add(root.val);
        }else {
            result = recursivelyCollectList(root.left, result);
            result.add(root.val);
        }
        if(root.right != null) {
            result = recursivelyCollectList(root.right, result);
        }
        return result;
    }
 }
