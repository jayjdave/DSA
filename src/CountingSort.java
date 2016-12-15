import java.util.Arrays;

public class CountingSort {
	public void countingSort(int arr[]){
		int[] temp = new int[10];
				
		for(int i = 0; i < arr.length; i++){
			temp[arr[i]]++;
		}
		
		int x = 0;
		
		for(int j = 0; j < temp.length; j++){
			for(int k = 0; k < temp[j]; k++){
				arr[x] = j;
				x++;
			}
		}
	}
	
	public static void main(String[] args){
		int[] test1 = {5,8,3,6,3,6,7,2,4,1,9,1,3,4,4,8,5};
		CountingSort cs = new CountingSort();
		cs.countingSort(test1);
		
		System.out.println(Arrays.toString(test1));
		
	}
	
	
}
