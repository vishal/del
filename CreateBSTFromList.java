package del;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;

/*
 * You are given a binary tree in a peculiar string representation. 
 * Each node is written in the form (lr), where l corresponds to the left child and r corresponds to the right child.

If either l or r is null, it will be represented as a zero. Otherwise, it will be represented by a new (lr) pair.

Here are a few examples:

A root node with no children: (00)
A root node with two children: ((00)(00))
An unbalanced tree with three consecutive left children: ((((00)0)0)0)
Given this representation, determine the depth of the tree.


 */
public class CreateBSTFromList {
	
	public static void main (String [] v ) {
		
		//[10,5,15,3,7,null,18] 7 and 15
		// [10,5,15,3,7,13,18,1,null,6] 10 and 6
//		TreeNode root = new TreeNode (10);
//		root.left = new TreeNode (5);
//		root.right = new TreeNode (15);
//		root.left.left = new TreeNode (3);
//		root.left.right = new TreeNode (7);
//		root.right.left = new TreeNode (13);
//		root.right.right = new TreeNode (18);
//		root.left.left.left = new TreeNode (1);
//		root.left.left.right = new TreeNode ();
//		root.left.right.left = new TreeNode (6);
		//[3,4,5,1,2]
		//[4,1,2]
		TreeNode a1 = new TreeNode(3);
		a1.left = new TreeNode (4);
		
		System.out.println( isSubtree (root, root.right));
		
		//printBST (root);
		
		//System.out.println(rangeSumBST(root, 10, 6));
	}
	
	public static void printBST (TreeNode root) {
		
		
		
	}
	
    public static int rangeSumBST(TreeNode root, int L, int R) {
        
    	TreeNode curr = root;
        HashSet <Integer> numSet = new HashSet <Integer>();
        int sum = 0;
        
        int myL =L;
        int myR = R;
        if (R < L) {
        	myL = R;
        	myR = L;
        }
        Stack <TreeNode> stackOfNodes = new Stack <> ();
		
		
		while (curr != null || stackOfNodes.isEmpty() == false) {
			while (curr != null ) {
				stackOfNodes.push(curr);
				curr = curr.left;
			}
			
			curr = stackOfNodes.pop();
			if (curr.val >= myL && curr.val <= myR) {
            	System.out.println("adding to set " + curr.val);
            	numSet.add(curr.val);
            }
			
			curr = curr.right;
			
		}
        
//         //search for left in BST
//         while (curr != null) {
//             System.out.println("Search for :" + L + " evaluating: " + curr.val);
//             if (curr.val >= myL && curr.val <= myR) {
//             	System.out.println("adding to set " + curr.val);
//             	numSet.add(curr.val);
//             }
//             if (curr.val == L) { 
//             	left = curr;
//             	System.out.println("Found L!");
//             	break;
//             }
//             if (curr.val < L) curr = curr.right;
//             else curr = curr.left;
//         }
        
//         curr = root;
//         //search for right in BST
//         while (curr != null) {
//         	System.out.println("Search for :" + R + " evaluating: " + curr.val);
//             if (curr.val >= myL && curr.val <= myR) {
//             	System.out.println("adding to set " + curr.val);
//             	numSet.add(curr.val);
//             }
//             if (curr.val == R) {
//             	right = curr;
//             	System.out.println("Found R!");
//             	break;
//             }
//             if (curr.val < R) curr = curr.right;
//             else curr = curr.left;
//         }
        
        Iterator<Integer> itr = numSet.iterator();  
        while(itr.hasNext()){  
            //System.out.println(itr.next());  
            sum = sum + itr.next();
        }  
        
        return sum;
        
        
    }

    public static boolean isSubtree(TreeNode s, TreeNode t) {
        
        int tVal = t.val;
        TreeNode curr = s;
        
        while (curr != null) {
            if (curr.val == tVal) break;
            if (curr.val > tVal) curr = curr.left;
            else curr = curr.right;
        }
        
        if (curr == null ) return false;
        else return compareTreeNode (curr, t);
        
    }
    
    public static boolean compareTreeNode (TreeNode a1, TreeNode a2) {
        
        if (a1 == null && a2 == null) return true;
        if (a1 == null && a2 != null) return false;
        if (a1 != null && a2 == null) return false;
        if (a1.val != a2.val) return false;
        
        return compareTreeNode(a1.left, a2.left) && compareTreeNode(a1.right, a2.right);
    }

}
