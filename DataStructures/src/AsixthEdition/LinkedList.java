package AsixthEdition;

import java.util.HashMap;
import java.util.HashSet;

import AsixthEdition.LinkedList.Node;

public class LinkedList {
	public static class Node {
		Node next = null;
		int data;

		public Node(int d) {
			data = d;
		}

		public void append(int d) {
			Node end = new Node(d);
			Node n = this;

			while (n.next != null) {
				n = n.next;
			}
			n.next = end;
		}

		public static Node delete(Node head, int d) {
			Node n = head;
			
			if(n.data == d){
				return head.next;
			}

			while (n.next != null) {
				if (n.next.data == d) {
					n.next = n.next.next;
					return head;
				}
				n = n.next;
			}

			return head;
		}
		
		public static void display(Node head){
			while(head != null){
				System.out.print(head.data);
				if(head.next != null){
					System.out.print(" --> ");
				}
				head = head.next;
			}
		}

		// 2.1 Remove Duplicated unsorted List
		public static void removeDups(Node n){
			HashSet<Integer> set = new HashSet<Integer>();
			Node prev = null;
			
			while (n != null){
				if(set.contains(n.data)){
					prev.next = n.next;
				}else{
					set.add(n.data);
					prev = n;
				}
				n = n.next;
			}
	    }
		
		// 2.2 kth to last element
		
		public static int kthLast(Node head, int k){
			if(head == null){
				return 0;
			}
			Node n = head;
			int count = 0;
			
			//gives out length
			while(n != null){
				count++;
				n = n.next;
			}
			
			int spot = count - k;
			
			for (int i = 0; i < spot ; i++){
				head = head.next;
			}
			return head.data;
		}
		
		// Other solution
		
		public static int kthLastAlt(Node head, int k){
			if(head == null) 
				return 0;
			
			int index = kthLastAlt(head.next, k) + 1;
			
			if (index == k){
				return head.data;
			}
			
			return index;
		}
		
		// 2.3 Delete middle Node, only access to it.
		
		public static void middleDelete(Node mid){
			mid.data = mid.next.data;
			mid.next = mid.next.next;
		}
		
		//2.4 Partition around x value REVIEW
		
		public static Node partition(Node n, int k){
			Node small = n;
			Node big = n;
			
			while (n != null){
				Node next = n.next;
				if(n.data < k){
					n.next = small;
					small = n;
					//small = small.next;
				}else{
					big.next = n;
					big = n;
				}
				n = next;
			}
			
			big.next = null;
			
			return small;
		}
		
	
	
	
	
	}
}