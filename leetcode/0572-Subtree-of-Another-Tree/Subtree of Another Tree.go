package leetcode

import "algorithm/structures"

type TreeNode = structures.TreeNode

func isSubtree(root *TreeNode, subRoot *TreeNode) bool {
	if isSameTree(root, subRoot) {
		return true
	}
	if root == nil {
		return false
	}
	if isSubtree(root.Left, subRoot) || isSubtree(root.Right, subRoot) {
		return true
	}
	return false
}

func isSameTree(p *TreeNode, q *TreeNode) bool {
	if p == nil && q == nil {
		return true
	} else if p != nil && q != nil {
		if p.Val != q.Val {
			return false
		}
		return isSameTree(p.Left, q.Left) && isSameTree(p.Right, q.Right)
	} else {
		return false
	}
}
