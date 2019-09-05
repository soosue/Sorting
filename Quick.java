package sorting;

import java.util.Arrays;

public class Quick {

	public static void main(String[] args) {
//		int[] arr = { 18, 7, 27, 2, 7, 3, 13, 17, 16, 4 };
		int[] arr = new int[20]; 
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 5);
		}

		System.out.println(Arrays.toString(arr));
		partition(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	static void partition(int[] arr, int start, int end) {
		int p_idx=quickSort(arr, start,end);
		if(start< p_idx-1)
		partition(arr,start,p_idx-1);
		if(p_idx+1<end)
		partition(arr,p_idx+1,end);	
	}
	
	static int quickSort(int[] arr, int start, int end) {
		int s = start;
		int e = end-1;
		int p = end;
		while(s<=e) {// swap후에 se가 교차되었는지 체크하는 부분
			while(arr[s]<arr[p])s++;
			while(s<=e && arr[p]<arr[e])e--; // 별 부분 e가 교차되지 못함. se가 됨.
			
			if(s<=e) {
				swap(arr,s,e);
				s++;e--;
			}
		}
		if(arr[s]>arr[p]) {
			swap(arr,s,p);
		}
		
		return s;
	}// quick끝
	
	static public void swap(int[] arr, int a, int b) {
		int tmp= arr[a];
		arr[a]=arr[b];
		arr[b]=tmp;
	}
}
