import java.util.Arrays;

public class MergeSort {

	public void sort(int[] data) {
		mergeSort(data, 0, data.length-1);
	}	
	
	private void mergeSort(int[] data, int start, int end) {
		if (start < end) {
			int mid = (int) Math.floor((start+end)/2);
			mergeSort(data, start, mid);
			mergeSort(data, mid+1, end);
			merge(data, start, mid, end);
		}
	}
	
	private void merge(int[] data, int start, int mid, int end) {
		int sizeOfLeft = mid-start+1;
		int sizeOfRight = end - mid;
		int[] left = new int[sizeOfLeft];
		int[] right = new int[sizeOfRight];
		for (int i = 0; i < sizeOfLeft; i++) {
			left[i] = data[start + i]; // be careful here
		}
		for (int j = 0; j < sizeOfRight; j++) {
			right[j] = data[mid + 1 + j]; // be careful
		}
		int i = 0, j = 0;
		for (int k = start; k <= end; k++) {
			if ((j >= sizeOfRight) || (i < sizeOfLeft && left[i] <= right[j])) {
				data[k] = left[i];
				i++;
			} else {
				data[k] = right[j];
				j++;
			}
		}
	}
	public static void main(String[] args){
		MergeSort ms = new MergeSort();
		
		int[] test1 = {5,2,9,6,5,7,2,10,1,0,11,15,3,5};
		ms.sort(test1);
		System.out.println(Arrays.toString(test1));
	}
}
