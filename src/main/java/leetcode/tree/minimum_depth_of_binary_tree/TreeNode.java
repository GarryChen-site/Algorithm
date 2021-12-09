package leetcode.tree.minimum_depth_of_binary_tree;

/**
 * @author cy
 * @className TreeNode
 * @description
 * @date 2021/12/4 19:40
 */
public class TreeNode {

    int val;

    TreeNode left;

    TreeNode right;

    TreeNode() {

    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;

    }
}