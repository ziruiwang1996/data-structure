
 
 class Node { 
	 
	int data; 
    Node next; 
// Constructor to create a new node 

      Node(int d) {data = d; next = null; } 
 } 


public class LinkedList2 {
	
	Node head;
	Node tail;
	
	public Node getHead(){
			return head;
	}
	
	
	public void insertEnd(int new_data) { 
		
		Node new_node = new Node(new_data); 
		
		if(head == null)
		{
			head = tail = new_node;
		}

		else{
				tail.next = new_node;
				tail = tail.next;
		}
		
	} 
	
	
	public boolean deleteEnd(){
		if(tail == null){
			System.out.println("There are no elements in the list");
			return false;
		}
		
		Node current = head;
		while(current.next != tail){
			current = current.next;
		}

		current.next = null;


		tail = current;

		
		return true;
	
	}
	
	public void insertAfter(Node prev_node, int new_data){
		if(prev_node == null){
			System.out.println("The given previous node cannot be null");
			return;
		}
		
		if(prev_node == tail){
				insertEnd(new_data);
				return;
		}
		

		Node new_node = new Node(new_data);

		new_node.next = prev_node.next;

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
		
		else if(tail == prev_node.next){
			tail = prev_node;
			tail.next = null;
		
		}

		else{
			prev_node.next = prev_node.next.next;
		
		}
		
		return true;
	}
	
	public void insertFront(int new_data) { 

		Node new_node = new Node(new_data); 
		new_node.next = head; 
		head = new_node; 
		
		if(tail == null){
			tail = head;
		}
	} 


	public boolean deleteFront() {
		
		if(head == null)
			return false;
		
		if(head == tail)
			head = tail = null;
		
		else
			head = head.next;
		
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
		
		LinkedList2 l1 = new LinkedList2();
		
		
		
		l1.insertEnd(100);
		l1.insertEnd(101);
		l1.insertEnd(102);
		
		System.out.println("State of the linkedlist after insert end operations \n" + l1);
		
		l1.deleteEnd();
		
		
		System.out.println("State of the linkedlist after one deleteEnd operations \n" + l1);
		
		l1.insertAfter(l1.getHead(),1);
		l1.insertAfter(l1.getHead(),2);
		l1.insertAfter(l1.getHead(),3);
		
		System.out.println("State of the linkedlist after insert After operations \n" + l1);
		
		l1.deleteAfter(l1.getHead());
		
		System.out.println("State of the linkedlist after delete After operations \n" + l1);
		
		l1.insertFront(10);
		l1.insertFront(11);
		l1.insertFront(12);
		
		System.out.println("State of the linkedlist after insert operations \n" + l1);
		
		l1.deleteFront();
		
		System.out.println("State of the linkedlist after one delete operations \n" + l1);
		
	}
}


