
public class BinarySearch {
	
	
	//Given an ordered array of integers, return the index of the integer
	/*Parameters 
	 * arr[] - ordered array of integers
	 * s - start position
	 * n - length of array being searched
	 * x - integer that is being searched for 
	 */
	public int binarySearch(int arr[], int s, int n, int x){
	
		int r = n - 1;
		if(r >= 1){
			int index = s + (r-1)/2;
			
			if(arr[index] == x){
				return index;
			}
			if(arr[index] > x){
				return binarySearch(arr,s,index-1,x);
			}
			
			return binarySearch(arr, index+1, n, x);
		}
		
		return -1;
		
	}
	
	//basic search
	public int regularSearch(int arr[], int x){
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == x){
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args){
		BinarySearch bs = new BinarySearch();
		
		int[] test1 = {-2,0,4,5,6,7,8,11,19,23};
		int n = test1.length;
		
		long startTime = System.nanoTime();
		int result = bs.binarySearch(test1, 0, n, 11);
		//int result = bs.regularSearch(test1, 19);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		
		
		if(result == -1){
			System.out.println("Element does not exist");
		}
		else{
			System.out.println("Index is: "+ result + " and Runtime: " + duration);
		}
		
	}
}
