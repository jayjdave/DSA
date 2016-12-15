
public class StackLinkedList {
	DoublyLinkedList<Integer> stack = new DoublyLinkedList<Integer>();
	
	doublyNode<Integer> top;
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public void push(Integer value){
		doublyNode<Integer> data = new doublyNode<Integer>(value);
		
		data.setPrevNode(this.top);
		if(top !=null){
			top.setNextNode(data);
		}
						
		top = data;		
	}
	
	
	public Integer pop(){
		Integer data = this.top.getData();
		
		if(this.top.getPrevNode() != null){
			this.top.getPrevNode().setNextNode(null);
		}
		
		this.top = this.top.getPrevNode();
		return data;
		
	}
	
	public int peek(){
		return this.top.getData();
	}

	
	public static void main(String[] args){
		StackLinkedList stack = new StackLinkedList();
		stack.push(1);
		stack.push(2);
		stack.push(3);

		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}
