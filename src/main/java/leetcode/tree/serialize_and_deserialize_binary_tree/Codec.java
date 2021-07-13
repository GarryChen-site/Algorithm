package leetcode.tree.serialize_and_deserialize_binary_tree;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author cy
 * @className Codec
 * @description TODO
 * @date 2021/6/30 17:49
 */
public class Codec {

    /**
     * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer,
     * or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
     *
     * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work.
     * You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
     * @param root
     * @return
     */

    private static final String spliter = ",";
    private static final String NN = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root,sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if(node == null)
        {
            sb.append(NN).append(spliter);
        }
        else
        {
            sb.append(node.val).append(spliter);
            buildString(node.left,sb);
            buildString(node.right,sb);
        }
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if(val.equals(NN)) return null;
        else
        {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }

    // The idea is simple: print the tree in pre-order traversal and use "X" to denote null node and split node with ",".
    // We can use a StringBuilder for building the string on the fly.
    // For deserializing, we use a Queue to store the pre-order traversal and since we have "X" as null node,
    // we know exactly how to where to end building subtress.
}