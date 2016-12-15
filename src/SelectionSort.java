import java.util.Arrays;

public class SelectionSort {
	//Implementation of Selection Sort
	//Reads the list and swaps the lowest element with the first
	
	/*TIME COMPLEXITY
	 * Best = O(n^2)
	 * Average = O(n^2)
	 * Worst = O(n^2)
	*/
	
	//SOLUTION
	public void selectionSort(int arr[]){
		
		int n = arr.length;
		
		for(int i = 0; i < n -1; i++){
			int minIndex = i;
			for(int j = i+1; j < n; j++){
				if(arr[j] < arr[minIndex]){
					minIndex = j;
				}
			}
			
			int temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
		}
	}
	//END SOLUTION
	
	//RECURSIVE SOLUTION
	public static void sort(int[] data){
		//recursive call to sort
		sort(data, 0);
	}
	
	private static void sort(int[] data, int start){
		//check the position of the sort
		if(start < data.length-1){
			//swap current value with the lowest value
			swap(data, start, findMinIndex(data, start));
			
			//recursive call to sort, incrementing the current position
			sort(data, start+1);
		}
	}
	
	private static int findMinIndex(int[] data, int start){
		//initialize minimum index with the current position
		int minIndex = start;
		
		//check the remainder of the list for the smallest value
		for(int i = start + 1; i < data.length; ++i){
			if(data[i] < data[minIndex]){
				minIndex = i;
			}
		}
		//return the index of the smallest remaining value
		return minIndex;
	}
	
	private static void swap(int[] data, int a, int b){
		if(a != b){
			//swap a and b, using a temp variable
			int temp = data[a];
			data[a] = data[b];
			data[b] = temp;
		}
	}
	
	
	//TEST
	public static void main(String[] args){
		
		SelectionSort ss = new SelectionSort();
				
		int[] test2 = {5,103,-2,34,123,40,231};
		System.out.println("Input: "+Arrays.toString(test2));		
		
		//Method timer
		long startTime2 = System.nanoTime();
		
		ss.selectionSort(test2);
		
		long endTime2 = System.nanoTime();
		long duration2 = (endTime2 - startTime2);
		
		System.out.println("Output: "+Arrays.toString(test2));
		System.out.println("Runtime(nano-seconds): "+duration2);
		
		
		
		//RECURSIVE Solution test case
		int[] test1 = {5,103,-2,34,123,40,231};
		System.out.println("Test1");
		//Method timer
		long startTime = System.nanoTime();
		sort(test1);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("Duration: "+duration);
		
	}
	
}
