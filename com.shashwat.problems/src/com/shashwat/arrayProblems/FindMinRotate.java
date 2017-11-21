package com.shashwat.arrayProblems;

public class FindMinRotate {
	public static void main(final String[] args) {
		int arr1[] = { 5, 6, 1, 2, 3, 4 };
		int n1 = arr1.length;
		System.out.println("The minimum element is " + findMin(arr1, 0, n1 - 1));

		int arr2[] = { 1, 2, 3, 4 };
		int n2 = arr2.length;
		System.out.println("The minimum element is " + findMin(arr2, 0, n2 - 1));

		int arr3[] = { 1 };
		int n3 = arr3.length;
		System.out.println("The minimum element is " + findMin(arr3, 0, n3 - 1));

		int arr4[] = { 1, 2 };
		int n4 = arr4.length;
		System.out.println("The minimum element is " + findMin(arr4, 0, n4 - 1));

		int arr5[] = { 2, 1 };
		int n5 = arr5.length;
		System.out.println("The minimum element is " + findMin(arr5, 0, n5 - 1));

		int arr6[] = { 5, 6, 7, 1, 2, 3, 4 };
		int n6 = arr6.length;
		System.out.println("The minimum element is " + findMin(arr6, 0, n6 - 1));

		int arr7[] = { 1, 2, 3, 4, 5, 6, 7 };
		int n7 = arr7.length;
		System.out.println("The minimum element is " + findMin(arr7, 0, n7 - 1));

		int arr8[] = { 2, 3, 4, 5, 6, 7, 8, 1 };
		int n8 = arr8.length;
		System.out.println("The minimum element is " + findMin(arr8, 0, n8 - 1));

		int arr9[] = { 3, 4, 5, 1, 2 };
		int n9 = arr9.length;
		System.out.println("The minimum element is " + findMin(arr9, 0, n9 - 1));
	}

	private static int findMin(int[] array, int low, int high) {
		if (high < low) {
			return array[0];
		}
		
		if (high == low) {
			return array[low];
		}
		
		int mid = low + (high - low)/2;
		
		if (mid < high && array[mid + 1] < array[mid]) {
			return array[mid + 1];
		}
		
		if (mid > low && array[mid] < array[mid - 1]) {
			return array[mid];
		}
		
		if (array[high] > array[mid]) {
			return findMin(array, low, mid - 1);
		}
		return findMin(array, mid + 1, high);
	}
}
