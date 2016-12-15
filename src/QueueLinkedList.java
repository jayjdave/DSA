
public class QueueLinkedList {
	DoublyLinkedList<Integer> queue = new DoublyLinkedList<Integer>();
	
	
	doublyNode<Integer> head;
	doublyNode<Integer> tail;
	
	public boolean isEmpty(){
		return head == null;
	}
	
	public void enqueue(Integer value){
		doublyNode<Integer> data = new doublyNode<Integer>(value);
		if(head==null){
			head = data;
			tail = head;
		}
		else{
			tail.setNextNode(data);
			tail = data;
		}
	}
	
	public Integer dequeue(){
		
		if(head == null){
			return null;
		}
		else{
			doublyNode<Integer> data = new doublyNode<Integer>(head.getData());
			head = head.getNextNode();
			return data.getData();
		}
		
	}
	
	public int peek(){
		return this.tail.getData();
	}
	
	
	public static void main(String[] args){
		QueueLinkedList queue = new QueueLinkedList();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}
}
