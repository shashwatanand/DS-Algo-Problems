package com.shashwat.arrayProblems;

/**
 * Write a function rotate(arr[], d, n) that rotates arr[] of size n by d elements
 * 
 * @author shashwat.anand
 *
 */
public class ArrayRotation {
	/* Driver program to test above functions */
	public static void main(String[] args) {
		int arr[] = { 21, 22, 23, 24, 25, 26, 27 };
		int rotateBy = 4;
		leftRotate(arr, rotateBy); // Rotate array by rotateBy
		display(arr);
	}

	/**
	 * Left rotate.
	 *
	 * @param array the array
	 * @param rotateBy the rotate by
	 */
	private static void leftRotate(int[] array, int rotateBy) {
		int len = array.length;
		reverseArray(array, 0, rotateBy - 1);
		reverseArray(array, rotateBy, len - 1);
		reverseArray(array, 0, len - 1);
	}

	/* function to display an array */
	static void display(int arr[]) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
	
	static void reverseArray(int[] array, int start, int end) {
		int temp;
		while (start < end) {
			temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			start++;
			end--;
		}
	}
}
