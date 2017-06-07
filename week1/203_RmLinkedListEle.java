/*
						     LeetCode 203   Remove Linked List Elements

*	Remove all elements from a linked list of integers that have value val.

*	Example
*	Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
*	Return: 1 --> 2 --> 3 --> 4 --> 5

*/

// Definition for singly-linked list.
public class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}

public class Solution {
	public ListNode removeElements(ListNode head, int val) {
		// Corner Case: It is a null linkedList
		if(head == null) {
			return null;
		}

		// Create a dummy node to point to head node.
		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		ListNode cur = dummy;

		while(cur.next != null) {
			if(cur.next.val == val) {
				cur.next = cur.next.next;
			} else {
				cur = cur.next; // Because cur.next != null, cur can move to cur.next
			}
		}

		return dummy.next;
	}
}
