package practices;
import java.util.Hashtable;
import practices.*;

public class LinkedListMain {
	
	public static void main(String[] args){
		LinkedListNode n = new LinkedListNode(0);
		
		n.appendToTail(1);
		n.appendToTail(2);
		n.appendToTail(3);
		n.appendToTail(3);
		n.appendToTail(4);

		LinkedListNode.display(n);
		
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
	
		LinkedListNode.nthToLastSize(n, 2);

		
	}
	
}