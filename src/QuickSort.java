import java.util.Arrays;

public class QuickSort {
	
	public void sort(int arr[]){
		quickSort(arr, 0, arr.length-1);
	}
	
	public void quickSort(int arr[], int start, int end){
		if(start < end){
			int pivot = partition(arr,start,end);
			quickSort(arr, start,pivot-1);
			quickSort(arr, pivot+1, end);
		}
	}
	
	public int partition(int arr[], int start, int end){
		int pivot = arr[end];
		
		int i = start;
		
		for(int j = start; j < end; j++){
			if(arr[j] <= pivot){
				swap(arr[i], arr[j]);
				
				i++;
			}
		}
		swap(arr[i],arr[end]);
		return i;
	
	}
	
	
	public void swap(int a, int b){
		int temp = a;
		a = b;
		b = temp;
	}
	
	
	
	public static void main(String[] args){
		QuickSort qs = new QuickSort();
		int[] test1 = {5,2,9,6,5,7,2,10,1,0,11,15,3,5};

		qs.sort(test1);
		System.out.println(Arrays.toString(test1));
	}
	
	
}
