package del;
/*
 * Given a linked list of numbers and a pivot k, partition the linked list so that all nodes less than k come before nodes greater than or equal to k.
For example, given the linked list 5 -> 1 -> 8 -> 0 -> 3 and k = 3, the solution could be 1 -> 0 -> 5 -> 8 -> 3.

 */

public class GroupAroundPivotInLinkedList {

	public static void main (String [] v ) {
		
		int [] linkedListAsArray = {5, 3, 8, 7, 14, 9, 10, 12};
		Node linkedList = createLinkedList (linkedListAsArray);
		printLinkedList(linkedList);
		//printLinkedList(reverseLinkedList (createLinkedList (linkedListAsArray)) );
		int k = 9;
		printLinkedList( groupAroundk ( linkedList, k) );
		
		
	}
	
	static Node groupAroundk (Node headOfLL, int k) {
		
		String temp = "";
		int tempInt = 0;
		
		Node currNode = headOfLL;
		Node prevNode = null;
		
		
		while (null != currNode) {
			temp = currNode.lbl;
			tempInt = Integer.parseInt(temp);
			
			if (tempInt < k) {
				if (prevNode != null ) {
					System.out.println("Less");
					prevNode.next = currNode.next;
					currNode.next = headOfLL;
					headOfLL = currNode;
					currNode = prevNode.next;
				}
			}
			
			prevNode = currNode; // may not work;
			currNode = currNode.next;
			
		}
		
		
		
		return headOfLL;
		
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
