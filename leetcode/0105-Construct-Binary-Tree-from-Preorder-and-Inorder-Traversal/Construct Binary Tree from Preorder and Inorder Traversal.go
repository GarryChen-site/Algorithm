package leetcode

import "algorithm/structures"

type TreeNode = structures.TreeNode


func buildTree(preorder []int, inorder []int) *TreeNode {
 
	if len(preorder) == 0 {
		return nil
	}

	root := &TreeNode{Val: preorder[0]}

	for index,node := range inorder {
		if node == root.Val {
			root.Left = buildTree(preorder[1:index+1], inorder[:index])
			root.Right = buildTree(preorder[index+1:], inorder[index+1:])
		}
	}

	return root
}