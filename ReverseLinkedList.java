package del;

public class ReverseLinkedList {
	
	public static void main (String [] v ) {
		
		int [] linkedListAsArray = {5, 3, 8, 7, 14, 9, 10, 12};
		printLinkedList(createLinkedList (linkedListAsArray));
		printLinkedList(reverseLinkedList (createLinkedList (linkedListAsArray)) );
		
	}
	
	static Node reverseLinkedList (Node headOfRevLinkedList) {
		Node currNode = headOfRevLinkedList;
		Node tempNode;
		Node prevNode = null;
		
		while (null != currNode) {
			tempNode = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = tempNode;
		}
		//System.out.println("yeah!");
		return prevNode;

	}
	
	static Node createLinkedList ( int [] arr ) {
		
		Node head = new Node();
		if (arr.length ==0) return head;
		head = new Node (arr[0]);
		Node curr = head;
		for (int i = 1; i < arr.length; i++) {
			Node next = new Node(arr[i]);
			curr.next = next;
			curr = next;
		}
		return head;
		
	}
	
	static void printLinkedList ( Node headOfLinkedList) {
		Node currNode = headOfLinkedList;
		while (true) {
			System.out.print (currNode.lbl + " --> ");
			if (null == currNode.next) break;
			currNode = currNode.next;
		}
	}
	

}

class Node {
	String lbl;
	Node next;
	
	Node () {
		
	}
	
	Node (int l) {
		this.lbl = ""+l+"";
		
	}
	
	Node (String val) {
		this.lbl = val;
	}
	
	Node (String val, Node next ) {
		this.lbl = val;
		this.next = next;
	}
}

/*
This problem was asked by Google.
Given the head of a singly linked list, reverse it in-place.


Solution
We can do this recursively and cleverly, using Python's default argument feature. Basically, we call reverse on the node's next, but not before cleaning up some pointers first:
def reverse(head, prev=None):
    if not head:
        return prev
    tmp = head.next
    head.next = prev
    return reverse(tmp, head)
This runs in O(N) time. But it also runs in O(N) space, since Python doesn't do tail-recursion elimination.
We can improve the space by doing this iteratively, and keeping track of two things: a prev pointer and a current pointer. The current pointer will iterate over through the list and the prev pointer will follow, one node behind. Then, as we move along the list, we'll fix up the current node's next to point to the previous node. Then we update prev and current.
def reverse(head):
    prev, current = None, head
    while current is not None:
        tmp = current.next
        current.next = prev
        prev = current
        current = tmp
    return prev
Now this only uses constant space!


*/