package LinkedList;

public class LinkedListMain {
	
	public static void main(String[] args){
		Node n = new Node(0);
		
		n.appendToTail(1);
		n.appendToTail(2);
		n.appendToTail(3);
		n.appendToTail(4);
		n.appendToTail(5);

		Node.display(n);
		
		System.out.println();
//		System.out.println("Buffer");
//		LinkedListNode.removeDups(n);
//		LinkedListNode.display(n);
//		
//		System.out.println();
//		System.out.println("Adding 3");
//		n.appendToTail(3);
//		LinkedListNode.display(n);
//		
//		System.out.println();
//		System.out.println("No Buffer");
//		LinkedListNode.removeDupsNoB(n);
//		LinkedListNode.display(n);
//		
		System.out.println();

	//	LinkedListNode.deleteNode(n.next);
		Node.deleteLast(n);
		
		Node.display(n);


		
	}
	
}