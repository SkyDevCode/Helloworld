package quicksortmodel;

import java.util.Random;

public class Partition {
	static int cnt = 1, ind = 1;
	
	public int getRandomNum (int num) {
		int result = 0;
		Random rangen = new Random();
		result = rangen.nextInt() % num;
		
		if (result < 0) result = result * -1;
		return result;
		
	}
	
	public int randomDivide(int[] arr, int leftmost, int rightmost) {
		Partition middle = new Partition();
		int key;
		if((rightmost - leftmost) <= 0) 
			return 0;
		else 
		{
			key = middle.getRandomNum(rightmost-leftmost+1) + leftmost;
			int pivot = swap(arr, key, rightmost);
			if(ind % 10 == 0) {
				ind++;
			}else{
				ind++;
			}
			
			int i = leftmost-1;
			int j = rightmost;
			while (true) {
				while(arr[++i] < pivot);
				while(j>leftmost && arr[--j] >= pivot);
				if(i >= j) 
					break;
				else
					swap(arr,i,j);
			}
			swap(arr,i,rightmost);
			randomDivide(arr,leftmost,i-1);
			randomDivide(arr,i+1,rightmost);
		}
		return key;
		
	}
	
	public int swap (int[] arr, int left, int right) {
		int temp;
		temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
		return temp;
	}
	
	public static void main(String args[]) {
		
		int i, size = 1000, left, right, pivot;
		int[] theArray = new int[size];
		Partition middle = new Partition();
		
		for (i=0;i<size;i++) {
			theArray[i] = middle.getRandomNum(size+1);
		}
		
		left = 0;
		right = size-1;
		pivot = middle.randomDivide(theArray,  left,  right);;
		System.out.println("\n\n<정렬된 후의 값>\n");
		System.out.println("------------------------------\n\t");
		int a = 0;
		for (i=0; i<size; i++) {
			System.out.println("["+(a++)+"]"+"\t");
			int ct = i;
			for (int j = ct; j<ct+20; j++) {
				System.out.print(theArray[j]+"\t");
				i++;
			
			}
			i -= 1;
			System.out.println();
		}
		
	}
	
}
