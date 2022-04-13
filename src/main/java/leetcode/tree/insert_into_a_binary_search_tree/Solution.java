package leetcode.tree.insert_into_a_binary_search_tree;

public class Solution {
	
	public TreeNode insertIntoBST(TreeNode root, int val) {

		if(root == null) {
			return new TreeNode(val);
		}

		if(root.val < val)
		{
			root.right = insertIntoBST(root.right, val);
		}
		else if (root.val > val)
		{
			root.left = insertIntoBST(root.left, val);
		}
		
		return root;
	}
}
