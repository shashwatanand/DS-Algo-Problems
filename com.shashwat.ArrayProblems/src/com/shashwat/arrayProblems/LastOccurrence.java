package com.shashwat.arrayProblems;

/**
 * Question : find the element last occurrence index in given increasing array
 */
public class LastOccurrence {
	public static void main(String[] args) {
		int[] array = { 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 4, 5, 5, 6, 7 };
		int key = 2;
		int keyFoundAt = findLastOccurrence(array, key);
		if (keyFoundAt == -1) {
			System.out.println("Key not found");
		} else {			
			System.out.println(key +  " is present at " + keyFoundAt + " index");
		}
	}

	private static int findLastOccurrence(int[] array, int key) {
		int result = -1;
		int low = 0;
		int high = array.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (key == array[mid]) {
				result = mid;
				low = mid + 1;
			} else if (key < array[mid]) {
				high = mid - 1;
			} else if (key > array[mid]) {
				low = mid + 1;
			}
		}
		return result;
	}
}
