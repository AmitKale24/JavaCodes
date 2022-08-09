package LinkedList;

public class ReverseLinkedList {
	
	public static void reverse(Node head) {
		if(head == null || head.next == null) {
			System.out.println(head.data);
		}
		
		reverse(head.next); //Suppose this is reverse our linked list except->head
		
		Node headNext = head.next;
		headNext.next = head; //reverse
		head.next = null;
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(10);
		Node first = new Node(20);
		Node second = new Node(30);
		
		head.prev = null;
		first.prev = head;
		second.prev = first;
		
		head.next = first;
		first.next = second;
		second.next = null;
		
		//System.out.println(reverse(head));
		reverse(head);
		

	}

}

class Node{
	int data;
	Node prev,next;
	public Node(int data) {
		this.data = data;
		prev = null;
		next = null;
	}
}
