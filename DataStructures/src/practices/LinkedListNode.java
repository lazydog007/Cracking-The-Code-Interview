package practices;
import java.util.Hashtable;

public class LinkedListNode {

	LinkedListNode next = null;
	int data;

	public LinkedListNode(int d) {
		data = d;
	}

	// adds element to the end of the list
	public void appendToTail(int d) {
		LinkedListNode end = new LinkedListNode(d);
		LinkedListNode n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}

	public static LinkedListNode deleteLinkedListNode(LinkedListNode head, int d) {
		LinkedListNode n = head;

		if (n.data == d) {
			return head.next; // moved to head.
		}

		while (n.next != null) {
			if (n.next.data == d) {
				n.next = n.next.next;
				return head; // head didnt chanage
			}
		}
		return head;
	}

	//Just displays the data, by traversing through the list.
	public static void display(LinkedListNode n) {
		LinkedListNode current = n;

		while (current != null) {
			if (current.next == null) {
				System.out.print(current.data);

			} else {
				System.out.print(current.data + " --> ");
			}
			current = current.next;
		}
	}

	//Solution with HashTable and temp buffer allow
	public static void removeDups(LinkedListNode n) {
		Hashtable table = new Hashtable();
		LinkedListNode prev = null;

		while (n != null) { 
			if (table.containsKey(n.data)) {
				prev.next = n.next;
			} else {
				table.put(n.data, true);
				prev = n;
			}
			n = n.next;
		}
	}
	
	public static void removeDupsNoB(LinkedListNode n){
		if (n == null){
			return;
		}
		LinkedListNode current = n; //starts at the head
		
		while(current != null){
			LinkedListNode runner = current;
			
			while(runner.next != null){
				if(runner.next.data == current.data){
					runner.next = runner.next.next;
				}else{
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}
	
	public static int nthToLastSize(LinkedListNode head, int k){
		if (head == null){
			return 0;
		}
		
		int i = (nthToLastSize(head.next, k)) + 1 ;
		

		if (i == k){
			System.out.println(head.data);
		}
		
		return i;
	}
	

}
