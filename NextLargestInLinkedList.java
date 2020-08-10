package del;


/*
 * Also includes solution to another LinkedList problem:
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 */

/**
* Definition for singly-linked list.
*/
class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class NextLargestInLinkedList {
	
//	Example 1:
//		Input: [2,1,5]
//		Output: [5,5,0]
//	Example 2:
//		Input: [2,7,4,3,5]
//		Output: [7,0,5,5,0]
//	Example 3:
//		Input: [1,7,5,1,9,2,5,1]
//		Output: [7,9,9,9,0,5,0,0]
	
	public static void main (String [] v ) {
		
		ListNode a = new ListNode();
		ListNode b = new ListNode();
		ListNode c = new ListNode();
		ListNode d = new ListNode();
		ListNode e = new ListNode();
		ListNode f = new ListNode();
		ListNode g = new ListNode();
		ListNode h = new ListNode();
		a.val = 1;
		b.val = 7;
		c.val = 5;
		d.val = 1;
		e.val = 9;
		f.val = 2;
		g.val = 5;
		h.val = 1;
		
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = g;
		g.next = h;
		int [] arr = new int [5];
		
		//ListNode workingNode = null;
		
//		arr = nextLargerNodes(a);
//		
//		
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println (arr[i]);
//		}
		
//		while (a.next != null) {
//			System.out.print (a.val+ "--> ");
//			a = a.next;
//		}
		ListNode ans = oddEvenList(a);
		
		System.out.println("");
		while (ans.next != null) {
			System.out.print (ans.val+ "--> ");
			ans = ans.next;
		}
		
	}

    public static int[] nextLargerNodes(ListNode head) {
 
        ListNode first = head;
        ListNode second = head;
        
        int size = 1;
        int max = 0;
        int pos = 0;
        
        while (first.next != null) {
        
            size++;
            if (max < first.val) max = first.val;
            first = first.next;
            
        }
        
        System.out.println (size);
        
        first = head;
        int [] result = new int [size];
        
        while (first.next != null) {
            
            //second = second.next;
            if (first.val < second.val ) {
                result [pos] = second.val;
                pos++;
                first = first.next;
            } else {
                if (second.next == null) {
                    result [pos] = 0;
                    pos++;
                    first = first.next;
                    second = first.next;
                } else {
                	second = second.next;
                }
            }
            
        }
        
        return result;
        
    }
    
    public static ListNode oddEvenList(ListNode head) {
    	
    	if (head == null ) return head;
    	
    	ListNode first = head;
    	ListNode second = null;
    	if (first.next==null) return first; 
    	second = head.next;
    	ListNode currOdd = first;
    	ListNode currEven = second;
    	ListNode oddNext = null;
    	ListNode evenNext = null;
    	
    	while (currOdd !=null && currEven != null) {
    		
    		
    		oddNext = currEven.next;
    		
    		if (oddNext == null) {
    			currOdd.next = second;
    	    	currEven.next = null;
    	    	break;
    		} 
    		evenNext = oddNext.next;
    		currOdd.next = oddNext;
    		currOdd = oddNext;
    		currEven.next = evenNext;
    		if (evenNext != null ) currEven = evenNext;
    		else {
    			currEven.next = null;
    			currOdd.next = second;
    			break;
    			
    		}
    		
    		
    		
    	}
    	
    	
        return head;
    }
}


/*
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        // monotonous stack
        // pos to val
        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            count++;
        }
        
        Deque<int[]> stack = new LinkedList<>();
        int[] res = new int[count];
        
        int pos = 0;
        while (head != null) {
            if (stack.isEmpty()) {
                stack.addFirst(new int[] { pos, head.val });
            } else {
                if (stack.getFirst()[1] > head.val) {
                    stack.addFirst(new int[] { pos, head.val });
                } else {
                    while (!stack.isEmpty() && stack.getFirst()[1] < head.val) {
                        int[] top = stack.removeFirst();
                        res[top[0]] = head.val;
                    }
                    stack.addFirst(new int[] { pos, head.val });
                }
            }
            pos++;
            head = head.next;
        }
        
        while (!stack.isEmpty()) res[stack.removeFirst()[0]] = 0;
        return res;
    }
}
*/

/*

public int[] nextLargerNodes(ListNode head) {
int[] t = new int[10000];
int size = 0;
for (; head != null; head = head.next) t[size++] = head.val;
int[] s = new int[size];
int[] ret = new int[size];
int top = -1;
ret[size - 1] = 0;
for (int i = size - 2; i >= 0; i--) {
    if (t[i] < t[i + 1]) {
        s[++top] = ret[i] = t[i + 1];
    } else {
        while ((top >= 0) && (s[top] <= t[i])) top--;
        ret[i] = (top < 0) ? 0 : s[top];
    }
}
return ret;
}
*/