package del;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class CousinsInBinaryTree {
	
	public static void main (String [] v ) {
		
		TreeNode rootOfTree = createTree();
		System.out.println("====");
		printTree (inOrder (rootOfTree));
		System.out.println("====");
		System.out.println(isCousins (rootOfTree, 4, 5));
		
	}

	private static void printTree(List<Integer> preOrder) {
 
		for (int i = 0; i < preOrder.size(); i++) System.out.println (preOrder.get(i) );
		
	}
	
	static List<Integer> inOrder (TreeNode root) {
		List <Integer> list = new ArrayList <Integer> ();
		
		if (root == null) return list;
		
		Stack <TreeNode> stackOfNodes = new Stack <> ();
		
		
		while (root != null || stackOfNodes.isEmpty() == false) {
			while (root != null ) {
				stackOfNodes.push(root);
				root = root.left;
			}
			
			root = stackOfNodes.pop();
			list.add(root.val);
			
			root = root.right;
			
		}
		
		return list;
	}

	private static TreeNode createTree() {
		TreeNode myRoot = new TreeNode (1);
		myRoot.left = new TreeNode (2);
		myRoot.right = new TreeNode (3);
		myRoot.left.left = null;
		myRoot.left.right = new TreeNode (4);
		myRoot.right.left = null;
		myRoot.right.right = new TreeNode (5);
		return myRoot;
	}

	public static boolean isCousins(TreeNode root, int x, int y) {
	        if (x == y) return false;
	        
	        TreeNode currNode = root;
	        TreeNode parent = null;
	        
	        TreeNode parentOfX = null;
	        TreeNode parentOfY = null;
	        
	        int depthOfX = -1;
	        int depthOfY = -1;
	        
	        int depth = 0;
	        
	        //Stack<TreeNode> stack = new Stack<TreeNode>();         
	        Queue<TreeNode> q = new LinkedList<TreeNode>();
	        Queue<TreeNode> parentQ = new LinkedList<TreeNode>();
	        Queue<Integer> depthQ = new LinkedList<Integer>();
	        q.add(root);
	        parentQ.add(root);
	        depthQ.add(0);
	        
	        //System.out.println (q.size());
	        while ( (q.size() > 0) ) {
	            currNode = q.remove();
	            depth = (int)depthQ.remove();
	            //if (parent !=null) System.out.println ("Parent: "+ parent.val + "current node: "+ currNode.val + " depth: " + depth);
	            parent = parentQ.remove();
	            
	            if (currNode.val == x) {
	                depthOfX = depth;
	                parentOfX = parent;
	                System.out.println ("Parent of X: "+ parent.val + " depth of x= " + depth);
	            }
	            if (currNode.val == y) {
	                depthOfY = depth;
	                parentOfY = parent;
	                
	                System.out.println ("Parent of Y: "+ parent.val + " depth of Y= " + depth);
	            }
	            depth++;
	            if ( !(currNode.left == null) ) {
	                q.add (currNode.left);
	                parentQ.add(currNode);
	                depthQ.add(depth);
	            }
	            if ( ! (currNode.right == null) ) {
	                q.add (currNode.right);
	                parentQ.add(currNode);
	                depthQ.add(depth);
	            }
	            
	        }
	        
	        if ((depthOfX == depthOfY) && ( !(parentOfX == parentOfY) ) ) return true;
	        
	        return false;
	        
	        
	    }



}


//Better code
/*
class Solution {
public boolean isCousins(TreeNode root, int x, int y) {
    
// Queue for BFS
    Queue <TreeNode> queue = new LinkedList <> ();
    queue.add(root);

    while (!queue.isEmpty()) {
        boolean siblings = false;
        boolean cousins = false;

        int nodesAtDepth = queue.size();

        for (int i = 0; i < nodesAtDepth; i++) {
            // FIFO
            TreeNode node = queue.remove();

            // Encountered the marker.
            // Siblings should be set to false as we are crossing the boundary.
            if (node == null) {
                siblings = false;
            } else {
                if (node.val == x || node.val == y) {
                    // Set both the siblings and cousins flag to true
                    // for a potential first sibling/cousin found.
                    if (!cousins) {
                        siblings = cousins = true;
                    } else {
                        // If the siblings flag is still true this means we are still
                        // within the siblings boundary and hence the nodes are not cousins.
                        return !siblings;
                    }
                }

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                // Adding the null marker for the siblings
                queue.add(null);
            }
        }
        // After the end of a level if `cousins` is set to true
        // This means we found only one node at this level
        if (cousins) return false;
    }
    return false;
}
}

*/