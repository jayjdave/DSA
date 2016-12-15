
public class StackArray {
	public static void main(String[] args){
		
		Stack s = new Stack(10);
		
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.printStack();
		
		s.pop();
		s.pop();
		System.out.println("Peek: "+s.peek());
		
		s.pop();
		s.printStack();
		
	}
	
}

class Stack{
	
	private int[] stack;
	private int top;
	
	Stack(int size){
		if(size <= 0){
			throw new IllegalArgumentException("Size not valid");
		}
		stack = new int[size];
		top = -1;
	}
	
	public void push(int value){
		if(top == stack.length){
			System.out.println("Stack is full");
		}
		top++;
		stack[top] = value;
		
	}
	
	public void pop() {
		if(top == -1){
			System.out.println("Stack is empty");
		}
		top--;
	}
	
	public int peek(){
		if(top == -1){
			System.out.println("Stack is empty");
		}
		return stack[top];
	}

	public boolean isEmpty(){
		return (top == -1);
	}
	
	public void printStack(){
		System.out.print("Bottom - ");
		for(int i = 0; i <= top; i++){
			System.out.print(stack[i] + " -");
		}
		System.out.print(" Top");
		System.out.println("");
	}
	
	
}