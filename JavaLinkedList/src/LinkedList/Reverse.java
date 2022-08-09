package LinkedList;

public class Reverse {
	
	public static Node reverseLL(Node head) {

        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
		
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
		//reverseLL(head);
		
		Node ans = reverseLL(head);
		while(ans.next!=null) {
			System.out.println(ans.data);
		}
	}

}

//class Node{
//	Node prev;
//	Node next;
//	int data;
//	
//	public Node(int data) {
//		this.data = data;
//	}
//}
