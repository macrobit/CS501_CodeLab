/*
			LeetCode 141  Linkded List Cycle

	Given a linked list, determine if it has a cycle in it.

	Follow up:
	Can you solve it without using extra space?

*/

// Definition for singly-linked list.
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}


// Use fast and slow pointers?

public class Solution {
	public boolean hasCycle(ListNode head) {
		// Corner Case: 1. LinkedList is null
		// 				2. LinkedList only has one node
		// A cycle need at least two nodes!!!
		if(head == null || head.next == null) {
			return false;
		}

		// Define Fast and Slow pointers
		ListNode slow = head;	    
		ListNode fast = head.next; // fast move 2 time steps

		while(fast != null && fast.next != null) {
			if(slow == fast) {
				return true;
			}
			slow = slow.next;
			fast = fast.next.next;
		}

		return false;
	}
}



