package com.shashwat.arrayProblems;

/**
 * Question : find the element index in given increasing array
 */

public class BinarySearch {
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7};
		int key = 7;
		int keyFoundAt = binarySearch(array, key);
		if (keyFoundAt == -1) {
			System.out.println("Key not found");
		} else {			
			System.out.println(key +  " is present at " + keyFoundAt + " index");
		}
	}
	
	private static int binarySearch(int[] array, int key) {
		int low = 0;
		int high = array.length - 1;
		while(low <= high) {
			int mid = (low + high) / 2;
			if (key == array[mid]) {
				return mid;
			} else if (key < array[mid]) {
				high = mid - 1;
			} else if (key > array[mid]) {
				low = mid + 1;
			}
		}
		return -1;
	}
}
