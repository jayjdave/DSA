import java.util.Arrays;

public class InsertionSort {

	public void insertionSort(int arr[]){
		int n = arr.length;
		
		for(int i = 1; i < n; ++i){
			int key = arr[i];
			int j = i-1;
			
			while(j >= 0 && arr[j] > key){
				arr[j+1] = arr[j];
				j = j-1;
			}
			arr[j+1] = key;
		}
	}
	public static void main(String[] args){
		
		InsertionSort is = new InsertionSort();
		
		
		//TEST1
		int[] test1 = {8,5,12,4,1,7};
		System.out.println("Input: "+Arrays.toString(test1));		
		
		//Method timer
		long startTime = System.nanoTime();
		
		is.insertionSort(test1);
		
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		
		System.out.println("Output: "+Arrays.toString(test1));
		System.out.println("Runtime(nano-seconds): "+duration);
	}
}
