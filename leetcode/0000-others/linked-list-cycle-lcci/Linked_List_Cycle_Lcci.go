package leetcode

import "algorithm/structures"



type ListNode = structures.ListNode


func detectCycle(head *ListNode) *ListNode {
    
	if head == nil {
		return nil
	}

	fast , slow := head, head

	for fast != nil && fast.Next != nil {
		fast = fast.Next.Next
		slow = slow.Next

		if slow == fast{
			break
		}
	}

	if fast == nil || fast.Next == nil {
		return nil
	}

	fast = head

	for fast != slow {
		fast = fast.Next
		slow = slow.Next
	}
	return fast
}