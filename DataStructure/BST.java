/*    
//  		Binary Search Tree
*/


// Tree Node Class

public class BST {
	private static class Node {
		int key;
		int value;
		Node left, right;

		Node(int key, int value) {
			this.key = key;
			this.value = value;
			left = right = null;
		}

	}

	public boolean find(Node root, int key) {
		// corner case: Tree is empty
		if(root == null) {
			return false;
		}

		Node cur = root;
		// there are two situations when cur.key != key
		while(cur.key != key) {
			if(cur.key < key) {
				cur = cur.right;
			} else {
				cur = cur.left;
			}

			if(cur == null) {
				return false;
			}
		}

		return true; // when cur.key == key

	}

	// insert operation need to record a parent reference
	// no duplicates allowed！！！

	public void insert(Node root, int key, double value) {
		Node newNode = new Node(key, value);
		// corner case
		if(root == null) {
			root = newNode;
			return;
		}

		Node parent = root; // two pointers
		Node cur = root;

		while(true) {
			// no duplicates allowed 
			if(cur.key == key) {
				return;
			}
			parent = cur;

			if(cur.key > key) {
				cur = cur.left;
				if(cur == null) {
					parent.left = newNode;
					return;
				}
			} else {
				cur = cur.right;
				if(cur == null) {
					parent.right = newNode;
					return;
				}
			}
		}
	}

	public void delete(Node root, int key) {
		// corner case:
		if (root == null) {
			return;
		}

		Node cur = root;
		Node parent = root;
		boolean isLeftChild = true; // used to judge the target is left child or right child

		while (cur.key != key) { // target is a root, parent == cur == root
			parent = cur;
			if (cur.key > key) { // go left
				isLeftChild = true;
				cur = cur.left;
			} else { // go right
				isLeftChild = false;
				cur = cur.right;
			}

			if (cur == null) { // not found
				return;
			}
		}

		// the target is found: cur.key == key
		if (cur.left == null && cur.right == null) { // the target is a leaf
			if (cur == root) { // the target is the root
				root = null;
			} else if (isLeftChild) { // this leaf is a left child
				parent.left = null;
			} else {				// this leaf is a right child
				parent.right = null; 
			}

		} else if (cur.right == null) { // the target has no right child
			if (cur == root) { // the target is a root
				root = cur.left;
			} else if (isLeftChild) {
				parent.left = cur.left;
			} else {
				parent.right = cur.left;
			}
		} else if (cur.left == null) {	// the target has no left child
			if (cur == root) {
				root = cur.right;
			} else if (isLeftChild) {
				parent.left = cur.right; // the target is a left child
			} else {
				parent.right = cur.right; // the target is a right child
			}
		} else { // the target has both left and right children, which is the trickist!!!
			// the successor must be in the right subtree!
			Node successor = getSuccessor(cur);

			if (cur == root) {
				root = successor;
			} else if (isLeftChild) {
				parent.left = successor;
			} else {
				parent.right = successor;
			} 

			successor.left = cur.left;
			//successor.right = cur.right;
		}
	}

	/*
	* 1. successor must be the leftest node in the right subtree. (it has no left child)
	* 2. successor may have a right subtree.
	* 3. successor may be a leaf.	
	*/

	private Node getSuccessor (Node keyNode) { // getting successor also means remove it from the tree.
		Node sucParent = keyNode;
		Node successor = keyNode;
		Node cur = keyNode.right; // cur start from the right child node

		// move to left as far as possible in the right subtree
		while (cur != null) { 
			sucParent = successor;
			successor = cur;
			cur = cur.left;
		}

		if (successor != keyNode.right) { // successor == keyNode.right when there is no left child for keyNode.right
			sucParent.left = successor.right; // successor must be a left child in this situation
			successor.right = keyNode.right; // use successor to replace keyNode, because keyNode need to be deleted
		}

		return successor;
	}
}










