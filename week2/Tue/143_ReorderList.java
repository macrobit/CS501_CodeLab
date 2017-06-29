/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
*/

public void reorderList(ListNode head) {
	//Corner Case: Only when there are at least 3 nodes, reordering is meaningful.
	if (head == null || head.next == null || head.next.next == null) {
		return;
	}

	//1. Find middle and cut
	ListNode mid = findMid(head);
	ListNOde secondHead = mid.next;
	mid.next = null;
	//2. Reverse the second
	secondHead = reverse(secondHead);
	//3. Merge
	head = merge(head, secondHead);
}

private ListNode findMid (ListNode head) {
	// Use fast and slow pointers
	ListNode fast = head;
	ListNode slow = head;
	while (fast != null && fast.next != null) {
		fast = fast.next.next;
		slow = slow.next;
	}

	return slow;
}

private ListNode