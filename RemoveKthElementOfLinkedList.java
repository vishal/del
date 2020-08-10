package del;

//Given a singly linked list and an integer k, remove the kth last element from the list. k is guaranteed to be smaller than the length of the list.
//The list is very long, so making more than one pass is prohibitively expensive.
//Do this in constant space and in one pass.

public class RemoveKthElementOfLinkedList {
	
	public static void deleteNode(ListNode node) {
        
		node.val = node.next.val;
		node.next = node.next.next;
        
    }
	
	public static void deleteKthNode(ListNode head, int k) {
        
        ListNode frontRunner = head;
        ListNode toBeDeleted = head;
        
        while (k-- >= 0) frontRunner = frontRunner.next;
        
        while (frontRunner != null) {
        	frontRunner = frontRunner.next;
        	toBeDeleted = toBeDeleted.next;
        }
        
        deleteNode (toBeDeleted);
//        toBeDeleted.val = toBeDeleted.next.val;
//        toBeDeleted.next = toBeDeleted.next.next;
        
        
    }
	
	public static void printLinkedList (ListNode headOfLL) {
		System.out.println("");
		while (headOfLL.next != null) {
			System.out.print (headOfLL.val+ "--> ");
			headOfLL = headOfLL.next;
		}
	}
	
	public static void main (String [] v ) {
		
		ListNode root = new ListNode (3);
		ListNode nd = new ListNode (7);
		
		ListNode second = new ListNode (5);
		ListNode third = new ListNode (15);
		ListNode fourth = new ListNode (21);
		ListNode fifth = new ListNode (31);
		ListNode sixth = new ListNode (51);
		
		root.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = nd;
		nd.next = fifth;
		fifth.next = sixth;
		
		printLinkedList (root);
		deleteNode (nd);
		printLinkedList (root);
		deleteKthNode (root, 3);
		printLinkedList (root);
	}

}
