
public class LinkedList<T> {
	private Node<T> head;
	
	public Node<T> getHead(){
		return this.head;
	}
	
	//insert node at the head
	public void insertAtHead(T data){
		Node<T> newNode = new Node<T>(data);
		newNode.setNextNode(this.head);
		this.head = newNode;
	}
	
	//delete the head node
	public Node<T> deleteFromHead(){
		Node<T> toRemove = this.head;
		this.head = this.head.getNextNode();
		return toRemove;
	}
	
	public Node<T> find(T data){
		Node<T> current = this.head;
		
		while(current != null){
			if(current.getData().equals(data)){
				return current;
			}
			current = current.getNextNode();
		}
		return null;
	}
	
	//find the length of the linked list
	public int length(){
		
		if(head == null){
			return 0;
		}
		int length = 0;
		Node<T> current = this.head;
		
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
		Node<T> current = this.head;
		
		while(current != null){
			result += current.toString() + ",";
			current = current.getNextNode();
		}
		
		result += "}";
		return result;
		
	}
	
	public static void main(String[] args){
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		
		//test case
		list.insertAtHead(5);
		list.insertAtHead(10);
		list.insertAtHead(2);
		list.insertAtHead(12);
		list.insertAtHead(19);
		list.insertAtHead(20);
		
		list.deleteFromHead();
		System.out.println("Found: " + list.find(12));
		System.out.println(list);
		System.out.println("Length: " + list.length());
	}
	
	
}

class Node<T>{
	private T data;
	private Node<T> nextNode;
	
	public T getData(){
		return this.data;
	}
	
	public void setData(T data){
		this.data = data;
	}
	
	public Node(T data){
		this.data = data;
	}
	
	public Node<T> getNextNode(){
		return this.nextNode;
	}
	
	public void setNextNode(Node<T> nextNode){
		this.nextNode = nextNode;
	}
	
	
	@Override
	public String toString() {
		return "Data: " + this.data;
	}
	
}
