package del;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

// BFS
// DFS
// In order
// Pre Order
// Post Order
// Find nth largest number in a BST
// Djikshtra
// Binary tree from preorder traversal array


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

public class OrderOrder {
	
	int pos = 0;
	
	static int depthOfBT (TreeNode root) {
		int depth = 0;
		if (root == null) return depth;
		
		TreeNode curr = root;
		
		return Math.max(depthOfBT (curr.left), depthOfBT(curr.right) + 1); 
		
	}
	
	public static TreeNode bstFromPreorder(int[] preorder) {
		
		if (preorder.length == 0) return null;
        
		return bstFromPreorder(preorder, 0, 1000000000);
		
    }
	
	public static TreeNode bstFromPreorder(int[] preorder, int pos, int max) {
		
		if (pos == preorder.length || preorder[pos] > max ) return null;
		//System.out.println (pos + ": pos ");
		TreeNode node = new TreeNode (preorder[pos]);
		pos++;
		node.left = bstFromPreorder (preorder, pos, node.val);
		node.right = bstFromPreorder (preorder, pos, max); 
			
        return node;
		
    }
	
	static List<Integer> BFS (TreeNode root) {
		List <Integer> list = new ArrayList <Integer> ();
		
		if (root == null) return list;
		
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		
		while (q.isEmpty() == false) {
			TreeNode node = q.peek();
			q.remove();
			
			if (node != null) {
				q.add(node.left);
				q.add(node.right);
				list.add(node.val);
			}
		}
		
		return list;
	}
	
	static List<Integer> preOrder (TreeNode root) {
		List <Integer> list = new ArrayList <Integer> ();
		
		if (root == null) return list;
		
		Stack <TreeNode> stackOfNodes = new Stack <> ();
		stackOfNodes.push(root);
		
		while (stackOfNodes.isEmpty() == false) {
			TreeNode node = stackOfNodes.peek();
			stackOfNodes.pop();
			
			if (node != null) {
				stackOfNodes.push(node.right);
				stackOfNodes.push(node.left);
				list.add(node.val);
			}
		}
		
		return list;
	}

	static List<Integer> postOrder (TreeNode root) {
		List <Integer> list = new ArrayList <Integer> ();
		
		if (root == null) return list;
		
		Stack <TreeNode> stackOfNodes = new Stack <> ();
		stackOfNodes.push(root);
		
		while (stackOfNodes.isEmpty() == false) {
			TreeNode node = stackOfNodes.peek();
			stackOfNodes.pop();
			
			if (node != null) {
				stackOfNodes.push(node.right);
				stackOfNodes.push(node.left);
				list.add(0,node.val);
			}
		}
		
		return list;
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
		
//		TreeNode rootOfTree = createTree();
//		printTree (preOrder (rootOfTree));
//		System.out.println("====");
//		printTree (postOrder (rootOfTree));
//		System.out.println("====");
//		printTree (inOrder (rootOfTree));
//		System.out.println("====");
//		printTree (BFS (rootOfTree));
//		System.out.println("====");
//		System.out.println (depthOfBT (rootOfTree));
		
		//Input: [8,5,1,7,10,12]
		//Output: [8,5,10,1,7,null,12]
		//https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3339/
		
		//int [] preOrder = {8,5,1,7,10,12};
		int [] preOrder = {1,3};
		TreeNode BST = bstFromPreorder(preOrder);
		System.out.println("====");
		printTree (inOrder (BST));
		
	}

	private static void printTree(List<Integer> preOrder) {
 
		for (int i = 0; i < preOrder.size(); i++) System.out.println (preOrder.get(i) );
		
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
}



/*


int ans = 0;

public int rangeSumBST(TreeNode root, int L, int R) {

  getSum(root,L,R);
  return ans;
  
    
}

private void getSum(TreeNode root, int L, int R){

if(root!=null){
 
 if(root.val>=L && root.val<=R){
   ans+=root.val;
 }
 
 if(L<root.val){
   getSum(root.left,L,R);
 }
 
 if(R>root.val){
   getSum(root.right,L,R);
 }     
}

}
*/


/*

int index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0){
            return null;
        }
        
        return bstFromPreorderHelper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    TreeNode bstFromPreorderHelper(int[] preorder, int min, int max){
        if(index >= preorder.length){
            return null;
        }
        
        int key = preorder[index];
        TreeNode node = null;
        if(key > min && key < max){
            node = new TreeNode(preorder[index]);
            index++;
            node.left = bstFromPreorderHelper(preorder, min, key);
            node.right = bstFromPreorderHelper(preorder, key, max);
        }
        return node;
    }

*/