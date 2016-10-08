package AsixthEdition;

import AsixthEdition.LinkedList.Node;



public class BinaryTreeNGraphs {

	// 4.2 Create a Binary Search tree given an array.
	
	public static Node createBST(int[] arr){
		return createBST(arr, arr.length -1 , 0);
	}
	
	// Overloading
	public static Node createBST(int[] arr, int start, int end){
		if (end > start) return null;
		
		// Divide the array into two parts basically
		int mid = (start + end) / 2;
		Node root = new Node(arr[mid]);
		root.left =  createBST(arr, 0 , mid - 1);
		root.right = createBST(arr, mid + 1 , end);
		
		return root;
	}
	
	// 4.3 List of Depth, given BT, design and algorithm which creates a 
	// linked list of all the node at each depth.
	
	//TODO
	
	// 4.4 check if tree is balanced
	
	public static boolean isBalanced(Node n){
		return heightDiff(n) != Integer.MIN_VALUE;
	}
	
	public static int heightDiff(Node n){
		if(n == null){
			return -1;
		}
		
		int left = heightDiff(n.left);
		int right = heightDiff(n.right);
		
		int heightDiff = Math.abs(left - right);
		if(heightDiff > 1){
			return Integer.MIN_VALUE;
		}else{
			return 1;
		}
	}
	
	// 4.5 Valid if it BST
	
	// InOrder, using an array, then verifying if its in order.
	
	public static int index = 0;
	public static void inOrderConvert(Node root, int[] arr){
		if(root == null){
			return;
		}
		
		// in order traversal;
		inOrderConvert(root.left, arr);
		arr[index] = root.data;
		index++;
		inOrderConvert(root.right,arr);
	}
	
	public static boolean checkOrder(Node root){
		int[] arr = new int[root.size];
		inOrderConvert(root, arr);
		
		for(int i = 0; i < arr.length; i++){
			if(arr[i] >= arr[i+1]){
				return false;
			}
		}
		return true;
	}
	
	// tracking an the last element
	public static Integer last = null;
	public static boolean isBST1(Node root){
		if(root == null){
			return false;
		}
	
		if(!isBST1(root.left)) return false;
		
		if(last != null && root.data <= last){
			return false;
		}
		last = root.data;
		
		if(!isBST1(root.right)) return false;
		
		return true;
	}
}












