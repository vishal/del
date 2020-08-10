package del;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
	int val;
	TreeNode left, right;
	
	TreeNode () {
		this.val = 0;
		this.left = null;
		this.right = null;
	}
	
	TreeNode (int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
	
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}


public class InvertBinaryTree {

	public static TreeNode invertTree(TreeNode root) {
		
		if (root == null) return null;
		
		root = swapNodes (root);
		return root;
        
    }
	
	private static TreeNode createTree() {
		TreeNode myRoot = new TreeNode (1);
		myRoot.left = new TreeNode (2);
		myRoot.right = new TreeNode (3);
		myRoot.left.left = new TreeNode (4);
		myRoot.left.right = new TreeNode (5);
		myRoot.right.left = new TreeNode (6);
		myRoot.right.right = new TreeNode (7);
		return myRoot;
	}
	
	public static TreeNode swapNodes (TreeNode node) {
	
		if (node.left == null && node.right == null) return node;
		TreeNode workingN = node.left;
		node.left = (node.right == null) ? null : swapNodes(node.right);
		node.right = (workingN == null) ? null : swapNodes (workingN);
		return node;
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
	
	public static void main (String [] v ) {
		
		TreeNode rootOfTree = createTree();
		printTree (inOrder (rootOfTree));
		TreeNode workingNode = invertTree (rootOfTree);
		System.out.println("====");
		printTree (inOrder (workingNode));
		
		
	}
	
}
