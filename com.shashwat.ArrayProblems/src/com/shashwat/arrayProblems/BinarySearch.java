package com.shashwat.arrayProblems;

/**
 * Question : find the element index in given increasing array
 */

public class BinarySearch {
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7};
		int key = 7;
		System.out.println(key +  " is present at " + binarySearch(array, key) + " index");
	}
	
	private static int binarySearch(int[] array, int key) {
		int low = 0;
		int high = array.length - 1;
		while(low < high) {
			int mid = (array[low] + array[high]) / 2;
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
