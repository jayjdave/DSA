
public class QueueArray {
	public static void main(String[] args){
		Queue q = new Queue(10);
		
		q.enqueue(5);
		q.enqueue(4);
		q.enqueue(6);
		q.enqueue(10);
		q.enqueue(46);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		q.enqueue(2);
		q.enqueue(4);
		q.enqueue(6);
		q.enqueue(8);
		q.enqueue(10);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		q.enqueue(11);
		q.enqueue(12);
		q.enqueue(13);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
	}
}

class Queue{
	private int[] queue;
	private int head = -1;
	private int tail = -1;
	private int items = 0;
	
	Queue(int size){
		if(size <= 0){
			throw new RuntimeException("Invalid Size");
		}
		queue = new int[size];		
	}
	
	public void enqueue(int value){
		if(items == queue.length){
			throw new RuntimeException("Queue is full");
		}
		if(tail == queue.length-1){
			tail = -1;
		}
		queue[++tail] = value;
		items++;
	}
	
	public int dequeue(){
		if(items == 0){
			throw new RuntimeException("Queue is empty");
		}
		
		if(head==queue.length-1){
			head=-1;
		}
		items--;
		return queue[++head];
	}
	
	public int peek(){
		return queue[head+1];
	}

}
