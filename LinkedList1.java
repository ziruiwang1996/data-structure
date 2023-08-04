
 
 class Node { 
	 
	int data; 
    Node next; 
// Constructor to create a new node 

      Node(int d) {data = d; next = null; } 
 } 


public class LinkedList1 {
	
	Node head;
	
	
	public Node getHead(){
			return head;
	}
	
	public void insertAfter(Node prev_node, int new_data){
/* 1. Check if the given Node is null */
		if(prev_node == null){
			System.out.println("The given previous node cannot be null");
			return;
		}
/* 2. Allocate the Node & 3. Put in the data*/
		Node new_node = new Node(new_data);
/* 4. Make next of new Node as next of prev_node */
		new_node.next = prev_node.next;
/* 5. make next of prev_node as new_node */
		prev_node.next = new_node;
	}
	
	public boolean deleteAfter(Node prev_node){
		if(prev_node == null){
			System.out.println("input parameter passed to the function is null");
			return false;
		}
		if(prev_node.next == null){
			System.out.println("Input parameter points to the last element in the list");
			return false;
		}
		else{
			prev_node.next = prev_node.next.next;
			return true;
		}
	}
	
	public void insertFront(int new_data){ 
/* 1 & 2: Allocate the Node & Put in the data*/

		Node new_node = new Node(new_data); 
/* 3. Make next of new Node as head */

		new_node.next = head; 
/* 4. Move the head to point to new Node */
		head = new_node; 
	} 
	
	public boolean deleteFront() {
		if (head != null){
			head = head.next;
			return true;
		}
		
		return false;
	}
	
	
	public void insertEnd(int new_data) { 

		Node new_node = new Node(new_data); 

		if(head == null) { 
			head = new_node; 
			return; 
		} 

		new_node.next = null; 
		Node last = head;

		while(last.next != null) 
			last = last.next; 
			
		last.next = new_node; 
		
	} 
	
	
	public boolean deleteEnd(){
		if(head == null)
			return false;
			
		if(head.next == null)
		{
			head = null;
			return true;
		}
			
		Node current = head;
		while ((current.next).next != null){
			current = current.next;
		}
	
		current.next = null;
		
		return true;
	}

	
	public String toString(){
			
			String ret = "";
			
			Node current = head;
			
			while(current != null){
					ret += current.data + " ";
					current = current.next;
			}
			
			return ret;
			
	}
	
	public static void main (String[] args) {
		
		LinkedList1 l1 = new LinkedList1();
		
		l1.insertFront(1);
		l1.insertFront(2);
		l1.insertFront(3);
		
		System.out.println("State of the linkedlist after insert operations \n" + l1);
		
		l1.insertAfter(l1.getHead(),10);
		l1.insertAfter(l1.getHead(),11);
		l1.insertAfter(l1.getHead(),12);
		
		
		System.out.println("State of the linkedlist after insertAfter operations \n" + l1);
		
		l1.deleteFront();
		
		System.out.println("State of the linkedlist after one delete operations \n" + l1);
		
		l1.deleteAfter(l1.getHead());
		
		System.out.println("State of the linkedlist after one deleteAfter operations \n" + l1);
		
		l1.insertEnd(100);
		l1.insertEnd(101);
		l1.insertEnd(102);
		
		System.out.println("State of the linkedlist after insert end operations \n" + l1);
		
		l1.deleteEnd();
		
		
		System.out.println("State of the linkedlist after one deleteEnd operations \n" + l1);
		
	}
}


