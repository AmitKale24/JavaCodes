package LinkedList;

public class PalindromeLinkedList {
	
	public static boolean palindrome(Node head) {
		
		if(head == null) {
			return true;
		}
		
		Node curr = head;
		Node mid = middle(head);
		Node last = reverse(mid.next);
		
		while(last!=null) {
			if(last.data != curr.data) {
				return false;
			}
			curr = curr.next;
			last = last.next;
		}
		
		return true;
	}
	
	public static Node middle(Node head) {
		Node slow = head;
		Node fast = head;
		
		while(fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	public static Node reverse(Node head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		Node newHead = reverse(head.next);
		Node headNext = head.next;
		headNext.next = head;
		
		return newHead;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(2);
		Node five = new Node(1);
		
		head.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = null;
		
		System.out.println(palindrome(head));
		

	}

}
