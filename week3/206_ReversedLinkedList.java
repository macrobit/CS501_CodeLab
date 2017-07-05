/*
		206. Reversed a Linked List
*/

public class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}

public class Solution {
// Iterative Method:
	public ListNode reverseLinkedList(ListNode head) {
		// corner case
		if (head == null) {
			return null;
		}

		ListNode newHead = new ListNode();
		while (head != null) {
			ListNode tmp = head.next;
			head.next = newHead;

			head = tmp; // head move to the old head.next
			newHead = head; // newHead move forward
		}

		return newHead;
	}

// Recursive Method:
	public ListNode reverseHelp(ListNode head, ListNode newHead) {
		// base case
		if (head == null) {
			return newHead;
		}

		ListNode tmp = head.next;
		head.next = newHead;

		return reverseHelp(tmp, head);

	}

	public ListNode reverseR (ListNode head) {
		// corner case
		if (head == null) {
			return null;
		}

		ListNode newHead = null;
		return reverseHelp (head, newHead);
	}
}