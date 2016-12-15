import java.util.Arrays;

//TIME COMPLEXITY
//Worst case: O(n^2)

public class BubbleSort {

	public void bubbleSort(int arr[]){
		//length of array that is to be sorted
		int n = arr.length;
		
		for(int i = 0; i < n-1; i++){
			
			for(int j = 0; j < n-i-1; j++){
				
				if(arr[j] > arr[j+1]){
					
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	//OPTIMIZED Version
	//stop if no swaps occur in the inner loop
	public void optimizedBubbleSort(int arr[]){
		int n = arr.length;
		Boolean swapped;
		
		for(int i = 0; i < n-1; i++){
			
			swapped = false;
			for(int j = 0; j < n-i-1; j++){
				
				if(arr[j] > arr[j+1]){
					
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					
					swapped = true;
				}
			}
			//If no items are swapped, array has completed sorting
			if(swapped==false)break;
		}
	}
	

	
	public static void main(String[] args){
		
		BubbleSort bs = new BubbleSort();
		
		
		//TEST1
		int[] test1 = {8,5,12,4,1,7};
		System.out.println("Input: "+Arrays.toString(test1));		
		
		//Method timer
		long startTime = System.nanoTime();
		
		bs.bubbleSort(test1);
		
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		
		System.out.println("Output: "+Arrays.toString(test1));
		System.out.println("Runtime(nano-seconds): "+duration);
		
		//TEST2 - optimized solution
		int[] test2 = {8,5,12,4,1,7};
		System.out.println("Input: "+Arrays.toString(test2));		
		
		//Method timer
		long startTime2 = System.nanoTime();
		
		bs.bubbleSort(test2);
		
		long endTime2 = System.nanoTime();
		long duration2 = (endTime2 - startTime2);
		
		System.out.println("Output: "+Arrays.toString(test2));
		System.out.println("Runtime(nano-seconds): "+duration2);
		
		
	}
	
}
