//Reverse a singly linked list.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {

	// Iterative Solution
    public ListNode reverseList(ListNode head) {
        //Corner Case:
        if (head == null) {
            return null;
        }
        
        ListNode newHead = null;
        ListNode next;
        // head is actually head.next
        while (head != null) {
            next = head.next; // save head.next
            head.next = newHead; // change head.next
            
            newHead = head;  // move newHead forward
            head = next; // move head foward
        }
        return newHead;
    }

    // Recursive Solution
    public ListNode reverseList(ListNode head) {
    	// Corner Case:
    	if (head == null) {
    		return null;
    	}

    	return revereListHelper(head, null);
    }

    private static ListNode revereListHelper (ListNode head, ListNode newHead) {
    	// Base
    	if (head == null) {
    		return newHead;
    	}

    	// Body: Tail Recursion
    	ListNode next = head.next;
    	head.next = newHead;
    	
    	return reverseListHelper (next, head);
    }
}