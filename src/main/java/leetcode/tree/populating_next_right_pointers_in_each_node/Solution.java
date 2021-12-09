package leetcode.tree.populating_next_right_pointers_in_each_node;

/**
 * @author cy
 * @className Solution
 * @description
 * @date 2021/11/29 20:26
 */
public class Solution {


    /**
     * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children.
     * The binary tree has the following definition:
     * struct Node {
     *   int val;
     *   Node *left;
     *   Node *right;
     *   Node *next;
     * }
     *
     *

     Populate each next pointer to point to its next right node.
     If there is no next right node, the next pointer should be set to NULL.

     Initially, all next pointers are set to NULL.

     Input: root = [1,2,3,4,5,6,7]
     Output: [1,#,2,3,#,4,5,6,7,#]
     Explanation: Given the above perfect binary tree (Figure A),
     your function should populate each next pointer to point to its next right node,
     just like in Figure B.
     The serialized output is in level order as connected by the next pointers,
     with '#' signifying the end of each level.

     Input: root = []
     Output: []
     * @param root
     * @return
     */
    public Node connect(Node root) {
        return dfs(root);
    }

    private Node dfs(Node root) {
        if (root == null)
        {
            return root;
        }

        if(root.left != null)
        {
            root.left.next = root.right;
            if(root.next != null)
            {
                root.right.next = root.next.left;
            }
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}