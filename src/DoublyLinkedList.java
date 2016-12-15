
public class DoublyLinkedList<T> {
	
	private doublyNode<T> head;
	
	public doublyNode<T> getHead(){
		return this.head;
	}
	
	protected void setHead(doublyNode<T> head){
		this.head = head;
	}
	
	//insert node at the head
	public void insertAtHead(T data){
		doublyNode<T> newNode = new doublyNode<T>(data);
		newNode.setNextNode(this.head);
		if(this.head != null){
			this.head.setPrevNode(newNode);
		}
		this.head = newNode;
	}
	
	
	//find the length of the linked list
	public int length(){
		
		if(head == null){
			return 0;
		}
		int length = 0;
		doublyNode<T> current = this.head;
		
		while(current != null){
			length++;
			current = current.getNextNode();
		}
		return length;
	}
	
	public boolean isEmpty() {
		return this.head == null;
	}
	
	//Make a string to print the linked list
	@Override
	public String toString() {
		String result = "{";
		doublyNode<T> current = this.head;
		
		while(current != null){
			result += current.toString() + ",";
			current = current.getNextNode();
		}
		
		result += "}";
		return result;
		
	}
	
	public static void main(String[] args){
		DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
		
		
		//test case
		list.insertAtHead(5);
		list.insertAtHead(10);
		list.insertAtHead(2);
		list.insertAtHead(12);
		list.insertAtHead(19);
		list.insertAtHead(20);
		
		System.out.println(list);
		System.out.println("Length: " + list.length());
	}
	
	
}

class doublyNode<T>{
	private T data;
	private doublyNode<T> nextNode;
	private doublyNode<T> prevNode;
	
	public doublyNode(T data){
		this.data = data;
	}
	
	public T getData(){
		return this.data;
	}
	
	public void setData(T data){
		this.data = data;
	}
	
	//Get and Set for nextNode
	public doublyNode<T> getNextNode(){
		return this.nextNode;
	}
	
	public void setNextNode(doublyNode<T> nextNode){
		this.nextNode = nextNode;
	}
	
	//Get and Set for prevNode
	public doublyNode<T> getPrevNode() {
		return prevNode;
	}

	public void setPrevNode(doublyNode<T> prevNode) {
		this.prevNode = prevNode;
	}
	
}
